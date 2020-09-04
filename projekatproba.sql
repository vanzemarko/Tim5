-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jul 13, 2020 at 03:21 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projekatproba`
--

-- --------------------------------------------------------

--
-- Table structure for table `angazovanje`
--

DROP TABLE IF EXISTS `angazovanje`;
CREATE TABLE IF NOT EXISTS `angazovanje` (
  `sifraNast` int(11) NOT NULL,
  `sifraPred` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `angazovanje`
--

INSERT INTO `angazovanje` (`sifraNast`, `sifraPred`) VALUES
(1, 2),
(10, 2),
(1, 1),
(1, 1),
(2, 1),
(16, 1),
(6, 3);

-- --------------------------------------------------------

--
-- Table structure for table `polozeniispiti`
--

DROP TABLE IF EXISTS `polozeniispiti`;
CREATE TABLE IF NOT EXISTS `polozeniispiti` (
  `brIndeksa` int(11) NOT NULL,
  `godUpisa` int(11) NOT NULL,
  `sifraPredmeta` int(11) NOT NULL,
  `ocena` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `polozeniispiti`
--

INSERT INTO `polozeniispiti` (`brIndeksa`, `godUpisa`, `sifraPredmeta`, `ocena`) VALUES
(64, 2013, 1, 10),
(64, 2013, 2, 10),
(64, 2013, 3, 9),
(91, 2018, 2, 6),
(91, 2018, 17, 7),
(91, 2018, 18, 9),
(104, 2018, 12, 7),
(104, 2018, 14, 8),
(46, 2018, 13, 8),
(46, 2018, 20, 9),
(53, 2015, 34, 7),
(53, 2015, 21, 10),
(16, 2014, 34, 6),
(16, 2014, 21, 8),
(49, 2017, 34, 9),
(49, 2017, 21, 10),
(69, 2015, 34, 7),
(69, 2015, 18, 8),
(69, 2015, 21, 8);

-- --------------------------------------------------------

--
-- Table structure for table `predmeti`
--

DROP TABLE IF EXISTS `predmeti`;
CREATE TABLE IF NOT EXISTS `predmeti` (
  `idPredmeta` int(11) NOT NULL AUTO_INCREMENT,
  `godinaStudija` int(1) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `espb` int(11) NOT NULL,
  `tip` enum('izborni','obavezni','fakultativno','') NOT NULL,
  PRIMARY KEY (`idPredmeta`)
) ENGINE=MyISAM AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `predmeti`
--

INSERT INTO `predmeti` (`idPredmeta`, `godinaStudija`, `naziv`, `espb`, `tip`) VALUES
(1, 1, 'Matematika 1', 6, 'obavezni'),
(2, 2, 'Objektno-orijentisano programiranje', 7, 'obavezni'),
(3, 1, 'Osnovi programiranja', 7, 'obavezni'),
(4, 1, 'Teorijske osnove informatike', 5, 'obavezni'),
(5, 1, 'Racunarski sistemi', 5, 'obavezni'),
(6, 1, 'Praktikum iz programiranja 1', 3, 'izborni'),
(7, 1, 'Praktikum iz programiranja 2', 3, 'izborni'),
(8, 1, 'Engleski jezik A1', 5, 'izborni'),
(9, 1, 'Engleski jezik B1', 5, 'izborni'),
(10, 1, 'Strukture podataka i algoritmi 1', 7, 'obavezni'),
(11, 1, 'Popularna nauka', 4, 'izborni'),
(12, 1, 'Softverski alati', 4, 'izborni'),
(13, 1, 'Praktikum iz programiranja 3', 4, 'izborni'),
(14, 1, 'Elektrotehnika', 5, 'izborni'),
(15, 1, 'Fizika', 5, 'izborni'),
(16, 1, 'Matematika 2', 9, 'obavezni'),
(17, 2, 'Operativni sistemi 1', 6, 'obavezni'),
(18, 2, 'Klijentske veb tehnologije', 6, 'obavezni'),
(19, 2, 'Praktikum iz objektno-orijentisanog programiranja', 6, 'obavezni'),
(20, 2, 'Baze podataka 1', 7, 'obavezni'),
(21, 2, 'Strukture podataka i algoritmi 2', 6, 'obavezni'),
(22, 2, 'Vizuelizacija i analiza podataka', 5, 'obavezni'),
(23, 2, 'Poslovna komunikacija', 6, 'izborni'),
(24, 2, 'Osnovi preduzetičkog menadžmenta', 6, 'izborni'),
(25, 2, 'Psihologija', 4, 'izborni'),
(26, 2, 'Računarske mreže', 6, 'obavezni'),
(27, 2, 'Teorija brojeva i kriptografija', 5, 'izborni'),
(28, 2, 'Praktikum iz operativnih sistema', 5, 'izborni'),
(29, 2, 'Odabrana poglavlja elementarne matematik', 6, 'izborni'),
(30, 2, 'Engleski jezik A2', 5, 'izborni'),
(31, 2, 'Engleski jezik B2', 5, 'izborni'),
(32, 2, 'Pedagogija', 4, 'izborni'),
(33, 2, 'Odabrana poglavlja elementarne matematike', 6, 'izborni'),
(34, 4, 'Operativni sistemi 2', 6, 'obavezni'),
(35, 3, 'Elektronsko poslovanje', 7, 'obavezni');

-- --------------------------------------------------------

--
-- Table structure for table `prijavljeniispiti`
--

DROP TABLE IF EXISTS `prijavljeniispiti`;
CREATE TABLE IF NOT EXISTS `prijavljeniispiti` (
  `sifraPredmeta` int(11) NOT NULL,
  `brojIndeksaStudenta` int(11) NOT NULL,
  `godUpisaStudenta` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `prijavljeniispiti`
--

INSERT INTO `prijavljeniispiti` (`brojIndeksaStudenta`, `godUpisaStudenta`, `sifraPredmeta`) VALUES
(43, 2016, 1),
(43, 2016, 2),
(91, 2018, 2),
(91, 2018, 17),
(91, 2018, 18),
(104, 2018, 2),
(104, 2018, 12),
(104, 2018, 14),
(46, 2018, 13),
(46, 2018, 20),
(53, 2015, 34),
(53, 2015, 2),
(53, 2015, 21),
(16, 2014, 34),
(16, 2014, 2),
(16, 2014, 21),
(49, 2017, 34),
(49, 2017, 21),
(69, 2015, 34),
(69, 2015, 18),
(69, 2015, 21);

-- --------------------------------------------------------

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
CREATE TABLE IF NOT EXISTS `profesor` (
  `idProfesora` int(11) NOT NULL AUTO_INCREMENT,
  `imeProfesora` varchar(20) NOT NULL,
  `prezimeProfesora` varchar(30) NOT NULL,
  PRIMARY KEY (`idProfesora`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `profesor`
--

INSERT INTO `profesor` (`idProfesora`, `imeProfesora`, `prezimeProfesora`) VALUES
(1, 'Ana', 'Kaplarević-Malisić'),
(2, 'Miloš', 'Ivanović'),
(3, 'Miloš', 'Pavković'),
(4, 'Ljubica', 'Kovačević'),
(5, 'Vladimir', 'Cvjetković'),
(6, 'Boban', 'Stojanović'),
(7, 'Tatjana', 'Stojanović'),
(8, 'Srđan', 'Nikolić'),
(9, 'Marina', 'Svičević'),
(10, 'Dragutin', 'Ostojić'),
(11, 'Anica ', 'Glođović'),
(12, 'Višnja', 'Simić'),
(13, 'Aleksandar', 'Peulić'),
(14, 'Nenad', 'Stefanović'),
(15, 'Bojana', 'Borovićanin'),
(16, 'Marko', 'Dabić'),
(17, 'Maja', 'Lučić'),
(18, 'Branko ', 'Arsić'),
(21, 'Bojana', 'Borovićanin');

-- --------------------------------------------------------

--
-- Table structure for table `studenti`
--

DROP TABLE IF EXISTS `studenti`;
CREATE TABLE IF NOT EXISTS `studenti` (
  `idStudenta` int(11) NOT NULL AUTO_INCREMENT,
  `imeStudenta` varchar(20) NOT NULL,
  `prezimeStudenta` varchar(30) NOT NULL,
  `brIndeksa` int(11) NOT NULL,
  `godUpisa` int(11) NOT NULL,
  `godStudija` int(11) NOT NULL,
  PRIMARY KEY (`idStudenta`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `studenti`
--

INSERT INTO `studenti` (`idStudenta`, `imeStudenta`, `prezimeStudenta`, `brIndeksa`, `godUpisa`, `godStudija`) VALUES
(17, 'Stefan', 'Aleksandrić', 43, 2016, 3),
(16, 'Luka', 'Maletković', 91, 2018, 2),
(5, 'Ognjen', 'Orlović', 104, 2018, 2),
(6, 'Lazar', 'Beslać', 46, 2018, 2),
(7, 'Dejan', 'Belić', 39, 2018, 2),
(8, 'Janko', 'Radović', 84, 2018, 2),
(9, 'Danijel', 'Anđelković', 32, 2018, 2),
(10, 'Milutin', 'Aleksić', 31, 2018, 2),
(11, 'Nikola', 'Rnjak', 80, 2018, 2),
(12, 'Luka', 'Vasiljević', 51, 2018, 2),
(13, 'Nemanja ', 'Veličković', 53, 2015, 4),
(14, 'Damjan', 'Vasojević', 54, 2018, 2),
(15, 'Nikola', 'Jevremović', 76, 2018, 2),
(18, 'Petar', 'Bojović', 40, 2018, 2),
(19, 'Milica', 'Vučić', 52, 2018, 2),
(1, 'Dušan', 'Đulaković', 49, 2017, 3),
(2, 'Momčilo', 'Jontulović', 16, 2014, 4),
(3, 'Katarina', 'Sredojević', 120, 2018, 2),
(4, 'Anika', 'Tomaševoć', 116, 2018, 2),
(20, 'Dušan', 'Gogić', 57, 2018, 2),
(21, 'Milos', 'Peković', 69, 2015, 3),
(23, 'Jovan', 'Jančić', 64, 2013, 4);

-- --------------------------------------------------------

--
-- Table structure for table `studentisapredmetimakojeslusaju`
--

DROP TABLE IF EXISTS `studentisapredmetimakojeslusaju`;
CREATE TABLE IF NOT EXISTS `studentisapredmetimakojeslusaju` (
  `brIndeksa` int(5) NOT NULL,
  `godUpisa` int(4) NOT NULL,
  `idPredmeta` int(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `studentisapredmetimakojeslusaju`
--

INSERT INTO `studentisapredmetimakojeslusaju` (`brIndeksa`, `godUpisa`, `idPredmeta`) VALUES
(64, 2013, 35),
(233, 2101, 35),
(69, 2015, 35),
(16, 2014, 35),
(49, 2017, 35),
(53, 2015, 35),
(43, 2016, 35),
(64, 2013, 34),
(16, 2014, 34),
(53, 2015, 34),
(64, 2013, 26),
(233, 2101, 26),
(69, 2015, 26),
(57, 2018, 26),
(116, 2018, 26),
(120, 2018, 26),
(16, 2014, 26),
(49, 2017, 26),
(52, 2018, 26),
(40, 2018, 26),
(76, 2018, 26),
(54, 2018, 26),
(53, 2015, 26),
(51, 2018, 26),
(80, 2018, 26),
(31, 2018, 26),
(32, 2018, 26),
(84, 2018, 26),
(39, 2018, 26),
(46, 2018, 26),
(104, 2018, 26),
(91, 2018, 26),
(43, 2016, 26),
(64, 2013, 22),
(233, 2101, 22),
(69, 2015, 22),
(57, 2018, 22),
(116, 2018, 22),
(120, 2018, 22),
(16, 2014, 22),
(49, 2017, 22),
(52, 2018, 22),
(40, 2018, 22),
(76, 2018, 22),
(54, 2018, 22),
(53, 2015, 22),
(51, 2018, 22),
(80, 2018, 22),
(31, 2018, 22),
(32, 2018, 22),
(84, 2018, 22),
(39, 2018, 22),
(46, 2018, 22),
(104, 2018, 22),
(91, 2018, 22),
(43, 2016, 22),
(64, 2013, 21),
(233, 2101, 21),
(69, 2015, 21),
(57, 2018, 21),
(116, 2018, 21),
(120, 2018, 21),
(16, 2014, 21),
(49, 2017, 21),
(52, 2018, 21),
(40, 2018, 21),
(76, 2018, 21),
(54, 2018, 21),
(53, 2015, 21),
(51, 2018, 21),
(80, 2018, 21),
(31, 2018, 21),
(32, 2018, 21),
(84, 2018, 21),
(39, 2018, 21),
(46, 2018, 21),
(104, 2018, 21),
(91, 2018, 21),
(43, 2016, 21),
(64, 2013, 20),
(233, 2101, 20),
(69, 2015, 20),
(57, 2018, 20),
(116, 2018, 20),
(120, 2018, 20),
(16, 2014, 20),
(49, 2017, 20),
(52, 2018, 20),
(40, 2018, 20),
(76, 2018, 20),
(54, 2018, 20),
(53, 2015, 20),
(51, 2018, 20),
(80, 2018, 20),
(31, 2018, 20),
(32, 2018, 20),
(84, 2018, 20),
(39, 2018, 20),
(46, 2018, 20),
(104, 2018, 20),
(91, 2018, 20),
(43, 2016, 20),
(64, 2013, 19),
(233, 2101, 19),
(69, 2015, 19),
(57, 2018, 19),
(116, 2018, 19),
(120, 2018, 19),
(16, 2014, 19),
(49, 2017, 19),
(52, 2018, 19),
(40, 2018, 19),
(76, 2018, 19),
(54, 2018, 19),
(53, 2015, 19),
(51, 2018, 19),
(80, 2018, 19),
(31, 2018, 19),
(32, 2018, 19),
(84, 2018, 19),
(39, 2018, 19),
(46, 2018, 19),
(104, 2018, 19),
(91, 2018, 19),
(43, 2016, 19),
(64, 2013, 18),
(233, 2101, 18),
(69, 2015, 18),
(57, 2018, 18),
(116, 2018, 18),
(120, 2018, 18),
(16, 2014, 18),
(49, 2017, 18),
(52, 2018, 18),
(40, 2018, 18),
(76, 2018, 18),
(54, 2018, 18),
(53, 2015, 18),
(51, 2018, 18),
(80, 2018, 18),
(31, 2018, 18),
(32, 2018, 18),
(84, 2018, 18),
(39, 2018, 18),
(46, 2018, 18),
(104, 2018, 18),
(91, 2018, 18),
(43, 2016, 18),
(64, 2013, 17),
(233, 2101, 17),
(69, 2015, 17),
(57, 2018, 17),
(116, 2018, 17),
(120, 2018, 17),
(16, 2014, 17),
(49, 2017, 17),
(52, 2018, 17),
(40, 2018, 17),
(76, 2018, 17),
(54, 2018, 17),
(53, 2015, 17),
(51, 2018, 17),
(80, 2018, 17),
(31, 2018, 17),
(32, 2018, 17),
(84, 2018, 17),
(39, 2018, 17),
(46, 2018, 17),
(104, 2018, 17),
(91, 2018, 17),
(43, 2016, 17),
(64, 2013, 16),
(233, 2101, 16),
(69, 2015, 16),
(57, 2018, 16),
(116, 2018, 16),
(120, 2018, 16),
(16, 2014, 16),
(49, 2017, 16),
(52, 2018, 16),
(40, 2018, 16),
(76, 2018, 16),
(54, 2018, 16),
(53, 2015, 16),
(51, 2018, 16),
(80, 2018, 16),
(31, 2018, 16),
(32, 2018, 16),
(84, 2018, 16),
(39, 2018, 16),
(46, 2018, 16),
(104, 2018, 16),
(91, 2018, 16),
(43, 2016, 16),
(64, 2013, 10),
(233, 2101, 10),
(69, 2015, 10),
(57, 2018, 10),
(116, 2018, 10),
(120, 2018, 10),
(16, 2014, 10),
(49, 2017, 10),
(52, 2018, 10),
(40, 2018, 10),
(76, 2018, 10),
(54, 2018, 10),
(53, 2015, 10),
(51, 2018, 10),
(80, 2018, 10),
(31, 2018, 10),
(32, 2018, 10),
(84, 2018, 10),
(39, 2018, 10),
(46, 2018, 10),
(104, 2018, 10),
(91, 2018, 10),
(43, 2016, 10),
(64, 2013, 5),
(233, 2101, 5),
(69, 2015, 5),
(57, 2018, 5),
(116, 2018, 5),
(120, 2018, 5),
(16, 2014, 5),
(49, 2017, 5),
(52, 2018, 5),
(40, 2018, 5),
(76, 2018, 5),
(54, 2018, 5),
(53, 2015, 5),
(51, 2018, 5),
(80, 2018, 5),
(31, 2018, 5),
(32, 2018, 5),
(84, 2018, 5),
(39, 2018, 5),
(46, 2018, 5),
(104, 2018, 5),
(91, 2018, 5),
(43, 2016, 5),
(64, 2013, 4),
(233, 2101, 4),
(69, 2015, 4),
(57, 2018, 4),
(116, 2018, 4),
(120, 2018, 4),
(16, 2014, 4),
(49, 2017, 4),
(52, 2018, 4),
(40, 2018, 4),
(76, 2018, 4),
(54, 2018, 4),
(53, 2015, 4),
(51, 2018, 4),
(80, 2018, 4),
(31, 2018, 4),
(32, 2018, 4),
(84, 2018, 4),
(39, 2018, 4),
(46, 2018, 4),
(104, 2018, 4),
(91, 2018, 4),
(43, 2016, 4),
(64, 2013, 3),
(233, 2101, 3),
(69, 2015, 3),
(57, 2018, 3),
(116, 2018, 3),
(120, 2018, 3),
(16, 2014, 3),
(49, 2017, 3),
(52, 2018, 3),
(40, 2018, 3),
(76, 2018, 3),
(54, 2018, 3),
(53, 2015, 3),
(51, 2018, 3),
(80, 2018, 3),
(31, 2018, 3),
(32, 2018, 3),
(84, 2018, 3),
(39, 2018, 3),
(46, 2018, 3),
(104, 2018, 3),
(91, 2018, 3),
(43, 2016, 3),
(64, 2013, 2),
(233, 2101, 2),
(69, 2015, 2),
(57, 2018, 2),
(116, 2018, 2),
(120, 2018, 2),
(16, 2014, 2),
(49, 2017, 2),
(52, 2018, 2),
(40, 2018, 2),
(76, 2018, 2),
(54, 2018, 2),
(53, 2015, 2),
(51, 2018, 2),
(80, 2018, 2),
(31, 2018, 2),
(32, 2018, 2),
(84, 2018, 2),
(39, 2018, 2),
(46, 2018, 2),
(104, 2018, 2),
(91, 2018, 2),
(43, 2016, 2),
(233, 2101, 1),
(69, 2015, 1),
(57, 2018, 1),
(116, 2018, 1),
(120, 2018, 1),
(16, 2014, 1),
(49, 2017, 1),
(52, 2018, 1),
(40, 2018, 1),
(76, 2018, 1),
(54, 2018, 1),
(53, 2015, 1),
(51, 2018, 1),
(80, 2018, 1),
(31, 2018, 1),
(32, 2018, 1),
(84, 2018, 1),
(39, 2018, 1),
(46, 2018, 1),
(104, 2018, 1),
(91, 2018, 1),
(43, 2016, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
