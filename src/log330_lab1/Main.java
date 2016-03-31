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

	public static void main(String[] args) throws IOException {
		ArrayList<Double> datax = new ArrayList<Double>();
		ArrayList<Double> datay = new ArrayList<Double>();
		ArrayList<Double> dataz = new ArrayList<Double>();

		DataInjector data = new DataInjector();
		datax = data.getListNbrex();
		datay = data.getListNbrey();
		dataz = data.getListNbrez();
		double sommeXMoyen = 0.0;
		double racineCarree = 0.0;
		double ecartType = 197.896;
		double result90 = 0.0;
		double result70 = 0.0;
		double nbreLigneCode = 900.0;
		
		for(int i=0;i<dataz.size();i++)
			sommeXMoyen += dataz.get(i);
		
		racineCarree = Math.sqrt(1+(1/datax.size())+((dataz.get(9))/(sommeXMoyen)));
		
		result90 = 1.860 * ecartType * racineCarree;
		System.out.println("90%: "+ result90);
		System.out.println("entre "+(nbreLigneCode - result90)+" et "+(nbreLigneCode + result90) + " ligne de codes");

		
		result70 = 1.108 * ecartType * racineCarree;
		System.out.println("70%: "+ result70);
		System.out.println("entre "+(nbreLigneCode - result70)+" et "+(nbreLigneCode + result70) + " ligne de codes");
		
		
		/*data.getDonnees(path);
		_sommeHeure = data.sommeHeure;
		_noteIntra = data.noteIntra;				

		/*CalculateCorrelation correlation = new CalculateCorrelation(_sommeHeure, _noteIntra);
		double resultCorrelation = correlation.calculate();
		System.out.println("Correlation: "+resultCorrelation);
		System.out.println("Correlation au carré: "  + correlation.calculateCorrelationAuCarre());
		
		/*TP3*/
				/*CalculateRegressionLineaire regression = new CalculateRegressionLineaire(_sommeHeure, _noteIntra);
		double[] resultRegression = regression.calculate();
		
		System.out.println("B1: "+ resultRegression[0]);
		System.out.println("B0: "+ resultRegression[1]);
		
		afficherResultats(resultCorrelation);*/
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
