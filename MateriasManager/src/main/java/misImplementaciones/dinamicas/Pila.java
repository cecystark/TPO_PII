package misImplementaciones.dinamicas;

import misApis.PilaTDA;

/*Clase testeada*/
//tope al inicio
public class Pila implements PilaTDA {

    class Nodo{
        int valor;
        Nodo sig;
    }

    Nodo primero;

    @Override
    public void inicializar() {
        Nodo primero = null;
    }

    @Override
    public void apilar(int valor) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.sig = primero;
        nuevoNodo.valor = valor;
        primero = nuevoNodo;
    }

    @Override
    public void desapilar() {
        primero = primero.sig;
    }

    @Override
    public int tope() {
        return primero.valor;
    }

    @Override
    public boolean estaVacia() {
        return primero == null;
    }
}
