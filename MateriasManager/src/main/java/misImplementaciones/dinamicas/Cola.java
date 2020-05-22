package misImplementaciones.dinamicas;

import misApis.ColaTDA;

//ingreso elementos siempre al inicio, y desacolo siempre el último nodo
public class Cola implements ColaTDA {

    class Nodo{
        int valor;
        Nodo siguiente;
    }

    Nodo primero;
    Nodo ultimo;

    @Override
    public void inicializar() {
        primero = null;
        ultimo = null;
    }

    //acolo al final
    @Override
    public void acolar(int valor) {

        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = valor;
        nuevoNodo.siguiente = null;

        // cola no vacia
        if(ultimo != null)
            ultimo.siguiente = nuevoNodo;

        ultimo = nuevoNodo;

        if(primero == null)
            primero = ultimo;
    }

    //desacolo al inicio
    @Override
    public void desacolar() {
        if (primero == ultimo){
            primero = null;
            ultimo = null;
        }
        else
            primero = primero.siguiente;
    }

    @Override
    public int primero() {
        return primero.valor;
    }

    @Override
    public boolean estaVacia() {
        return ultimo == null;
    }
}
