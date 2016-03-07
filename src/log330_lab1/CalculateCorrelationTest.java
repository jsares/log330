package log330_lab1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.omg.PortableInterceptor.SUCCESSFUL;

public class CalculateCorrelationTest {

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
	

	@Test
	public void deuxListMemeNbreDeDonnees() {

		datax = getListeX();
		datay = getListeY();
		
		Calculate correlation = new CalculateCorrelation(datax, datay);
		
		if(datax.size() != datay.size())
			fail("Liste x doit contenir le même nbre de données que la liste y.");
	}

	@Test
	public void correlationRacineCarreeIsPareilqueCorrelationDepart() {

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
		
		double resultatCorrelation = 0.0;

		datax = getListeX();
		datay = getListeY();
		
		CalculateCorrelation correlation = new CalculateCorrelation(datax, datay);
		resultatCorrelation = correlation.calculate();
		
		assertTrue("Ne peut pas être Nan", !Double.isNaN(resultatCorrelation));
		
	}
	
	@Test
	public void regressionLineaireIsCorrect() {
		double resultatCorrelation = 0.0;
		double resultatCorrAuCarre = 0.0;
		datax = getListeX();
		datay = getListeY();
		
		CalculateCorrelation correlation = new CalculateCorrelation(datax, datay);
		resultatCorrelation = correlation.calculate();
		resultatCorrAuCarre = correlation.calculateCorrelationAuCarre();
						
		assertTrue("Les résultat ne sont pas équivalent.", resultatCorrelation == 0.8032140816632494 && resultatCorrAuCarre == 0.645152860982137);
	}
}
