package misImplementaciones.dinamicas;

import misApis.ABBTDA;

public class ABB implements ABBTDA {

    class Nodo{
        int valor;
        ABBTDA hijoIzq;
        ABBTDA hijoDer;
    }
    Nodo raiz;

    @Override
    public void inicializar() {
        raiz = null;
    }

    @Override
    public int raiz() {
        return raiz.valor;
    }

    @Override
    public ABBTDA hijoDer() {
        return raiz.hijoDer;
    }

    @Override
    public ABBTDA hijoIzq() {
        return raiz.hijoIzq;
    }

    @Override
    public void agregar(int x) {
        Nodo nuevoNodo = new Nodo();
        if(raiz == null){
            raiz.valor = x;
            raiz.hijoDer = new ABB();
            raiz.hijoDer.inicializar();
            raiz.hijoIzq = new ABB();
            raiz.hijoIzq.inicializar();
            return;
        }

        if(raiz.valor < x)
            raiz.hijoDer.agregar(x);
        else
            raiz.hijoIzq.agregar(x);
    }

    @Override
    public void eliminar(int x) {
        if(raiz != null){
            if(raiz.valor == x && raiz.hijoDer.arbolVacio() && raiz.hijoIzq.arbolVacio())
                raiz = null;
            else if(raiz.valor == x && !raiz.hijoIzq.arbolVacio()){
                raiz.valor = mayor(raiz.hijoIzq);
                raiz.hijoIzq.eliminar(raiz.valor);
            }
            else if(raiz.valor == x && raiz.hijoIzq.arbolVacio()){
                raiz.valor = menor(raiz.hijoDer);
                raiz.hijoDer.eliminar(raiz.valor);
            }
            else if(raiz.valor < x)
                raiz.hijoDer.eliminar(x);
            else
                raiz.hijoIzq.eliminar(x);
        }
    }

    private int mayor(ABBTDA arbol) {
        if(arbol.hijoDer().arbolVacio())
            return arbol.raiz();
        else
            return mayor(arbol.hijoDer());
    }

    private int menor(ABBTDA arbol) {
        if(arbol.hijoIzq().arbolVacio())
            return arbol.raiz();
        else
            return menor(arbol.hijoIzq());
    }

    @Override
    public boolean arbolVacio() {
        return raiz == null;
    }
}
