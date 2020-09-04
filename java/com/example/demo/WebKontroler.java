package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebKontroler {

    /*@GetMapping("/")
    public String home() {

        return "login";
    }*/

    @GetMapping("/indexx")
    public String homee() {

        return "indexx";
    }

    /*TESTING LOGIN*/
    @GetMapping("/")
    public String login(Baza b,
                        @RequestParam(name = "username", defaultValue = "") String user,
                        @RequestParam(name = "pass", defaultValue = "") String password) throws SQLException {

        if (user.equals("") || password.equals("")) {
            System.out.println("nije upisano korisnicko ime i lozinka");
        } else if (user.equals("admin") && password.equals("admin")) {
            System.out.println("ulogovan admin...");
            System.out.println(user + " " + password);

            return "indexx";
        } else {/*OVDE MENJATI*/

            //--------------------------------------//

            String string = user;
            String[] niz = string.split("\\.");

            if (niz.length > 1) {
                String part1 = niz[0]; // ime
                String part2 = niz[1]; // prezime

                for (String a : niz)
                    System.out.println(a);


                b.setSql("SELECT * FROM profesor WHERE `imeProfesora` ='" + niz[0] + "' AND `prezimeProfesora`='" + niz[1] + "' AND `idProfesora`=" + password + "");
                ResultSet rs1 = b.upit.executeQuery(b.getSql());

                b.setSql("SELECT * FROM studenti WHERE `imeStudenta` ='" + niz[0] + "' AND `prezimeStudenta`='" + niz[1] + "' AND `idStudenta`=" + password + "");
                ResultSet rs2 = b.upit.executeQuery(b.getSql());

                if (rs1.next()) {
                    System.out.println("Ulogovan profesor!");
                    return "indexxProfesor";
                } else if (rs2.next()) {
                    System.out.println("Ulogovan student!");
                    return "indexxStudent";
                } else {
                    System.out.println("Nepostojeci nalog!");
                }
            } else {
                System.out.println("Nepostojeci nalog!");
            }
        }

        return "/login";
    }/**/


    @GetMapping("/unesiProfesora")
    public String ubaciProfesora2(Baza b,
                                  @RequestParam(name = "ImeProfesora", defaultValue = "defaultProf") String imeProfesora,
                                  @RequestParam(name = "PrezimeProfesora", defaultValue = "defaultProf") String prezimeProfesora) {

        if (imeProfesora.equals("defaultProf") && prezimeProfesora.equals("defaultProf")) {
            System.out.println("Nije upisano ime i prezime");
        } else {
            System.out.println("Ubacujem profesora...");
            System.out.println(imeProfesora + " " + prezimeProfesora);

            b.unesiProfesora(imeProfesora, prezimeProfesora);

            System.out.println("Ubačen profesor...");
        }
        return "unesiProfesora";
    }

    @GetMapping("/unesiStudenta")
    public String ubaciStudenta2(Baza b,
                                 @RequestParam(name = "ImeStudenta", defaultValue = "defaultStud") String imeStudenta,
                                 @RequestParam(name = "PrezimeStudenta", defaultValue = "defaultStud") String prezimeStudenta,
                                 @RequestParam(name = "BrIndeksa", defaultValue = "0") int brIndeksa,
                                 @RequestParam(name = "GodUpisa", defaultValue = "0") int godUpisa,
                                 @RequestParam(name = "GodStudija", defaultValue = "0") int godStudija) {

        if (imeStudenta.equals("defaultStud") && prezimeStudenta.equals("defaultStud")) {
            System.out.println("nije upisano ime i prezime");
        } else {
            if (b.daLiPostojiStudent(brIndeksa, godUpisa) != true) {
                System.out.println("ubacujem studenta...");
                System.out.println(imeStudenta + " " + prezimeStudenta);

                b.unesiStudenta(imeStudenta, prezimeStudenta, brIndeksa, godUpisa, godStudija);
            } else {
                System.out.println("Student vec postoji u bazi!");
            }
        }
        return "unesiStudenta";
    }


    @GetMapping("/unesiPredmet")
    public String ubaciPredmet2(Baza b,
                                @RequestParam(name = "NazivPredmeta", defaultValue = "defaultPred") String nazivPredmeta,
                                @RequestParam(name = "GodinaStudija", defaultValue = "0") int godinaStudija,
                                @RequestParam(name = "Espb", defaultValue = "0") int espb,
                                @RequestParam(name = "Tip", defaultValue = "obavezni") String tip) {

        if (nazivPredmeta.equals("defaultPred")) {
            System.out.println("nije upisan predmet...");
        } else {
            if (b.daLiPostojiPredmet(nazivPredmeta) != true) {
                System.out.println("ubacujem predm..");
                System.out.println(godinaStudija + " " + nazivPredmeta + " " + espb + " " + tip);

                b.unesiPredmet(godinaStudija, nazivPredmeta, espb, tip);

                System.out.println("ubacen predm...");
            } else {
                System.out.println("Predmet vec postoji u bazi!");
            }
        }

        return "unesiPredmet";
    }

    @GetMapping("/povezivanjeAngazovanja")
    public String poveziAngazovanja2(Baza b,
                                     @RequestParam(name = "sifraNast", defaultValue = "0") int sifraNast,
                                     @RequestParam(name = "sifraPred", defaultValue = "0") int sifraPred) {


        if (sifraNast == 0 || sifraPred == 0) {        // ako polja nisu popunjena

            System.out.println("nije upisano angazovanje...");
        } else {       // ako polja jesu popunjena


            if ((b.daLiPostojiProfesor(sifraNast) != false)) {

                if ((b.daLiPostojiPredmet(sifraPred) != false)) {

                    if ((b.daLiPostojiAngazovanje(sifraNast, sifraPred) != true)) {
                        System.out.println("povezujem angazovanje sa profesorom..");
                        System.out.println(sifraNast + " : " + sifraPred);

                        b.unesiAngazovanje(sifraNast, sifraPred);

                        System.out.println("povezano angazovanje sa profesorom...");
                    } else {
                        System.out.println("Nemoguce je povezati - angazovanje vec postoji...");
                    }
                } else {
                    System.out.println("Nemoguce je povezati - ne postoji navedeni predmet...");
                }
            } else {
                System.out.println("Nemoguce je povezati - ne postoji navedeni profesor...");
            }
        }

        return "povezivanjeAngazovanja";
    }


    @GetMapping("/poveziIzbornePredmete")//dodato
    public String poveziPredmet(Baza b,
                                @RequestParam(name = "brIndeksa", defaultValue = "0") int brIndeksa,
                                @RequestParam(name = "godUpisa", defaultValue = "0") int godUpisa,
                                @RequestParam(name = "idPredmeta", defaultValue = "0") int idPredmeta) {

        try {


            b.setSql("SELECT * FROM `studentisapredmetimakojeslusaju` WHERE `brIndeksa` = " + brIndeksa + " AND `godUpisa` = " + godUpisa + " AND `idPredmeta` = " + idPredmeta + ";");      //Upit da li je vec povezan predmet sa studentom
            ResultSet rezultat = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `studenti` WHERE `brIndeksa` = " + brIndeksa + " AND `godUpisa` = " + godUpisa + ";");      //Upit da li student postoji
            ResultSet rezultat2 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `predmeti` WHERE `idPredmeta` = " + idPredmeta + " AND `tip` = 'izborni'" + ";");      //Upit da li predmet postoji i da li je izborni
            ResultSet rezultat3 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita


            if (brIndeksa == 0 || godUpisa == 0 || idPredmeta == 0 || (rezultat.next() != false) || (rezultat2.next() != true) || (rezultat3.next() != true)) {
                System.out.println("Pogresan unos nekog podatka ili je student vec povezan sa tim izbornim predmetom.");
            } else {
                System.out.println("Povezujem studenta sa predmetom");
                System.out.println(brIndeksa + " " + godUpisa + " " + idPredmeta);

                b.setSql("INSERT INTO `studentisapredmetimakojeslusaju` (`brIndeksa`, `godUpisa`, `idPredmeta`)\n" +
                        "VALUES('" + brIndeksa + "', '" + godUpisa + "', '" + idPredmeta + "');");

                try {
                    ResultSet rs = b.upit.executeQuery(b.getSql());

                    System.out.println(b.getSql());

                    System.out.println("Povezan predmet.");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "poveziIzbornePredmete";
    }


    //int sifraPredmeta, brojIndeksa, godinaUpisa;

    @GetMapping("/prijaviIspit")
    public String prjaviIspit(Baza b,
                              @RequestParam(name = "SifraPredmeta", defaultValue = "0") int sifraPredmeta,
                              @RequestParam(name = "BrojIndeksa", defaultValue = "0") int brojIndeksa,
                              @RequestParam(name = "GodinaUpisa", defaultValue = "0") int godinaUpisa) {


        try {
            b.setSql("SELECT * FROM `prijavljeniispiti` WHERE `sifraPredmeta` = " + sifraPredmeta + " AND `brojIndeksaStudenta` = " + brojIndeksa + " AND `godUpisaStudenta` = " + godinaUpisa + ";");      //Upit da li je ispit vec prijavljen
            ResultSet rezultat = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `studenti` WHERE `brIndeksa` = " + brojIndeksa + " AND `godUpisa` = " + godinaUpisa + ";");      //Upit da li student postoji
            ResultSet rezultat2 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `predmeti` WHERE `idPredmeta` = " + sifraPredmeta + ";");      //Upit da li predmet postoji koji se prijavljuje
            ResultSet rezultat3 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `studentisapredmetimakojeslusaju` WHERE `idPredmeta` = " + sifraPredmeta + " AND `brIndeksa` = " + brojIndeksa + " AND `godUpisa` = " + godinaUpisa + ";");      //Upit da li student slusa predmet
            ResultSet rezultat4 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `polozeniispiti` WHERE `brIndeksa` = " + brojIndeksa + " AND `godUpisa` = " + godinaUpisa + " AND `sifraPredmeta` = " + sifraPredmeta + ";");      //Upit da li je ispit vec polozen
            ResultSet rezultat5 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            if(!rezultat5.next()) //ako nije vec polozen
            {
                if ((rezultat2.next() != true) || (rezultat3.next() != true)) {
                    System.out.println("Greska pri unosu indeksa, godine upisa ili sifre predmeta !");
                } else if ((rezultat.next() != false)) {
                    System.out.println("Ispit je vec prijavljen!");
                } else if ((rezultat4.next() != true)) {
                    System.out.println("Student ne slusa dati predmet!");
                } else if (sifraPredmeta < 1 || brojIndeksa < 1 || godinaUpisa < 1) {
                    System.out.println("Podaci nisu dobro uneti.");
                } else {
                    System.out.println("prijavljujem ispit.");
                    System.out.println(sifraPredmeta + " " + brojIndeksa + " " + godinaUpisa);

                    b.setSql("INSERT INTO `prijavljeniispiti` (`sifraPredmeta`, `brojIndeksaStudenta`, `godUpisaStudenta`)\n" +
                            "VALUES('" + sifraPredmeta + "', '" + brojIndeksa + "', '" + godinaUpisa + "');");

                    try {
                        ResultSet rs = b.upit.executeQuery(b.getSql());

                        System.out.println("Prijavljen ispit.");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "prijaviIspit";
    }


    @GetMapping("/oceniIspit")
    public String oceniIspit(Baza b,
                             @RequestParam(name = "SifraPredmeta", defaultValue = "0") int sifraPredmeta,
                             @RequestParam(name = "BrojIndeksa", defaultValue = "0") int brojIndeksa,
                             @RequestParam(name = "GodinaUpisa", defaultValue = "0") int godinaUpisa,
                             @RequestParam(name = "Ocena", defaultValue = "0") int ocena,
                             @RequestParam(name = "ID", defaultValue = "0") int id){

        try {
            b.setSql("SELECT * FROM `prijavljeniispiti` WHERE `sifraPredmeta` = " + sifraPredmeta + " AND `brojIndeksaStudenta` = " + brojIndeksa + " AND `godUpisaStudenta` = " + godinaUpisa + ";");      //Upit da li je ispit vec prijavljen
            ResultSet rezultat = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `studenti` WHERE `brIndeksa` = " + brojIndeksa + " AND `godUpisa` = " + godinaUpisa + ";");      //Upit da li student postoji
            ResultSet rezultat2 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `predmeti` WHERE `idPredmeta` = " + sifraPredmeta + ";");      //Upit da li predmet postoji koji se prijavljuje
            ResultSet rezultat3 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `studentisapredmetimakojeslusaju` WHERE `idPredmeta` = " + sifraPredmeta + " AND `brIndeksa` = " + brojIndeksa + " AND `godUpisa` = " + godinaUpisa + ";");      //Upit da li student slusa predmet
            ResultSet rezultat4 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `angazovanje` WHERE `sifraNast` = " + id + " AND `sifraPred` = " + sifraPredmeta  + ";");      //Upit da li profesor predaje taj predmet
            ResultSet rezultat5 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            if(rezultat5.next() || id == 0)
            {
                if (ocena <= 5) {
                    System.out.println("Na zalost student sa indeksom " + brojIndeksa + "/" + godinaUpisa + " je pao ispit");
                    b.setSql("DELETE FROM `prijavljeniispiti` WHERE `brojIndeksaStudenta` = " + brojIndeksa + " AND `godUpisaStudenta` = " + godinaUpisa + " AND `sifraPredmeta` = " + sifraPredmeta);
                } else if ((rezultat2.next() != true) || (rezultat3.next() != true)) {
                    System.out.println("Greska pri unosu indeksa, godine upisa ili sifre predmeta !");
                } else if ((rezultat.next() != true)) {
                    System.out.println("Ispit nije prijavljen!");
                } else if ((rezultat4.next() != true)) {
                    System.out.println("Student ne slusa dati predmet!");
                } else if (sifraPredmeta < 1 || brojIndeksa < 1 || godinaUpisa < 1) {
                    System.out.println("Podaci nisu dobro uneti.");
                } else {
                    System.out.println("Ocenjujem ispit.");
                    System.out.println(brojIndeksa + " " + godinaUpisa + " " + sifraPredmeta + " " + ocena);


                    try {
                        b.setSql("INSERT INTO `polozeniispiti` (`brIndeksa`, `godUpisa`, `sifraPredmeta`, `ocena`)\n" +
                                "VALUES('" + brojIndeksa + "', '" + godinaUpisa + "', '" + sifraPredmeta + "', '" + ocena + "');");
                        ResultSet rs = b.upit.executeQuery(b.getSql());

                        b.setSql("DELETE FROM `prijavljeniispiti` WHERE `brojIndeksaStudenta` = " + brojIndeksa + " AND `godUpisaStudenta` = " + godinaUpisa + " AND `sifraPredmeta` = " + sifraPredmeta);
                        ResultSet rs1 = b.upit.executeQuery(b.getSql());

                        System.out.println("Ocenjen ispit.");
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "oceniIspit";
    }

    @GetMapping("/priznajIspit")
    public String priznajIspit(Baza b,
                               @RequestParam(name = "SifraPredmeta", defaultValue = "0") int sifraPredmeta,
                               @RequestParam(name = "BrojIndeksa", defaultValue = "0") int brojIndeksa,
                               @RequestParam(name = "GodinaUpisa", defaultValue = "0") int godinaUpisa,
                               @RequestParam(name = "Ocena", defaultValue = "0") int ocena) {

        try {

            b.setSql("SELECT * FROM `studenti` WHERE `brIndeksa` = " + brojIndeksa + " AND `godUpisa` = " + godinaUpisa + ";");      //Upit da li student postoji
            ResultSet rezultat2 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `predmeti` WHERE `idPredmeta` = " + sifraPredmeta + ";");      //Upit da li predmet postoji koji se prijavljuje
            ResultSet rezultat3 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            b.setSql("SELECT * FROM `studentisapredmetimakojeslusaju` WHERE `idPredmeta` = " + sifraPredmeta + " AND `brIndeksa` = " + brojIndeksa + " AND `godUpisa` = " + godinaUpisa + ";");      //Upit da li student slusa predmet
            ResultSet rezultat4 = b.upit.executeQuery(b.getSql()); //izvrsavanje upita

            if ((rezultat2.next() != true) || (rezultat3.next() != true)) {
                System.out.println("Greska pri unosu indeksa, godine upisa ili sifre predmeta !");
            } else if ((rezultat4.next() != true)) {
                System.out.println("Student ne sluša dati predmet!");
            } else if (sifraPredmeta < 1 || brojIndeksa < 1 || godinaUpisa < 1) {
                System.out.println("Podaci nisu dobro uneti.");
            } else {
                System.out.println("Priznajem ispit.");
                System.out.println(sifraPredmeta + " " + brojIndeksa + " " + godinaUpisa);

                b.setSql("INSERT INTO `polozeniispiti` (`brIndeksa`, `godUpisa`, `sifraPredmeta`, `ocena`)\n" +
                        "VALUES('" + brojIndeksa + "', '" + godinaUpisa + "', '" + sifraPredmeta + "', '" + ocena + "');");

                try {
                    ResultSet rs = b.upit.executeQuery(b.getSql());

                    System.out.println("Prijavljen ispit.");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "priznajIspit";
    }

}
