package misAplicaciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import misApis.DiccionarioMultipleTDA;
import misMetodos.MetodosDiccionario;
import misMetodos.MetodosFuncionales;
import misUtilidades.Constantes;

public class LectorDeArchivo {
	
	private static FileReader fr;
	private static BufferedReader bf;
	
	private static String[] data; 
	
    private static String nro_carrera;
    private static String cod_materia;
    private static String materia_precedente;
    private static String carrera;
    private static String materia;

	public static void cargarDatos(DiccionarioMultipleTDA registroDeMaterias) {

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
					         materia_precedente = data[Constantes.MATERIA_PRECEDENTE];
					         carrera = data[Constantes.CARRERA];
							 materia = data[Constantes.MATERIA];

							MetodosFuncionales.registrarMateria(registroDeMaterias, nro_carrera, cod_materia);

					}
					MetodosDiccionario.imprimirDiccionario(registroDeMaterias);

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
