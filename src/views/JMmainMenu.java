package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import presenters.Event;

public class JMmainMenu extends JMenuBar {
	
	/////////////////// Agregar al frame
	//	setJMenuBar(new JMmainMenu(listener));
	
	private static final String TXT_FILE = "File";
	private static final String TXT_ACERDA_DE_CALCULADORA = "Acerda de Calculadora";
	private static final String TXT_VER_LA_AYUDA = "Ver la ayuda";
	private static final String TXT_AYUDA = "Ayuda";
	private static final String TXT_PEGAR = "Pegar";
	private static final String TXT_COPIAR = "Copiar";
	private static final String TXT_EDICION = "Edicion";
	private static final String TXT_CONSUMO_DE_COMBUSTIBLE_1_100_KM = "Consumo de combustible (1/100 Km)";
	private static final String TXT_CONSUMO_DE_COMBUSTIBLE_MPG = "Consumo de combustible (mpg)";
	private static final String TXT_ALQUILER_DE_VEHÍCULOS = "Alquiler de vehículos";
	private static final String TXT_HIPOTECA = "Hipoteca";
	private static final String TXT_HOJAS_DE_CÁLCULO = "Hojas de cálculo";
	private static final String TXT_CÁLCULO_DE_FECHA = "Cálculo de fecha";
	private static final String TXT_CONVERSIÓN_DE_UNIDADES = "Conversión de unidades";
	private static final String TXT_BASICAS = "Basicas";
	private static final String TXT_NUMERO_DE_DÍGITOS_EN_GRUPO = "Numero de dígitos en grupo";
	private static final String TXT_HISTORIAL = "Historial";
	private static final String TXT_ESTADÍSTICAS = "Estadísticas";
	private static final String TXT_PROGRAMADOR = "Programador";
	private static final String TXT_UPDATE = "Update product";
	private static final String TXT_ADD_PRODUCT = "Add product";
	
	private static final Color BACKGROUND_COLOR = new Color(208, 225, 243);
	
	private JMenu jmFile, jmEdicion,jmAyuda,jmiCalculos;
	private JMenuItem jmiAddProduct,jmiUpdateProduct,jmiProgramador,jmiEstadisticas,
	jmiHistorial,jmiDigitos,jmiBasicas,jmiConversion,jmiFecha,jmiHipoteca,
	jmiAlquiler,jmiCombustible1,jmiCombustible2,jmiCopiar,jmiPegar,jmiAyuda,jmiAcercaDe;

	public JMmainMenu(ActionListener listener) {
		setBackground(BACKGROUND_COLOR);
		initCompoenents(listener);	
	}
	private void initCompoenents(ActionListener listener) {
		jmFile = new JMenu(TXT_FILE);
		jmFile.setBackground(BACKGROUND_COLOR);
		this.add(jmFile);
		
			jmiAddProduct = new JMenuItem(TXT_ADD_PRODUCT);
			jmiAddProduct.setBackground(BACKGROUND_COLOR);
			jmiAddProduct.addActionListener(listener);
			jmiAddProduct.setActionCommand(Event.SHOW_ADD_PRODUCT.toString());
			jmiAddProduct.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
			jmFile.add(jmiAddProduct);
			
			jmiUpdateProduct = new JMenuItem(TXT_UPDATE);
			jmiUpdateProduct.setBackground(BACKGROUND_COLOR);
			jmiUpdateProduct.addActionListener(listener);
			jmiUpdateProduct.setActionCommand(Event.SHOW_UPDATE_PRODUCT.toString());
			jmiUpdateProduct.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));
			jmFile.add(jmiUpdateProduct);
