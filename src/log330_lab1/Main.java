package log330_lab1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		DataInjector dataInjector = new DataInjector();
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		
		dataInjector.setListNbre();
		data = dataInjector.getListNbre();
		
		Calculate avg = new CalculateMoyenne(data);
		double resultavg = avg.calculate();
		System.out.println("moyenne: "+resultavg);
		
		Calculate distance = new CalculateDistance(data, resultavg);
		double sommeDistance = distance.calculate();
		System.out.println("somme distance: "+sommeDistance);
		
		Calculate variance = new CalculateVariance(data, sommeDistance);
		double resultVariance = variance.calculate();
		System.out.println("Variance: "+resultVariance);
		
		Calculate ecartType = new CalculateEcartType(resultVariance);
		double resultEcartType = ecartType.calculate();
		
		System.out.println("Ecart-type: "+resultEcartType);

	}

}
