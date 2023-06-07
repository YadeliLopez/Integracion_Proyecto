CREATE DATABASE  IF NOT EXISTS `sag` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sag`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sag
-- ------------------------------------------------------
-- Server version	5.5.62

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `catalogo`
--

DROP TABLE IF EXISTS `catalogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `catalogo` (
  `idCatalogo` int(10) NOT NULL,
  `idCategoria` int(10) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `activo` varchar(255) NOT NULL,
  PRIMARY KEY (`idCatalogo`),
  KEY `idCategoria` (`idCategoria`),
  CONSTRAINT `catalogo_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `catalogo` (`idCatalogo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `catalogo`
--

LOCK TABLES `catalogo` WRITE;
/*!40000 ALTER TABLE `catalogo` DISABLE KEYS */;
INSERT INTO `catalogo` VALUES (1,NULL,'Estatus actividad','S'),(2,NULL,'Rol de sistema','S'),(3,NULL,'Raza','S'),(4,NULL,'Ingreso','S'),(5,NULL,'Egreso','S'),(101,1,'Activo','S'),(102,1,'Inactivo','S'),(103,1,'Cancelado','S'),(201,2,'Administrador','S'),(202,2,'Ganadero','S'),(301,3,'Simmental','S'),(302,3,'Brangus','S'),(303,3,'Limousin','S'),(304,3,'Belgian Blue','S'),(305,3,'Nelore','S'),(306,3,'Romagnola','S'),(307,3,'Marchigiana','S'),(308,3,'Holstein','S'),(401,4,'Venta de ganado','S'),(402,4,'Venta de producto lácteo','S'),(403,4,'Venta de producto agrícola','S'),(501,5,'Pago de salario','S'),(502,5,'Compra de medicamento','S'),(503,5,'Honorario a veterinario','S');
/*!40000 ALTER TABLE `catalogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `catalogosfullinfo`
--

DROP TABLE IF EXISTS `catalogosfullinfo`;
/*!50001 DROP VIEW IF EXISTS `catalogosfullinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `catalogosfullinfo` AS SELECT 
 1 AS `idCatalogo`,
 1 AS `idCategoria`,
 1 AS `nombre`,
 1 AS `activo`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `categoriasfullinfo`
--

DROP TABLE IF EXISTS `categoriasfullinfo`;
/*!50001 DROP VIEW IF EXISTS `categoriasfullinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `categoriasfullinfo` AS SELECT 
 1 AS `idCategoria`,
 1 AS `nombre`,
 1 AS `activo`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consulta` (
  `idConsulta` int(10) NOT NULL AUTO_INCREMENT,
  `idHatoTratado` int(10) NOT NULL,
  `veterinario` varchar(100) NOT NULL,
  `fechaAtencion` date NOT NULL,
  `observaciones` varchar(250) DEFAULT NULL,
  `motivoAtencion` varchar(250) NOT NULL,
  PRIMARY KEY (`idConsulta`),
  KEY `idHatoTratado` (`idHatoTratado`),
  CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`idHatoTratado`) REFERENCES `hatos` (`idHato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cria`
--

DROP TABLE IF EXISTS `cria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cria` (
  `idCria` int(10) NOT NULL AUTO_INCREMENT,
  `idHatoMadre` int(10) NOT NULL,
  `sexo` int(10) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `idRaza` int(10) NOT NULL,
  `idEstatus` int(10) NOT NULL,
  `observaciones` varchar(250) DEFAULT NULL,
  `idUsuarioCreador` int(10) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `idUsuarioModificador` int(10) NOT NULL,
  `fechaModificacion` date NOT NULL,
  `fechaBaja` date NOT NULL,
  PRIMARY KEY (`idCria`),
  KEY `idHatoMadre` (`idHatoMadre`),
  KEY `idRaza` (`idRaza`),
  KEY `idEstatus` (`idEstatus`),
  KEY `idUsuarioCreador` (`idUsuarioCreador`),
  KEY `idUsuarioModificador` (`idUsuarioModificador`),
  CONSTRAINT `cria_ibfk_1` FOREIGN KEY (`idHatoMadre`) REFERENCES `hatos` (`idHato`),
  CONSTRAINT `cria_ibfk_2` FOREIGN KEY (`idRaza`) REFERENCES `catalogo` (`idCatalogo`),
  CONSTRAINT `cria_ibfk_3` FOREIGN KEY (`idEstatus`) REFERENCES `catalogo` (`idCatalogo`),
  CONSTRAINT `cria_ibfk_4` FOREIGN KEY (`idUsuarioCreador`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `cria_ibfk_5` FOREIGN KEY (`idUsuarioModificador`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cria`
--

LOCK TABLES `cria` WRITE;
/*!40000 ALTER TABLE `cria` DISABLE KEYS */;
/*!40000 ALTER TABLE `cria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hatos`
--

DROP TABLE IF EXISTS `hatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hatos` (
  `idHato` int(10) NOT NULL AUTO_INCREMENT,
  `arete` varchar(100) NOT NULL,
  `idRaza` int(10) NOT NULL,
  `idLote` int(10) NOT NULL,
  `idRancho` int(10) NOT NULL,
  `sexo` varchar(1) NOT NULL,
  `idEstatus` int(10) NOT NULL,
  `descripcionHato` varchar(150) NOT NULL,
  `idUsuarioCreador` int(10) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `idUsuarioModificador` int(10) NOT NULL,
  `fechaModificacion` date NOT NULL,
  `fechaBaja` date NOT NULL,
  `motivoBaja` varchar(150) NOT NULL,
  PRIMARY KEY (`idHato`),
  KEY `idRaza` (`idRaza`),
  KEY `idLote` (`idLote`),
  KEY `idRancho` (`idRancho`),
  KEY `idEstatus` (`idEstatus`),
  KEY `idUsuarioCreador` (`idUsuarioCreador`),
  KEY `idUsuarioModificador` (`idUsuarioModificador`),
  CONSTRAINT `hatos_ibfk_1` FOREIGN KEY (`idRaza`) REFERENCES `catalogo` (`idCatalogo`),
  CONSTRAINT `hatos_ibfk_2` FOREIGN KEY (`idLote`) REFERENCES `lote` (`idLote`),
  CONSTRAINT `hatos_ibfk_3` FOREIGN KEY (`idRancho`) REFERENCES `rancho` (`idRancho`),
  CONSTRAINT `hatos_ibfk_4` FOREIGN KEY (`idEstatus`) REFERENCES `catalogo` (`idCatalogo`),
  CONSTRAINT `hatos_ibfk_5` FOREIGN KEY (`idUsuarioCreador`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `hatos_ibfk_6` FOREIGN KEY (`idUsuarioModificador`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hatos`
--

LOCK TABLES `hatos` WRITE;
/*!40000 ALTER TABLE `hatos` DISABLE KEYS */;
/*!40000 ALTER TABLE `hatos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `idLote` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `idEstatus` int(10) NOT NULL,
  `idRancho` int(10) NOT NULL,
  `idUsuarioCreador` int(10) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `idUsuarioModificador` int(10) DEFAULT NULL,
  `fechaModificacion` date DEFAULT NULL,
  PRIMARY KEY (`idLote`),
  KEY `idEstatus` (`idEstatus`),
  KEY `idRancho` (`idRancho`),
  KEY `idUsuarioModificador` (`idUsuarioModificador`),
  KEY `idUsuarioCreador` (`idUsuarioCreador`),
  CONSTRAINT `lote_ibfk_1` FOREIGN KEY (`idEstatus`) REFERENCES `catalogo` (`idCatalogo`),
  CONSTRAINT `lote_ibfk_2` FOREIGN KEY (`idRancho`) REFERENCES `rancho` (`idRancho`),
  CONSTRAINT `lote_ibfk_3` FOREIGN KEY (`idUsuarioCreador`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `lote_ibfk_4` FOREIGN KEY (`idUsuarioModificador`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `lote_ibfk_5` FOREIGN KEY (`idUsuarioModificador`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `lote_ibfk_6` FOREIGN KEY (`idUsuarioCreador`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `idMovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `idTipo` int(11) NOT NULL,
  `idConcepto` int(11) NOT NULL,
  `cantidad` varchar(45) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `idUsuarioCreador` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `idEstatus` int(10) NOT NULL,
  `fechaCancelacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMovimiento`),
  KEY `idTipo_idx` (`idTipo`),
  KEY `idConcepto_idx` (`idConcepto`),
  KEY `idUsuarioCreador_idx` (`idUsuarioCreador`),
  KEY `idEstatus_idx` (`idEstatus`),
  CONSTRAINT `idConcepto` FOREIGN KEY (`idConcepto`) REFERENCES `catalogo` (`idCatalogo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idEstatus` FOREIGN KEY (`idEstatus`) REFERENCES `catalogo` (`idCatalogo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idTipo` FOREIGN KEY (`idTipo`) REFERENCES `catalogo` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idUsuarioCreador` FOREIGN KEY (`idUsuarioCreador`) REFERENCES `usuarios` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,4,401,'5','2023-06-01',1,'Venta de 5 hatos a Don Ramiro',101,NULL),(2,5,501,'1','2023-06-01',1,'Pago de salario a Adrían Casas',101,''),(3,4,403,'4','2023-06-06',1,'Venta de 4 costales de arroz',101,NULL),(4,4,402,'9','2023-06-06',1,'Venta de 9 litros de leche a la Lechera Nestle',101,''),(5,4,403,'5','2023-06-06',1,'Venta de un huevito de rancho',101,''),(6,5,501,'1000','2023-06-07',1,'Pago de salario a Luis Zpt. Para que se compre algo bonito.',101,''),(7,5,502,'1500','2023-06-07',1,'Compra de paracetamol para mi vaquita #50',101,NULL);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `movimientosfullinfo`
--

DROP TABLE IF EXISTS `movimientosfullinfo`;
/*!50001 DROP VIEW IF EXISTS `movimientosfullinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `movimientosfullinfo` AS SELECT 
 1 AS `idMovimiento`,
 1 AS `idTipo`,
 1 AS `tipo`,
 1 AS `idConcepto`,
 1 AS `concepto`,
 1 AS `cantidad`,
 1 AS `idEstatus`,
 1 AS `estatus`,
 1 AS `fechaCreacion`,
 1 AS `idUsuarioCreador`,
 1 AS `usuarioCreador`,
 1 AS `descripcion`,
 1 AS `fechaCancelacion`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `rancho`
--

DROP TABLE IF EXISTS `rancho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rancho` (
  `idRancho` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `encargado` varchar(150) NOT NULL,
  `idEstatus` int(10) DEFAULT NULL,
  `idUsuarioCreador` int(10) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `idUsuarioModificador` int(10) DEFAULT NULL,
  `fechaModificacion` date DEFAULT NULL,
  PRIMARY KEY (`idRancho`),
  KEY `idUsuarioCreador` (`idUsuarioCreador`),
  KEY `idUsuarioModificador` (`idUsuarioModificador`),
  CONSTRAINT `rancho_ibfk_1` FOREIGN KEY (`idUsuarioCreador`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `rancho_ibfk_2` FOREIGN KEY (`idUsuarioModificador`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rancho`
--

LOCK TABLES `rancho` WRITE;
/*!40000 ALTER TABLE `rancho` DISABLE KEYS */;
INSERT INTO `rancho` VALUES (1,'Loma Bonita','Palmas de Abajo','Enrique López',101,1,'2023-05-07',1,'2023-05-08'),(2,'Rancho Alegre','Palmas de Arriba','Marco Turrón',101,1,'2023-05-07',1,'2023-05-29'),(3,'Cielo Abierto','Pacho Viejo','Luis Zapata',101,1,'2023-05-07',1,'2023-05-26'),(4,'Hacienda de Cortés','La Antigua','Guillermo del Toro',101,1,'2023-05-19',1,'2023-05-26'),(5,'Vaquita Feliz 1','Agua Santa','Erick Hernández',102,1,'2023-05-26',5,'2023-06-06'),(6,'Quinta San Martín','San Martín','Luis Zapata',102,1,'2023-05-26',5,'2023-06-06'),(7,'Hacienda Llano Grande','Llano Grande','Jacinto el Grande',101,2,'2023-05-27',NULL,NULL),(13,'Aguacatal','Xalapa','John Morphy',102,1,'2023-05-28',1,'2023-05-29'),(14,'Tulúm','Cardel','Pedro Chacón',102,1,'2023-05-28',1,'2023-05-29'),(15,'El Semental Blanco','El Farallón','Guillermo Rivera',101,1,'2023-05-28',1,'2023-05-29'),(16,'Ganado Ganador','Jalacingo','Diana Cristino',102,1,'2023-05-28',1,'2023-05-29'),(17,'Paloma Blanca','rt','rt',101,1,'2023-05-28',1,'2023-05-31'),(18,'Otro Rancho','San Martín','Oscar Altamirano',102,1,'2023-05-31',1,'2023-06-01'),(19,'Uno','DOs','Yres',101,1,'2023-06-01',1,'2023-06-01'),(20,'Mi Ranchito','Palma Sola','Arisbeth',102,1,'2023-06-01',1,'2023-06-01'),(21,'Vaca que más aplaude','Una mesa por ahí','La misma vaca',102,1,'2023-05-29',1,'2023-06-01'),(22,'q','q','q',101,1,'2023-06-01',NULL,NULL),(23,'Rancho Robles','Robles','Tibursio Robles',102,1,'2023-06-01',NULL,NULL),(24,'4','403','5',NULL,1,'2023-06-07',NULL,NULL),(25,'4','403','5',101,1,'2023-06-06',NULL,NULL);
/*!40000 ALTER TABLE `rancho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `ranchosfullinfo`
--

DROP TABLE IF EXISTS `ranchosfullinfo`;
/*!50001 DROP VIEW IF EXISTS `ranchosfullinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `ranchosfullinfo` AS SELECT 
 1 AS `idRancho`,
 1 AS `nombre`,
 1 AS `direccion`,
 1 AS `encargado`,
 1 AS `idEstatus`,
 1 AS `Estatus`,
 1 AS `idUsuarioCreador`,
 1 AS `usuarioCreador`,
 1 AS `fechaCreacion`,
 1 AS `idUsuarioModificador`,
 1 AS `usuarioModificador`,
 1 AS `fechaModificacion`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `traspasos`
--

DROP TABLE IF EXISTS `traspasos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `traspasos` (
  `idTraspaso` int(10) NOT NULL AUTO_INCREMENT,
  `idLoteAnterior` int(10) NOT NULL,
  `idLoteDestino` int(10) NOT NULL,
  `fechaCancelacion` date NOT NULL,
  `motivoCancelacion` varchar(250) NOT NULL,
  `idRancho` int(10) NOT NULL,
  `idUsuarioCreador` int(10) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `idUsuarioModificador` int(10) NOT NULL,
  `fechaModificacion` date NOT NULL,
  PRIMARY KEY (`idTraspaso`),
  KEY `idLoteAnterior` (`idLoteAnterior`),
  KEY `idLoteDestino` (`idLoteDestino`),
  KEY `idRancho` (`idRancho`),
  KEY `idUsuarioCreador` (`idUsuarioCreador`),
  KEY `idUsuarioModificador` (`idUsuarioModificador`),
  CONSTRAINT `traspasos_ibfk_1` FOREIGN KEY (`idLoteAnterior`) REFERENCES `lote` (`idLote`),
  CONSTRAINT `traspasos_ibfk_2` FOREIGN KEY (`idLoteDestino`) REFERENCES `lote` (`idLote`),
  CONSTRAINT `traspasos_ibfk_3` FOREIGN KEY (`idRancho`) REFERENCES `rancho` (`idRancho`),
  CONSTRAINT `traspasos_ibfk_4` FOREIGN KEY (`idUsuarioCreador`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `traspasos_ibfk_5` FOREIGN KEY (`idUsuarioModificador`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traspasos`
--

LOCK TABLES `traspasos` WRITE;
/*!40000 ALTER TABLE `traspasos` DISABLE KEYS */;
/*!40000 ALTER TABLE `traspasos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuario` int(10) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `apellidoPaterno` varchar(150) NOT NULL,
  `apellidoMaterno` varchar(150) NOT NULL,
  `celular` varchar(10) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(200) DEFAULT NULL,
  `idRol` int(10) NOT NULL,
  `idEstatus` int(10) NOT NULL,
  `idRancho` int(10) NOT NULL,
  `idUsuarioCreador` int(10) NOT NULL,
  `fechaCreacion` date NOT NULL,
  `idUsuarioModificador` int(10) DEFAULT NULL,
  `fechaModificacion` date DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idEstatus` (`idEstatus`),
  KEY `idRol` (`idRol`),
  KEY `idRancho` (`idRancho`),
  KEY `idUsuarioCreador` (`idUsuarioCreador`),
  KEY `idUsuarioModificador` (`idUsuarioModificador`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idEstatus`) REFERENCES `catalogo` (`idCatalogo`),
  CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`idRol`) REFERENCES `catalogo` (`idCatalogo`),
  CONSTRAINT `usuarios_ibfk_3` FOREIGN KEY (`idRancho`) REFERENCES `rancho` (`idRancho`),
  CONSTRAINT `usuarios_ibfk_4` FOREIGN KEY (`idUsuarioCreador`) REFERENCES `usuarios` (`idUsuario`),
  CONSTRAINT `usuarios_ibfk_5` FOREIGN KEY (`idUsuarioModificador`) REFERENCES `usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Yadelí','López','Puntualidad','2961192001','yayis','7B0A2055793A76518FADFE192E23109E4552157783D4B52AAD6AB6318C4A093C5DB67F13F20CFFD1B9539DC8CE77B77ECE18A3028023ADA6A4C779C2549DD1BD',201,101,2,1,'2023-05-10',1,'2023-06-06'),(2,'Evelyn','López','Aguilar','2961167820','eve','48B9B84558AD2E4043D888CB929A716706739865864AB3A05B766D0F028F22891CD39B71BADC58BB8DB99BD890BDC5C0B6A20D117D2D1F0627E7080E3C062429',202,101,2,1,'2023-05-10',1,'2023-05-14'),(3,'Marco','Arriaga','Bravo','2289035718','marco','C8F3D20FB9A1C1EE86B90A729C3763E4890A40ABD12713499F6FAE9C23A1D19C5FD5E34337D068613DF64027F4694FE1B0C1297BA6DDE3F6EA60494878AF3355',202,101,3,1,'2023-05-10',1,'2023-05-14'),(4,'Paulina','Montalvo','Pérez','2293480123','pau','19283475744DA16866122D61F3D131ECA81D4ACE27AD662CA55E2D9ADB48B946A19EA0CE40A091E166E9B7307086F9B8E0BEC61D985788B44CD490C69417AD36',202,101,1,1,'2023-05-10',1,'2023-05-14'),(5,'Emilio','Rodríguez','Estevez','2284502984','emilio','33F4D35B6F9607779BF640350D7487BD4274F6FAFFEAD99C08C70383133239DE5AA98944E09D995F52AE5B6B5DBDD60CD4107D462DF0F0CFD656F3AF6A90CF0E',201,101,3,1,'2023-05-10',1,'2023-05-14'),(6,'Tabata','Gómez','Hernández','2283401235','tabata','5D1A77D23932B49F2786335FA0ACA3679FA6DD14A5D9859FA07DEDF2AA1A3F7BD656527CDA0A47B4FB738A966310A8970AD6CEF505DF8930529DF40E5149D7E6',202,101,2,2,'2023-05-10',NULL,NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `usuariosfullinfo`
--

DROP TABLE IF EXISTS `usuariosfullinfo`;
/*!50001 DROP VIEW IF EXISTS `usuariosfullinfo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `usuariosfullinfo` AS SELECT 
 1 AS `idUsuario`,
 1 AS `nombre`,
 1 AS `apellidoPaterno`,
 1 AS `apellidoMaterno`,
 1 AS `celular`,
 1 AS `usuario`,
 1 AS `contrasena`,
 1 AS `idRol`,
 1 AS `rol`,
 1 AS `idEstatus`,
 1 AS `estatus`,
 1 AS `idRancho`,
 1 AS `rancho`,
 1 AS `idUsuarioCreador`,
 1 AS `usuarioCreador`,
 1 AS `fechaCreacion`,
 1 AS `idUsuarioModificador`,
 1 AS `usuarioModificador`,
 1 AS `fechaModificacion`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'sag'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarCatalogo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarCatalogo`(IN idCatalogo INT(10), IN idCategoria INT(10), IN nombre VARCHAR(50), IN activo VARCHAR(255))
BEGIN
UPDATE catalogo c SET c.idCategoria=idCategoria, c.nombre=nombre, c.activo=activo WHERE c.idCatalogo=idCatalogo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarCategoria`(IN idCategoria INT(10), IN nombre VARCHAR(50), IN activo char(255))
BEGIN
UPDATE catalogo c SET c.nombre=nombre, c.activo=activo WHERE c.idCatalogo=idCategoria;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarEstatusCatalogo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarEstatusCatalogo`(IN idCatalogo INT(10), IN activo VARCHAR(255))
BEGIN
UPDATE catalogo c SET c.activo=activo WHERE c.idCatalogo=idCatalogo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarEstatusCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarEstatusCategoria`(IN idCategoria int(10), IN activo varchar(255))
BEGIN
UPDATE catalogo c SET c.activo=activo WHERE c.idCatalogo=idCategoria;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarEstatusMovi` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarEstatusMovi`(IN idMovimiento INT, IN fechaCancelacion VARCHAR(100), IN idEstatus INT)
BEGIN
	UPDATE movimientos m SET m.idEstatus=idEstatus, m.fechaCancelacion=fechaCancelacion WHERE m.idMovimiento=idMovimiento;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarEstatusRancho` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarEstatusRancho`(IN idRancho INT, IN idEstatus INT)
BEGIN
	UPDATE rancho r SET r.idEstatus=idEstatus WHERE r.idRancho=idRancho;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarEstatusUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarEstatusUsuario`(IN idUsuario INT(10), IN idEstatus INT(10))
BEGIN
UPDATE usuarios u SET u.idEstatus = idEstatus WHERE u.idUsuario=idUsuario;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarRancho` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarRancho`(IN idRancho INT, IN nombre VARCHAR(100), IN direccion VARCHAR(100), IN encargado VARCHAR(100), IN idEstatus INT, IN idUsuarioModificador INT, IN fechaModificacion DATE)
BEGIN
	UPDATE rancho r SET r.nombre=nombre, r.direccion=direccion, r.encargado=encargado, r.idEstatus=idEstatus, r.idUsuarioModificador=idUsuarioModificador, r.fechaModificacion=fechaModificacion
    WHERE r.idRancho=idRancho;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizarUsuario`(IN idUsuario INT(10), IN nombre VARCHAR(150), IN apellidoPaterno VARCHAR(150) , IN apellidoMaterno VARCHAR(150), IN celular VARCHAR(10), IN usuario VARCHAR(50),IN contrasena VARCHAR(200), IN idRol INT(10), IN idEstatus INT(10), IN idRancho INT(10), IN idUsuarioModificador INT(10), IN fechaModificacion DATE)
BEGIN
UPDATE usuarios u SET u.nombre=nombre, u.apellidoPaterno=apellidoPaterno, u.apellidoMaterno=apellidoMaterno, u.celular=celular, u.usuario=usuario, u.contrasena=contrasena, u.idRol=idRol, u.idEstatus=idEstatus, u.idRancho=idRancho, u.idUsuarioModificador=idUsuarioModificador, u.fechaModificacion=fechaModificacion WHERE u.idUsuario=idUsuario;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarCategoria`(IN busqueda varchar(50))
BEGIN
SELECT * FROM categoriasfullinfo c WHERE c.idCategoria=busqueda OR LOCATE(busqueda, c.nombre);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarRancho` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarRancho`(IN busqueda varchar(50))
BEGIN
	SELECT * FROM ranchosfullinfo r WHERE r.idRancho=busqueda OR LOCATE(busqueda, r.nombre);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_buscarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscarUsuario`(IN busqueda VARCHAR(50))
BEGIN
	SELECT * FROM usuariosfullinfo u WHERE u.idUsuario=busqueda OR LOCATE(busqueda, u.nombre);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_cancelarMovimiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_cancelarMovimiento`(IN idMovimiento INT, IN fechaCancelacion DATE)
BEGIN
	UPDATE movimientos m SET m.fechaCancelacion=fechaCancelacion, idEstatus=103 WHERE m.idMovimiento=idMovimiento;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_eliminarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminarUsuario`(IN idUsuario INT(10))
BEGIN
UPDATE usuarios u SET idEstatus=102 WHERE u.idUsuario=idUsuario;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllCatalogos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllCatalogos`()
BEGIN
SELECT * FROM catalogosfullinfo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllCatalogosByIdCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllCatalogosByIdCategoria`(IN idCategoria INT(10))
BEGIN
SELECT * FROM catalogosfullinfo c WHERE c.idCategoria = idCategoria;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllCategorias` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllCategorias`()
BEGIN
SELECT * FROM categoriasfullinfo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllMovimientos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllMovimientos`()
BEGIN
	Select * from movimientosfullinfo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllRanchos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllRanchos`()
BEGIN
SELECT * FROM ranchosfullinfo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllRolesUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllRolesUsuario`()
BEGIN
	Select * from catalogo where idCategoria=2 AND activo="S";
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllUsers` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getAllUsers`()
BEGIN
	SELECT * FROM usuariosfullinfo;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getEgresos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getEgresos`()
BEGIN
	Select * from catalogo where idCategoria=5 AND activo="S";
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getIngresos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getIngresos`()
BEGIN
	Select * from catalogo where idCategoria=4 AND activo="S";
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_login`(IN usuario VARCHAR(50), IN contrasena VARCHAR(1000))
BEGIN
SELECT * FROM usuariosfullinfo u WHERE u.usuario=usuario AND u.contrasena=contrasena;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registarMovimiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registarMovimiento`(IN idTipo INT, IN tipo VARCHAR(100), IN idConcepto INT, IN concepto VARCHAR(100), 
IN cantidad VARCHAR(100),IN fechaCreacion DATE, IN idUsuarioCreador INT, IN usuarioCreador VARCHAR(100), IN descripcion VARCHAR(250), IN fechaCancelacion DATE)
BEGIN
	INSERT INTO movimientos(idTipo, tipo, idConcepto, concepto, cantidad, fechaCreacion, idUsuarioCreador, usuarioCreador, descripcion, fechaCancelacion) VALUES (idTipo, tipo, idConcepto, concepto, cantidad, fechaCreacion, idUsuarioCreador, usuarioCreador, descripcion, fechaCancelacion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrarCatalogo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarCatalogo`(IN idCatalogo INT(10), IN idCategoria INT(10), IN nombre VARCHAR(50), IN activo CHAR(255))
BEGIN
INSERT INTO catalogo(idCatalogo, idCategoria, nombre, activo) VALUES (idCatalogo, idCategoria, nombre, activo);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrarCategoria` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarCategoria`(IN idCategoria INT(10), IN nombre VARCHAR(50), IN activo CHAR(255))
BEGIN
INSERT INTO catalogo(idCatalogo, nombre, activo) VALUES (idCategoria, nombre, activo);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrarMovimiento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarMovimiento`(IN idTipo INT, IN idConcepto INT, 
IN cantidad VARCHAR(100),IN fechaCreacion DATE, IN idUsuarioCreador INT, IN descripcion VARCHAR(250), IN idEstatus INT)
BEGIN
	INSERT INTO movimientos(idTipo, idConcepto, cantidad, fechaCreacion, idUsuarioCreador, descripcion, idEstatus) VALUES (idTipo, idConcepto, cantidad, fechaCreacion, idUsuarioCreador, descripcion, idEstatus);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrarRancho` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarRancho`(IN nombre VARCHAR(150), IN direccion VARCHAR(150), IN encargado VARCHAR(150), IN idEstatus INT(10),IN idUsuarioCreador INT(10), IN fechaCreacion DATE)
BEGIN
	INSERT INTO rancho(nombre, direccion,encargado, idEstatus, idUsuarioCreador, fechaCreacion) VALUES (nombre,direccion,encargado,idEstatus,idUsuarioCreador,fechaCreacion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrarUsuario`(IN nombre VARCHAR(150), IN apellidoPaterno VARCHAR(150) , IN apellidoMaterno VARCHAR(150), IN celular VARCHAR(10), IN usuario VARCHAR(50),IN contrasena VARCHAR(200), IN idRol INT(10), IN idEstatus INT(10), IN idRancho INT(10), IN idUsuarioCreador INT(10), IN fechaCreacion DATE)
BEGIN
INSERT INTO usuarios (nombre, apellidoPaterno, apellidoMaterno, celular, usuario, contrasena, idRol, idEstatus, idRancho, idUsuarioCreador, fechaCreacion) VALUES (nombre, apellidoPaterno, apellidoMaterno, celular, usuario, contrasena, idRol, idEstatus, idRancho, idUsuarioCreador, fechaCreacion);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `catalogosfullinfo`
--

/*!50001 DROP VIEW IF EXISTS `catalogosfullinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `catalogosfullinfo` AS select `catalogo`.`idCatalogo` AS `idCatalogo`,`catalogo`.`idCategoria` AS `idCategoria`,`catalogo`.`nombre` AS `nombre`,`catalogo`.`activo` AS `activo` from `catalogo` where (`catalogo`.`idCategoria` is not null) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `categoriasfullinfo`
--

/*!50001 DROP VIEW IF EXISTS `categoriasfullinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `categoriasfullinfo` AS select `catalogo`.`idCatalogo` AS `idCategoria`,`catalogo`.`nombre` AS `nombre`,`catalogo`.`activo` AS `activo` from `catalogo` where isnull(`catalogo`.`idCategoria`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `movimientosfullinfo`
--

/*!50001 DROP VIEW IF EXISTS `movimientosfullinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `movimientosfullinfo` AS select `m`.`idMovimiento` AS `idMovimiento`,`m`.`idTipo` AS `idTipo`,`c1`.`nombre` AS `tipo`,`m`.`idConcepto` AS `idConcepto`,`c2`.`nombre` AS `concepto`,`m`.`cantidad` AS `cantidad`,`m`.`idEstatus` AS `idEstatus`,`c3`.`nombre` AS `estatus`,date_format(`m`.`fechaCreacion`,'%d-%m-%Y') AS `fechaCreacion`,`m`.`idUsuarioCreador` AS `idUsuarioCreador`,concat(`ua`.`nombre`,' ',`ua`.`apellidoPaterno`,' ',`ua`.`apellidoMaterno`) AS `usuarioCreador`,`m`.`descripcion` AS `descripcion`,date_format(`m`.`fechaCancelacion`,'%d-%m-%Y') AS `fechaCancelacion` from ((((`movimientos` `m` join `catalogo` `c1` on((`m`.`idTipo` = `c1`.`idCatalogo`))) join `catalogo` `c2` on((`m`.`idConcepto` = `c2`.`idCatalogo`))) join `catalogo` `c3` on((`m`.`idEstatus` = `c3`.`idCatalogo`))) join `usuarios` `ua` on((`m`.`idUsuarioCreador` = `ua`.`idUsuario`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `ranchosfullinfo`
--

/*!50001 DROP VIEW IF EXISTS `ranchosfullinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `ranchosfullinfo` AS select `r`.`idRancho` AS `idRancho`,`r`.`nombre` AS `nombre`,`r`.`direccion` AS `direccion`,`r`.`encargado` AS `encargado`,`r`.`idEstatus` AS `idEstatus`,`c1`.`nombre` AS `Estatus`,`r`.`idUsuarioCreador` AS `idUsuarioCreador`,concat(`ua`.`nombre`,' ',`ua`.`apellidoPaterno`,' ',`ua`.`apellidoMaterno`) AS `usuarioCreador`,date_format(`r`.`fechaCreacion`,'%d-%m-%Y') AS `fechaCreacion`,`r`.`idUsuarioModificador` AS `idUsuarioModificador`,concat(`ue`.`nombre`,' ',`ue`.`apellidoPaterno`,' ',`ue`.`apellidoMaterno`) AS `usuarioModificador`,date_format(`r`.`fechaModificacion`,'%d-%m-%Y') AS `fechaModificacion` from (((`rancho` `r` join `catalogo` `c1` on((`r`.`idEstatus` = `c1`.`idCatalogo`))) join `usuarios` `ua` on((`r`.`idUsuarioCreador` = `ua`.`idUsuario`))) left join `usuarios` `ue` on((`r`.`idUsuarioModificador` = `ue`.`idUsuario`))) order by `r`.`idRancho` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `usuariosfullinfo`
--

/*!50001 DROP VIEW IF EXISTS `usuariosfullinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `usuariosfullinfo` AS select `u`.`idUsuario` AS `idUsuario`,`u`.`nombre` AS `nombre`,`u`.`apellidoPaterno` AS `apellidoPaterno`,`u`.`apellidoMaterno` AS `apellidoMaterno`,`u`.`celular` AS `celular`,`u`.`usuario` AS `usuario`,`u`.`contrasena` AS `contrasena`,`u`.`idRol` AS `idRol`,`c1`.`nombre` AS `rol`,`u`.`idEstatus` AS `idEstatus`,`c2`.`nombre` AS `estatus`,`u`.`idRancho` AS `idRancho`,`c3`.`nombre` AS `rancho`,`u`.`idUsuarioCreador` AS `idUsuarioCreador`,concat(`ua`.`nombre`,' ',`ua`.`apellidoPaterno`,' ',`ua`.`apellidoMaterno`) AS `usuarioCreador`,date_format(`u`.`fechaCreacion`,'%d-%m-%Y') AS `fechaCreacion`,`u`.`idUsuarioModificador` AS `idUsuarioModificador`,concat(`ue`.`nombre`,' ',`ue`.`apellidoPaterno`,' ',`ue`.`apellidoMaterno`) AS `usuarioModificador`,date_format(`u`.`fechaModificacion`,'%d-%m-%Y') AS `fechaModificacion` from (((((`usuarios` `u` join `catalogo` `c1` on((`u`.`idRol` = `c1`.`idCatalogo`))) join `catalogo` `c2` on((`u`.`idEstatus` = `c2`.`idCatalogo`))) join `rancho` `c3` on((`u`.`idRancho` = `c3`.`idRancho`))) join `usuarios` `ua` on((`u`.`idUsuarioCreador` = `ua`.`idUsuario`))) left join `usuarios` `ue` on((`u`.`idUsuarioModificador` = `ue`.`idUsuario`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 15:37:27
