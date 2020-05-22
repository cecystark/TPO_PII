package misImplementaciones.dinamicas;

import misApis.ConjuntoTDA;
import misApis.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

    class NodoPar{
        int clave;
        int valor;
        NodoPar sigClave;
    }

    NodoPar primero;

    @Override
    public void inicializar() {
        primero = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        NodoPar nodoEncontrado  = buscarNodoPorClave(clave);

        if(nodoEncontrado == null){
            nodoEncontrado = new NodoPar();
            nodoEncontrado.clave = clave;
            nodoEncontrado.sigClave = primero;
            primero = nodoEncontrado;
        }
        nodoEncontrado.valor = valor;
    }

    private NodoPar buscarNodoPorClave(int clave) {

        if(primero != null){
            NodoPar actual = primero;

            while (actual.sigClave != null) {
                if (actual.clave == clave)
                    return actual;
                actual = actual.sigClave;
            }
        }
        return null;
    }

    @Override
    public void eliminar(int clave) {
        if(primero == null) return;
        if(primero.clave == clave){
            primero = primero.sigClave;
            return;
        }

        NodoPar actual = primero;
        while(actual.sigClave != null){
            if(actual.sigClave.clave == clave){
                actual.sigClave = actual.sigClave.sigClave;
                return;
            }
            actual = actual.sigClave;
        }
    }

    @Override
    public int recuperar(int clave) {
        NodoPar actual = primero;
        while (actual.sigClave != null){
            if(actual.clave == clave)
                return actual.valor;
            actual = actual.sigClave;
        }
        return -1;
    }

    @Override
    public ConjuntoTDA claves() {
        if(primero == null) return null; // si el diccionario está vacío, no hago nada, solo devolver null.

        ConjuntoTDA res = new Conjunto();
        res.inicializar();
        NodoPar actual = primero;
        while (actual != null){
            res.agregar(actual.clave);
            actual = actual.sigClave;
        }
        return res;
    }
}
