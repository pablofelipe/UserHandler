
CREATE DATABASE `datauser` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `avatar` blob,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `usermovieviewed` (
  `idusermovieviewed` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `idmovie` int(11) NOT NULL,
  PRIMARY KEY (`idusermovieviewed`),
  UNIQUE KEY `IDX_VIEWED` (`iduser`,`idmovie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `usermoviewatch` (
  `idusermoviewatch` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `idmovie` int(11) NOT NULL,
  PRIMARY KEY (`idusermoviewatch`),
  UNIQUE KEY `IDX_WATCH` (`iduser`,`idmovie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
