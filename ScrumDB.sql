-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: mumscrum
-- ------------------------------------------------------
-- Server version	5.6.22

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
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(25) DEFAULT NULL,
  `username` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `roleId` int(15) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqhim71uj0gsscmh2giuoebcdh` (`roleId`),
  CONSTRAINT `FKqhim71uj0gsscmh2giuoebcdh` FOREIGN KEY (`roleId`) REFERENCES `Role` (`id`),
  CONSTRAINT `ROLE_EMP` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,'sophanna','pel','a','a',1,'active'),(2,'kuroun','seung','b','a',3,'active'),(3,'Shruthi','surendran','c','a',4,'active'),(4,'MonyDara','Nget','d','a',3,'active'),(5,'Thon','Connor','e','a',4,'active'),(6,'Sovongsa','Ly','f','a',2,'active'),(7,'Vortana','Say','g','a',2,'active');
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `dueDate` timestamp NULL DEFAULT NULL,
  `description` text,
  `statusId` int(15) DEFAULT NULL,
  `employeeId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7gogi6a2q2u2fxpa1g8w865bq` (`employeeId`),
  KEY `FK72y9lcb6vsr8omrvugepfogbv` (`statusId`),
  CONSTRAINT `FK72y9lcb6vsr8omrvugepfogbv` FOREIGN KEY (`statusId`) REFERENCES `Status` (`id`),
  CONSTRAINT `FK7gogi6a2q2u2fxpa1g8w865bq` FOREIGN KEY (`employeeId`) REFERENCES `Employee` (`id`),
  CONSTRAINT `PRODUCT_EMP` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`id`),
  CONSTRAINT `STATUS_EMP` FOREIGN KEY (`statusId`) REFERENCES `status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2372 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (2369,'Scrum','2015-09-13 05:00:00','2015-09-15 05:00:00','',1,2),(2370,'Agile','2015-09-15 05:00:00','2015-09-18 05:00:00','',1,2),(2371,'Waterfall','2015-09-09 05:00:00','2015-09-18 05:00:00','',1,1);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ReleaseBacklog`
--

DROP TABLE IF EXISTS `ReleaseBacklog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ReleaseBacklog` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `dueDate` timestamp NULL DEFAULT NULL,
  `descriptioon` text,
  `productId` int(15) NOT NULL,
  `scrumMasterId` int(15) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `scrumMasterId` (`scrumMasterId`),
  KEY `FKkpsbbyhx9i3vg5e7kdyghwxpl` (`productId`),
  CONSTRAINT `FKkpsbbyhx9i3vg5e7kdyghwxpl` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`),
  CONSTRAINT `FKqmg7h1ccxcuukldlbdegjy8s5` FOREIGN KEY (`scrumMasterId`) REFERENCES `Employee` (`id`),
  CONSTRAINT `PRODUCT_RELEASE` FOREIGN KEY (`productId`) REFERENCES `product` (`id`),
  CONSTRAINT `RELEASE_EMPLOYEE` FOREIGN KEY (`scrumMasterId`) REFERENCES `Employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ReleaseBacklog`
--

