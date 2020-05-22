package misAplicaciones;

import misApis.DiccionarioMultipleTDA;
import misImplementaciones.dinamicas.DiccionarioMultiple;

public class Main {


	public static void main(String[] args) {

		DiccionarioMultipleTDA registroDeMaterias = new DiccionarioMultiple();
		registroDeMaterias.inicializar();

		LectorDeArchivo.cargarDatos(registroDeMaterias);


	}


}