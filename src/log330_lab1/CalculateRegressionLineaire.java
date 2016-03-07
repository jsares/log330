package log330_lab1;
/*
 * Jean-Sébastien Arès, LOG330 TP4
 * Desc: Contient les fonctions nécessaire pour
 * calculer la régression linéaire, implémente Calculate
 * 
 * */
import java.util.ArrayList;
import java.util.List;

public class CalculateRegressionLineaire {

	ArrayList<Double> datax = new ArrayList<Double>();	
	ArrayList<Double> datay = new ArrayList<Double>();	

	public CalculateRegressionLineaire(ArrayList<Double> datax, ArrayList<Double> datay){
		this.datax = datax;
		this.datay = datay;
	}

	public double[] calculate() {
		double[] liste = new double[2];
		
		double calculPente = calculPente();
		double calculConstante = calculConstante();
		
		liste[0] = calculPente;
		liste[1] = calculConstante;
		
		return liste;
	}

	private double calculConstante() {
		Calculate moyenney = new CalculateMoyenne(datay);
		double resulty = moyenney.calculate();
		
		Calculate moyennex = new CalculateMoyenne(datax);
		double resultx = moyennex.calculate();
		
		return resulty - (calculPente() * resultx);
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
