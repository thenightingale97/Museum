-- MySQL dump 10.13  Distrib 5.7.21, for Win64 (x86_64)
--
-- Host: localhost    Database: museum
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES (1,'Мікеланджело','Буонарроті'),(2,'Каземир','Малевич'),(3,'Сальвадор','Далі'),(4,'Тарас','Шевченко'),(5,'Леонардо','да Винчи'),(6,'Джотто','ди Бондоне'),(7,'Амброджо','Лоренцетти');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` int(11) NOT NULL,
  `finishTime` datetime DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `excursion_id` int(11) DEFAULT NULL,
  `guide_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKefyni6vfmajhoc7my7n0fr88i` (`excursion_id`),
  KEY `FKl53ihd22l5qy5qf694rxf8o5n` (`guide_id`),
  CONSTRAINT `FKefyni6vfmajhoc7my7n0fr88i` FOREIGN KEY (`excursion_id`) REFERENCES `excursion` (`id`),
  CONSTRAINT `FKl53ihd22l5qy5qf694rxf8o5n` FOREIGN KEY (`guide_id`) REFERENCES `guide` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'2018-02-19 12:00:00','2018-02-19 10:00:00',1,3),(2,'2018-02-20 15:00:00','2018-02-20 12:00:00',3,4),(3,'2018-02-20 18:00:00','2018-02-20 11:00:00',2,1),(4,'2018-02-22 01:00:00','2018-02-21 22:00:00',1,2),(5,'2018-02-20 19:00:00','2018-02-20 17:00:00',3,4);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `excursion`
--

DROP TABLE IF EXISTS `excursion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `excursion` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursion`
--

LOCK TABLES `excursion` WRITE;
/*!40000 ALTER TABLE `excursion` DISABLE KEYS */;
INSERT INTO `excursion` VALUES (1,'Путівка в античність'),(2,'Тарас Шевченко та його значення в українському мистецтві'),(3,'Новий та новітній час'),(4,'Назад у Середні віки');
/*!40000 ALTER TABLE `excursion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `excursion_showpiece`
--

DROP TABLE IF EXISTS `excursion_showpiece`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `excursion_showpiece` (
  `excursions_id` int(11) NOT NULL,
  `showpieces_id` int(11) NOT NULL,
  KEY `FKlxa3nmmrr19wo0cya7cy9jvdd` (`showpieces_id`),
  KEY `FKib1aisrlp5mwj29xdcmlp8hqp` (`excursions_id`),
  CONSTRAINT `FKib1aisrlp5mwj29xdcmlp8hqp` FOREIGN KEY (`excursions_id`) REFERENCES `excursion` (`id`),
  CONSTRAINT `FKlxa3nmmrr19wo0cya7cy9jvdd` FOREIGN KEY (`showpieces_id`) REFERENCES `showpiece` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursion_showpiece`
--

LOCK TABLES `excursion_showpiece` WRITE;
/*!40000 ALTER TABLE `excursion_showpiece` DISABLE KEYS */;
INSERT INTO `excursion_showpiece` VALUES (3,1),(3,4),(3,5),(1,8),(2,4),(4,6),(4,7),(3,2),(3,3);
/*!40000 ALTER TABLE `excursion_showpiece` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guardian`
--

DROP TABLE IF EXISTS `guardian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guardian` (
  `id` int(11) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guardian`
--

LOCK TABLES `guardian` WRITE;
/*!40000 ALTER TABLE `guardian` DISABLE KEYS */;
INSERT INTO `guardian` VALUES (1,'Назарій','Дем\'яновський'),(2,'Юрій','Катола'),(3,'Олексій','Стародуб'),(4,'Ксеній','Мех');
/*!40000 ALTER TABLE `guardian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guide`
--

DROP TABLE IF EXISTS `guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guide` (
  `id` int(11) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `position` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guide`
--

LOCK TABLES `guide` WRITE;
/*!40000 ALTER TABLE `guide` DISABLE KEYS */;
INSERT INTO `guide` VALUES (1,'Оксана','Мех','+380991094165',0),(2,'Тарас','Козловський','+380936963456',4),(3,'Гаврило','Амбаловський','+380680699278',2),(4,'Іван','Енкор','+380502849234',3),(5,'Наталія','Павловська','+380672283921',1);
/*!40000 ALTER TABLE `guide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hall`
--

DROP TABLE IF EXISTS `hall`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hall` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `guardian_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKig6x6na3jlmnj69iifdqgst24` (`guardian_id`),
  CONSTRAINT `FKig6x6na3jlmnj69iifdqgst24` FOREIGN KEY (`guardian_id`) REFERENCES `guardian` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hall`
--

LOCK TABLES `hall` WRITE;
/*!40000 ALTER TABLE `hall` DISABLE KEYS */;
INSERT INTO `hall` VALUES (1,'Античність',3),(2,'Середньовіччя',2),(3,'Новий час',4),(4,'Новітній час',1);
/*!40000 ALTER TABLE `hall` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1),(1),(1),(1),(1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `showpiece`
--

DROP TABLE IF EXISTS `showpiece`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `showpiece` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `hall_id` int(11) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  `material` int(11) DEFAULT NULL,
  `technique` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt9p3mjcf0ty1u1qt6lxx9uble` (`author_id`),
  KEY `FKgxg7837q0xwbuy751gjjjnmje` (`hall_id`),
  CONSTRAINT `FKgxg7837q0xwbuy751gjjjnmje` FOREIGN KEY (`hall_id`) REFERENCES `hall` (`id`),
  CONSTRAINT `FKt9p3mjcf0ty1u1qt6lxx9uble` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `showpiece`
--

LOCK TABLES `showpiece` WRITE;
/*!40000 ALTER TABLE `showpiece` DISABLE KEYS */;
INSERT INTO `showpiece` VALUES (1,'Мона Ліза',1,5,3,'mona_lisa.jpg',1,1),(2,'Чорний Квадрат',1,2,4,'black_square.jpg',3,1),(3,'Жираф у полум\'ї',1,3,4,'giraffe_on_fire.jpg',2,2),(4,'Циганка-ворожка',1,4,3,'gypsy-fortuneteller.jpg',1,2),(5,'Тайна вечеря',1,5,3,'secret_dinner.jpg',1,1),(6,'Cвято чоток',1,6,2,'holiday_of_the_beads.jpg',4,2),(7,'Алегорія доброго правління',1,7,2,'allegory_of_good_governance.jpg',5,3),(8,'Давид',0,1,1,'david.jpg',3,0);
/*!40000 ALTER TABLE `showpiece` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-21 21:16:20
