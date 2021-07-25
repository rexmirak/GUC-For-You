package App;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;



public class LowerGpa extends JPanel implements ActionListener {
	
	
	/**
	 * Karim Ahmed
	 */
	
	private static final long serialVersionUID = 1L;

	private MainView MainView;
	
	private JTextArea CurrGpa,GpaToReach,currCH,nxtCH,avgGpaToMaintain;
	private JTextPane L1;
	private JButton Calculate;
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	public LowerGpa(MainView M)
	{
		this.setMainView(M);
		
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
        gbc.insets=new Insets(5,5,5,5);
        setBounds(300,0,785,602);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		
		gbc.weightx=1;
		gbc.weighty=1;

		gbc.ipadx = 135;
		
		CurrGpa = new JTextArea ();
		CurrGpa.setText(" Enter Current GPA");	
		CurrGpa.setEditable(true);
		CurrGpa.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		CurrGpa.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		gbc.gridx=0; gbc.gridy=0;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		CurrGpa.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(CurrGpa.getText().equals(" Enter Current GPA"))
		    	CurrGpa.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if(CurrGpa.getText().equals(""))
		    		CurrGpa.setText(" Enter Current GPA");
		    }
		});
		this.add(CurrGpa,gbc);
		
		GpaToReach = new JTextArea ();
		GpaToReach.setText(" GPA To Reach");	
		GpaToReach.setEditable(true);
		GpaToReach.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		GpaToReach.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		gbc.gridx=1; gbc.gridy=0;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		GpaToReach.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(GpaToReach.getText().equals(" GPA To Reach"))
		    	GpaToReach.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if(GpaToReach.getText().equals(""))
		    		GpaToReach.setText(" GPA To Reach");
		    }
		});
		this.add(GpaToReach,gbc);
		
		currCH = new JTextArea ();
		currCH.setText(" Current Credit Hours");	
		currCH.setEditable(true);
		currCH.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		currCH.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		gbc.gridx=0; gbc.gridy=1;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		currCH.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(currCH.getText().equals(" Current Credit Hours"))
		    	currCH.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if(currCH.getText().equals(""))
		    		currCH.setText(" Current Credit Hours");
		    }
		});
		this.add(currCH,gbc);
		
		nxtCH = new JTextArea ();
		nxtCH.setText(" Next Semester Credit Hours");	
		nxtCH.setEditable(true);
		nxtCH.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		nxtCH.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		gbc.gridx=1; gbc.gridy=1;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		nxtCH.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(nxtCH.getText().equals(" Next Semester Credit Hours"))
		    	nxtCH.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if(nxtCH.getText().equals(""))
		    		nxtCH.setText(" Next Semester Credit Hours");
		    }
		});
		this.add(nxtCH,gbc);
		
		avgGpaToMaintain = new JTextArea ();
		avgGpaToMaintain.setText(" GPA To Get Next Semester");	
		avgGpaToMaintain.setEditable(true);
		avgGpaToMaintain.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		avgGpaToMaintain.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		gbc.gridx=1; gbc.gridy=2;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		avgGpaToMaintain.setEditable(false);
		this.add(avgGpaToMaintain,gbc);
		
		Calculate = new JButton("Calculate");
		Calculate.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=2;
		Calculate.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		Calculate.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(Calculate,gbc);
		
		gbc.ipadx = 1;
		gbc.gridx=0; gbc.gridy=3;

		L1 = new JTextPane ();
		L1.setText("\nThis page helps you know what GPA to aim for in the next semester(s) to reach a certain Cumulative GPA \n"
				+ "Other than the current and wanted GPAs, you alson need to specify the total \n"
				+ "Credit Hours taken so far and the Credit hours in the next semester(s). \n"
				+ "This tool can be applied for more than one semester, all you need is to know \n"
				+ "how many Credit Hours will be studied in this period \n"
				
				+ "\n'Never Let "
				+ "Success "
				+ "go to your head, "
				+ "and never let "
				+ "Failure "
				+ "go to your heart' ");
		StyledDocument doc = L1.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		L1.setEditable(true);
		L1.setFont(new Font(Font.SERIF, Font.ITALIC,  20));
		L1.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		gbc.gridx=0; gbc.gridy=3;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.BOTH;
		L1.setEditable(false);
		this.add(L1,gbc);

	}
	
	
	//Lower Engine
	public double avgGpaToMaintain (double currant, double wanted, int nextCH, int pastCH)
	{
		double avgGpaToMaintain = 0;
		int totalCH = nextCH+pastCH;
		double nxtPts=wanted*totalCH;
		double curPts = currant*pastCH;
		double wantedPts=nxtPts-curPts;
		avgGpaToMaintain=wantedPts/nextCH;
		return avgGpaToMaintain;
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==Calculate)
		{
			try {
			double curGpa=Double.parseDouble(CurrGpa.getText());
			double nxtGpa=Double.parseDouble(GpaToReach.getText());
			int curCh=Integer.parseInt(currCH.getText());
			int nxtCh=Integer.parseInt(nxtCH.getText());
			
			double res =Math.floor(avgGpaToMaintain(curGpa, nxtGpa, nxtCh, curCh) * 100) / 100;
			avgGpaToMaintain.setText(res+"");
			}
			catch (NullPointerException e0) {
				JOptionPane.showMessageDialog(this, "Wrong Number Format","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Wrong Number Format","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
	}


	public MainView getMainView() {
		return MainView;
	}


	public void setMainView(MainView mainView) {
		MainView = mainView;
	}

}
	


