package misApis;

public interface ColaPrioTDAParcial {

    void inicializarCola();
    //Debe estar inicializada.
    void acolarPrioridad ( int valor, int prioridad);
    //Debe estar inicializada y no vacia.
    void desacolar();
    //Debe estar inicializada y no vacia.
    int primero();
    //Debe estar inicializada.
    boolean colaVacia ();
    //Debe estar inicializada y no vacia.
    int prioridad();
}
