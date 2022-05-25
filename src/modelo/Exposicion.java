package modelo;


import java.util.Date;

public class Exposicion {

    private int numExp;
    private String nombre;
    private String tematica;
    private Date fechainicio;
    private Date fechafin;
    private String descripcion;
    private Sala numsala;


    public Exposicion(int numExp){
        this.numExp = numExp;
    }

    public Exposicion() {
        this.numsala = new Sala();
    }

    public Exposicion(int numExp, String nombre, String tematica, Date fechainicio, Date fechafin, String descripcion, Sala numsala) {
        this.numsala = new Sala();
        this.numExp = numExp;
        this.nombre = nombre;
        this.tematica = tematica;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.descripcion = descripcion;
        this.numsala.setNumSala(numsala.getNumSala());
    }

    public Exposicion(String nombre) {
        this.nombre = nombre;
    }

    public Exposicion(String nombre, String tematica, Date fechainicio, Date fechafin, String descripcion, Sala numsala) {
        this.numsala = new Sala();
        this.nombre = nombre;
        this.tematica = tematica;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.descripcion = descripcion;
        this.numsala.setNumSala(numsala.getNumSala());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Sala getNumsala() {
        return numsala;
    }

    public void setNumsala(Sala numsala) {
        this.numsala = numsala;
    }

    public int getNumExp() {
        return numExp;
    }

    public void setNumExp(int numExp) {
        this.numExp = numExp;
    }

    /*public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }*/


}
