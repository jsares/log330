package log330_lab1;

import java.io.File;
import java.io.FileInputStream;
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
		try
		{
			FileInputStream file = new FileInputStream(new File("test.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				datax = new ArrayList<Double>();
				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType()) 
					{
					case Cell.CELL_TYPE_NUMERIC:
						if(datax.size()<nbreNotes){
							datax.add(cell.getNumericCellValue());
						}
						else if(datax.size()==nbreNotes){
							double result = 0;
							for(int i=0; i<datax.size();i++)
								result += datax.get(i);
							sommeHeure.add(result);
							noteIntra.add(cell.getNumericCellValue());
						}
						
							
							
						break;
					case Cell.CELL_TYPE_STRING:
						break;
					}
				}
			}
			file.close();

				
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
		Calculate correlation = new CalculateCorrelation(sommeHeure, noteIntra);
		double resultCorrelation = correlation.calculate();
		System.out.println("Correlation: "+resultCorrelation);
		System.out.println("Correlation au carré: "  + Math.pow(resultCorrelation,2));

		/*TP3*/
		Calculate regression = new CalculateRegressionLineaire(sommeHeure, noteIntra);
		double resultRegression = regression.calculate();
		
		System.out.println("*******Interprétation de la corrélation *********");
		if(resultCorrelation <= 0.25)
			System.out.println("La corrélation entre l'effort et la note à l'intra n'est pas forte (<0.25)");
		else if(resultCorrelation <= 0.50)
			System.out.println("La corrélation entre l'effort et la note à l'intra est plus ou moin bonne (<0.50)");
		else if(resultCorrelation <= 1.0)
			System.out.println("La corrélation entre l'effort et la note à l'intra est très forte (a peu près 1.0)");
		
		

	}

	

}
