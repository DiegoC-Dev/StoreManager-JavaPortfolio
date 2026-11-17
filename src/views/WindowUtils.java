package views;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 * Utility helpers for sizing and centering application windows relative to the screen.
 */
public final class WindowUtils {

	private static final double MAX_SCREEN_RATIO = 0.78;
	private static final int MIN_WIDTH = 460;
	private static final int MIN_HEIGHT = 360;
	private static final List<JFrame> trackedWindows = new ArrayList<JFrame>();
	private static int sharedExtendedState = Frame.NORMAL;
	private static boolean isSyncingState = false;

	private WindowUtils() {
	}

	/**
	 * Sizes and centers a frame using the preferred dimensions, capped to a safe
	 * fraction of the usable screen bounds, and keeps maximized/normal state synced.
	 */
	public static void configureAdaptiveBounds(JFrame frame, int preferredWidth, int preferredHeight) {
		Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		double ratio = maxBounds.height < 680 ? 1.0 : MAX_SCREEN_RATIO;
		int width = Math.min(preferredWidth, (int) (maxBounds.width * ratio));
		int height = Math.min(preferredHeight, (int) (maxBounds.height * ratio));
		frame.setSize(width, height);
		frame.setMinimumSize(new Dimension(Math.min(MIN_WIDTH, width), Math.min(MIN_HEIGHT, height)));
		frame.setLocationRelativeTo(null);

		if (!trackedWindows.contains(frame)) {
			trackedWindows.add(frame);
			frame.setExtendedState(sharedExtendedState);
			frame.addWindowStateListener(new WindowStateListener() {
				@Override
				public void windowStateChanged(WindowEvent e) {
					if (isSyncingState || (e.getNewState() & Frame.ICONIFIED) != 0) {
						return;
					}
					sharedExtendedState = (e.getNewState() & Frame.MAXIMIZED_BOTH);
					isSyncingState = true;
					try {
						for (JFrame w : trackedWindows) {
							if (w != frame) {
								w.setExtendedState(sharedExtendedState);
							}
						}
					} finally {
						isSyncingState = false;
					}
				}
			});
		}
	}
}