LOCK TABLES `ReleaseBacklog` WRITE;
/*!40000 ALTER TABLE `ReleaseBacklog` DISABLE KEYS */;
INSERT INTO `ReleaseBacklog` VALUES (37,'test ','Beta','2015-09-14 05:00:00','2015-09-30 05:00:00','',2369,6);
/*!40000 ALTER TABLE `ReleaseBacklog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Sprint`
--

DROP TABLE IF EXISTS `Sprint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sprint` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `dueDate` timestamp NULL DEFAULT NULL,
  `releaseId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnd1p4dg1x0q94fnr1apjrdsd4` (`releaseId`),
  CONSTRAINT `FKnd1p4dg1x0q94fnr1apjrdsd4` FOREIGN KEY (`releaseId`) REFERENCES `ReleaseBacklog` (`id`),
  CONSTRAINT `RELEASE_SPRINT` FOREIGN KEY (`releaseId`) REFERENCES `releaseBacklog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Sprint`
--

LOCK TABLES `Sprint` WRITE;
/*!40000 ALTER TABLE `Sprint` DISABLE KEYS */;
INSERT INTO `Sprint` VALUES (5,'tset','2015-09-08 05:00:00','2015-09-08 05:00:00',37);
/*!40000 ALTER TABLE `Sprint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserStory`
--

DROP TABLE IF EXISTS `UserStory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserStory` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `priority` varchar(25) DEFAULT NULL,
  `startDate` timestamp NULL DEFAULT NULL,
  `dueDate` timestamp NULL DEFAULT NULL,
  `estimateDevEffort` int(15) DEFAULT NULL,
  `estimateTestEffort` int(15) DEFAULT NULL,
  `description` text,
  `productId` int(15) NOT NULL,
  `releaseId` int(15) DEFAULT NULL,
  `sprintId` int(15) DEFAULT NULL,
  `developerId` int(15) DEFAULT NULL,
  `testId` int(15) DEFAULT NULL,
  `ownerId` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdb9geri8jpt5ct0ht1uv376n5` (`developerId`),
  KEY `FKnfstgkmnvy19vw2iamoj6bd9g` (`ownerId`),
  KEY `FKspegtft55b4ief630i3y43g32` (`productId`),
  KEY `FKt1jyhvaql9pjkdsl982xvgqha` (`releaseId`),
  KEY `FK9jv3uoa7rm7frfn3gpxuej7qv` (`sprintId`),
  KEY `FKhpo2m12su95rh4xf553gvkdxs` (`testId`),
  CONSTRAINT `FK9jv3uoa7rm7frfn3gpxuej7qv` FOREIGN KEY (`sprintId`) REFERENCES `Sprint` (`id`),
  CONSTRAINT `FKdb9geri8jpt5ct0ht1uv376n5` FOREIGN KEY (`developerId`) REFERENCES `Employee` (`id`),
  CONSTRAINT `FKhpo2m12su95rh4xf553gvkdxs` FOREIGN KEY (`testId`) REFERENCES `Employee` (`id`),
  CONSTRAINT `FKnfstgkmnvy19vw2iamoj6bd9g` FOREIGN KEY (`ownerId`) REFERENCES `Employee` (`id`),
  CONSTRAINT `FKspegtft55b4ief630i3y43g32` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`),
  CONSTRAINT `FKt1jyhvaql9pjkdsl982xvgqha` FOREIGN KEY (`releaseId`) REFERENCES `ReleaseBacklog` (`id`),
  CONSTRAINT `SPRINT_USERSTORY` FOREIGN KEY (`sprintId`) REFERENCES `sprint` (`id`),
  CONSTRAINT `USERSTORY_EMP` FOREIGN KEY (`developerId`) REFERENCES `employee` (`id`),
  CONSTRAINT `USERSTORY_OWNER` FOREIGN KEY (`ownerId`) REFERENCES `employee` (`id`),
  CONSTRAINT `USERSTORY_PRODUCT` FOREIGN KEY (`productId`) REFERENCES `product` (`id`),
  CONSTRAINT `USERSTORY_TESTER` FOREIGN KEY (`testId`) REFERENCES `employee` (`id`),
  CONSTRAINT `userstory_ibfk_1` FOREIGN KEY (`releaseId`) REFERENCES `releaseBacklog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserStory`
--

LOCK TABLES `UserStory` WRITE;
/*!40000 ALTER TABLE `UserStory` DISABLE KEYS */;
INSERT INTO `UserStory` VALUES (50,'Sprint US 1','Low','2015-09-14 05:00:00','2015-09-15 05:00:00',12,10,'',2369,NULL,NULL,4,5,2);
/*!40000 ALTER TABLE `UserStory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserStory_Worklog`
--

DROP TABLE IF EXISTS `UserStory_Worklog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserStory_Worklog` (
  `UserStory_id` int(11) NOT NULL,
  `worklogs_id` int(11) NOT NULL,
  PRIMARY KEY (`UserStory_id`,`worklogs_id`),
  UNIQUE KEY `UK_2kmcfm93q1y066w3nano7je7g` (`worklogs_id`),
  CONSTRAINT `FK_2kmcfm93q1y066w3nano7je7g` FOREIGN KEY (`worklogs_id`) REFERENCES `Worklog` (`id`),
  CONSTRAINT `FK_tn8ljhlw62eqfrow9h3f0g1sb` FOREIGN KEY (`UserStory_id`) REFERENCES `UserStory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserStory_Worklog`
--

LOCK TABLES `UserStory_Worklog` WRITE;
/*!40000 ALTER TABLE `UserStory_Worklog` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserStory_Worklog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Worklog`
--

DROP TABLE IF EXISTS `Worklog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Worklog` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `actualEffort` int(15) DEFAULT NULL,
  `modifiedDate` timestamp NULL DEFAULT NULL,
  `userStoryId` int(15) NOT NULL,
  `effortType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKob8dh79eje5ahxlp8m5xh4k81` (`userStoryId`),
  CONSTRAINT `FKob8dh79eje5ahxlp8m5xh4k81` FOREIGN KEY (`userStoryId`) REFERENCES `UserStory` (`id`),
  CONSTRAINT `USERSTORY_WORKLOG` FOREIGN KEY (`userStoryId`) REFERENCES `userstory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Worklog`
--

LOCK TABLES `Worklog` WRITE;
/*!40000 ALTER TABLE `Worklog` DISABLE KEYS */;
/*!40000 ALTER TABLE `Worklog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Product owner'),(2,'Scrum master'),(3,'Developer'),(4,'Tester'),(5,'HR Admin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'To Do','Initialial product status'),(2,'In Progress','Work in progress'),(3,'Closed','Work completed');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-12 15:24:27
