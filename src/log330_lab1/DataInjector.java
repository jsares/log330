package log330_lab1;

import java.util.ArrayList;

public class DataInjector {

	ArrayList<Integer> listNbrex = new ArrayList<Integer>();
	ArrayList<Integer> listNbrey = new ArrayList<Integer>();
	
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

}
