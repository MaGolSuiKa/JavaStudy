CREATE DATABASE  IF NOT EXISTS `stu_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `stu_db`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: stu_db
-- ------------------------------------------------------
-- Server version	5.7.42-log

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
-- Table structure for table `tb_class`
--

DROP TABLE IF EXISTS `tb_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_class` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(10) NOT NULL,
  `class_address` varchar(30) NOT NULL,
  `class_members` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_class`
--

LOCK TABLES `tb_class` WRITE;
/*!40000 ALTER TABLE `tb_class` DISABLE KEYS */;
INSERT INTO `tb_class` VALUES (1,'01班','A处',NULL),(2,'02班','B处',NULL),(3,'03班','C处',NULL);
/*!40000 ALTER TABLE `tb_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_stu`
--

DROP TABLE IF EXISTS `tb_stu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_stu` (
  `stu_id` int(11) NOT NULL,
  `stu_name` varchar(45) NOT NULL,
  `stu_joindate` date DEFAULT NULL,
  `stu_gender` int(11) NOT NULL,
  `stu_no` varchar(10) NOT NULL,
  `class_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_stu`
--

LOCK TABLES `tb_stu` WRITE;
/*!40000 ALTER TABLE `tb_stu` DISABLE KEYS */;
INSERT INTO `tb_stu` VALUES (1,'赵','2000-08-31',1,'2000102',1),(2,'钱','2000-08-30',1,'2000101',1),(3,'孙','2000-09-01',1,'2000103',1),(4,'李','2000-09-01',0,'2000104',2),(5,'周','2001-08-31',1,'2001103',2),(6,'吴','2001-08-30',1,'2001102',2),(7,'郑','2001-07-19',0,'2001101',3),(8,'王','2002-08-08',0,'2002101',3);
/*!40000 ALTER TABLE `tb_stu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_subjects`
--

DROP TABLE IF EXISTS `tb_subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_subjects` (
  `sub_id` int(11) NOT NULL AUTO_INCREMENT,
  `sub_name` varchar(45) NOT NULL,
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='科目';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_subjects`
--

LOCK TABLES `tb_subjects` WRITE;
/*!40000 ALTER TABLE `tb_subjects` DISABLE KEYS */;
INSERT INTO `tb_subjects` VALUES (1,'语文'),(2,'数学'),(3,'外语');
/*!40000 ALTER TABLE `tb_subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_test`
--

DROP TABLE IF EXISTS `tb_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_test` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_no` varchar(45) NOT NULL,
  `test_subject` int(11) NOT NULL,
  `test_scores` float NOT NULL,
  `test_date` date DEFAULT NULL,
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='成绩表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_test`
--

LOCK TABLES `tb_test` WRITE;
/*!40000 ALTER TABLE `tb_test` DISABLE KEYS */;
INSERT INTO `tb_test` VALUES (1,'2000101',1,80,'2003-06-06'),(2,'2000101',2,60.5,'2003-06-06'),(3,'2000101',3,89,'2003-06-06'),(4,'2000102',1,90,'2003-06-06'),(5,'2000102',2,75.5,'2003-06-06'),(6,'2000102',3,67,'2003-06-06'),(7,'2000103',1,46,'2003-06-06'),(8,'2000103',2,99,'2003-06-06'),(9,'2000103',3,97,'2003-06-06'),(10,'2000104',1,55,'2003-06-06'),(11,'2000104',2,66,'2003-06-06'),(12,'2000104',3,88,'2003-06-06');
/*!40000 ALTER TABLE `tb_test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-25 10:05:19
