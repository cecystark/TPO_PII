package misApis;

public interface ConjuntoTDA {

    void inicializar();
    //Debe estar inicializado.
    boolean estaVacio();
    //Debe estar inicializado.
    void agregar(int valor);
    //Debe estar inicializado y no vacio.
    int elegir();
    //Debe estar inicializado.
    void sacar(int valor);
    //Debe estar inicializado.
    boolean pertenece(int valor);

}
