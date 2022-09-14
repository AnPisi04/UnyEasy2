package com.mygroup.app.UnyEasy;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class IntPrincipale {
	
	private static JFrame frame;
	private static JPanel north, east, west, center, south, contentPane;
	
	public static void inizializzaFrame(){
		
		frame = new JFrame("Gestione Esami");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setBounds(100, 100, 1248, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);
		frame.setVisible(true);
		north = new JPanel();
		east = new JPanel();
		west = new JPanel();
		center = new JPanel();
		south = new JPanel();
		
		contentPane.setLayout(new BorderLayout());
		contentPane.add(north, BorderLayout.NORTH);
		contentPane.add(east, BorderLayout.EAST);
		contentPane.add(west, BorderLayout.WEST);
		contentPane.add(center, BorderLayout.CENTER);
		contentPane.add(south, BorderLayout.SOUTH);
		
	}
	
	public static void setCenterPanel(JPanel p){
		center.removeAll();
		center.add(p);
		center.revalidate();
		center.repaint();
	}
	
	public static void setWestPanel(JPanel p){
		west.removeAll();
		west.add(p);
		west.revalidate();
		west.repaint();
	}
	
	public static void setEastPanel(JPanel p){
		east.removeAll();
		east.add(p);
		east.revalidate();
		east.repaint();
	}
	
	public static void resetPanel(){
		east.removeAll();
		east.revalidate();
		east.repaint();
		
		center.removeAll();
		center.revalidate();
		center.repaint();
		
		west.removeAll();
		west.revalidate();
		west.repaint();
		
		south.removeAll();
		south.revalidate();
		south.repaint();
		
	}
	
	public static void add(JPanel p){
		IntPrincipale.resetPanel();
		IntPrincipale.setCenterPanel(p);
	}
	

	public static void resetPanelCenter() {
		center.removeAll();
		center.revalidate();
		center.repaint();
		
	}
	
}

