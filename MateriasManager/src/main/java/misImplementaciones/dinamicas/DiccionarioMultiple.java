package misImplementaciones.dinamicas;

import misApis.ConjuntoTDA;
import misApis.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
    class NodoClave{
        int clave;
        NodoClave sigClave;
        NodoValor primerValor;
    }

    class NodoValor{
        int valor;
        NodoValor sigValor;
    }

    NodoClave primerClave;

    @Override
    public void inicializar() {
        primerClave = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        NodoClave claveBuscada = buscarNodoPorClave(clave);
        if(claveBuscada == null){
            claveBuscada = new NodoClave();
            claveBuscada.clave = clave;
            claveBuscada.sigClave = primerClave;
            primerClave = claveBuscada;
        }

        NodoValor valorBuscado = buscarNodoPorValor(claveBuscada, valor);

        if(valorBuscado == null){
            valorBuscado = new NodoValor();
            valorBuscado.valor = valor;
            valorBuscado.sigValor = claveBuscada.primerValor;
            claveBuscada.primerValor = valorBuscado;
        }
    }

    private NodoValor buscarNodoPorValor(NodoClave nodoClave, int valor) {
        NodoValor actual = nodoClave.primerValor;
        while (actual != null){
            if(actual.valor == valor)
                return actual;
            actual = actual.sigValor;
        }
        return null;
    }

    private NodoClave buscarNodoPorClave(int clave) {
        NodoClave actual = primerClave;
        while(actual != null) {
            if (actual.clave == clave)
                return actual;
            actual = actual.sigClave;
        }
        return null;
    }

    @Override
    public void eliminar(int clave) {
        NodoClave actual = primerClave;

        if(actual.clave == clave){ //si la clave que quiero borrar es la primera, la borro y retorno.
            primerClave = actual.sigClave;
            return;
        }

        while (actual.sigClave != null){
            if(actual.sigClave.clave == clave){
                actual.sigClave = actual.sigClave.sigClave;
                return;
            }
            actual = actual.sigClave;
        }
    }

    @Override
    public void eliminarValor(int clave, int valor) {

        NodoClave claveBuscada = buscarNodoPorClave(clave);

        if(claveBuscada!= null) { // si existe la clave de la cual quiero borrar un valor, entonces lo busco, sino no hago nada.
            if(claveBuscada.primerValor.valor == valor){ //si el primer valor de la lista coincide con el que ando buscando
                if( claveBuscada.primerValor.sigValor == null) { //si solo tengo un valor en la lista, borro directamente la clave
                    eliminar(claveBuscada.clave);
                    return;
                }
                claveBuscada.primerValor = claveBuscada.primerValor.sigValor;
                return;
            }

            NodoValor actual = claveBuscada.primerValor;
            while (actual.sigValor != null){
                if(actual.sigValor.valor == valor){
                    actual.sigValor = actual.sigValor.sigValor;
                    return;
                }
                actual = actual.sigValor;
            }
        }
    }

    @Override
    public ConjuntoTDA recuperar(int clave) {
        ConjuntoTDA valores = new Conjunto();
        valores.inicializar();
        NodoClave claveBuscada = buscarNodoPorClave(clave);
        NodoValor actual = claveBuscada.primerValor;

        while(actual != null){
            valores.agregar(actual.valor);
            actual = actual.sigValor;
        }

        return valores;
    }

    @Override
    public ConjuntoTDA claves() {
        NodoClave actual = primerClave;
        ConjuntoTDA todasLasClaves = new Conjunto();
        todasLasClaves.inicializar();

        while (actual != null) {
            todasLasClaves.agregar(actual.clave);
            actual = actual.sigClave;
        }
        return todasLasClaves;
    }
}
