package log330_lab1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class CalculateCorrelationTest {

	private ArrayList<Double> getListeX(){
		
		ArrayList<Double> datax = new ArrayList<Double>();	
		
		datax.add(2.1);
		datax.add(87.0);
		datax.add(45.0);
		datax.add(56.0);
		datax.add(4.0);
		
		return datax;
	}
	
	private ArrayList<Double> getListeY(){
		
		ArrayList<Double> datay = new ArrayList<Double>();
		
		datay.add(5.2);
		datay.add(78.2);
		datay.add(98.5);
		datay.add(58.1);
		datay.add(15.7);
		
		return datay;
	}

	@Test
	public void deuxListMemeNbreDeDonnees() {
		
		ArrayList<Double> datax = new ArrayList<Double>();
		ArrayList<Double> datay = new ArrayList<Double>();

		datax = getListeX();
		datay = getListeY();
		
		Calculate correlation = new CalculateCorrelation(datax, datay);
		
		if(datax.size() != datay.size())
			fail("Liste x doit contenir le même nbre de données que la liste y.");
	}

	@Test
	public void correlationRacineCarreeIsPareilqueCorrelationDepart() {

		ArrayList<Double> datax = new ArrayList<Double>();
		ArrayList<Double> datay = new ArrayList<Double>();

		datax = getListeX();
		datay = getListeY();
		
		double resultatCorrelation = 0.0;
		double resultatCorrelationAuCarre = 0.0;
		
		CalculateCorrelation correlation = new CalculateCorrelation(datax, datay);
		resultatCorrelation = correlation.calculate();
		resultatCorrelationAuCarre = correlation.calculateCorrelationAuCarre();
		
		assertTrue("Correlation et la racine carree de correlation au carree doivent être pareil.", resultatCorrelation == Math.sqrt(resultatCorrelationAuCarre));
	}

	@Test
	public void correlationIsNotNaN() {
		
		ArrayList<Double> datax = new ArrayList<Double>();
		ArrayList<Double> datay = new ArrayList<Double>();
		double resultatCorrelation = 0.0;

		datax = getListeX();
		datay = getListeY();
		
		CalculateCorrelation correlation = new CalculateCorrelation(datax, datay);
		resultatCorrelation = correlation.calculate();
		
		assertTrue("Ne peut pas être Nan", !Double.isNaN(resultatCorrelation));
		
	}
}
