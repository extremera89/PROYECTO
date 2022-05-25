package modelo;

public class Sala {

    private int NumSala; //pk
    private int DadaAlta;
    private int Tamanio;
    private int Aforo;
    private int NumPlanta;

    public Sala() {
    }

    public Sala(int numSala, int dadaAlta, int tamanio, int aforo, int numPlanta) {
        NumSala = numSala;
        DadaAlta = dadaAlta;
        Tamanio = tamanio;
        Aforo = aforo;
        NumPlanta = numPlanta;
    }

    public int getAforo() {
        return Aforo;
    }

    public void setAforo(int aforo) {
        Aforo = aforo;
    }

    public int getNumPlanta() {
        return NumPlanta;
    }

    public void setNumPlanta(int numPlanta) {
        NumPlanta = numPlanta;
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
                ", Aforo=" + Aforo +
                ", NumPlanta=" + NumPlanta +
                '}';
    }
}
