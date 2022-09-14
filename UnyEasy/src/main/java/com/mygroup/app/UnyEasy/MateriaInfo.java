package com.mygroup.app.UnyEasy;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MateriaInfo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int h = 10; ///SPAZIATURA VERTICAL STUT
	Font fontIntest = new Font("Times New Roman", Font.BOLD, 14);
	Font fontValue = new Font("Times New Roman", Font.ITALIC, 14);
	
	public MateriaInfo(Materia mat){
		
		JPanel left = new JPanel();
		JPanel right = new JPanel();
		
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel codice = new JLabel("Codice Materia: ");
		JLabel nome = new JLabel("Nome Materia: ");
		JLabel cfu = new JLabel("Cfu: ");
		nome.setFont(fontIntest);
		codice.setFont(fontIntest);
		cfu.setFont(fontIntest);
		nome.setHorizontalAlignment(JLabel.RIGHT);
		cfu.setHorizontalAlignment(JLabel.RIGHT);
		codice.setHorizontalAlignment(JLabel.RIGHT);
		
		JLabel nomeV = new JLabel(mat.getNome());
		JLabel codiceV = new JLabel(mat.getCodice());
		JLabel cfuV = new JLabel(mat.getCfu());
		
		nomeV.setFont(fontValue);
		codiceV.setFont(fontValue);
		cfuV.setFont(fontValue);
		
		left.add(Box.createVerticalStrut(h));
		left.add(codice);
		left.add(Box.createVerticalStrut(h));
		left.add(nome);
		left.add(Box.createVerticalStrut(h));
		left.add(cfu);
		left.add(Box.createVerticalStrut(h));
		
		right.add(Box.createVerticalStrut(h));
		right.add(codiceV);
		right.add(Box.createVerticalStrut(h));
		right.add(nomeV);
		right.add(Box.createVerticalStrut(h));
		right.add(cfuV);
		right.add(Box.createVerticalStrut(h));
		
		this.add(left);
		this.add(right);
		
		this.setMaximumSize(new Dimension(250,100));
		this.setPreferredSize(new Dimension(250,100));
		this.setMinimumSize(new Dimension(250,100));
		
	}

}

