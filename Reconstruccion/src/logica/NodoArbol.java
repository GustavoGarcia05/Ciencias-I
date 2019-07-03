package logica;

public class NodoArbol {

    private String valor;

    public NodoArbol() {
        this.setValor(null);
    }

    public NodoArbol(String valor) {
        this.setValor(valor);
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
