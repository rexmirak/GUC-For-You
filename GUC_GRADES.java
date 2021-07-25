package App;

import javax.swing.*;

public class GUC_GRADES extends JFrame{
	
	/**
	 * karim Ahmed
	 */
	private static final long serialVersionUID = 1L;

	public GUC_GRADES()
	{
        this.setTitle("Grade Scheme");
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);
		setBounds(450,200,281,460);
		this.setVisible(true);

		JLabel GradesImage = new JLabel();
		ImageIcon img = new ImageIcon(getClass().getResource("grades.png")); 
		GradesImage.setIcon(img);
		GradesImage.setBounds(450,200,300,396);
		this.add(GradesImage);
		
		this.repaint();
		this.revalidate();
	}

}
