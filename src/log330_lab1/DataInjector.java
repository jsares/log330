package log330_lab1;
/*
 * Jean-Sébastien Arès, LOG330 TP4
 * Desc:Classe qui injecte les données du fichier excel
 *  dans 2 tableaux (x et y)
 * 
 * */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInjector {

	ArrayList<Integer> listNbrex = new ArrayList<Integer>();
	ArrayList<Integer> listNbrey = new ArrayList<Integer>();
	
	ArrayList<Double> _sommeHeure = new ArrayList<Double>();
	ArrayList<Double> _noteIntra = new ArrayList<Double>();
	int _nbreNotes = 0;
	
	public DataInjector(){}
	
	public DataInjector(ArrayList<Double> sommeHeure, ArrayList<Double> noteIntra, int nbreNotes){
		_sommeHeure = sommeHeure;
		_noteIntra = noteIntra;
		_nbreNotes = nbreNotes;
	}
	
	public ArrayList<Integer> getListNbrex(){
		return listNbrex;
	}
	
	public ArrayList<Integer> getListNbrey(){
		return listNbrey;
	}
	
	public void setListNbrex(){
		listNbrex.add(130);
		listNbrex.add(650);
		listNbrex.add(99);
		listNbrex.add(150);
		listNbrex.add(128);
		listNbrex.add(302);
		listNbrex.add(95);
		listNbrex.add(945);
		listNbrex.add(368);
		listNbrex.add(961);
	}
	
	public void setListNbrey(){
		listNbrey.add(186);
		listNbrey.add(699);
		listNbrey.add(132);
		listNbrey.add(272);
		listNbrey.add(291);
		listNbrey.add(331);
		listNbrey.add(199);
		listNbrey.add(1890);
		listNbrey.add(788);
		listNbrey.add(1601);
	}
	
	public void getDonnees(String path) throws FileNotFoundException, IOException {
		ArrayList<Double> datax = new ArrayList<Double>();
		FileInputStream file = getFile(path);

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
					if(datax.size()<_nbreNotes){
						datax.add(cell.getNumericCellValue());
					}
					else if(datax.size()==_nbreNotes){
						double result = 0;
						for(int i=0; i<datax.size();i++)
							result += datax.get(i);
						_sommeHeure.add(result);
						_noteIntra.add(cell.getNumericCellValue());
					}
					
						
						
					break;
				case Cell.CELL_TYPE_STRING:
					break;
				}
			}
		}
		file.close();
	}

	private FileInputStream getFile(String path) throws FileNotFoundException {
		FileInputStream file = new FileInputStream(new File(path));
		return file;
	}

}
