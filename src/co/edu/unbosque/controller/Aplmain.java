package co.edu.unbosque.controller;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Aplmain {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Controller();
		} catch (Exception e) {
		}

	}

}
