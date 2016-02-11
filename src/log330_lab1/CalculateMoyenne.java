package log330_lab1;
/*
 * Jean-Sébastien Arès, LOG330 TP4
 * Desc: Contient les fonctions nécessaire pour
 * calculer la moyenne, implémente Calculate
 * 
 * */
import java.util.ArrayList;

public class CalculateMoyenne implements Calculate {

	ArrayList<Integer> data = new ArrayList<Integer>();	
	
	public CalculateMoyenne(){}
	public CalculateMoyenne(ArrayList<Integer> data){
		this.data = data;
	}

	@Override
	public double calculate() {
		double resultSomme;
		resultSomme = somme();
		return resultSomme * (1.0/(double)this.data.size());
	}
	private int somme() {

		int result = 0;
		for(int i=0; i<data.size();i++){
			result += data.get(i);
		}
		return result;
	}
	
	
	
	
	
}
