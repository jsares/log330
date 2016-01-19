package log330_lab1;

import java.util.ArrayList;

public class CalculateVariance implements Calculate {

	ArrayList<Integer> data = new ArrayList<Integer>();	
	double sommeDistance = 0.0;
	
	public CalculateVariance(){}
	public CalculateVariance(ArrayList<Integer> data, double sommeDistance){
		this.data = data;
		this.sommeDistance = sommeDistance;
	}
	
	@Override
	public double calculate() {
		
		return ((1.0)/((double)this.data.size()-1))*(this.sommeDistance);
	}

}
