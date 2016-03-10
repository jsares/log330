package log330_labTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import log330_lab1.CalculateRegressionLineaire;

public class CalculateRegressionLineaireTest {

	ArrayList<Double> datax = new ArrayList<Double>();
	ArrayList<Double> datay = new ArrayList<Double>();
	
	private ArrayList<Double> getListeX(){
		
		ArrayList<Double> data = new ArrayList<Double>();	
		
		data.add(2.1);
		data.add(87.0);
		data.add(45.0);
		data.add(56.0);
		data.add(4.0);
		
		return data;
	}
	
	private ArrayList<Double> getListeY(){
		
		ArrayList<Double> data = new ArrayList<Double>();
		
		data.add(5.2);
		data.add(78.2);
		data.add(98.5);
		data.add(58.1);
		data.add(15.7);
		
		return data;
	}
	
	@Test (expected=NumberFormatException.class)
	public void donneesListeIsDouble() {

		datax = getListeX();
				
		datax.add(5, Double.parseDouble("allo"));
		
	}
	
	@Test
	public void regressionLineaireIsResultatCorrect() {
		double[] resultat = new double[2];
		datax = getListeX();
		datay = getListeY();
		
		CalculateRegressionLineaire regression = new CalculateRegressionLineaire(datax, datay);
		resultat = regression.calculate();
		
		//resultat[0]:B1
		//resultat[2]:B0
		assertTrue("Les résultat ne sont pas équivalent.", resultat[0] == 0.887211074519415 && resultat[1] == 16.376210308646698);
	}

}
