package log330_lab1;
/*
 * Jean-S�bastien Ar�s, LOG330 TP4
 * Desc: Contient les fonctions n�cessaire pour
 * calculer la correlation, impl�mente Calculate
 * 
 * */


import java.util.ArrayList;

public class CalculateCorrelation implements Calculate {

	ArrayList<Double> datax = new ArrayList<Double>();	
	ArrayList<Double> datay = new ArrayList<Double>();	
	double result = 0.0;
	
	public CalculateCorrelation(ArrayList<Double> datax, ArrayList<Double> datay){
		this.datax = datax;
		this.datay = datay;
	}
	
	@Override
	public double calculate() {
		double xfoisy = xfoisy();
		double sommexFoisSommey = sommexFoisSommey();
		double soustractionDeSommeCarrex = soustractionDeSommeCarrex();
		double soustractionDeSommeCarrey = soustractionDeSommeCarrey();
		this.result = ((xfoisy)-(sommexFoisSommey))/Math.sqrt(((soustractionDeSommeCarrex)*(soustractionDeSommeCarrey)));
		return result;
	}
	public double calculateCorrelationAuCarre(){
	
		return Math.pow(this.result, 2);
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
		double resultat = 0.0;
		int i=0;
			for(int j=0;j<datay.size();j++){
				resultat += datax.get(i) * datay.get(j);
				i++;
			}
		return datax.size() * resultat;
	}

}
