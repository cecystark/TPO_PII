package misApis;

public interface PilaTDA {
    public void inicializar();
    //Debe estar inicializada.
    public void apilar(int valor);
    //No debe estar vacia.
    public void desapilar();
    //No debe estar vacia.
    public int tope();
    //Debe estar inicializada.
    public boolean estaVacia();
}
