-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dbinfox
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `tbos`
--

DROP TABLE IF EXISTS `tbos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbos` (
  `os` int NOT NULL AUTO_INCREMENT,
  `data_os` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo` varchar(40) NOT NULL DEFAULT '',
  `situacao` varchar(50) NOT NULL DEFAULT 'Aguardando Aprovação',
  `equipamento` varchar(150) NOT NULL DEFAULT '',
  `defeito` varchar(150) NOT NULL DEFAULT '',
  `servico` varchar(150) DEFAULT '',
  `valor` decimal(10,2) DEFAULT '0.00',
  `id_cliente` int NOT NULL,
  `id_usuario_tecnico` int NOT NULL,
  PRIMARY KEY (`os`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_usuario_tecnico` (`id_usuario_tecnico`),
  CONSTRAINT `tbos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `tbclientes` (`id`),
  CONSTRAINT `tbos_ibfk_2` FOREIGN KEY (`id_usuario_tecnico`) REFERENCES `tbusuarios` (`id`),
  CONSTRAINT `tbos_chk_1` CHECK ((`situacao` in (_utf8mb4'Entrega OK',_utf8mb4'Orçamento Reprovado',_utf8mb4'Orçamento Aprovado',_utf8mb4'Aguardando Aprovação',_utf8mb4'Aguardando Peças',_utf8mb4'Abandonado Pelo Cliente',_utf8mb4'Na Bancada',_utf8mb4'Retornou',_utf8mb4'Aguardando Entrega',_utf8mb4'Irreparável'))),
  CONSTRAINT `tbos_chk_2` CHECK ((`tipo` in (_utf8mb4'Ordem de Serviço',_utf8mb4'Orçamento')))
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbos`
--

LOCK TABLES `tbos` WRITE;
/*!40000 ALTER TABLE `tbos` DISABLE KEYS */;
INSERT INTO `tbos` VALUES (1,'2022-06-30 12:25:42','Orçamento','Orçamento Reprovado','celular','não liga','trocar bateria',350.00,1,1),(2,'2022-06-30 20:11:11','Ordem de Serviço','Entrega OK','Celular','Não liga','Trocado a bateria',250.00,1,4),(3,'2022-07-01 14:16:57','Ordem de Serviço','Aguardando Peças','celular','tela quebrada','trocar tela',250.00,15,3),(4,'2022-07-01 14:20:02','Ordem de Serviço','Na Bancada','Smartphone','Pelicula Trincada','Trocar pelicula',50.00,1,1),(5,'2022-07-01 17:56:14','Ordem de Serviço','Aguardando Entrega','radio','chiando','trocar antena',110.00,10,4),(6,'2022-07-04 20:37:05','Orçamento','Aguardando Peças','Controle remoto','Não troca de canal','Trocar pilhas',20.00,12,1),(7,'2022-07-04 20:40:30','Ordem de Serviço','Aguardando Entrega','teclado','teclas trancando','limpar teclado',50.00,6,2),(10,'2022-07-05 18:51:16','Ordem de Serviço','Orçamento Aprovado','Geladeira','Não gela','Colocar gás',250.00,18,2),(11,'2022-07-05 19:00:46','Ordem de Serviço','Na Bancada','Notebook lenovo','travando','formatar',120.00,7,3),(12,'2022-07-05 19:03:42','Orçamento','Aguardando Aprovação','torradeira','não esquenta','trocar resistencia',90.00,10,5),(13,'2022-07-05 19:05:09','Orçamento','Entrega OK','s','s','',20.00,7,1),(14,'2022-07-05 19:09:23','Ordem de Serviço','Na Bancada','radio tv','chuviscando','trocar antena',200.00,12,1);
/*!40000 ALTER TABLE `tbos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-05 17:18:15
