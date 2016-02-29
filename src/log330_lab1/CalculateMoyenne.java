package log330_lab1;
/*
 * Jean-S�bastien Ar�s, LOG330 TP4
 * Desc: Contient les fonctions n�cessaire pour
 * calculer la moyenne, impl�mente Calculate
 * 
 * */
import java.util.ArrayList;

public class CalculateMoyenne implements Calculate {

	ArrayList<Double> data = new ArrayList<Double>();	
	
	public CalculateMoyenne(){}
	public CalculateMoyenne(ArrayList<Double> data){
		this.data = data;
	}

	@Override
	public double calculate() {
		double resultSomme;
		resultSomme = somme();
		return resultSomme * (1.0/this.data.size());
	}
	private int somme() {

		int result = 0;
		for(int i=0; i<data.size();i++){
			result += data.get(i);
		}
		return result;
	}
	
	
	
	
	
}
