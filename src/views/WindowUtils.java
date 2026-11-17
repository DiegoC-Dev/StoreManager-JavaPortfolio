package views;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import javax.swing.JFrame;

/**
 * Utility helpers for sizing and centering application windows relative to the screen.
 */
public final class WindowUtils {

	private static final double MAX_SCREEN_RATIO = 0.78;
	private static final int MIN_WIDTH = 460;
	private static final int MIN_HEIGHT = 360;

	private WindowUtils() {
	}

	/**
	 * Sizes and centers a frame using the preferred dimensions, capped to a safe
	 * fraction of the usable screen bounds so it does not span edge-to-edge.
	 */
	public static void configureAdaptiveBounds(JFrame frame, int preferredWidth, int preferredHeight) {
		Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
		int width = Math.min(preferredWidth, (int) (maxBounds.width * MAX_SCREEN_RATIO));
		int height = Math.min(preferredHeight, (int) (maxBounds.height * MAX_SCREEN_RATIO));
		frame.setSize(width, height);
		frame.setMinimumSize(new Dimension(Math.min(MIN_WIDTH, width), Math.min(MIN_HEIGHT, height)));
		frame.setLocationRelativeTo(null);
	}
}
