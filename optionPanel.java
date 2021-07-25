package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class optionPanel extends JLabel implements ActionListener{
	
	/**
	 * Karim Ahmed
	 */
	private static final long serialVersionUID = 1L;
	private MainView MainView;
	private GridBagConstraints gbc = new GridBagConstraints();
	private JTextArea header;
	private JButton B1,B2,B3,B6;
	private JLabel IMG;
	
	public optionPanel(MainView mainView) {
		
		this.MainView=mainView;
		
		
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
//		this.setLayout(new GridLayout(1, 1));
        gbc.insets=new Insets(5,5,5,5);
        this.setBounds(0,0,295,602);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));


		gbc.weightx=1;
		gbc.weighty=1;
		
		header = new JTextArea("  GERMAN UNIVERSITY IN CAIRO\n                  STUDENT BUDDY");
		header.setFont(new Font(Font.SERIF, Font.BOLD,  17));
		gbc.gridx=0; gbc.gridy=0;
		gbc.gridwidth=3;
		header.setBorder((BorderFactory.createLineBorder(Color.DARK_GRAY, 2)));
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(header,gbc);
		
		B1 = new JButton("GPA Calculator");
		B1.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=1;
//		gbc.gridwidth=2;
		B1.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		B1.addActionListener(this);
//		gbc.fill=GridBagConstraints.HORIZONTAL;
//       gbc.fill=GridBagConstraints.VERTICAL;
		this.add(B1,gbc);
		
		B2 = new JButton("Course Grade Calculator");
		B2.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=2;
//		gbc.gridwidth=2;
		B2.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		B2.addActionListener(this);
//		gbc.fill=GridBagConstraints.HORIZONTAL;
//       gbc.fill=GridBagConstraints.VERTICAL;
		this.add(B2,gbc);

		
		B3 = new JButton("Lower GPA");
		B3.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=3;
//		gbc.gridwidth=2;
		B3.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		B3.addActionListener(this);
//		gbc.fill=GridBagConstraints.HORIZONTAL;
//       gbc.fill=GridBagConstraints.VERTICAL;
		this.add(B3,gbc);
		
		B6 = new JButton("About");
		B6.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=6;
//		gbc.gridwidth=2;
		B6.setBorder((BorderFactory.createLineBorder(Color.MAGENTA, 2)));
		B6.addActionListener(this);
//		gbc.fill=GridBagConstraints.HORIZONTAL;
//       gbc.fill=GridBagConstraints.VERTICAL;
		this.add(B6,gbc);
		
		IMG = new JLabel();
		gbc.gridx=0; gbc.gridy=7;
		IMG.setBorder((BorderFactory.createLineBorder(Color.BLUE, 2)));
		IMG.setSize(100,100);
		ImageIcon img = new ImageIcon(getClass().getResource("CAMPUS_1_348x126.jpg")); 
		IMG.setIcon(img);
		this.add(IMG,gbc);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == B1)
		{
			MainView.getWelcomePanel().setVisible(false);
			MainView.getCourseGradePanel().setVisible(false);
			MainView.getPanel().setVisible(true);
			MainView.getAppInfoPanel().setVisible(false);
			MainView.getLowerGpa().setVisible(false);
		}
		else if (e.getSource() == B2)
		{
			MainView.getWelcomePanel().setVisible(false);
			MainView.getPanel().setVisible(false);
			MainView.getCourseGradePanel().setVisible(true);
			MainView.getAppInfoPanel().setVisible(false);
			MainView.getLowerGpa().setVisible(false);
		}
		else if (e.getSource() == B3)
		{
			MainView.getPanel().setVisible(false);
			MainView.getCourseGradePanel().setVisible(false);
			MainView.getWelcomePanel().setVisible(false);
			MainView.getAppInfoPanel().setVisible(false);
			MainView.getLowerGpa().setVisible(true);

		}
		
		else if (e.getSource() == B6)
		{
			MainView.getWelcomePanel().setVisible(false);
			MainView.getPanel().setVisible(false);
			MainView.getCourseGradePanel().setVisible(false);
			MainView.getAppInfoPanel().setVisible(true);
			MainView.getLowerGpa().setVisible(false);
		}
		// TODO Auto-generated method stub
		
	}

}
