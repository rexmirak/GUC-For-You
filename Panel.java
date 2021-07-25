package App;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Panel extends JPanel implements ActionListener{

	
	
	/**
	 * Karim Ahmed
	 */
	private static final long serialVersionUID = 1L;

	private MainView MainView;
	private JComboBox<String> Subjects,Grade;
	private JLabel Name,CreditHours,Grades,icon,prevGPA;
	private JTextField subjName,CHs,prevGPAIn,prevCHs;
	private JButton reset, Add, removeSelected, Calculate,GUC;
	private JTextArea CGPA_Out;
	private ArrayList<Subject> arr;
	private GridBagConstraints gbc = new GridBagConstraints();
	private String[] Grad= {"A+","A","A-","B+","B","B-","C+","C","C-","D+","D","F"};
	private boolean f=false;

	
	public Panel(MainView M)
	{
		this.setMainView(M);
		
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
        gbc.insets=new Insets(5,5,5,5);
		setBounds(300,0,785,602);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
		
		gbc.weightx=1;
		gbc.weighty=1;
		
		
		prevCHs = new JTextField(" Enter Previous Total Credit Hours");
		prevCHs.setFont(new Font(Font.SERIF, Font.PLAIN,  18));
		gbc.gridx=0; gbc.gridy=0;
		prevCHs.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		prevCHs.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		prevCHs.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(prevCHs.getText().equals(" Enter Previous Total Credit Hours"))
		    		prevCHs.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if(prevCHs.getText().equals(""))
		    		prevCHs.setText(" Enter Previous Total Credit Hours");
		    }
		});
		this.add(prevCHs,gbc);
		
		prevGPAIn = new JTextField(" Previous GPA");
		prevGPAIn.setFont(new Font(Font.SERIF, Font.PLAIN,  18));
		gbc.gridx=1; gbc.gridy=0;
		prevGPAIn.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		prevGPAIn.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		prevGPAIn.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		    	if(prevGPAIn.getText().equals(" Previous GPA"))
		    		prevGPAIn.setText("");
		    }

		    public void focusLost(FocusEvent e) {
		    	if(prevGPAIn.getText().equals(""))
		    		prevGPAIn.setText(" Previous GPA");
		    }
		});
		this.add(prevGPAIn,gbc);
       
        
        Name = new JLabel(" Course Name, Not Necessary");
        Name.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
        gbc.gridx=0; gbc.gridy=1;
        Name.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
        gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(Name,gbc);
		
		subjName = new JTextField();
		subjName.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=1; gbc.gridy=1;
	    subjName.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		subjName.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(subjName,gbc);
		
		
		CreditHours = new JLabel(" Course Credit Hours");
		CreditHours.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=2;
	    CreditHours.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
	    gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(CreditHours,gbc);
		
		CHs = new JTextField();
		CHs.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=1; gbc.gridy=2;
	    CHs.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		CHs.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(CHs,gbc);
		
		
		Grades = new JLabel(" Your Grade");
		Grades.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=3;
		Grades.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
	    gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(Grades,gbc);
		
		Grade = new JComboBox<String>(Grad);
		Grade.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=1; gbc.gridy=3;
		Grade.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		Grade.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(Grade,gbc);
		
		reset = new JButton(" Reset Entries");
		reset.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=1; gbc.gridy=4;
	    reset.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		reset.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(reset,gbc);
		
		Add = new JButton(" Add Course");
		Add.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=4;
	    Add.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		Add.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(Add,gbc);
		
		removeSelected = new JButton(" Remove Selected Course");
		removeSelected.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=2; gbc.gridy=4;
		removeSelected.setBorder((BorderFactory.createLineBorder(Color.ORANGE, 2)));
		removeSelected.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(removeSelected,gbc);
		
		Calculate = new JButton("Calculate");
		Calculate.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=5;
		gbc.gridwidth=3;
	    Calculate.setBorder((BorderFactory.createLineBorder(Color.BLACK, 2)));
		Calculate.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(Calculate,gbc);
		
		Subjects = new JComboBox<String>();
		Subjects.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=6;
		Subjects.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		Subjects.addActionListener(this);
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(Subjects,gbc);
		
		CGPA_Out = new JTextArea(" CGPA");
		CGPA_Out.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=2; gbc.gridy=6;
		CGPA_Out.setEditable(false);
		CGPA_Out.setBorder((BorderFactory.createLineBorder(Color.RED, 2)));
		gbc.gridwidth=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		this.add(CGPA_Out,gbc);
		
		icon = new JLabel();
		ImageIcon img = new ImageIcon(getClass().getResource("GUC new.png")); 
		icon.setIcon(img);
		gbc.gridx=2; gbc.gridy=1;
		gbc.gridheight=3;
		gbc.fill=GridBagConstraints.VERTICAL;
		this.add(icon,gbc);
		
		GUC = new JButton("See GUC Grading Scheme");
		GUC.setFont(new Font(Font.SERIF, Font.PLAIN,  20));
		gbc.gridx=0; gbc.gridy=7;
		gbc.gridwidth=3;
		GUC.setBorder((BorderFactory.createLineBorder(Color.BLUE, 2)));
		GUC.addActionListener(this);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		
		this.add(GUC,gbc);

		arr = new ArrayList<Subject>();
		refresh();
	}
	
	public void refresh ()
	{
		String[] tmp= new String[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			tmp[i]="Course: "+arr.get(i).getName()+ ", Hours: "+ arr.get(i).getHrs()+"" +", Weight: "+ arr.get(i).getPoints()+"";
		}
		this.Subjects.removeAllItems();
		Subjects.setModel(new DefaultComboBoxModel<String>(tmp));
		
		subjName.selectAll();
	    subjName.replaceSelection("");
	    
	    Grade.setSelectedItem(null);
	    
	    CHs.selectAll();
	    CHs.replaceSelection("");
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Add)
		{
			//add to arr
			//refresh Subjects
			String currName = subjName.getText();
			double currGrade =0;
			String tmp="";
			
			try
			{
				tmp = Grad[Grade.getSelectedIndex()];
			}
			catch (ArrayIndexOutOfBoundsException e00) {
				JOptionPane.showMessageDialog(this, "Wrong Input Format","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			switch(tmp)
			{
				case "A+": currGrade = 0.7; break;
				case "A": currGrade = 1.0; break;
				case "A-": currGrade = 1.3; break;
				
				case "B+": currGrade = 1.7; break;
				case "B": currGrade = 2.0; break;
				case "B-": currGrade = 2.3; break;
				
				case "C+": currGrade = 2.7; break;
				case "C": currGrade = 3.0; break;
				case "C-": currGrade = 3.3; break;
				
				case "D+": currGrade = 3.7; break;
				case "D": currGrade = 4.0; break;
				
				case "F": currGrade = 5.0; break;
				default: return;
			
			}
			int currHrs=0;

			try {
				currHrs = Integer.parseInt(CHs.getText());
			}
			catch (NullPointerException e0) {
				JOptionPane.showMessageDialog(this, "Wrong Input Format","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Wrong Number Format","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			Subject newSubject = new Subject(currName,currHrs,currGrade);

			arr.add(newSubject);
			refresh();
			
		}
		else if(e.getSource()==reset)
		{
			arr.removeAll(arr);
			prevGPAIn.setText(" Previous GPA");
			prevCHs.setText(" Enter Previous Total Credit Hours");
			CGPA_Out.setText(" CGPA");
			refresh();
		}
		else if(e.getSource()==removeSelected)
		{
			if (arr.size()==0)
			{
				JOptionPane.showMessageDialog(this, "Add Course to be removed","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			int selected = Subjects.getSelectedIndex();
			arr.remove(selected);
			refresh();
		}
		else if(e.getSource()==Calculate)
		{
			int PCH;
			double PGPA;
			PCH=0;
			PGPA=0;
			try {
			if(arr.size()==0&&(prevGPAIn.getText().equals(" Previous GPA")||prevCHs.getText().equals(" Enter Previous Total Credit Hours")))
			{
				JOptionPane.showMessageDialog(this, "No Subjects Entered","Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(!(prevGPAIn.getText().equals(" Previous GPA")
					||prevCHs.getText().equals(" Enter Previous Total Credit Hours")))
			{
				PCH = Integer.parseInt(prevCHs.getText());
				PGPA = Double.parseDouble(prevGPAIn.getText());
			}
			
			Subject[] arrToCalculate = new Subject[arr.size()];
			for (int i = 0; i < arrToCalculate.length; i++) {
				arrToCalculate[i]=arr.get(i);
			}
			double CGPA=Math.floor(Subject.CGPA(PCH,PGPA,arrToCalculate)*100)/100;
			CGPA_Out.setText(CGPA+"");
			}
			catch (NumberFormatException e1)
			{
				return;
			}
			
		}
		else if(e.getSource()==GUC)
		{
			if(!f) {
				ImageIcon img1 = new ImageIcon(getClass().getResource("GUC new new0 (1).jpg")); 
				icon.setIcon(img1);
				f=!f;
			}
			else
			{
				ImageIcon img = new ImageIcon(getClass().getResource("GUC new.png")); 
				icon.setIcon(img);
				f=!f;
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
