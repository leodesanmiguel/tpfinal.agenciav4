-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 21, 2021 at 02:35 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `polo_agencia_v4`
--

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `IDPERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `APELLIDOP` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `CELULAR` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DIRECCIONP` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DNI` int(11) DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `FECHANACIO` date DEFAULT NULL,
  `NACIONALIDAD` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `NOMBREP` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`IDPERSONA`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`IDPERSONA`, `APELLIDOP`, `CELULAR`, `DIRECCIONP`, `DNI`, `EMAIL`, `FECHANACIO`, `NACIONALIDAD`, `NOMBREP`) VALUES
(1, 'AGUSTINELLI', '1166837154', ' Gabriel Miro 2881', 33333333, 'sofia.elena179@gmail.com', '1970-06-25', 'argentino', 'SOFIA ELENA'),
(2, 'BALCASA', '1165164353', 'Fernández Moreno 1415', 77777777, 'andrea.evelyn188@gmail.com', '1988-06-19', 'argentino', 'ANDREA EVELYN'),
(3, 'BARRIOS', '1150587598', 'Rawson 5715', 55611110, 'sonia.ines941@gmail.com', '1979-01-01', 'argentino', 'SONIA INES'),
(4, 'CONTARDO', '1122008549', 'Salguero 1869', 89777776, 'julieta.anabella528@gmail.com', '1964-01-10', 'argentino', 'JULIETA ANABELLA'),
(5, 'CORONEL', '1167805264', 'paez 1882', 22244444, 'karen.agustina615@gmail.com', '1991-05-18', 'argentino', 'KAREN AGUSTINA'),
(6, 'CORTELL CUBÍ', '1135090901', 'Lourdes 2657', 33366666, 'karen.michelle485@gmail.com', '1990-09-20', 'argentino', 'KAREN MICHELLE'),
(7, 'DOMINGUEZ', '2320437458', 'Carlos Calvo 760', 11222222, 'daiana.noemi637@gmail.com', '1978-06-02', 'argentino', 'DAIANA NOEMI'),
(8, 'GAYOSO', '1128679238', '25 DE MAYO 1496', 22224444, 'malena.solana.agustina671@gmail.com', '1994-04-18', 'argentino', 'MALENA SOLANA AGUSTINA'),
(9, 'GIORGI', '2320696354', '12 de Octubre 2431', 56111110, 'eliana.agustina825@gmail.com', '1983-07-24', 'argentino', 'ELIANA AGUSTINA'),
(10, 'GRISETTI', '1160368533', 'Paraguay 215', 88888888, 'maría.angélica615@gmail.com', '1980-04-20', 'argentino', 'MARÍA ANGÉLICA'),
(11, 'INSAURRALDE', '1136101561', 'blandegue', 77855554, 'florencia.romina253@gmail.com', '1962-01-07', 'argentino', 'FLORENCIA ROMINA'),
(12, 'JOHO', '2320696806', 'Arias 3300 Manzana 1 Casa 8', 77785554, 'freddy.raul808@gmail.com', '1963-07-05', 'argentino', 'FREDDY RAUL'),
(13, 'JUAREZ', '1525155527', 'Gregorio Marañon 3748', 55561110, 'matias471@gmail.com', '1974-12-14', 'argentino', 'MATIAS'),
(14, 'LEIVA', '2320453039', 'PAULA ALBARRACIN 2041', 99999999, 'melina.flavia171@gmail.com', '1977-10-01', 'argentino', 'MELINA FLAVIA'),
(15, 'LEZCANO DE ROCCO', '1165116425', 'ZUVIRIA 4439', 44888888, 'paola.del.carmen361@gmail.com', '1975-03-03', 'argentino', 'PAOLA DEL CARMEN'),
(16, 'LOVASCHI', '1140986245', 'LABARDEN 1415', 66666666, 'johanna.elizabeth389@gmail.com', '1967-06-18', 'argentino', 'JOHANNA ELIZABETH'),
(17, 'MARTINEZ', '2320551282', 'Avenida Croacia 340', 67333332, 'juan.gabriel160@gmail.com', '1967-08-05', 'argentino', 'JUAN GABRIEL'),
(18, 'NAVARRO', '1144947521', 'GRANADERO BAIGORRIA 5612', 55555555, 'lucía.inés276@gmail.com', '1962-09-24', 'argentino', 'LUCÍA INÉS'),
(19, 'ROMERO', '1123864132', 'MARCELO T DE ALVEAR 130', 44448888, 'juana.maría248@gmail.com', '1966-05-19', 'argentino', 'JUANA MARÍA'),
(20, 'ROMERO', '1154002857', 'Luis Maria Campos 2178  ', 22444444, 'maria.de.la.paz333@gmail.com', '1995-09-24', 'argentino', 'MARIA DE LA PAZ'),
(21, 'SULLCA', '1165711345', 'Corbeta Uruguay 3370', 11122222, 'lucila.belen106@gmail.com', '1980-03-20', 'argentino', 'LUCILA BELEN'),
(22, 'THOMPSON', '1154320501', 'EMILIO ZOLA 2084', 33666666, 'micaela.florencia816@gmail.com', '1999-11-23', 'argentino', 'MICAELA FLORENCIA'),
(23, 'TORRES', '2320484477', 'Arechavala 5383', 66673332, 'malena.solana.agustina604@gmail.com', '1993-03-09', 'argentino', 'MALENA SOLANA AGUSTINA'),
(24, 'VERA', '1140518526', 'Santiago del Estero 2575', 44488888, 'rosana.andrea593@gmail.com', '1968-02-13', 'argentino', 'ROSANA ANDREA'),
(25, 'VERGARA', '1121038044', 'Arturo Capdevilla 336', 33336666, 'maria.de.la.paz121@gmail.com', '1977-08-28', 'argentino', 'MARIA DE LA PAZ');

-- --------------------------------------------------------

--
-- Table structure for table `cliente_venta`
--

DROP TABLE IF EXISTS `cliente_venta`;
CREATE TABLE IF NOT EXISTS `cliente_venta` (
  `Cliente_IDPERSONA` int(11) NOT NULL,
  `compras_IDVENTA` int(11) NOT NULL,
  PRIMARY KEY (`Cliente_IDPERSONA`,`compras_IDVENTA`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `cliente_venta`
--

INSERT INTO `cliente_venta` (`Cliente_IDPERSONA`, `compras_IDVENTA`) VALUES
(7, 4),
(9, 8),
(11, 2),
(15, 7),
(17, 9),
(20, 5),
(22, 6);

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `IDPERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `APELLIDOP` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `CELULAR` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DIRECCIONP` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DNI` int(11) DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `FECHANACIO` date DEFAULT NULL,
  `NACIONALIDAD` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `NOMBREP` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `SUPUESTO` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `SUELDO` double DEFAULT NULL,
  `TAREA` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `USUARIO_IDUSUARIO` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPERSONA`),
  KEY `FK_empleado_USUARIO_IDUSUARIO` (`USUARIO_IDUSUARIO`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `empleado`
--

INSERT INTO `empleado` (`IDPERSONA`, `APELLIDOP`, `CELULAR`, `DIRECCIONP`, `DNI`, `EMAIL`, `FECHANACIO`, `NACIONALIDAD`, `NOMBREP`, `SUPUESTO`, `SUELDO`, `TAREA`, `USUARIO_IDUSUARIO`) VALUES
(1, 'MEMOLI', '1162884470', 'Las Delicias', 39144923, 'ruth.estefania208@gmail.com', '1985-12-15', 'argentino', 'RUTH ESTEFANIA', 'Jefe', 100000, '...', 1),
(2, 'AGUSTINELLI', '1152920038', 'Luis Maria Campos 2178  ', 46514699, 'mariela.elizabeth585@gmail.com', '1997-08-29', 'argentino', 'MARIELA ELIZABETH', 'Jefe', 100000, '...', 2),
(3, 'TORREZ', '1168789470', 'Alejandro Sirio 3417', 35265817, 'paola.del.carmen702@gmail.com', '1971-07-24', 'argentino', 'PAOLA DEL CARMEN', 'Jefe', 100000, '...', 3),
(4, 'URQUIJO', '1120624906', 'Salguero 3957', 51584081, 'maría.alejandra.leonor630@gmail.com', '1987-06-17', 'argentino', 'MARÍA ALEJANDRA LEONOR', 'Jefe', 100000, '...', 4),
(5, 'VERGARA', '1550296920', 'Adolfo Alsina 2441', 53045177, 'rosana.beatriz952@gmail.com', '1974-11-13', 'argentino', 'ROSANA BEATRIZ', 'Jefe', 100000, '...', 5),
(6, 'ZAPATA', '1150042512', 'Isabel la Catolica', 48475827, 'maria.del.rosario460@gmail.com', '1977-06-09', 'argentino', 'MARIA DEL ROSARIO', 'Vendedor', 70000, '...', 6),
(7, 'GAUNA', '1138339839', 'mexico 878', 36921131, 'diamela.ayelén789@gmail.com', '1960-09-07', 'argentino', 'DIAMELA AYELÉN', 'Vendedor', 70000, '...', 7),
(8, 'ACUÑA', '1161722706', 'Portugal 5538', 45653845, 'sandra.paola563@gmail.com', '1985-06-25', 'argentino', 'SANDRA PAOLA', 'Vendedor', 70000, '...', 8),
(9, 'THOMPSON', '1151778185', 'Arroyo 289', 47415935, 'malena.del.pilar565@gmail.com', '1965-12-29', 'argentino', 'MALENA DEL PILAR', 'Vendedor', 70000, '...', 9),
(10, 'GIORGI', '1144515996', ' EL CALLAO 745', 37631235, 'marcela.alejandra755@gmail.com', '1969-05-11', 'argentino', 'MARCELA ALEJANDRA', 'Vendedor', 70000, '...', 10),
(11, 'GRISETTI', '1122509023', 'CAÑONERA TORTUGA  1372', 52037316, 'eva.natalia177@gmail.com', '1973-11-21', 'argentino', 'EVA NATALIA', 'Vendedor', 70000, '...', 11),
(12, 'CARDOZO', '1156172092', 'Cruz del sur 1912', 71820903, 'carla503@gmail.com', '1979-11-12', 'argentino', 'CARLA', 'Vendedor', 70000, '...', 12),
(13, 'CONTARDO', '1151598110', 'conesa 4743', 56828023, 'cintia.elizabeth386@gmail.com', '1987-11-19', 'argentino', 'CINTIA ELIZABETH', 'Vendedor', 70000, '...', 13),
(14, 'ZAPATA', '1138710762', 'Copello 1350', 55220001, 'ruth.estefania554@gmail.com', '1980-01-08', 'argentino', 'RUTH ESTEFANIA', 'Vendedor', 70000, '...', 14),
(15, 'AVILA', '1133070528', 'Las Heras 1825', 55966867, 'analía.agostina352@gmail.com', '1967-03-07', 'argentino', 'ANALÍA AGOSTINA', 'Vendedor', 70000, '...', 15),
(16, 'INSAURRALDE', '1144558061', 'sarmiento2987', 70029489, 'mariela.elizabeth996@gmail.com', '1982-02-06', 'argentino', 'MARIELA ELIZABETH', 'Vendedor', 70000, '...', 16),
(17, 'ROBLES', '1155954339', 'Isabel la Catolica', 54675205, 'marcela.veronica557@gmail.com', '1975-11-06', 'argentino', 'MARCELA VERONICA', 'Vendedor', 70000, '...', 17),
(18, 'DOMINGUEZ', '2320627498', 'Chopin 445', 63900955, 'lucía.inés993@gmail.com', '1987-05-09', 'argentino', 'LUCÍA INÉS', 'Vendedor', 70000, '...', 18);

-- --------------------------------------------------------

--
-- Table structure for table `paquete`
--

DROP TABLE IF EXISTS `paquete`;
CREATE TABLE IF NOT EXISTS `paquete` (
  `IDPAQUETE` int(11) NOT NULL AUTO_INCREMENT,
  `COSTOPAQUETE` double DEFAULT NULL,
  `DESCUENTO` double DEFAULT NULL,
  `NOMBREPAQUETE` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`IDPAQUETE`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `paquete`
--

INSERT INTO `paquete` (`IDPAQUETE`, `COSTOPAQUETE`, `DESCUENTO`, `NOMBREPAQUETE`) VALUES
(1, 3000, 0, 'HOTEL POR NOCHE'),
(2, 5000, 0, 'ALQUILER DE AUTO'),
(3, 1000, 0, 'PASAJE DE COLECTIVO'),
(4, 50000, 0, 'PASAJE DE AVIÓN'),
(5, 1500, 0, 'PASAJE DE TREN'),
(6, 3500, 0, 'EXCURSIÓN'),
(7, 10000, 0, 'ENTRADAS A EVENTOS'),
(8, 3600, 0.1, 'Noche+bus'),
(9, 52200, 0.1, 'Hotel+Auto+Avion'),
(10, 6750, 0.1, 'Hotel+Bus+Excursion'),
(11, 13050, 0.1, 'bus+excursion+evento');

-- --------------------------------------------------------

--
-- Table structure for table `paquete_servicio`
--

DROP TABLE IF EXISTS `paquete_servicio`;
CREATE TABLE IF NOT EXISTS `paquete_servicio` (
  `Paquete_IDPAQUETE` int(11) NOT NULL,
  `servicios_IDSERVICIO` int(11) NOT NULL,
  PRIMARY KEY (`Paquete_IDPAQUETE`,`servicios_IDSERVICIO`),
  KEY `FK_paquete_servicio_servicios_IDSERVICIO` (`servicios_IDSERVICIO`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `paquete_servicio`
--

INSERT INTO `paquete_servicio` (`Paquete_IDPAQUETE`, `servicios_IDSERVICIO`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 1),
(8, 3),
(9, 1),
(9, 2),
(9, 4),
(10, 1),
(10, 3),
(10, 6),
(11, 3),
(11, 6),
(11, 7);

-- --------------------------------------------------------

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `IDPERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `APELLIDOP` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `CELULAR` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DIRECCIONP` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DNI` int(11) DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `FECHANACIO` date DEFAULT NULL,
  `NACIONALIDAD` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `NOMBREP` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`IDPERSONA`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
