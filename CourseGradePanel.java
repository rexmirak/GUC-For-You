package App;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import exceptions.WrongNumberException;


public class CourseGradePanel extends JPanel implements ActionListener {
	
	
	/**
	 * Karim Ahmed
	 */
	
	private static final long serialVersionUID = 1L;

	private MainView MainView;
	private JButton showGrades;
	private static int r=3;
	private JTextPane fin,newF; //percentages
	private JTextPane finWeight,newFWeight; //percentages
	private ArrayList<Double> Grades,Weights;
	private ArrayList<JTextPane> gradeFields,weightFields;
	private JComboBox<String> finalGrade;
	private JButton Calc1,Calc2,Calc3,Help,addRow;
	private JLabel Lect1,Lect2,Lect3,GradesImg;
	private String[] Grad= {"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","F","FF"};
	private JTextPane headGrade;
	private JTextPane headWeight;
	private JTextPane finalPercent;
	private boolean there;
	
	GridBagConstraints gbc = new GridBagConstraints();
	CourseGradeEngine Engine;
	public CourseGradePanel(MainView M)
	{
		this.setMainView(M);
		Engine = new CourseGradeEngine();
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
        gbc.insets=new Insets(5,5,5,5);
        setBounds(300,0,785,602);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		gradeFields= new ArrayList<JTextPane>();
		weightFields= new ArrayList<JTextPane>();
		Weights= new ArrayList<Double>();
		Grades= new ArrayList<Double>();


		gbc.weightx=1;
		gbc.weighty=1;
		
		Lect1 = new JLabel();
		ImageIcon img = new ImageIcon(getClass().getResource("0bf251965020464d963e1e4b41d943f0.jpg")); 
		Lect1.setIcon(img);
		Lect1.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		gbc.gridx=0; gbc.gridy=0; 
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weighty=1;gbc.weightx=1;
		this.add(Lect1,gbc);
		
		Lect2 = new JLabel();
		img = new ImageIcon(getClass().getResource("library_04.jpg")); 
		Lect2.setIcon(img);
		Lect2.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		gbc.gridx=1; gbc.gridy=0; 
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weighty=1;gbc.weightx=1;
		this.add(Lect2,gbc);

		Lect3 = new JLabel();
		img = new ImageIcon(getClass().getResource("c1aa3e4e-2c79-46e0-b633-702bd71151b4.jpg")); 
		Lect3.setIcon(img);
		Lect3.setBorder((BorderFactory.createLineBorder(Color.black, 2)));
		gbc.gridx=2; gbc.gridy=0; 
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weighty=1;gbc.weightx=1;
		this.add(Lect3,gbc);
		
		there = true;
		
		showGrades = new JButton ();
		showGrades.setText(" Show Grade Distribution");
		showGrades.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		showGrades.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		gbc.gridx=0; gbc.gridy=1;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		showGrades.addActionListener(this);
		this.add(showGrades,gbc);
		
		headWeight = new JTextPane(); headWeight.setText(" Components' Weights");
		headWeight.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		StyledDocument doc = headWeight.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		headWeight.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		gbc.gridx=2; gbc.gridy=1;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		headWeight.setEditable(false);
		this.add(headWeight,gbc);
		
		headGrade = new JTextPane(); headGrade.setText(" Components' Grades");
		headGrade.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		doc = headGrade.getStyledDocument();
		center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		headGrade.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		gbc.gridx=1; gbc.gridy=1;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		headGrade.setEditable(false);
		this.add(headGrade,gbc);
		
		fin = new JTextPane (); fin.setText(" Final Exam as a %");
		fin.setEditable(true);
		fin.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		fin.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		gbc.gridx=1; gbc.gridy=2;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		fin.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(fin.getText().equals(" Final Exam as a %"))
		    	fin.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if(fin.getText().equals(""))
		    		fin.setText(" Final Exam as a %");
		    }
		});
		this.add(fin,gbc);
		
		
		finWeight = new JTextPane (); finWeight.setText(" Final Weight as a %");
		finWeight.setEditable(true);
		finWeight.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		finWeight.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		gbc.gridx=2; gbc.gridy=2;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		finWeight.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(finWeight.getText().equals(" Final Weight as a %"))
		    	finWeight.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if(finWeight.getText().equals(""))
		    		finWeight.setText(" Final Weight as a %");
		    }
		});
		this.add(finWeight,gbc);
		
		finalGrade = new JComboBox<String>(Grad);
		finalGrade.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		finalGrade.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		gbc.gridx=2; gbc.gridy=3;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		finalGrade.setEditable(false);
		this.add(finalGrade,gbc);
		
		finalPercent = new JTextPane (); finalPercent.setText(" Course Percentage: ");
		finalPercent.setEditable(false);
		finalPercent.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		finalPercent.setBorder((BorderFactory.createLineBorder(Color.orange, 2)));
		gbc.gridx=1; gbc.gridy=3;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(finalPercent,gbc);
		
		
		Calc1 = new JButton("Calculate Final Grade");
		Calc1.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=2;
		Calc1.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		Calc1.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