//			jmiProgramador = new JMenuItem(TXT_PROGRAMADOR);
//			jmiProgramador.setBackground(BACKGROUND_COLOR);
//			jmiProgramador.addActionListener(listener);
////			jmiProgramador.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiProgramador.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));
//			jmVer.add(jmiProgramador);
//			jmiEstadisticas = new JMenuItem(TXT_ESTADÍSTICAS);
//			jmiEstadisticas.setBackground(BACKGROUND_COLOR);
//			jmiEstadisticas.addActionListener(listener);
////			jmiEstadisticas.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiEstadisticas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_DOWN_MASK));
//			jmVer.add(jmiEstadisticas);
//			jmiHistorial = new JMenuItem(TXT_HISTORIAL);
//			jmiHistorial.setBackground(BACKGROUND_COLOR);
//			jmiHistorial.addActionListener(listener);
////			jmiHistorial.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiHistorial.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_DOWN_MASK));
//			jmVer.add(jmiHistorial);
//			jmiDigitos = new JMenuItem(TXT_NUMERO_DE_DÍGITOS_EN_GRUPO);
//			jmiDigitos.setBackground(BACKGROUND_COLOR);			
//			jmiDigitos.addActionListener(listener);
////			jmiDigitos.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiDigitos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
//			jmVer.add(jmiDigitos);
//			jmiBasicas = new JMenuItem(TXT_BASICAS);
//			jmiBasicas.setBackground(BACKGROUND_COLOR);
//			jmiBasicas.addActionListener(listener);
////			jmiBasicas.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiBasicas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_DOWN_MASK));
//			jmVer.add(jmiBasicas);
//			jmiConversion = new JMenuItem(TXT_CONVERSIÓN_DE_UNIDADES);
//			jmiConversion.setBackground(BACKGROUND_COLOR);
//			jmiConversion.addActionListener(listener);
////			jmiConversion.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiConversion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK));
//			jmVer.add(jmiConversion);
//			jmiFecha = new JMenuItem(TXT_CÁLCULO_DE_FECHA);
//			jmiFecha.setBackground(BACKGROUND_COLOR);
//			jmiFecha.addActionListener(listener);
////			jmiFecha.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiFecha.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
//			jmVer.add(jmiFecha);
//			jmiCalculos = new JMenu(TXT_HOJAS_DE_CÁLCULO);
//			jmiCalculos.setBackground(BACKGROUND_COLOR);
////			jmiCalculos.addActionListener(listener);
////			jmiCalculos.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmVer.add(jmiCalculos);
//			
//				jmiHipoteca = new JMenuItem(TXT_HIPOTECA);
//				jmiHipoteca.setBackground(BACKGROUND_COLOR);
//				jmiHipoteca.addActionListener(listener);
////				jmiHipoteca.setActionCommand(Event.PURSACHE_MENU.toString());
//				jmiHipoteca.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
//				jmiCalculos.add(jmiHipoteca);
//				jmiAlquiler = new JMenuItem(TXT_ALQUILER_DE_VEHÍCULOS);
//				jmiAlquiler.setBackground(BACKGROUND_COLOR);
//				jmiAlquiler.addActionListener(listener);
////				jmiAlquiler.setActionCommand(Event.PURSACHE_MENU.toString());
//				jmiAlquiler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
//				jmiCalculos.add(jmiAlquiler);
//				jmiCombustible1 = new JMenuItem(TXT_CONSUMO_DE_COMBUSTIBLE_MPG);
//				jmiCombustible1.setBackground(BACKGROUND_COLOR);
//				jmiCombustible1.addActionListener(listener);
////				jmiCombustible1.setActionCommand(Event.PURSACHE_MENU.toString());
//				jmiCombustible1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
//				jmiCalculos.add(jmiCombustible1);
//				jmiCombustible2 = new JMenuItem(TXT_CONSUMO_DE_COMBUSTIBLE_1_100_KM);
//				jmiCombustible2.setBackground(BACKGROUND_COLOR);
//				jmiCombustible2.addActionListener(listener);
////				jmiCombustible2.setActionCommand(Event.PURSACHE_MENU.toString());
//				jmiCombustible2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
//				jmiCalculos.add(jmiCombustible2);
//
//		jmEdicion = new JMenu(TXT_EDICION);
//		jmEdicion.setBackground(BACKGROUND_COLOR);
//		this.add(jmEdicion);
//			
//			jmiCopiar = new JMenuItem(TXT_COPIAR);
//			jmiCopiar.setBackground(BACKGROUND_COLOR);
//			jmiCopiar.addActionListener(listener);
////			jmiCopiar.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
//			jmEdicion.add(jmiCopiar);
//			jmiPegar = new JMenuItem(TXT_PEGAR);
//			jmiPegar.setBackground(BACKGROUND_COLOR);
//			jmiPegar.addActionListener(listener);
////			jmiPegar.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
//			jmEdicion.add(jmiPegar);
//
//		jmAyuda = new JMenu(TXT_AYUDA);
//		jmAyuda.setBackground(BACKGROUND_COLOR);
//		this.add(jmAyuda);
//		
//			jmiAyuda = new JMenuItem(TXT_VER_LA_AYUDA);
//			jmiAyuda.setBackground(BACKGROUND_COLOR);
//			jmiAyuda.addActionListener(listener);
////			jmiAyuda.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_DOWN_MASK));
//			jmAyuda.add(jmiAyuda);
//			jmiAcercaDe = new JMenuItem(TXT_ACERDA_DE_CALCULADORA);
//			jmiAcercaDe.setBackground(BACKGROUND_COLOR);
//			jmiAcercaDe.addActionListener(listener);
////			jmiAcercaDe.setActionCommand(Event.PURSACHE_MENU.toString());
//			jmiAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
//			jmAyuda.add(jmiAcercaDe);
	}
}