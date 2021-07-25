package App;

public class Subject {
	
	private String name;
	private int hrs;
	private double points;
	
	public Subject (String name, int hrs, double points)
	{
		this.name=name;
		this.hrs=hrs;
		this.points=points;
	}
	
	public static double CGPA (int PCH, double PGPA,Subject[] subjs)
	{
		int curHrs=PCH;
		double curPoints=PCH*PGPA;
		
		for (int i = 0; i < subjs.length; i++) {
			curPoints+=(subjs[i].points*subjs[i].hrs);
			curHrs+=subjs[i].hrs;
		}
		double CGPA = curPoints/curHrs;
		return CGPA;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHrs() {
		return hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
}
