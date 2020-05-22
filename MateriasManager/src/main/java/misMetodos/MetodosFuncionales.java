package misMetodos;

import misApis.ConjuntoTDA;
import misApis.DiccionarioMultipleTDA;

public class MetodosFuncionales {

    public static void registrarMateria(DiccionarioMultipleTDA dm, String codigoCarrera, String codigoMateria){
        int codigo = Integer.parseInt(codigoCarrera);
        int materia = Integer.parseInt(codigoMateria);

        dm.agregar(codigo, materia);
    }
}
