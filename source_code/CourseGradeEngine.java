package App;

import java.util.ArrayList;

import exceptions.WrongNumberException;

public class CourseGradeEngine {
	
	
	public double Grade(double comp, double weight)
	{
		return (comp/100)*weight;
	}

	
	public String finalGrade(double courseWorkWeight, double courseWorkGrade, String finalGrade) throws WrongNumberException
	{//fix this to display only one percentage
		double finalWeight = 100-courseWorkWeight;
		System.out.println(courseWorkGrade);
		double lb,hb;
		double scoredCW=(courseWorkGrade/100)*courseWorkWeight;
		
		switch (finalGrade.toLowerCase()) {
		case "a+":
			lb=94 ;hb= 100;
			break;
		case "a":
			lb=90 ;hb=93.9 ;
			break;
		case "a-":
			lb=86 ;hb=89.9 ;
			break;
		case "b+":
			lb=82 ;hb=85.9 ;
			break;
		case "b":
			lb=78 ;hb=81.9 ;
			break;
		case "b-":
			lb=74 ;hb=77.9 ;
			break;
		case "c+":
			lb=70 ;hb=73.0 ;
			break;
		case "c":
			lb=65 ;hb=69.9 ;
			break;
		case "c-":
			lb=60 ;hb=64.9 ;
			break;
		case "d+":
			lb=55 ;hb=59.9 ;
			break;
		case "d":
			lb=50 ;hb=54.9 ;
			break;
		case "f":
			lb=0 ;hb=49.9 ;
			break;
			
		default: lb=0 ;hb=0 ; 
			break;
		}
		
		double A1= hb-scoredCW;
		double A2= lb-scoredCW;

		double resHigh = Math.floor(((A1/finalWeight)*100)*10000/10000);
			
		double resLow =  Math.floor(((A2/finalWeight)*100)*10000/10000);
		if(resLow<0) resLow = 0;
		if(resHigh<0) resHigh = 0;
		if(lb==0 && hb==0) return "Fail Final";
		
//		if(resHigh>100||resHigh<100||resLow>100||resLow<100)
//			throw new WrongNumberException();
//		
		return " Low Bound: "+resLow+""+"\n High Bound: "+resHigh+".";
	}
	
//	public double courseWorkGrade(double quiz,double assign, double mid, double proj, double labs, double other)
//	{
//		return quiz+assign+mid+proj;
//	}
	
	public double courseWorkWeight(ArrayList<Double> Weights)
	{
		double res=0;
		for (int i = 0; i < Weights.size(); i++) {
			res+=Weights.get(i);
		}
		return res;
	}
	

	public String totalGrade(double total)
	{
		String res ="";
		
		if(total>=94)
		{
			res="A+";
		}
		else if(total>=90&&total<=93.9)
		{
			res="A";
		}
		else if(total>=86&&total<=89.9)
		{
			res="A-";
		}
		
		else if(total>=82&&total<=85.9)
		{
			res="B+";
		}
		else if(total>=78&&total<=81.9)
		{
			res="B";
		}
		else if(total>=74&&total<=77.9)
		{
			res="B-";
		}
		
		else if(total>=70&&total<=73.0)
		{
			res="C+";
		}
		else if(total>=65&&total<=69.9)
		{
			res="C";
		}
		else if(total>=60&&total<=64.9)
		{
			res="C-";
		}
		
		else if(total>=55&&total<=59.9)
		{
			res="D+";
		}
		else if(total>=50&&total<=54.9)
		{
			res="D";
		}
		else if(total>=0&&total<=49.9)
		{
			res="F";
		}
		
		return res;
	}
}
