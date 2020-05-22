package misApis;

public interface DiccionarioMultipleTDA {
    void inicializar () ;
    //Debe estar inicializado.
    void agregar( int clave , int valor);
    //Debe estar inicializado y no vacio.
    void eliminar( int clave);
    //Debe estar inicializado y no vacio.
    void eliminarValor( int clave , int valor);
    //Debe estar inicializado y no vacio.
    ConjuntoTDA recuperar(int clave);
    //Debe estar inicializado y no vacio.
    ConjuntoTDA claves();
}
