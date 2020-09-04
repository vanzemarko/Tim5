package com.example.demo;

public class Angazovanje {

    private int sifraNast;
    private int sifraPred;

    private String imeProfesora;
    private String prezimeProfesora;
    private String predmet;

    public Angazovanje(int sifraNast, int sifraPred , String imeProfesora, String prezimeProfesora, String predmet) {
        this.sifraNast = sifraNast;
        this.sifraPred = sifraPred;
        this.imeProfesora = imeProfesora;
        this.predmet = predmet;
        this.prezimeProfesora = prezimeProfesora;
    }

    public String getImeProfesora()
    {
        return imeProfesora;
    }

    public String getPrezimeProfesora()
    {
        return prezimeProfesora;
    }

    public String getPredmet()
    {
        return predmet;
    }

    public void setImeProfesora(String imeProfesora)
    {
        this.imeProfesora=imeProfesora;
    }

    public void setPrezimeProfesora(String prezimeProfesora)
    {
        this.prezimeProfesora=prezimeProfesora;
    }

    public void setPredmet(String predmet)
    {
        this.predmet=predmet;
    }

    public int getSifraNast() {
        return sifraNast;
    }

    public void setSifraNast(int id) {
        this.sifraNast = sifraNast;
    }

    public int getSifraPred() {
        return sifraPred;
    }

    public void setSifraPred(int sifraPred) {
        this.sifraPred = sifraPred;
    }

}
