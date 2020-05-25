package com.excel.excel;


import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class LeerFicherosExcel {

	public static String[] main() throws IOException {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("C:/survey.csv"));
			String[] nextLine=null;
			String[] var = null;
			while ((nextLine = reader.readNext()) != null) {
				String aux = Arrays.toString(nextLine);
				var = aux.split(",");
				imprimirArray(var);
			}
			return var;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (null != reader) {
				reader.close();
			} 
		}
	}
	

	/*
	 * Impimir una matrix de tamaño m
	 */
	public static void imprimirArray(String[] Array)
	{
		String texto = "";
		for (int i = 0; i < Array.length; i++) {
			texto = (i+1) + " : " + Array[i];
			System.out.println(texto );
		}
	}
}
