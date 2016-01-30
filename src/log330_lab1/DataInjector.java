package log330_lab1;

import java.util.ArrayList;

public class DataInjector {

	ArrayList<Integer> listNbrex = new ArrayList<Integer>();
	ArrayList<Double> listNbrey = new ArrayList<Double>();
	
	public ArrayList<Integer> getListNbrex(){
		return listNbrex;
	}
	
	public ArrayList<Double> getListNbrey(){
		return listNbrey;
	}
	
	public void setListNbrex(){
		listNbrex.add(186);
		listNbrex.add(699);
		listNbrex.add(132);
		listNbrex.add(272);
		listNbrex.add(291);
		listNbrex.add(331);
		listNbrex.add(199);
		listNbrex.add(1890);
		listNbrex.add(788);
		listNbrex.add(1601);
	}
	
	public void setListNbrey(){
		listNbrey.add(15.0);
		listNbrey.add(69.9);
		listNbrey.add(6.5);
		listNbrey.add(22.4);
		listNbrey.add(28.4);
		listNbrey.add(65.9);
		listNbrey.add(19.4);
		listNbrey.add(189.7);
		listNbrey.add(38.8);
		listNbrey.add(138.2);
	}

}
