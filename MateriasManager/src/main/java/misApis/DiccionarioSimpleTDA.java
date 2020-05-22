package misApis;

public interface DiccionarioSimpleTDA {

    void inicializar() ;
    //Debe estar inicializado.
    void agregar( int clave , int valor);
    //Debe estar inicializado y no vacio.
    void eliminar( int clave);
    //Debe estar inicializado y no vacio.
    int recuperar( int clave);
    //Debe estar inicializado.
    ConjuntoTDA claves();
}
