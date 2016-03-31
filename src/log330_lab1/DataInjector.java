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

	ArrayList<Double> listNbrex = new ArrayList<Double>();
	ArrayList<Double> listNbrey = new ArrayList<Double>();
	ArrayList<Double> listNbrez = new ArrayList<Double>();
	
	ArrayList<Double> sommeHeure = new ArrayList<Double>();
	ArrayList<Double> noteIntra = new ArrayList<Double>();
	int _nbreNotes = 0;
	
	public DataInjector(){
		setListNbrex();
		setListNbrey();
		setListNbrez();
	}
	
	public DataInjector(ArrayList<Double> _sommeHeure, ArrayList<Double> _noteIntra, int nbreNotes){
		sommeHeure = _sommeHeure;
		noteIntra = _noteIntra;
		_nbreNotes = nbreNotes;
	}
	
	public ArrayList<Double> getListNbrex(){
		return listNbrex;
	}
	
	public ArrayList<Double> getListNbrey(){
		return listNbrey;
	}
	public ArrayList<Double> getListNbrez(){
		return listNbrez;
	}
	
	public void setListNbrex(){
		listNbrex.add(130.0);
		listNbrex.add(650.0);
		listNbrex.add(99.0);
		listNbrex.add(150.0);
		listNbrex.add(128.0);
		listNbrex.add(302.0);
		listNbrex.add(95.0);
		listNbrex.add(945.0);
		listNbrex.add(368.0);
		listNbrex.add(961.0);
	}
	
	public void setListNbrey(){
		listNbrey.add(186.0);
		listNbrey.add(699.0);
		listNbrey.add(132.0);
		listNbrey.add(272.0);
		listNbrey.add(291.0);
		listNbrey.add(331.0);
		listNbrey.add(199.0);
		listNbrey.add(1890.0);
		listNbrey.add(788.0);
		listNbrey.add(1601.0);
	}
	
	public void setListNbrez(){
		listNbrez.add(63907.84);
		listNbrez.add(71395.84);
		listNbrez.add(80542.44);
		listNbrez.add(54195.84);
		listNbrez.add(64923.04);
		listNbrez.add(6528.64);
		listNbrez.add(82828.84);
		listNbrez.add(316068.84);
		listNbrez.add(219.04);
		listNbrez.add(334315.24);
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

	private FileInputStream getFile(String path) throws FileNotFoundException {
		FileInputStream file = new FileInputStream(new File(path));
		return file;
	}

}
