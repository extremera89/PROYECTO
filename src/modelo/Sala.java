package modelo;

public class Sala {

    private int NumSala; //pk
    private boolean DadaAlta;
    private int Tamanio;

    public Sala(int numSala, boolean dadaAlta, int tamanio) {
        NumSala = numSala;
        DadaAlta = dadaAlta;
        Tamanio = tamanio;
    }

    public int getNumSala() {
        return NumSala;
    }

    public void setNumSala(int numSala) {
        NumSala = numSala;
    }

    public boolean isDadaAlta() {
        return DadaAlta;
    }

    public void setDadaAlta(boolean dadaAlta) {
        DadaAlta = dadaAlta;
    }

    public int getTamanio() {
        return Tamanio;
    }

    public void setTamanio(int tamanio) {
        Tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "NumSala=" + NumSala +
                ", DadaAlta=" + DadaAlta +
                ", Tamanio=" + Tamanio +
                '}';
    }
}
