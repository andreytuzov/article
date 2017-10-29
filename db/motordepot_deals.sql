CREATE DATABASE  IF NOT EXISTS `motordepot` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `motordepot`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: motordepot
-- ------------------------------------------------------
-- Server version	5.5.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `deals`
--

DROP TABLE IF EXISTS `deals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deals` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_user_id` int(11) NOT NULL,
  `d_car_id` int(11) NOT NULL,
  `d_deal_state_id` int(11) NOT NULL,
  `d_cost` float NOT NULL,
  `d_date_from` datetime NOT NULL,
  `d_date_to` datetime NOT NULL,
  `d_comment` varchar(200) DEFAULT NULL,
  `d_cancel_reason` varchar(200) DEFAULT NULL,
  `d_passport_number` varchar(20) NOT NULL,
  PRIMARY KEY (`d_id`),
  KEY `fk_deals_users_idx` (`d_user_id`),
  KEY `fk_deals_cars_idx` (`d_car_id`),
  KEY `fk_deals_deal_states_idx` (`d_deal_state_id`),
  CONSTRAINT `fk_deals_cars` FOREIGN KEY (`d_car_id`) REFERENCES `cars` (`c_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_deals_deal_states` FOREIGN KEY (`d_deal_state_id`) REFERENCES `deal_states` (`ds_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_deals_users` FOREIGN KEY (`d_user_id`) REFERENCES `users` (`u_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deals`
--

LOCK TABLES `deals` WRITE;
/*!40000 ALTER TABLE `deals` DISABLE KEYS */;
INSERT INTO `deals` VALUES (57,17,86,3,36,'2017-11-03 18:00:00','2017-11-04 18:00:00','Автомобиль нужен для отдыха',NULL,'НВ 1234567'),(58,17,87,2,1632,'2017-11-05 18:00:00','2017-12-09 18:00:00','',NULL,'НВ 1896678'),(59,17,88,1,537.6,'2017-11-15 18:00:00','2017-12-13 18:00:00','',NULL,'НВ 189667'),(60,16,88,4,230,'2017-10-30 18:00:00','2017-11-11 18:00:00','Автомобиль для рабочей поездки','Автомобиль на ремонте','НВ 3232322'),(61,16,89,4,1466,'2017-10-30 18:00:00','2017-12-16 18:00:00','Будет использоваться для путешествия','Слишком большой срок аренды','НВ 1231231');
/*!40000 ALTER TABLE `deals` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-29 22:12:33
