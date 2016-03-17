package log330_lab1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Jean-S�bastien Ar�s , LOG330 TP4
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
		ArrayList<Double> _sommeHeure = new ArrayList<Double>();
		ArrayList<Double> _noteIntra = new ArrayList<Double>();
		int nbreNotes = 6;
		String path = "test.xlsx";
		String msgErreur = "";
		
		try
		
		{
			DataInjector data = new DataInjector(_sommeHeure, _noteIntra, nbreNotes);
			data.getDonnees(path);
			_sommeHeure = data.sommeHeure;
			_noteIntra = data.noteIntra;				

		CalculateCorrelation correlation = new CalculateCorrelation(_sommeHeure, _noteIntra);
		double resultCorrelation = correlation.calculate();
		System.out.println("Correlation: "+resultCorrelation);
		System.out.println("Correlation au carr�: "  + correlation.calculateCorrelationAuCarre());

		/*TP3*/
		CalculateRegressionLineaire regression = new CalculateRegressionLineaire(_sommeHeure, _noteIntra);
		double[] resultRegression = regression.calculate();
		
		System.out.println("B1: "+ resultRegression[0]);
		System.out.println("B0: "+ resultRegression[1]);
		
		afficherResultats(resultCorrelation);
			
		} 
		catch (FileNotFoundException fnfe) 
		{
			msgErreur = "Le path du fichier sp�cifi� est introuvable";
			System.out.println(msgErreur+"\n");
		}
	}

	private static void afficherResultats(double resultCorrelation) {
		System.out.println("\n*******Interpr�tation de la corr�lation *********");
		if(resultCorrelation <= 0.25)
			System.out.println("La corr�lation entre l'effort et la note � l'intra n'est pas forte (<0.25)");
		else if(resultCorrelation <= 0.50)
			System.out.println("La corr�lation entre l'effort et la note � l'intra est plus ou moin bonne (<0.50)");
		else if(resultCorrelation <= 1.0)
			System.out.println("La corr�lation entre l'effort et la note � l'intra est tr�s forte (a peu pr�s 1.0)");
	}

}
