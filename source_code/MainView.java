package App;

import javax.swing.*;
import java.awt.*; 

public class MainView extends JFrame{
	
	/*
	 * author Karim Ahmed
	 * 2021
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel Panel;
	private CourseGradePanel CourseGradePanel;
	private optionPanel optionPanel;
	private WelcomePanel WelcomePanel;
	private appInfoPanel appInfoPanel;
	private LowerGpa LowerGpa;
	
	public MainView ()
	{
        Panel = new Panel(this);
        CourseGradePanel= new CourseGradePanel(this);
        optionPanel = new optionPanel(this);
        WelcomePanel = new WelcomePanel(this);
        appInfoPanel = new appInfoPanel(this);
        LowerGpa = new LowerGpa(this);
        
        this.getContentPane().add(optionPanel); 
        this.getContentPane().add(WelcomePanel);
        this.getContentPane().add(Panel); Panel.setVisible(false);
        this.getContentPane().add(CourseGradePanel); CourseGradePanel.setVisible(false);
        this.getContentPane().add(appInfoPanel); appInfoPanel.setVisible(false);
        this.getContentPane().add(LowerGpa); LowerGpa.setVisible(false);
        
        setTitle("Student Buddy");
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
		setBounds(200,100,1105,650);
		setVisible(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("guc.png")));
		
		this.repaint();
		this.revalidate();
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainView m = new MainView();
	}

	public Panel getPanel() {
		return Panel;
	}

	public void setPanel(Panel panel) {
		Panel = panel;
	}

	public CourseGradePanel getCourseGradePanel() {
		return CourseGradePanel;
	}

	public void setCourseGradePanel(CourseGradePanel courseGradePanel) {
		CourseGradePanel = courseGradePanel;
	}

	public optionPanel getOptionPanel() {
		return optionPanel;
	}

	public void setOptionPanel(optionPanel optionPanel) {
		this.optionPanel = optionPanel;
	}

	public WelcomePanel getWelcomePanel() {
		return WelcomePanel;
	}

	public void setWelcomePanel(WelcomePanel welcomePanel) {
		WelcomePanel = welcomePanel;
	}

	public appInfoPanel getAppInfoPanel() {
		return appInfoPanel;
	}

	public void setAppInfoPanel(appInfoPanel appInfoPanel) {
		this.appInfoPanel = appInfoPanel;
	}

	public LowerGpa getLowerGpa() {
		return LowerGpa;
	}

	public void setLowerGpa(LowerGpa lowerGpa) {
		LowerGpa = lowerGpa;
	}
	
	

}
