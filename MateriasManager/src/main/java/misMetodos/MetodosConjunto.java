package misMetodos;

import misApis.ConjuntoTDA;
import misImplementaciones.dinamicas.Conjunto;

public class MetodosConjunto {

    public static void copiarConjunto(ConjuntoTDA c1, ConjuntoTDA c2){
        ConjuntoTDA aux = new Conjunto();
        aux.inicializar();

        int valor;

        while(!c1.estaVacio()){
            valor = c1.elegir();
            aux.agregar(valor);
            c1.sacar(valor);
        }

        while(!aux.estaVacio()){
            valor = aux.elegir();
            c1.agregar(valor);
            c2.agregar(valor);
            aux.sacar(valor);
        }

    }

    public static void imprimirConjunto(ConjuntoTDA c) {
        int valor;
        ConjuntoTDA aux = new Conjunto();
        aux.inicializar();

        copiarConjunto(c,aux);

        while (!aux.estaVacio()) {
            valor = aux.elegir();
            System.out.println("    " + valor);
            aux.sacar(valor);
        }

    }

}
