package App;

import java.awt.*;

import javax.swing.*;
import javax.swing.text.*;

public class appInfoPanel extends JPanel {
	
	/**
	 * Karim Ahmed
	 */
	
	private static final long serialVersionUID = 1L;
	
	MainView MainView;
	JTextArea Body,Foot,Vision;
	JTextPane Title;
	JLabel Image,Side;
	
	
	public appInfoPanel (MainView MainView)
	{
		this.MainView=MainView;
		
		this.setVisible(true);
		this.setLayout(null);
		setBounds(300,0,785,602);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		
		Image = new JLabel();
		Image.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
//		Image.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		Image.setBounds(5,5,785/3,602/3);
		ImageIcon img = new ImageIcon(getClass().getResource("guc.jpg")); 
		Image.setIcon(img);
		this.add(Image);
		
		Title = new JTextPane ();
		Title.setText("GERMAN UNIVERSITY IN CAIRO\nDeutsche Universität in Kairo");

		StyledDocument doc = Title.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		Title.setAlignmentX(CENTER_ALIGNMENT);
		Title.setEditable(false);
		Title.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		Title.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		Title.setBounds((785/3)+10,5,468,60);
		this.add(Title);
		
		Vision = new JTextArea(" GUC's Vision:\n Building a leading centre of excellence"
							+ " in teaching and research that \n will effectively contribute"
							+ " to the general welfare nationally and \n internationally and endeavour"
							+ " the scientific, technical, economic \n and cultural"
							+ " cooperation between Egypt and Germany.");
		Vision.setEditable(false);
		Vision.setFont(new Font(Font.SERIF, Font.PLAIN,  17));
		Vision.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		Vision.setBounds((785/3)+10,70,468,134);
		this.add(Vision);
		
		Body = new JTextArea(" About the Student Buddy App: \n"
				+ " It was designed and made by a 49- MET Student, the App is dedicated to help students \n in their academic"
				+ " quest for knowledge in the GUC.\n"
				+ " The App is easy to use, free, no ads and no permissions required! \n"
				+ " Curently only available for Windows, but soon enough will be available for Apple \n (Mac and Iphone) and Android users too "
				+ "\n "
				+ "\n For More Information or suggestions to the App please email:"
				+ "\n karim.ahmed7660@gmail.com"
				+ "\n "
				+ "\n Karim Ahmed,"
				+ "\n July 2021.");
		
		Body.setEditable(false);
		Body.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		Body.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		Body.setBounds(5,12+(602/3),735,338);
		this.add(Body);
		
		Foot = new JTextArea("The GERMAN UNIVERSITY IN CAIRO");
		Foot.setEditable(false);
		Foot.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		Foot.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		Foot.setBounds(5,15+(602/3)+340,735,40);
		this.add(Foot);
		
		Side = new JLabel();
		Side.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
//		Side.setBorder((BorderFactory.createLineBorder(Color.DARK_GRAY, 2)));
		Side.setBounds(743,5,35,590);
		img = new ImageIcon(getClass().getResource("germany_presentday_35x590.png")); 
		Side.setIcon(img);
		this.add(Side);
		
		
	}
	
	
	
}
