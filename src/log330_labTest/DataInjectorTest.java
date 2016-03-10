package log330_labTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import log330_lab1.DataInjector;

public class DataInjectorTest {

	@Test (expected=FileNotFoundException.class)
	public void filePathIsWrong() throws Exception {
		
		DataInjector data = new DataInjector(new ArrayList<Double>(), new ArrayList<Double>(), 0);
		data.getDonnees("fsdhgs.xsks");
	}
	
	@Test (expected=FileNotFoundException.class)
	public void filePathIsNull() throws Exception {
		
		DataInjector data = new DataInjector(new ArrayList<Double>(), new ArrayList<Double>(), 0);
		data.getDonnees("");
	}

}