//        gbc.fill=GridBagConstraints.VERTICAL;
		this.add(Calc1,gbc);
		
		Calc2 = new JButton(" How Much Scored in Final");
		Calc2.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=3;
		Calc2.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		Calc2.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
//        gbc.fill=GridBagConstraints.VERTICAL;
		this.add(Calc2,gbc);
		
		Calc3 = new JButton(" Clear");
		Calc3.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=4;
		Calc3.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		Calc3.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
//        gbc.fill=GridBagConstraints.VERTICAL;
		this.add(Calc3,gbc);
		
		addRow = new JButton(" Add Row"); 
		addRow.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=5;
		addRow.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		addRow.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
//        gbc.fill=GridBagConstraints.VERTICAL;
		this.add(addRow,gbc);
		
		Help = new JButton(" Help");
		Help.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=6;
		Help.setBorder((BorderFactory.createLineBorder(Color.MAGENTA, 2)));
		Help.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
//        gbc.fill=GridBagConstraints.VERTICAL;
		this.add(Help,gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
	if(e.getSource()==showGrades)
	{
		if(there) {
			Lect1.setVisible(false);
			Lect2.setVisible(false);
			Lect3.setVisible(false);
		
			
			ImageIcon img = new ImageIcon(getClass().getResource("Grades2.png"));
			GradesImg = new JLabel(img,JLabel.CENTER);
//			GradesImg.setIcon();
//			GradesImg.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
			gbc.gridx=0; gbc.gridy=0; 
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.gridwidth=3;
			gbc.weighty=1;gbc.weightx=1;
			this.add(GradesImg,gbc);
			there = false;
			return;
		}
		
		Lect1.setVisible(true);
		Lect2.setVisible(true);
		Lect3.setVisible(true);
		GradesImg.setVisible(false);
		there = true;
	}
	
	else if(e.getSource()==addRow)
	{
		if(r==10)
		{
			JOptionPane.showMessageDialog(this, "Max Number of Rows Reached.","Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.remove(finalGrade);
		this.remove(finalPercent);
		newF = new JTextPane (); newF.setText(" ");
		newF.setEditable(true);
		newF.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		newF.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		gbc.gridx=1; gbc.gridy=r;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		gradeFields.add(newF);
		this.add(newF,gbc);
		
		newFWeight = new JTextPane (); newFWeight.setText(" ");
		newFWeight.setEditable(true);
		newFWeight.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		newFWeight.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		gbc.gridx=2; gbc.gridy=r;r++;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		weightFields.add(newFWeight);
		this.add(newFWeight,gbc);
		
		finalGrade = new JComboBox<String>(Grad);
		finalGrade.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		finalGrade.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		gbc.gridx=2; gbc.gridy=r;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		finalGrade.setEditable(false);
		this.add(finalGrade,gbc);
		
		finalPercent = new JTextPane (); finalPercent.setText(" Course Percentage: ");
		finalPercent.setEditable(false);
		finalPercent.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		finalPercent.setBorder((BorderFactory.createLineBorder(Color.orange, 2)));
		gbc.gridx=1; gbc.gridy=r;
//		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(finalPercent,gbc);
		repaint(); revalidate();
	}
	else if(e.getSource()==Calc1)
		{			
			try {
				
			for (int i = 0; i < weightFields.size(); i++) {
				Weights.add(Double.parseDouble(weightFields.get(i).getText()));
			}
			for (int i = 0; i < gradeFields.size(); i++) {
				Grades.add(Double.parseDouble(gradeFields.get(i).getText()));
			}
			
			}
			catch(NumberFormatException n)
			{
				JOptionPane.showMessageDialog(this, "Enter Grades/Weights Correctly","Error", JOptionPane.ERROR_MESSAGE);
				Calc3.doClick();
				return;
			}
			try {
				double tot = 0;
				
				for (int i = 0; i < Weights.size(); i++) {
					tot+= Engine.Grade(Grades.get(i),Weights.get(i));
				}
				double f=Double.parseDouble(fin.getText());
				double fw=Double.parseDouble(finWeight.getText());
				double weightsIF =0;
				for (int i = 0; i < Weights.size(); i++) {
					weightsIF+=	Weights.get(i);
				}
				if(weightsIF+fw<100)
					{
						JOptionPane.showMessageDialog(this, "Weights are less than 100","Error", JOptionPane.ERROR_MESSAGE);
						Calc3.doClick();
						return;
					}
				
				if(f<30)
				{
					System.out.println("here");
					finalGrade.setSelectedItem("FF");
					finalPercent.setText(" Fail Final ");
					Weights.removeAll(Weights);
					Grades.removeAll(Grades);
					return;
				}
				
				tot+=Engine.Grade(f, fw);
				finalGrade.setSelectedItem(Engine.totalGrade(tot));
				finalPercent.setText(" Course Percentage: "+tot);
				System.out.println(tot);
				Weights.removeAll(Weights);
				Grades.removeAll(Grades);
				System.out.println(tot);
			}
			catch (NullPointerException e0) {
				JOptionPane.showMessageDialog(this, "Enter Grades/Weights Correctly","Error", JOptionPane.ERROR_MESSAGE);
				Calc3.doClick();
				return;
			}
			catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Enter Grades/Weights Correctly","Error", JOptionPane.ERROR_MESSAGE);
				Calc3.doClick();
				return;
			} 
			catch (IndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(this, "Enter Grades/Weights Correctly","Error", JOptionPane.ERROR_MESSAGE);
				Calc3.doClick();
				return;
			} 
			
		}
		else if(e.getSource()==Calc2)
		{
			String res;
			try {
				
				for (int i = 0; i < weightFields.size(); i++) {
					Weights.add(Double.parseDouble(weightFields.get(i).getText()));
				}
				for (int i = 0; i < gradeFields.size(); i++) {
					Grades.add(Double.parseDouble(gradeFields.get(i).getText()));
				}
				
				}
				catch(NumberFormatException n)
				{
					JOptionPane.showMessageDialog(this, "Enter Grades/Weights Correctly","Error", JOptionPane.ERROR_MESSAGE);
					Calc3.doClick();

					return;
				}
			try {
				double f1 = 0 ;double ff1 = 0;
				for (int i = 0; i < Grades.size(); i++) {
					f1+=Engine.Grade(Grades.get(i), Weights.get(i));
					ff1+=Weights.get(i);
				}
				
				if(ff1>=100)
				{
					JOptionPane.showMessageDialog(this, "Weights Exceeded 100%","Error", JOptionPane.ERROR_MESSAGE);
					Calc3.doClick();

					return;
				}
				String grade = (String) finalGrade.getSelectedItem();
				
				try {									//coursework weights scored        grade
					res=new CourseGradeEngine().finalGrade(ff1,              (f1/ff1)*100, grade);
					Weights.removeAll(Weights); 
					Grades.removeAll(Grades);
					
				} catch (WrongNumberException e1) {
					JOptionPane.showMessageDialog(this, "Enter Grades/Weights Correctly","Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				Weights.removeAll(Weights);
				Grades.removeAll(Grades);
				fin.setText(res); finWeight.setText((100-ff1)+""); f1=0;ff1=0;
				
			}
			catch (NullPointerException e0) {
				JOptionPane.showMessageDialog(this, "Enter Grades/Weights Correctly","Error", JOptionPane.ERROR_MESSAGE);
				Calc3.doClick();

				return;
			}
			catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Enter Grades/Weights Correctly","Error", JOptionPane.ERROR_MESSAGE);
				Calc3.doClick();

				return;
			}
			
		}
		else if(e.getSource()==Calc3) 
		{
			
			fin.setText(" Final Exam as a %");
			finWeight.setText(" Final Weight as a %");
			this.remove(finalGrade);
			this.remove(finalPercent);
			for (int j = 0; j < weightFields.size(); j++)
			{
				this.remove(weightFields.get(j));
				this.remove(gradeFields.get(j));
			}
			weightFields.removeAll(weightFields);
			gradeFields.removeAll(gradeFields);
			Weights.removeAll(Weights);
			Grades.removeAll(Grades);
			r=3;
			finalGrade = new JComboBox<String>(Grad);
			finalGrade.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
			finalGrade.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
			gbc.gridx=2; gbc.gridy=r;
//			gbc.gridwidth=2;
			gbc.fill=GridBagConstraints.HORIZONTAL;
			finalGrade.setEditable(false);
			this.add(finalGrade,gbc);
			
			finalPercent = new JTextPane (); finalPercent.setText(" Course Percentage: ");
			finalPercent.setEditable(false);
			finalPercent.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
			finalPercent.setBorder((BorderFactory.createLineBorder(Color.orange, 2)));
			gbc.gridx=1; gbc.gridy=3;
//			gbc.gridwidth=2;
			gbc.fill=GridBagConstraints.HORIZONTAL;
			this.add(finalPercent,gbc);
			
			repaint(); revalidate();
			
			finalGrade.setEditable(true);
		}
		
		else if(e.getSource()==Help)
		{

			Object[] options = {
                    "I Got it"};
			
			int n = JOptionPane.showOptionDialog(this,
					"in 'Calculate Final Grade' Enter the information as in the next message\n"
					+ "and click calculate to recieve your final grade",
					"Help 1/6 ",
					JOptionPane.YES_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[0]);
			
			if(n==JOptionPane.YES_OPTION)
			{
				n = JOptionPane.showOptionDialog(this,
					"in 'How Much Scored in Final' enter all information including final grade and\n"
					+ "the scored percentage of the final and its weight will be calculated",	
					"Help 2/6 ",
					JOptionPane.YES_OPTION,
					JOptionPane.INFORMATION_MESSAGE,
					null,
					options,
					options[0]);
			}
			if (n==JOptionPane.YES_OPTION)
			{
				n = JOptionPane.showOptionDialog(this,
						"In the second Column enter the percentage you scored from each component,\n"
						+ "i.e if you scored scored 10/10 in all quizzes enter 100 in its respective field",
								"Help 3/6",
								JOptionPane.YES_OPTION,
								JOptionPane.INFORMATION_MESSAGE,
								null,
								options,
								options[0]);
				
			}
			if (n==JOptionPane.YES_OPTION)
			{
				n = JOptionPane.showOptionDialog(this,"In the third Column enter the weight of each component,",
								"Help 4/6",
								JOptionPane.YES_OPTION,
								JOptionPane.INFORMATION_MESSAGE,
								null,
								options,
								options[0]);
			}
			if (n==JOptionPane.YES_OPTION)
			{
				n = JOptionPane.showOptionDialog(this,
						"In 'How Much Scored in Final' the results may be >100%,\n"
						+ "this accounts to any possible bonus.",
								"Help 5/6",
								JOptionPane.YES_OPTION,
								JOptionPane.INFORMATION_MESSAGE,
								null,
								options,
								options[0]);
			}
			if (n==JOptionPane.YES_OPTION)
			{
				n = JOptionPane.showOptionDialog(this,
						"for better layout add the components' rows one by one,\n"
						+ "clear the fields if they clog the view, maximum 8 fields are to be added ",
								"Help 6/6",
								JOptionPane.YES_OPTION,
								JOptionPane.INFORMATION_MESSAGE,
								null,
								options,
								options[0]);
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
	


