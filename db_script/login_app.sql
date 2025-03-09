CREATE DATABASE  IF NOT EXISTS `login_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `login_app`;
-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: login_app
-- ------------------------------------------------------
-- Server version	8.0.41-0ubuntu0.24.04.1

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
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupo` (
  `id_grupo` int NOT NULL AUTO_INCREMENT,
  `nome_grupo` varchar(45) DEFAULT NULL,
  `descricao_grupo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_grupo`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (17,'admin','Administrators'),(18,'usuario','Usuarios');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `nome_usuario` varchar(45) DEFAULT NULL,
  `sobrenome_usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'ana','PBKDF2WithHmacSHA256:2048:J3rGl2Nr0AyscrZWQM1zZTr/Vmlz/Kfy0E3KoipKdJ4=:NWSpVQ/BXGT97Rvj+ApsXtBCSeA30xHOu8G13oCgqfw=','Ana Maria','Pedro'),(2,'maria','maria','Maria','Sapalo'),(3,'bartolomeu','bartolomeu','Bartolomeu','Hangalo'),(4,'hangalo','hangalo','Joaquim','Hangalo'),(10,'saddams','PBKDF2WithHmacSHA256:2048:XJcO7uStpJ9fxrc9wv48WTnjUxLWrvlGbn1KU9NZUII=:TcozoEbmhGUN7DWS0k2bQueHpQx43i+EEySuJp5MTxM=','Sally Addams','Addams'),(11,'tmatthews','PBKDF2WithHmacSHA256:2048:zvVIKl4qzdChwRaILXhDEmBeX/uYke/Vebxvid8HsOk=:PdWsPKcee8qSRBLk03DiMW7/cIjX2pwIYrH+6eQ8tzA=','Tom Matthews','Matthews'),(12,'sapalo','PBKDF2WithHmacSHA256:2048:381P4iY+MkHmNbz2eVAdtBdkv2EApNK+9MXuDSm+LlA=:Jv5hSLEc/mh78LDhon+x6CpRsvvk4N2pWsrHfqa8DI0=','Maria','Sapalo'),(13,'carlos','PBKDF2WithHmacSHA256:2048:yl+uBM4wPWe/hmTT2gQfwn5ruQZfTyFhqa0npJbdkQ8=:nAFzUmzSctFaY3bXXjJYtmCjDWFX1RGQSHk5fKKCbQQ=','Carlos','Alberto'),(15,NULL,'PBKDF2WithHmacSHA256:2048:S7pBcOV/rSm6E+ltDXXegb6T3Qx6pVkVp2yczbCS61o=:lsrTvpwmQluO/qBk9m0jCRkZkeHbL8i6UxuYL3lQoe8=','Ana Maria','Pedro'),(16,'mariasapalo','PBKDF2WithHmacSHA256:2048:8GjvwgBlRhYjTMQnkwvLOjdcnB79fBwtf4Lt5LzGfTk=:jvK/GkrUA2X7njeqnS/KCE/qxc+WHCvgTYYtddLuBiU=','Maria','da Conceição');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_grupo`
--

DROP TABLE IF EXISTS `usuario_grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_grupo` (
  `id_usuario` int NOT NULL,
  `id_grupo` int NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_grupo`),
  KEY `FK_usario_grupo_grupo_idx` (`id_grupo`),
  CONSTRAINT `FK_usario_grupo_grupo` FOREIGN KEY (`id_grupo`) REFERENCES `grupo` (`id_grupo`),
  CONSTRAINT `FK_usuario_grupo_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_grupo`
--

LOCK TABLES `usuario_grupo` WRITE;
/*!40000 ALTER TABLE `usuario_grupo` DISABLE KEYS */;
INSERT INTO `usuario_grupo` VALUES (1,17),(2,17),(10,17),(12,17),(3,18),(11,18);
/*!40000 ALTER TABLE `usuario_grupo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-09 11:43:55
