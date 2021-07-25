package App;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

	

public class WelcomePanel extends JLayeredPane{
	
	/**
	 * Karim Ahmed
	 */
	
	private static final long serialVersionUID = 1L;
	private MainView MainView;
	private JTextPane L1;
	
	public WelcomePanel(MainView MainView)
	{
		this.setMainView(MainView);
		
		this.setVisible(true);
        this.setBounds(300,0,785,600);
        this.setLayout(new BorderLayout());
        
		L1 = new JTextPane ();
		L1.setText("“Education is the most powerful weapon which you can use to change the world” \n– Nelson Mandela");
		StyledDocument doc = L1.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		L1.setEditable(true);
		L1.setFont(new Font(Font.SERIF, Font.ITALIC,  20));
		L1.setBackground(new Color(255, 255, 255, 0));
		L1.setOpaque(false);
		L1.setEditable(false);
		
		this.add(L1,BorderLayout.NORTH);
		
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		JLabel Welc = new JLabel();
		ImageIcon img = new ImageIcon(getClass().getResource("guc_785x602.jpg")); 
		Welc.setIcon(img);
		Welc.setBounds(0,0,785,600);
		this.add(Welc);

	}
	


	public MainView getMainView() {
		return MainView;
	}


	public void setMainView(MainView mainView) {
		MainView = mainView;
	}

}
