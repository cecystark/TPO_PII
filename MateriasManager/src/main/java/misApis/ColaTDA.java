package misApis;

public interface ColaTDA {
    public void inicializar();
    //Debe estar inicializada.
    public void acolar(int valor);
    //Debe estar inicializada y no vacia.
    public void desacolar();
    //Debe estar inicializada y no vacia.
    public int primero();
    //Debe estar inicializada.
    public boolean estaVacia();
}
