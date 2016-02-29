package log330_lab1;

public class CalculateEcartType implements Calculate {
	
	double variance = 0.0;
	
	public CalculateEcartType(){}
	public CalculateEcartType(double variance){
		this.variance = variance;
	}
	
	@Override
	public double calculate() {
		
		return Math.sqrt(this.variance);
	}

}
