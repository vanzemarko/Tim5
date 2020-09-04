package com.example.demo;
import java.sql.*;

public class Baza {

    private Connection konekcija = null;
    public Statement upit = null;
    private String sql;

    public Baza() throws SQLException {
        System.out.println("povezivanje sa bazom...");
        konekcija = DriverManager.getConnection("jdbc:mariadb://localhost/projekatproba", "root", "");
        System.out.println("povezano...");

        upit = konekcija.createStatement();
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public boolean daLiPostojiStudent(int brIndeksa,
                                      int godUpisa) {
        // ako vec postoji student sa ovim indeksom
        // vraca true ako postoji, false ako ne postoji

        sql = "SELECT * FROM `studenti` WHERE `brIndeksa` = ? AND `godUpisa` = ?;";

        try {
            // priprema sql-a za protiv SQL injection-a
            PreparedStatement ps = konekcija.prepareStatement(sql);

            // ubacuje brIndeksa i godUpisa, redom, na mesto znkova pitanja
            ps.setString(1, String.valueOf(brIndeksa));
            ps.setString(2, String.valueOf(godUpisa));

            ResultSet rs = ps.executeQuery();

            if(rs.next() == true)
                return true;    // vec postoji student
            else
                return false;   // ne postoji student
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public void unesiStudenta(String imeStudenta,
                              String prezimeStudenta,
                              int brIndeksa,
                              int godUpisa,
                              int godStudija){
        sql = "INSERT INTO `studenti` (`idStudenta`, `imeStudenta`, `prezimeStudenta`, `brIndeksa`, `godUpisa`, `godStudija`)\n" +
                "VALUES(null, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = konekcija.prepareStatement(sql);

            ps.setString(1, imeStudenta);
            ps.setString(2, prezimeStudenta);
            ps.setString(3, String.valueOf(brIndeksa));
            ps.setString(4, String.valueOf(godUpisa));
            ps.setString(5, String.valueOf(godStudija));

            ResultSet rs = ps.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean daLiPostojiProfesor(int sifraNastavnika) {
        // ako vec postoji profesor sa ovom sifromNastavnika
        // vraca true ako postoji, false ako ne postoji

        sql = "SELECT * FROM `profesor` WHERE `idProfesora` = ? ;";

        try {
            // priprema sql-a za protiv SQL injection-a
            PreparedStatement ps = konekcija.prepareStatement(sql);

            // ubacuje brIndeksa i godUpisa, redom, na mesto znkova pitanja
            ps.setString(1, String.valueOf(sifraNastavnika));

            ResultSet rs = ps.executeQuery();

            if(rs.next() == true)
                return true;    // vec postoji profesor
            else
                return false;   // ne postoji profesor
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public void unesiProfesora(String imeProfesora,
                              String prezimeProfesora){
        sql = "INSERT INTO `profesor` (`idProfesora`, `imeProfesora`, `prezimeProfesora`)\n" +
                "VALUES(null, ?, ?);";

        try {
            PreparedStatement ps = konekcija.prepareStatement(sql);

            ps.setString(1, imeProfesora);
            ps.setString(2, prezimeProfesora);

            ResultSet rs = ps.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean daLiPostojiPredmet(String nazivPredmeta) {
        // ako vec postoji predmet sa ovim nazivom
        // vraca true ako postoji, false ako ne postoji

        sql = "SELECT * FROM `predmeti` WHERE `naziv` = ? ;";

        try {
            // priprema sql-a za protiv SQL injection-a
            PreparedStatement ps = konekcija.prepareStatement(sql);

            // ubacuje nazivPredmeta, redom, na mesto znkova pitanja
            ps.setString(1, nazivPredmeta);

            ResultSet rs = ps.executeQuery();

            if(rs.next() == true)
                return true;    // vec postoji predmet
            else
                return false;   // ne postoji predmet
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public boolean daLiPostojiPredmet(int sifraPredmeta) {
        // ako vec postoji predmet sa ovim idPredmeta
        // vraca true ako postoji, false ako ne postoji

        sql = "SELECT * FROM `predmeti` WHERE `idPredmeta` = ? ;";

        try {
            // priprema sql-a za protiv SQL injection-a
            PreparedStatement ps = konekcija.prepareStatement(sql);

            // ubacuje idPredmeta, redom, na mesto znkova pitanja
            ps.setString(1, String.valueOf(sifraPredmeta));

            ResultSet rs = ps.executeQuery();

            if(rs.next() == true)
                return true;    // vec postoji predmet
            else
                return false;   // ne postoji predmet
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public void unesiPredmet(int godStudija,
                             String nazivPredmeta,
                             int espb,
                             String tip){

        sql = "INSERT INTO `predmeti` (`idPredmeta`, `godinaStudija`, `naziv`, `espb`, `tip`)\n" +
                "VALUES(null, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = konekcija.prepareStatement(sql);

            ps.setString(1, String.valueOf(godStudija));
            ps.setString(2, nazivPredmeta);
            ps.setString(3, String.valueOf(espb));
            ps.setString(4, tip);

            ResultSet rs = ps.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean daLiPostojiAngazovanje(int sifraNast,
                                          int sifraPred) {
        // ako vec postoji par (sifraNast, sifraPred) u tabeli angazovanje
        // vraca true ako postoji, false ako ne postoji

        sql = "SELECT * FROM `angazovanje` WHERE `sifraNast` = ? AND `sifraPred` = ?;";

        try {
            // priprema sql-a za protiv SQL injection-a
            PreparedStatement ps = konekcija.prepareStatement(sql);

            // ubacuje sifraNast i sifraPred, redom, na mesto znkova pitanja
            ps.setString(1, String.valueOf(sifraNast));
            ps.setString(2, String.valueOf(sifraPred));

            ResultSet rs = ps.executeQuery();

            if(rs.next() == true)
                return true;    // vec postoji predmet
            else
                return false;   // ne postoji predmet
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }

    public void unesiAngazovanje(int sifraNast,
                                 int sifraPred){

        sql = "INSERT INTO `angazovanje` (`sifraNast`, `sifraPred`)\n" +
                "VALUES(?, ?);";

        try {
            PreparedStatement ps = konekcija.prepareStatement(sql);

            ps.setString(1, String.valueOf(sifraNast));
            ps.setString(2, String.valueOf(sifraPred));

            ResultSet rs = ps.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
