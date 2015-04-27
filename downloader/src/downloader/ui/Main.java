package downloader.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import downloader.fc.Downloader;

public class Main {
	
	public static void main(String[] args) {
		JFrame fenPrinc = new JFrame();
		JPanel panelPrinc = new JPanel(new BorderLayout());
		final JPanel babarres = new JPanel(new StackLayout());
		JPanel saisirUrl = new JPanel(new BorderLayout());
		
		panelPrinc.add(babarres, BorderLayout.CENTER);
		panelPrinc.add(saisirUrl, BorderLayout.SOUTH);
		
		//saisirUrl
		
		fenPrinc.add(panelPrinc);
		
		final JTextField textUrl = new JTextField();
//		textUrl.setSize(400, 50);
		saisirUrl.add(textUrl, BorderLayout.CENTER);
		
		
		JButton envoyer = new JButton("add");
		saisirUrl.add(envoyer,BorderLayout.EAST);
		
		envoyer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			final Downloader downloader; 
			final JPanel barrePanel;
			final JPanel boutons;
			final JPanel barre;
			final JProgressBar barreProgression;
			final JButton pause,annuler;
			
			String url = textUrl.getText();
			
			try {
				downloader = new Downloader(url);
				barreProgression = new JProgressBar();
				barrePanel = new JPanel(new BorderLayout());
				boutons = new JPanel(new FlowLayout());
				barre = new JPanel(new StackLayout());
				
				barre.add(new JLabel(url));
				barre.add(barreProgression);
				
				pause = new JButton("PLAY");
				annuler = new JButton("X");
				pause.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				annuler.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				
				boutons.add(pause);
				boutons.add(annuler);
				
				barrePanel.add(boutons,BorderLayout.EAST);
				barrePanel.add(barre,BorderLayout.CENTER);
				
				
				babarres.add(barrePanel);
				
				downloader.addPropertyChangeListener(new  PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						barreProgression.setValue(downloader.getProgress());
						barreProgression.setStringPainted(true);
						barreProgression.setString(""+downloader.getProgress());
						System.out.flush();
					}
				});
			
				downloader.execute();
			}
			catch(RuntimeException e1) {
				System.err.format("skipping %s %s\n", url, e1);
			}
			
			}
			
		});
		
		fenPrinc.setSize(500, 500);
		fenPrinc.setVisible(true);
		
		fenPrinc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/***********************************************************************************/
		
		
//		for (int i = 0; i < args.length; i++) {
//			threads.add(new Thread());
//		}
		
//		for(String url: args) {
//			
//			
//				
//		}
		
		/********************************************************************************/

	}
}