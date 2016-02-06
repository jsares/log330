package log330_lab1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		DataInjector dataInjector = new DataInjector();
		
		ArrayList<Integer> datax = new ArrayList<Integer>();
		ArrayList<Double> datay = new ArrayList<Double>();
		
		dataInjector.setListNbrex();
		dataInjector.setListNbrey();
		datax = dataInjector.getListNbrex();
		datay = dataInjector.getListNbrey();
		
		/*TP1
		Calculate avg = new CalculateMoyenne(datax);
		double resultavg = avg.calculate();
		System.out.println("moyenne: "+resultavg);
		
		Calculate distance = new CalculateDistance(datax, resultavg);
		double sommeDistance = distance.calculate();
		System.out.println("somme distance: "+sommeDistance);
		
		Calculate variance = new CalculateVariance(datax, sommeDistance);
		double resultVariance = variance.calculate();
		System.out.println("Variance: "+resultVariance);
		
		Calculate ecartType = new CalculateEcartType(resultVariance);
		double resultEcartType = ecartType.calculate();
		
		System.out.println("Ecart-type: "+resultEcartType);
		
		Calculate correlation = new CalculateCorrelation(datax, datay);
		double resultCorrelation = correlation.calculate();
		System.out.println("Correlation: "+resultCorrelation);
		System.out.println("Correlation au carré: "  + Math.pow(resultCorrelation,2));*/
		
		/*TP3*/
		Calculate regression = new CalculateRegressionLineaire(datax, datay);
		double resultRegression = regression.calculate();
		System.out.println("Regression: "+resultRegression);
		System.out.println("Regression: "+resultRegression);

	}

}
