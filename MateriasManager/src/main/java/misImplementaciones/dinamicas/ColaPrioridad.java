package misImplementaciones.dinamicas;

import misApis.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
    class Nodo{
        int valor;
        int prioridad;
        Nodo siguiente;
    }

    Nodo primero;

    @Override
    public void inicializar() {
        primero  = null;
    }

    @Override
    public void acolarPrioridad(int valor, int prioridad) {

        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = valor;
        nuevoNodo.prioridad = prioridad;

        Nodo nodoAnterior = buscarAnteriorPorPrioridad(prioridad);

        if (nodoAnterior == null) { // o va primero o es el primero, no me importa, lo pongo ahi nomasss, al principio de la lista
            nuevoNodo.siguiente = primero;
            primero = nuevoNodo;
            return;
        }

        nuevoNodo.siguiente = nodoAnterior.siguiente;
        nodoAnterior.siguiente = nuevoNodo;
    }

    private Nodo buscarAnteriorPorPrioridad(int prioridad) {
        Nodo actual = primero;

        if(actual!= null) {
            if(actual.prioridad < prioridad)
                return null;

            while (actual.siguiente != null) {
                if (actual.siguiente.prioridad < prioridad)
                    return actual;

                actual = actual.siguiente;
            }
        }
        return actual;
    }

    @Override
    public void desacolar() {
        if(primero != null)
            primero = primero.siguiente;
    }

    @Override
    public int primero() {
        return primero.valor;
    }

    @Override
    public boolean estaVacia() {
        return primero == null;
    }

    @Override
    public int prioridad() {
        return primero.prioridad;
    }
}
