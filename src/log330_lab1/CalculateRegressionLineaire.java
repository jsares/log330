package log330_lab1;
/*
 * Jean-Sébastien Arès, LOG330 TP4
 * Desc: Contient les fonctions nécessaire pour
 * calculer la régression linéaire, implémente Calculate
 * 
 * */
import java.util.ArrayList;

public class CalculateRegressionLineaire implements Calculate {

	ArrayList<Integer> datax = new ArrayList<Integer>();	
	ArrayList<Integer> datay = new ArrayList<Integer>();	

	public CalculateRegressionLineaire(ArrayList<Integer> datax, ArrayList<Integer> datay){
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
		Calculate moyenney = new CalculateMoyenne(datay);
		double resulty = moyenney.calculate();
		
		Calculate moyennex = new CalculateMoyenne(datax);
		double resultx = moyennex.calculate();
		
		
		System.out.println("B0: " + (resulty - (calculPente() * resultx)));
		return resulty - (calculPente() * resultx);
	}

	private double calculPente() {
		double sommeXFoisSommeY = sommeXFoisSommeY();
		double xFoisYFoisN = xFoisYFoisN();
		int sommeXauCarre = sommeXauCarre();
		int nFoisSommeXcaree = nFoisSommeXcaree();

		System.out.println("B1: "+ (sommeXFoisSommeY - xFoisYFoisN) / (sommeXauCarre - nFoisSommeXcaree));
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
			result += (datax.get(i) * datay.get(i));

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
