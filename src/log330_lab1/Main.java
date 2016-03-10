package log330_lab1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Jean-Sébastien Arès , LOG330 TP4
 * Desc: Classe Main
 * 
 * */

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Main {

	public static void main(String[] args) {
		ArrayList<Double> datax = new ArrayList<Double>();
		ArrayList<Double> sommeHeure = new ArrayList<Double>();
		ArrayList<Double> noteIntra = new ArrayList<Double>();
		int nbreNotes = 6;
		String path = "test.xlsx";
		
		try
		{
			DataInjector data = new DataInjector(sommeHeure, noteIntra, nbreNotes);
			data.getDonnees(path);
			sommeHeure = data._sommeHeure;
			noteIntra = data._noteIntra;				
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}


		/*TP3
		DataInjector dataInjector = new DataInjector();

		ArrayList<Integer> datax = new ArrayList<Integer>();
		ArrayList<Integer> datay = new ArrayList<Integer>();

		dataInjector.setListNbrex();
		dataInjector.setListNbrey();
		datax = dataInjector.getListNbrex();
		datay = dataInjector.getListNbrey();


		Calculate regression = new CalculateRegressionLineaire(datax, datay);
		double resultRegression = regression.calculate();*/


		//TP1
		/*Calculate avg = new CalculateMoyenne(datax);
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
		 */
		CalculateCorrelation correlation = new CalculateCorrelation(sommeHeure, noteIntra);
		double resultCorrelation = correlation.calculate();
		System.out.println("Correlation: "+resultCorrelation);
		System.out.println("Correlation au carré: "  + correlation.calculateCorrelationAuCarre());

		/*TP3*/
		CalculateRegressionLineaire regression = new CalculateRegressionLineaire(sommeHeure, noteIntra);
		double[] resultRegression = regression.calculate();
		
		System.out.println("B1: "+ resultRegression[0]);
		System.out.println("B0: "+ resultRegression[1]);
		
		afficherResultats(resultCorrelation);
			
	}

	private static void afficherResultats(double resultCorrelation) {
		System.out.println("\n*******Interprétation de la corrélation *********");
		if(resultCorrelation <= 0.25)
			System.out.println("La corrélation entre l'effort et la note à l'intra n'est pas forte (<0.25)");
		else if(resultCorrelation <= 0.50)
			System.out.println("La corrélation entre l'effort et la note à l'intra est plus ou moin bonne (<0.50)");
		else if(resultCorrelation <= 1.0)
			System.out.println("La corrélation entre l'effort et la note à l'intra est très forte (a peu près 1.0)");
	}

}
