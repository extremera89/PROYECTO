package modelo;

public class Sala {

    private int NumSala; //pk
    private int DadaAlta;
    private int Tamanio;

    public Sala() {
    }

    public Sala(int numSala, int dadaAlta, int tamanio) {
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

    public int getDadaAlta() {
        return DadaAlta;
    }

    public void setDadaAlta(int dadaAlta) {
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
