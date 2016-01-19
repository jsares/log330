package log330_lab1;

import java.util.ArrayList;

public class DataInjector {

	ArrayList<Integer> listNbre = new ArrayList<Integer>();
	
	public ArrayList<Integer> getListNbre(){
		return listNbre;
		
	}
	
	public void setListNbre(){
		listNbre.add(186);
		listNbre.add(699);
		listNbre.add(132);
		listNbre.add(272);
		listNbre.add(291);
		listNbre.add(331);
		listNbre.add(199);
		listNbre.add(1890);
		listNbre.add(788);
		listNbre.add(1601);
	}
}
