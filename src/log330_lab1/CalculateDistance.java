package log330_lab1;

import java.util.ArrayList;

public class CalculateDistance implements Calculate {

	ArrayList<Integer> data = new ArrayList<Integer>();	
	double avg = 0.0;
	
	public CalculateDistance(){}
	public CalculateDistance(ArrayList<Integer> data, double avg){
		this.data = data;
		this.avg = avg;
	}
	
	@Override
	public double calculate() {
		double result=0.0;
		for(int i=0;i<this.data.size();i++){
			result += Math.pow((data.get(i) - this.avg), 2);
		}
		System.out.println(result);
		
		return result;
	}

}
