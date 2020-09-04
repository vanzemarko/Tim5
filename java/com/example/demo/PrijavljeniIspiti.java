package com.example.demo;

public class PrijavljeniIspiti {

    private int sifraPredmeta;
    private int brojIndeksaStudenta;
    private int godUpisaStudenta;
    private int idStudenta;

    public PrijavljeniIspiti(int sifraPredmeta, int brojIndeksaStudenta, int godUpisaStudenta, int idStudenta) {
        this.sifraPredmeta = sifraPredmeta;
        this.brojIndeksaStudenta = brojIndeksaStudenta;
        this.godUpisaStudenta = godUpisaStudenta;
        this.idStudenta = idStudenta;
    }

    public int getIdStudenta() {
        return idStudenta;
    }

    public int getSifraPredmeta() {
        return sifraPredmeta;
    }

    public int getBrojIndeksaStudenta() {
        return brojIndeksaStudenta;
    }

    public int getGodUpisaStudenta() {
        return godUpisaStudenta;
    }

    public void setIdStudenta(int idStudenta) {
        this.idStudenta = idStudenta;
    }

    public void setSifraPredmeta(int sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public void setBrojIndeksaStudenta(int brojIndeksaStudenta) {
        this.brojIndeksaStudenta = brojIndeksaStudenta;
    }

    public void setGodUpisaStudenta(int godUpisaStudenta) {
        this.godUpisaStudenta = godUpisaStudenta;
    }
}
