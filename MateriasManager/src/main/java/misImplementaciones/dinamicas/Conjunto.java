package misImplementaciones.dinamicas;

import misApis.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {

    class Nodo{
        int valor;
        Nodo siguiente;
    }

    Nodo primero;

    @Override
    public void inicializar() {
        primero = null;
    }

    @Override
    public boolean estaVacio() {
        return primero == null;
    }

    @Override
    public void agregar(int valor) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = valor;
        nuevoNodo.siguiente = primero;
        primero = nuevoNodo;
    }

    @Override
    public int elegir() {
        return primero.valor;
    }

    @Override
    public void sacar(int valor) {
        Nodo aux;

        if (primero!= null){ //si el conjunto no está vacío
            if(primero.valor == valor) // esta primero
                primero = primero.siguiente;
            else {
                aux = primero;
                while (aux.siguiente != null && aux.siguiente.valor != valor)
                    aux = aux.siguiente;

                if(aux.siguiente != null)  //si realmente existe el nodo que busco, si es null no está en el conjunto
                   aux.siguiente = aux.siguiente.siguiente;
            }
        }
    }

    @Override
    public boolean pertenece(int valor) {
        Nodo aux = primero;

        while(aux != null && aux.valor != valor)
            aux = aux.siguiente;

        return aux!=null;
    }
}
