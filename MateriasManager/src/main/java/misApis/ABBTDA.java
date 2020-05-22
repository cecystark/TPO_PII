package misApis;

public interface ABBTDA {
    void inicializar();
    /*No debe estar vacío*/
    int raiz();
    /*No debe estar vacío*/
    ABBTDA hijoDer();
    /*No debe estar vacío*/
    ABBTDA hijoIzq();
    /*X NO debe existir*/
    void agregar(int x);
    /*X debe existir*/
    void eliminar(int x);
    /*Debe estar inicializado*/
    boolean arbolVacio();
}
