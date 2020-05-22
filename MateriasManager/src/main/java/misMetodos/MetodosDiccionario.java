package misMetodos;

import misApis.ConjuntoTDA;
import misApis.DiccionarioMultipleTDA;
import misImplementaciones.dinamicas.Conjunto;

public class MetodosDiccionario {

    public static void imprimirDiccionario(DiccionarioMultipleTDA dm) {
        int clave;
        ConjuntoTDA claves = dm.claves();
        ConjuntoTDA valores;

        while (!claves.estaVacio()) {
            clave = claves.elegir();
            valores = dm.recuperar(clave);
            System.out.println("Clave: " + "\n    " + clave);
            System.out.println("Valores: ");
            MetodosConjunto.imprimirConjunto(valores);

            claves.sacar(clave);
        }
    }
}
