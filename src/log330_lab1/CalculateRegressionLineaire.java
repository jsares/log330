package log330_lab1;

import java.util.ArrayList;

public class CalculateRegressionLineaire implements Calculate {

	ArrayList<Integer> datax = new ArrayList<Integer>();	
	ArrayList<Double> datay = new ArrayList<Double>();	

	public CalculateRegressionLineaire(ArrayList<Integer> datax, ArrayList<Double> datay){
		this.datax = datax;
		this.datay = datay;
	}

	@Override
	public double calculate() {
		double calculPente = calculPente();
		double calculConstante = calculConstante();
		return 0;
	}

	private double calculConstante() {
		// TODO Auto-generated method stub
		return 0;
	}

	private double calculPente() {
		double sommeXFoisSommeY = sommeXFoisSommeY();
		double xFoisYFoisN = xFoisYFoisN();
		int sommeXauCarre = sommeXauCarre();
		int nFoisSommeXcaree = nFoisSommeXcaree();

		return (sommeXFoisSommeY - xFoisYFoisN) / (sommeXauCarre - nFoisSommeXcaree);
	}

	private int nFoisSommeXcaree() {
		int result = 0;

		for(int i=0;i<datax.size();i++)
			result += Math.pow(datax.get(i),2);

		return datax.size() * result;
	}

	private int sommeXauCarre() {
		int result =0;

		for(int i=0;i<datax.size();i++)
			result += datax.get(i);

		return (int) Math.pow(result, 2);
	}

	private double xFoisYFoisN() {
		int result = 0;

		for(int i=0;i<datax.size();i++)
			result += (datax.get(i) + datay.get(i));

		return datax.size() * result;
	}

	private double sommeXFoisSommeY() {
		double resultx = 0.0;
		double resulty = 0.0;

		for(int i=0;i<datax.size();i++){
			resultx += datax.get(i);
			resulty += datay.get(i);
		}

		return resultx * resulty;
	}

}
