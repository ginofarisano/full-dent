-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.67-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema pro
--

CREATE DATABASE IF NOT EXISTS pro;
USE pro;

--
-- Definition of table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `userId` varchar(10) NOT NULL default ' ',
  `password` varchar(10) NOT NULL default ' ',
  `Tipo` varchar(20) NOT NULL default ' ',
  `codiceFiscale` varchar(16) NOT NULL default ' ',
  PRIMARY KEY  (`userId`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`userId`,`password`,`Tipo`,`codiceFiscale`) VALUES 
 ('admin','admin','amministratore','drcmra91d17h703t'),
 ('segret','abcd','segretaria','mrarss88a01h703m');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


--
-- Definition of table `calendario`
--

DROP TABLE IF EXISTS `calendario`;
CREATE TABLE `calendario` (
  `tipoServizio` varchar(45) NOT NULL,
  `nomePaziente` varchar(20) NOT NULL,
  `cognomePaziente` varchar(20) NOT NULL,
  `nomeMedico` varchar(20) NOT NULL,
  `cognomeMedico` varchar(20) NOT NULL,
  `data` varchar(45) NOT NULL,
  `ora` varchar(45) NOT NULL,
  `richiamo` int(1) unsigned NOT NULL,
  PRIMARY KEY  (`tipoServizio`,`data`,`ora`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `calendario`
--

/*!40000 ALTER TABLE `calendario` DISABLE KEYS */;
INSERT INTO `calendario` (`tipoServizio`,`nomePaziente`,`cognomePaziente`,`nomeMedico`,`cognomeMedico`,`data`,`ora`,`richiamo`) VALUES 
 ('igiene','giovanni','mastro','flavio','serra','12/10/2007','12:00',0),
 ('igiene','luca','sassari','mirko','deluca','25/10/2008','11:00',0),
 ('igiene','mario','casali','roberto','spisso','27/05/2009','17:00',0),
 ('igiene','mariella','d\'arco','luisa','siniscalco','27/05/2009','18:00',0),
 ('paradontologia','donato','darco','paolo','cavaliere','12/09/2009','11:00',0),
 ('paradontologia','sara','aliberti','dario','napoli','27/05/2009','12:00',0),
 ('paradontologia','carmen','apicella','giuseppe','moscatiello','27/05/2009','13:00',0),
 ('paradontologia','miriam','lussa','gialluca','petta','27/05/2009','17:00',0);
/*!40000 ALTER TABLE `calendario` ENABLE KEYS */;


--
-- Definition of table `fatture`
--

DROP TABLE IF EXISTS `fatture`;
CREATE TABLE `fatture` (
  `codiceFattura` int(10) unsigned NOT NULL auto_increment,
  `intestatario` varchar(45) NOT NULL,
  `emitente` varchar(45) NOT NULL,
  `data` datetime NOT NULL,
  `descServ` varchar(150) NOT NULL,
  `note` varchar(150) NOT NULL,
  `prezzo` double NOT NULL,
  `totaleArticoli` int(10) unsigned NOT NULL,
  `codiceFiscale` varchar(16) NOT NULL,
  PRIMARY KEY  (`codiceFattura`),
  KEY `cf` (`codiceFiscale`),
  CONSTRAINT `cf` FOREIGN KEY (`codiceFiscale`) REFERENCES `personale` (`codiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fatture`
--

/*!40000 ALTER TABLE `fatture` DISABLE KEYS */;
/*!40000 ALTER TABLE `fatture` ENABLE KEYS */;


--
-- Definition of table `fornitori`
--

DROP TABLE IF EXISTS `fornitori`;
CREATE TABLE `fornitori` (
  `PIVA` varchar(16) NOT NULL,
  `nomeResponsabile` varchar(20) default NULL,
  `cognomeResponsabile` varchar(20) NOT NULL,
  `sede` varchar(45) NOT NULL,
  `recapito` varchar(15) NOT NULL default '',
  `e-mail` varchar(45) NOT NULL,
  PRIMARY KEY  (`PIVA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fornitori`
--

/*!40000 ALTER TABLE `fornitori` DISABLE KEYS */;
INSERT INTO `fornitori` (`PIVA`,`nomeResponsabile`,`cognomeResponsabile`,`sede`,`recapito`,`e-mail`) VALUES 
 ('asdfghjklòàù+èpo','giuseppe ','verdi','milano','08998765','ilano@hotmail.com'),
 ('asdfghjklòàùasdf','franco','bianchi','cagliari','08976536','julo@tiscali.it'),
 ('qwertyuiopè+asdf','prisco','priscoli','salerno','08977654','dipri@gmail.it');
/*!40000 ALTER TABLE `fornitori` ENABLE KEYS */;


--
-- Definition of table `personale`
--

DROP TABLE IF EXISTS `personale`;
CREATE TABLE `personale` (
  `codiceFiscale` varchar(16) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `residenza` varchar(45) NOT NULL,
  `dataNascita` varchar(10) NOT NULL,
  `luogoNascita` varchar(20) NOT NULL,
  `telefono` int(12) unsigned NOT NULL,
  `tipo` varchar(14) NOT NULL,
  `sesso` varchar(1) NOT NULL,
  `contratto` varchar(45) NOT NULL,
  PRIMARY KEY  (`codiceFiscale`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personale`
--

/*!40000 ALTER TABLE `personale` DISABLE KEYS */;
INSERT INTO `personale` (`codiceFiscale`,`nome`,`cognome`,`residenza`,`dataNascita`,`luogoNascita`,`telefono`,`tipo`,`sesso`,`contratto`) VALUES 
 ('asdfghjklòàùzxcv','mario','rossi','salerno','30/12/2009','salerno',1234567,'medico','m','asd 1234.0 dsgh'),
 ('asdfghjklòàùzxcx','luca','bianchi','lancusi','22/12/2000','avellino',12345,'segretario','m','dgfc 1234.0 redfgh'),
 ('qwertyuiopè+qwer','simone','trotta','fisciano','12/10/2008','salerno',654322,'medico','m','asd 2134.0 sfg');
/*!40000 ALTER TABLE `personale` ENABLE KEYS */;


--
-- Definition of table `possedere`
--

DROP TABLE IF EXISTS `possedere`;
CREATE TABLE `possedere` (
  `codiceSala` int(3) unsigned NOT NULL auto_increment,
  `codiceTipo` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`codiceSala`,`codiceTipo`),
  KEY `ct` (`codiceTipo`),
  CONSTRAINT `cs` FOREIGN KEY (`codiceSala`) REFERENCES `sala` (`codiceSala`),
  CONSTRAINT `ct` FOREIGN KEY (`codiceTipo`) REFERENCES `servizi` (`codiceTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `possedere`
--

/*!40000 ALTER TABLE `possedere` DISABLE KEYS */;
/*!40000 ALTER TABLE `possedere` ENABLE KEYS */;


--
-- Definition of table `sala`
--

DROP TABLE IF EXISTS `sala`;
CREATE TABLE `sala` (
  `codiceSala` int(3) unsigned NOT NULL,
  `descrizione` varchar(45) NOT NULL default ' ',
  `nomeSala` varchar(20) NOT NULL default ' ',
  `codiceFiscale` varchar(16) NOT NULL,
  PRIMARY KEY  USING BTREE (`codiceSala`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sala`
--

/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` (`codiceSala`,`descrizione`,`nomeSala`,`codiceFiscale`) VALUES 
 (0,'deposito','sala0','drcmra91d17h703t'),
 (1,'igiene','sala2','drcmra91d17h703t'),
 (2,'paradontotiatria','sala1','drcmra91d17h703t');
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;


--
-- Definition of table `servizi`
--

DROP TABLE IF EXISTS `servizi`;
CREATE TABLE `servizi` (
  `codiceTipo` int(10) unsigned NOT NULL,
  `nome` varchar(30) NOT NULL default ' ',
  `quantità` int(10) unsigned NOT NULL COMMENT 'quantita disponibile',
  `costo` double NOT NULL,
  `tipo` varchar(12) NOT NULL default ' ',
  `descrizione` varchar(150) NOT NULL default ' ',
  `locazione` varchar(15) NOT NULL,
  `codiceFornitore` varchar(16) NOT NULL,
  PRIMARY KEY  USING BTREE (`codiceTipo`),
  KEY `codiceFornitore` (`codiceFornitore`),
  CONSTRAINT `codiceFornitore` FOREIGN KEY (`codiceFornitore`) REFERENCES `fornitori` (`PIVA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `servizi`
--

/*!40000 ALTER TABLE `servizi` DISABLE KEYS */;
INSERT INTO `servizi` (`codiceTipo`,`nome`,`quantità`,`costo`,`tipo`,`descrizione`,`locazione`,`codiceFornitore`) VALUES 
 (435,'macchina raggiX',1,234,'attrezzatura','macchina per raggi','sala1','asdfghjklòàù+èpo'),
 (1234,'pacco plastica',123,123,'Materiale','uso  pulizia dentale','sala0','qwertyuiopè+asdf');
/*!40000 ALTER TABLE `servizi` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
