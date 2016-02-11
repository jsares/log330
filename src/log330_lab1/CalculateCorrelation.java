package log330_lab1;
/*
 * Jean-Sébastien Arès, LOG330 TP4
 * Desc: Contient les fonctions nécessaire pour
 * calculer la correlation, implémente Calculate
 * 
 * */


import java.util.ArrayList;

public class CalculateCorrelation implements Calculate {

	ArrayList<Integer> datax = new ArrayList<Integer>();	
	ArrayList<Double> datay = new ArrayList<Double>();	
	
	public CalculateCorrelation(ArrayList<Integer> datax, ArrayList<Double> datay){
		this.datax = datax;
		this.datay = datay;
	}
	
	@Override
	public double calculate() {
		double xfoisy = xfoisy();
		double sommexFoisSommey = sommexFoisSommey();
		double soustractionDeSommeCarrex = soustractionDeSommeCarrex();
		double soustractionDeSommeCarrey = soustractionDeSommeCarrey();
		
		return ((xfoisy)-(sommexFoisSommey))/Math.sqrt(((soustractionDeSommeCarrex)*(soustractionDeSommeCarrey)));
	}

	private double soustractionDeSommeCarrey() {
		double sommeChaqueYauCarre = 0.0;
		double sommeY = 0.0;
		
		for(int i=0;i<datay.size();i++){
			sommeChaqueYauCarre += Math.pow(datay.get(i), 2);
			sommeY += datay.get(i);
		}
		
		return (datay.size()*sommeChaqueYauCarre) - (Math.pow(sommeY, 2));
	}

	private double soustractionDeSommeCarrex() {
		double sommeChaqueXauCarre = 0.0;
		double sommeX = 0.0;
		
		for(int i=0;i<datax.size();i++){
			sommeChaqueXauCarre += Math.pow(datax.get(i), 2);
			sommeX += datax.get(i);
		}
		
		return (datax.size()*sommeChaqueXauCarre) - (Math.pow(sommeX, 2));
	}

	private double sommexFoisSommey() {
		double sommex = 0.0;
		double sommey = 0.0;
		
		for(int i=0;i<datax.size();i++){
			sommex += datax.get(i);
		}
		for(int j=0;j<datay.size();j++){
			sommey += datay.get(j);
		}
		
		return sommex * sommey;
	}

	private double xfoisy() {
		double result = 0.0;
		int i=0;
			for(int j=0;j<datay.size();j++){
				result += datax.get(i) * datay.get(j);
				i++;
			}
		return datax.size() * result;
	}

}
