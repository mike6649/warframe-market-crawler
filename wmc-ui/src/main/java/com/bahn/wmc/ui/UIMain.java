package com.bahn.wmc.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class UIMain extends JFrame {
	
	public UIMain(){
		initUI();
	}

	public void initUI(){
		setTitle("Title");
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {
			UIMain main = new UIMain();
			main.setVisible(true);
		});
	}

}
