package ar.edu.uade.fileReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ar.edu.uade.utils.Constantes;

public class Archivo {
	
	private static FileReader fr;
	private static BufferedReader bf;
	
	private static String[] data; 
	
    private static String nro_carrera;
    private static String cod_materia;
    private static String materia_precedente;
    private static String carrera;
    private static String materia;

	public static void parsearDatos() {

    	String fileS = Constantes.RUTA_ARCHIVO;
    	
    	try {
				fr = new FileReader(fileS);
	        	System.out.println("Archivo a procesar:" + fileS);
	
				bf = new BufferedReader(fr);
	        	String sCadena;
	        	
	        	try {
	        		//la primera fila la skipeamos porque son los nombres de las columnas
	        		sCadena = bf.readLine();
	        		
					while ((sCadena = bf.readLine())!=null) {
					    
					    	 data = sCadena.split(";");

					         nro_carrera = data[Constantes.NRO_CARRERA];
					         cod_materia = data[Constantes.COD_MATERIA];
					         materia_precedente = data[Constantes.MATERIA];
					         carrera = data[Constantes.MATERIA_PRECEDENTE];
							 materia = data[Constantes.NRO_CARRERA];

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}      	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
