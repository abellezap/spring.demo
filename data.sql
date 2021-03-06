CREATE DATABASE  IF NOT EXISTS `clinica_kvbe_2022_1` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `clinica_kvbe_2022_1`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: clinica_kvbe_2022_1
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_medicamento`
--

DROP TABLE IF EXISTS `tb_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_medicamento` (
  `cod_med` int NOT NULL AUTO_INCREMENT,
  `nom_med` varchar(50) DEFAULT NULL,
  `des_med` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sto_med` int DEFAULT NULL,
  `pre_med` double DEFAULT NULL,
  `fec_fab_med` date DEFAULT NULL,
  `cod_tipo` int DEFAULT NULL,
  PRIMARY KEY (`cod_med`),
  KEY `fk_01` (`cod_tipo`),
  CONSTRAINT `fk_01` FOREIGN KEY (`cod_tipo`) REFERENCES `tb_tipo_medicamento` (`cod_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_medicamento`
--

LOCK TABLES `tb_medicamento` WRITE;
/*!40000 ALTER TABLE `tb_medicamento` DISABLE KEYS */;
INSERT INTO `tb_medicamento` VALUES (1,'Paracetamol 500 mg','Paracetamol',20,5.6,'2022-01-01',2),(2,'Simvastatina','Se emplea para reducir el colesterol y los triglic??ridos (tipo de grasa) en la sangre. Descubierta y desarrollada por Merck, se trata del primer medicamento con estatina que evidencia una disminuci??n de la enfermedad cardiovascular y mortalidad. Est?? en la lista modelo de medicamentos esenciales de la Organizaci??n Mundial de la Salud, en la que se describen los m??s importantes y necesarios en el sistema sanitario b??sico.',1,22,'2021-03-01',3),(3,'Aspirina','Tambi??n conocida como ??cido acetilsalic??lico (ASA), reduce las sustancias en el cuerpo que producen dolor, fiebre e inflamaci??n. Es el medicamento m??s usado en todo el mundo y se calcula que cada a??o se consumen unas 40.000 toneladas.',20,22,'2021-03-01',1),(4,'Omeprazol ','inhibe la bomba de protones (IBPS)y disminuye la producci??n de ??cido al bloquear la enzima de la pared del estomago que se encarga de producir esta sustancia. Este efecto reviene las ulceras y tiene un resultado curativo sobre las ulceras existentes en el es??fago, estomago y duodeno. La OMS lo incluye como medicamento b??sico.',20,5,'2021-03-10',1),(5,'Lexotiroxina s??dica','Se encarga de sustituir una hormona que se suele producir en nuestra gl??ndula tiroidea para regular la energ??a y el metabolismo del cuerpo. Es una versi??n artificial de la hormona tiroxina, responsable de aumentar la tasa metab??lica de las c??lulas de todos los tejidos del organismo y ayuda a mantener la funci??n cerebral, la absorci??n de los alimentos y la temperatura corporal, entre otros efectos. Tambi??n la lista de la OMS.',25,25.6,'2025-06-24',2),(50,'prueba50000000','bbbb5000000',15,12.8,'2022-04-05',1);
/*!40000 ALTER TABLE `tb_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_medicamento`
--

DROP TABLE IF EXISTS `tb_tipo_medicamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_medicamento` (
  `cod_tipo` int NOT NULL AUTO_INCREMENT,
  `nom_tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_medicamento`
--

LOCK TABLES `tb_tipo_medicamento` WRITE;
/*!40000 ALTER TABLE `tb_tipo_medicamento` DISABLE KEYS */;
INSERT INTO `tb_tipo_medicamento` VALUES (1,'Analgesicos'),(2,'Ansioliticos e hipneticos'),(3,'Antiacidos'),(4,'Antibacticos'),(5,'Antidiarreicos'),(6,'Antigripales'),(7,'Antihistamanicos'),(8,'Antiinflamatorios'),(9,'Antimicaticos'),(10,'Antipirticos'),(11,'Anticepticos'),(12,'Antitusivos'),(13,'Broncodilatadores'),(14,'Expectorantes'),(15,'Laxantes'),(16,'Mucoliticos');
/*!40000 ALTER TABLE `tb_tipo_medicamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'clinica_kvbe_2022_1'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-08 22:33:12