CREATE TABLE IF NOT EXISTS `servicio` (
  `IDSERVICIO` int(11) NOT NULL AUTO_INCREMENT,
  `COSTOS` double DEFAULT NULL,
  `DESCRIPCIONBREVE` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DESTINOS` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `FECHASERVICIO` date DEFAULT NULL,
  `TIPODSERVICIOS` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`IDSERVICIO`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `servicio`
--

INSERT INTO `servicio` (`IDSERVICIO`, `COSTOS`, `DESCRIPCIONBREVE`, `DESTINOS`, `FECHASERVICIO`, `TIPODSERVICIOS`) VALUES
(1, 3000, 'Cada noche de Hotel', '...', '2021-12-20', 'HOTEL POR NOCHE'),
(2, 5000, 'Se alquila el auto, con un kilometraje fijo.', '...', '2021-12-20', 'ALQUILER DE AUTO'),
(3, 1000, 'Cada Pasaje de Colectivo', '...', '2021-12-20', 'PASAJE DE COLECTIVO'),
(4, 50000, 'Cada Pasaje de avión', '...', '2021-12-20', 'PASAJE DE AVIÓN'),
(5, 1500, 'Cada Pasaje de tren', '...', '2021-12-20', 'PASAJE DE TREN'),
(6, 3500, 'Una excursión de turistica', '...', '2021-12-20', 'EXCURSIÓN'),
(7, 10000, 'el ingreso a un evento.', '...', '2021-12-20', 'ENTRADAS A EVENTOS');

-- --------------------------------------------------------

--
-- Table structure for table `servicio_paquete`
--

DROP TABLE IF EXISTS `servicio_paquete`;
CREATE TABLE IF NOT EXISTS `servicio_paquete` (
  `Servicio_IDSERVICIO` int(11) NOT NULL,
  `paquetes_IDPAQUETE` int(11) NOT NULL,
  PRIMARY KEY (`Servicio_IDSERVICIO`,`paquetes_IDPAQUETE`),
  KEY `FK_servicio_paquete_paquetes_IDPAQUETE` (`paquetes_IDPAQUETE`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `servicio_paquete`
--

INSERT INTO `servicio_paquete` (`Servicio_IDSERVICIO`, `paquetes_IDPAQUETE`) VALUES
(1, 1),
(1, 8),
(1, 9),
(1, 10),
(2, 2),
(2, 9),
(3, 3),
(3, 8),
(3, 10),
(3, 11),
(4, 4),
(4, 9),
(5, 5),
(6, 6),
(6, 10),
(6, 11),
(7, 7),
(7, 11);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `IDUSUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `NOMBREUSR` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `PASSWORD` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `EMPLEADO_IDPERSONA` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDUSUARIO`),
  KEY `FK_usuario_EMPLEADO_IDPERSONA` (`EMPLEADO_IDPERSONA`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`IDUSUARIO`, `ACTIVO`, `NOMBREUSR`, `PASSWORD`, `EMPLEADO_IDPERSONA`) VALUES
(1, 1, '39144923', '12345', 1),
(2, 1, '46514699', '12345', 2),
(3, 1, '35265817', '12345', 3),
(4, 1, '51584081', '12345', 4),
(5, 1, '53045177', '12345', 5),
(6, 1, '48475827', '12345', 6),
(7, 1, '36921131', '12345', 7),
(8, 1, '45653845', '12345', 8),
(9, 1, '47415935', '12345', 9),
(10, 1, '37631235', '12345', 10),
(11, 1, '52037316', '12345', 11),
(12, 1, '71820903', '12345', 12),
(13, 1, '56828023', '12345', 13),
(14, 1, '55220001', '12345', 14),
(15, 1, '55966867', '12345', 15),
(16, 1, '70029489', '12345', 16),
(17, 1, '54675205', '12345', 17),
(18, 1, '63900955', '12345', 18);

-- --------------------------------------------------------

--
-- Table structure for table `usuario_venta`
--

DROP TABLE IF EXISTS `usuario_venta`;
CREATE TABLE IF NOT EXISTS `usuario_venta` (
  `Usuario_IDUSUARIO` int(11) NOT NULL,
  `ventas_IDVENTA` int(11) NOT NULL,
  PRIMARY KEY (`Usuario_IDUSUARIO`,`ventas_IDVENTA`),
  KEY `FK_usuario_venta_ventas_IDVENTA` (`ventas_IDVENTA`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `usuario_venta`
--

INSERT INTO `usuario_venta` (`Usuario_IDUSUARIO`, `ventas_IDVENTA`) VALUES
(8, 10),
(11, 8),
(11, 9),
(12, 5),
(12, 6),
(12, 7),
(13, 1),
(13, 2),
(13, 3),
(13, 4);

-- --------------------------------------------------------

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
CREATE TABLE IF NOT EXISTS `venta` (
  `IDVENTA` int(11) NOT NULL AUTO_INCREMENT,
  `CONTRATACION` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `ESTAPAGO` tinyint(1) DEFAULT '0',
  `FECHAVENTA` date DEFAULT NULL,
  `IMPORTE` double DEFAULT NULL,
  `MEDIODPAGO` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `IDPERSONA` int(11) DEFAULT NULL,
  `IDPAQUETE` int(11) DEFAULT NULL,
  `IDUSUARIO` int(11) NOT NULL,
  PRIMARY KEY (`IDVENTA`),
  KEY `FK_venta_IDUSUARIO` (`IDUSUARIO`),
  KEY `FK_venta_IDPERSONA` (`IDPERSONA`),
  KEY `FK_venta_IDPAQUETE` (`IDPAQUETE`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `venta`
--

INSERT INTO `venta` (`IDVENTA`, `CONTRATACION`, `ESTAPAGO`, `FECHAVENTA`, `IMPORTE`, `MEDIODPAGO`, `IDPERSONA`, `IDPAQUETE`, `IDUSUARIO`) VALUES
(1, 'INDIVIDUAL', 1, '2001-06-15', 3000, 'Efectivo: Sin comisión', NULL, 1, 13),
(2, 'INDIVIDUAL', 1, '2013-11-03', 5150, 'Tarjeta de Débito: 3%', 11, 2, 13),
(3, 'INDIVIDUAL', 1, '2016-11-25', 1090, 'Tarjeta de Crédito: 9%', NULL, 3, 13),
(4, 'INDIVIDUAL', 1, '2020-01-25', 50000, 'Monedero Virtual: Sin comisión', 7, 4, 13),
(5, 'PAQUETE', 1, '2012-11-14', 6915.375, 'Transferencia: 2.45%', 20, 10, 12),
(6, 'PAQUETE', 1, '2012-08-25', 13050, 'Efectivo: Sin comisión', 22, 11, 12),
(7, 'INDIVIDUAL', 1, '2018-09-03', 3605, 'Tarjeta de Débito: 3%', 15, 6, 12),
(8, 'INDIVIDUAL', 1, '2021-06-14', 1635.0000000000002, 'Tarjeta de Crédito: 9%', 9, 5, 11),
(9, 'PAQUETE', 1, '2008-03-31', 3600, 'Monedero Virtual: Sin comisión', 17, 8, 11),
(10, 'PAQUETE', 1, '2015-04-27', 53478.9, 'Transferencia: 2.45%', NULL, 9, 8);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
