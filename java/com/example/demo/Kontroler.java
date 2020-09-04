package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Kontroler {

    @GetMapping("/listajStudente")
    public List<Student> listajStudente(Baza b) throws SQLException {

        System.out.println("selektovanje...");
        b.setSql("SELECT * FROM studenti ORDER BY godUpisa asc, brIndeksa asc");

        ResultSet rs = b.upit.executeQuery(b.getSql());

        int brRedova = 0;

        List<Student> lista = new ArrayList<Student>();
        while( rs.next() )
        {
            Student s = new Student(rs.getInt("idStudenta"),
                    rs.getInt("brIndeksa"),
                    rs.getInt("godUpisa"),
                    rs.getString("imeStudenta"),
                    rs.getString("prezimeStudenta"),
                    rs.getInt("godStudija"));

            System.out.println("Red " + brRedova++ + " :");
            System.out.println("\tID: " + rs.getInt("idStudenta"));

            System.out.println("\tIme: " + rs.getString("imeStudenta"));

            System.out.println("\tPrezime: " + rs.getString("prezimeStudenta"));

            System.out.println("\tIndeks: " + rs.getString("brIndeksa"));

            System.out.println("\tGodina upisa: " + rs.getString("godUpisa"));

            System.out.println("\tGodina studija: " + rs.getInt("godStudija"));

            lista.add(s);
        }

        System.out.println("selektovano");
        return lista;
    }

    @GetMapping("/listajProfesore")
    public List<Profesor> listajProfesore(Baza b) throws SQLException {

        System.out.println("selektovanje...");
        b.setSql("SELECT * FROM profesor");

        ResultSet rs = b.upit.executeQuery(b.getSql());

        int brRedova = 0;

        List<Profesor> lista = new ArrayList<Profesor>();
        while( rs.next() )
        {
            Profesor p = new Profesor(rs.getInt("idProfesora"),
                    rs.getString("imeProfesora"),
                    rs.getString("prezimeProfesora"));

            System.out.println("Red " + brRedova++ + " :");
            System.out.println("\tID: " + rs.getInt("idProfesora"));

            System.out.println("\tIme: " + rs.getString("imeProfesora"));

            System.out.println("\tPrezime: " + rs.getString("prezimeProfesora"));

            lista.add(p);
        }

        System.out.println("selektovano");
        return lista;
    }

    @GetMapping("/listajPredmete")
    public List<Predmet> listajPredmete(Baza b) throws SQLException {

        System.out.println("selektovanje...");
        b.setSql("SELECT * FROM predmeti");

        ResultSet rs = b.upit.executeQuery(b.getSql());

        int brRedova = 0;

        List<Predmet> lista = new ArrayList<Predmet>();
        while( rs.next() )
        {
            Predmet p = new Predmet(rs.getInt("idPredmeta"),
                    rs.getInt("godinaStudija"),
                    rs.getString("naziv"),
                    rs.getInt("espb"),
                    rs. getString ("tip"));

            System.out.println("Red " + brRedova++ + " :");
            System.out.println("\tID: " + rs.getInt("idPredmeta"));
            System.out.println("\tGodSt: " + rs.getInt("godinaStudija"));

            System.out.println("\tNaziv: " + rs.getString("naziv"));
            System.out.println("\tESPB: " + rs.getInt("espb"));
            System.out.println("\tTIP: " + rs.getString("tip"));


            lista.add(p);
        }

        System.out.println("selektovano");
        return lista;
    }

    @GetMapping("/listajPolozeneIspite")
    public List<PolozeniIspit> listajPolozeneIspite(Baza b) throws SQLException {

        System.out.println("selektovanje...");
        b.setSql("SELECT pi.sifraPredmeta, p.naziv, pi.brIndeksa, pi.godUpisa, s.imeStudenta, s.prezimeStudenta, pi.ocena, p.tip, p.godinaStudija, s.idStudenta FROM polozeniispiti pi JOIN predmeti p ON pi.sifraPredmeta = p.idPredmeta JOIN studenti s ON s.brIndeksa = pi.brIndeksa AND s.godUpisa = pi.godUpisa ORDER BY pi.sifraPredmeta asc, pi.godUpisa asc, pi.brIndeksa asc");

        ResultSet rs = b.upit.executeQuery(b.getSql());

        int brRedova = 0;

        List<PolozeniIspit> lista = new ArrayList<PolozeniIspit>();
        while( rs.next() )
        {
            PolozeniIspit p = new PolozeniIspit(rs.getInt("sifraPredmeta"),
                    rs.getString("naziv"),
                    rs.getInt("brIndeksa"),
                    rs.getInt("godUpisa"),
                    rs.getString("imeStudenta"),
                    rs.getString("prezimeStudenta"),
                    rs.getInt("ocena"),
                    rs.getString("tip"),
                    rs.getInt("godinaStudija"),
                    rs.getInt("idStudenta"));

            System.out.println("Red " + brRedova++ + " :");
            System.out.println("\tŠifra premdeta: " + rs.getInt("sifraPredmeta"));
            System.out.println("\tNaziv premdeta: " + rs.getString("naziv"));
            System.out.println("\tBroj indeksa: " + rs.getInt("brIndeksa"));

            System.out.println("\tGodina Upisa: " + rs.getInt("godUpisa"));
            System.out.println("\tIme: " + rs.getString("imeStudenta"));

            System.out.println("\tPrezime: " + rs.getString("prezimeStudenta"));
            System.out.println("\tOcena: " + rs.getInt("ocena"));
            System.out.println("\tTip predmeta: " + rs.getString("tip"));
            System.out.println("\tGod studija: " + rs.getInt("godinaStudija"));

            lista.add(p);
        }

        System.out.println("selektovano");
        return lista;
    }

    @GetMapping("/listajPrijavljeneIspite")//odarditi JOIN ZA NAZIVE PREDMETA
    public List<PrijavljeniIspiti> listajPrijavljeneIspite(Baza b) throws SQLException {

        System.out.println("selektovanje...");
        b.setSql("SELECT * FROM prijavljeniispiti p JOIN studenti s ON s.brIndeksa = p.brojIndeksaStudenta AND s.godUpisa = p.godUpisaStudenta ORDER BY sifraPredmeta asc, godUpisaStudenta asc, brojIndeksaStudenta asc ");

        ResultSet rs = b.upit.executeQuery(b.getSql());

        int brRedova = 0;

        List<PrijavljeniIspiti> lista = new ArrayList<PrijavljeniIspiti>();
        while( rs.next() )
        {
            PrijavljeniIspiti p = new PrijavljeniIspiti(rs.getInt("sifraPredmeta"),
                    rs.getInt("brojIndeksaStudenta"),
                    rs.getInt("godUpisaStudenta"),
                    rs.getInt("idStudenta"));

            System.out.println("Red " + brRedova++ + " :");
            System.out.println("\tID: " + rs.getInt("sifraPredmeta"));
            System.out.println("\tIndeks: " + rs.getInt("brojIndeksaStudenta"));
            System.out.println("\tGodUpisa: " + rs.getInt("godUpisaStudenta"));
            System.out.println("\tID Studenta: " + rs.getInt("idStudenta"));

            lista.add(p);
        }

        System.out.println("selektovano");
        return lista;
    }

    @GetMapping("/listajAngazovanja")
    public List<Angazovanje> listajAngazovanja(Baza b) throws SQLException {

        System.out.println("selektovanje...");
        b.setSql("SELECT * FROM angazovanje ORDER BY sifraNast asc, sifraPred asc");

        ResultSet rs = b.upit.executeQuery(b.getSql());

        int brRedova = 0;

        List<Angazovanje> lista = new ArrayList<Angazovanje>();
        while( rs.next() )
        {
            Angazovanje p = new Angazovanje(rs.getInt("sifraNast"),
                    rs.getInt("sifraPred"),"","","");

            System.out.println("Red " + brRedova++ + " :");
            System.out.println("\tŠifra Nastavnika: " + rs.getInt("sifraNast"));

            System.out.println("\tŠifra Predmeta: " + rs.getInt("sifraPred"));

            lista.add(p);
        }

        System.out.println("selektovano");
        return lista;
    }

    @GetMapping("/listajAngazovanja2")
    public List<Angazovanje> listajAngazovanja2(Baza b) throws SQLException {

        System.out.println("selektovanje...");
        b.setSql("SELECT * FROM angazovanje ORDER BY sifraNast asc, sifraPred asc");
        ResultSet rs = b.upit.executeQuery(b.getSql());

        int brRedova = 0;

        List<Angazovanje> lista = new ArrayList<Angazovanje>();
        while( rs.next() ) {
            b.setSql("SELECT * FROM profesor WHERE `idProfesora`=" + rs.getInt("sifraNast")+"");
            ResultSet rs1 = b.upit.executeQuery(b.getSql());

            b.setSql("SELECT * FROM predmeti WHERE `idPredmeta`=" + rs.getInt("sifraPred")+"");
            ResultSet rs2 = b.upit.executeQuery(b.getSql());

            if ((rs1.next()==true) && (rs2.next()==true))
            {
                Angazovanje p = new Angazovanje(rs.getInt("sifraNast"),rs.getInt("sifraPred"),rs1.getString("imeProfesora"),rs1.getString("prezimeProfesora"),rs2.getString("naziv"));

                System.out.println("Red " + brRedova++ + " :");
                System.out.println("\tIme Nastavnika: " + rs1.getString("imeProfesora")+" "+rs1.getString("prezimeProfesora"));

                System.out.println("\tNaziv Predmeta: " + rs2.getString("naziv"));

                lista.add(p);
            }
            else
            {
                System.out.println("NEMA");
            }
        }

        System.out.println("selektovano");
        return lista;
    }


    @GetMapping("/azurirajObaveznePredmete")//dodato
    public void azurirajObaveznePredmetes(Baza b) throws SQLException {

        System.out.println("Brišem stare studente sa obaveznim predmetima");
        b.setSql("DELETE FROM studentisapredmetimakojeslusaju WHERE `idPredmeta` IN (SELECT `idPredmeta` FROM predmeti WHERE `tip`='"+"obavezni"+"')");

        ResultSet rezultat1 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

        System.out.println("Ažuriram obavezne premete u tabeli StudentiSaPredmetimaKojeSlusaju");

        b.setSql("INSERT INTO `studentisapredmetimakojeslusaju` (`brIndeksa`, `godUpisa`, `idPredmeta`) SELECT s.brIndeksa, s.godUpisa, p.idPredmeta FROM predmeti p JOIN studenti s ON p.godinaStudija <= s.godStudija AND p.tip = 'obavezni' WHERE NOT EXISTS ( SELECT * FROM polozeniispiti pi WHERE s.brIndeksa = pi.brIndeksa AND s.godUpisa = pi.godUpisa AND p.idPredmeta = pi.sifraPredmeta)");
        ResultSet rezultat2 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

        System.out.println("Završeno ažuriranje tabele");

    }



/*
    @GetMapping("/predmeteKojeStudentiSlusaju")//dodato
    public List<PredmetiKojeStudentiSlusaju> listajprePredmetiKojeStudentiSlusaju(Baza b) throws SQLException {


        System.out.println("selektovanje...");
        b.setSql("SELECT * FROM studentisapredmetimakojeslusaju sp join studenti s ON sp.brIndeksa = s.brIndeksa AND sp.godUpisa = s.godUpisa JOIN predmeti p ON p.idPredmeta = sp.idPredmeta ");

        ResultSet rs = b.upit.executeQuery(b.getSql());

        int brRedova = 0;

        List<PredmetiKojeStudentiSlusaju> lista = new ArrayList<PredmetiKojeStudentiSlusaju>();
        while( rs.next() )
        {
            PredmetiKojeStudentiSlusaju p = new PredmetiKojeStudentiSlusaju(
                    rs.getInt("brIndeksa"),
                    rs.getInt("godUpisa"),
                    rs.getInt("godStudija"),
                    rs.getString("imeStudenta"),
                    rs.getString("prezimeStudenta"),
                    rs.getInt("idPredmeta"),
                    rs.getString("naziv"),
                    rs.getInt("espb"));

            System.out.println("Red " + brRedova++ + " :");
            System.out.println("\tStudent: " + rs.getInt("brIndeksa") + "/" + rs.getInt("godUpisa") + "-" + rs.getInt("godStudija") + " " + rs.getString("imeStudenta") + " " + rs.getString("prezimeStudenta"));

            System.out.println("\tNaziv Predmeta: " + rs.getString("idPredmeta") + " " + rs.getString("naziv") + " ESPB: " + rs.getInt("espb"));

            lista.add(p);
        }

        System.out.println("selektovano");
        return lista;
    }
*/


//listaPredmetaKojeSTUDENTslusa  TESTING

    @GetMapping("/predmeteKojeStudentiSlusaju")//dodato
    public List<PredmetiKojeStudentiSlusaju> listajprePredmetiKojeStudentiSlusaju(Baza b,
                                                                                  @RequestParam(name = "korisnik", defaultValue = "noUser") String user
    ) throws SQLException {
        List<PredmetiKojeStudentiSlusaju> lista = new ArrayList<PredmetiKojeStudentiSlusaju>();
        if (user.equals("noUser"))
            System.out.println("NEMA ULOGOVANOG");
        else

        {

            //--------------------------------------//
            //Luka.Maletkovic-16

            String string = user;
            String[] niz = string.split("\\-");
            System.out.println("PODACI SE OBRADjUJU!!");
            System.out.println("User!"+string);

            if (niz.length > 1) {
                String username = niz[0]; // username
                String password = niz[1]; // password

                System.out.println("Username!" + niz[0]);
                System.out.println("Password!" + niz[1]);

                String string1 = username;
                String[] niz1 = string.split("\\.");

                if (niz1.length > 1) {
                    String part1 = niz1[0]; // ime
                    String part2 = niz1[1]; // prezime-ID
                    System.out.println("\nIme!" + niz1[0]);
                    System.out.println("Prezime!" + niz1[1]);

                    String[] niz2 = niz1[1].split("\\-");
                    String part3 = niz2[0]; // prezime
                    String part4 = niz2[1]; //ID
                    b.setSql("SELECT * FROM profesor WHERE `imeProfesora` ='" + niz1[0] + "' AND `prezimeProfesora`='" + niz2[0] + "' AND `idProfesora`='" + password + "'");
                    ResultSet rs1 = b.upit.executeQuery(b.getSql());

                    b.setSql("SELECT * FROM studenti WHERE `imeStudenta` ='" + niz1[0] + "' AND `prezimeStudenta`='" + niz2[0] + "' AND `idStudenta`='" + password + "'");
                    ResultSet rs2 = b.upit.executeQuery(b.getSql());

                    if (rs1.next()) {
                        System.out.println("Ulogovan profesor!");
                        b.setSql("SELECT * FROM studentisapredmetimakojeslusaju sp join studenti s ON sp.brIndeksa = s.brIndeksa AND sp.godUpisa = s.godUpisa JOIN predmeti p ON p.idPredmeta = sp.idPredmeta ");

                    } else if (rs2.next()) {
                        System.out.println("Ulogovan student!");
                        b.setSql("SELECT * FROM studentisapredmetimakojeslusaju sp join studenti s ON sp.brIndeksa = s.brIndeksa AND s.idStudenta = '" + password + "' AND sp.godUpisa = s.godUpisa JOIN predmeti p ON p.idPredmeta = sp.idPredmeta ");
                    }
                } else {
                    System.out.println("Ulogovan admin!");
                    b.setSql("SELECT * FROM studentisapredmetimakojeslusaju sp join studenti s ON sp.brIndeksa = s.brIndeksa AND sp.godUpisa = s.godUpisa JOIN predmeti p ON p.idPredmeta = sp.idPredmeta ");
                }

                System.out.println("selektovanje...");

                ResultSet rs = b.upit.executeQuery(b.getSql());

                int brRedova = 0;

                while (rs.next()) {
                    PredmetiKojeStudentiSlusaju p = new PredmetiKojeStudentiSlusaju(
                            rs.getInt("brIndeksa"),
                            rs.getInt("godUpisa"),
                            rs.getInt("godStudija"),
                            rs.getString("imeStudenta"),
                            rs.getString("prezimeStudenta"),
                            rs.getInt("idPredmeta"),
                            rs.getString("naziv"),
                            rs.getInt("espb"));

                    System.out.println("Red " + brRedova++ + " :");
                    System.out.println("\tStudent: " + rs.getInt("brIndeksa") + "/" + rs.getInt("godUpisa") + "-" + rs.getInt("godStudija") + " " + rs.getString("imeStudenta") + " " + rs.getString("prezimeStudenta"));

                    System.out.println("\tNaziv Predmeta: " + rs.getString("idPredmeta") + " " + rs.getString("naziv") + " ESPB: " + rs.getInt("espb"));

                    lista.add(p);
                }
                System.out.println("selektovano");
            }
        }return lista;
    }


}
