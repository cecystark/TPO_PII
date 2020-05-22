package misApis;

public interface ColaPrioridadTDA {

    void inicializar();
    //Debe estar inicializada.
    void acolarPrioridad ( int valor, int prioridad);
    //Debe estar inicializada y no vacia.
    void desacolar();
    //Debe estar inicializada y no vacia.
    int primero();
    //Debe estar inicializada.
    boolean estaVacia ();
    //Debe estar inicializada y no vacia.
    int prioridad();
}
