-- MySQL dump 10.13  Distrib 5.7.42, for Win64 (x86_64)
--
-- Host: localhost    Database: hotelplannersystem
-- ------------------------------------------------------
-- Server version	5.7.42-log


--
-- Table structure for table `calls`
--

DROP TABLE IF EXISTS `calls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calls` (
  `call_id` varchar(500) DEFAULT NULL,
  `call_status` varchar(50) DEFAULT NULL,
  `is_prepaid` tinyint(1) DEFAULT NULL,
  `linked_sale_id` varchar(500) DEFAULT NULL,
  `call_date_start` datetime DEFAULT NULL,
  `call_date_end` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calls`
--


--
-- Table structure for table `monthly_reports`
--

DROP TABLE IF EXISTS `monthly_reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `monthly_reports` (
  `report_id` varchar(500) DEFAULT NULL,
  `report_month` int(11) DEFAULT NULL,
  `report_year` int(11) DEFAULT NULL,
  `report_file_path` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `monthly_reports`
--


--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `sale_id` varchar(500) DEFAULT NULL,
  `call_id` varchar(500) DEFAULT NULL,
  `call_status` varchar(50) DEFAULT NULL,
  `call_date` date DEFAULT NULL,
  `is_prepaid` tinyint(1) DEFAULT NULL,
  `check_in_date` date DEFAULT NULL,
  `check_out_date` date DEFAULT NULL,
  `is_paid_out` tinyint(1) DEFAULT NULL,
  `paid_out_date` date DEFAULT NULL,
  `hotel_name` varchar(500) DEFAULT NULL,
  `total_bill` int(11) DEFAULT NULL,
  `commission_percentage` int(11) DEFAULT NULL,
  `total_commission` int(11) DEFAULT NULL,
  `is_canceled_booking` tinyint(1) DEFAULT NULL,
  `canceled_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

-- Table structure for table `time_punches`
--

DROP TABLE IF EXISTS `time_punches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time_punches` (
  `punch_id` varchar(500) DEFAULT NULL,
  `user_id` varchar(500) DEFAULT NULL,
  `clock_in_time` varchar(500) DEFAULT NULL,
  `clock_out_time` varchar(500) DEFAULT NULL,
  `is_recovered` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_punches`
--


--
-- Table structure for table `timesheets`
--

DROP TABLE IF EXISTS `timesheets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timesheets` (
  `timesheet_id` varchar(500) DEFAULT NULL,
  `user_id` varchar(500) DEFAULT NULL,
  `clock_in_time` varchar(500) DEFAULT NULL,
  `clock_out_time` varchar(500) DEFAULT NULL,
  `hours_worked` int(11) DEFAULT NULL,
  `sales_made` int(11) DEFAULT NULL,
  `calls_received` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timesheets`
--


--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` varchar(500) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--



--
-- Table structure for table `vars`
--

DROP TABLE IF EXISTS `vars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vars` (
  `current_timesheet_id` varchar(50) DEFAULT NULL,
  `is_clocked_in` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vars`
--

LOCK TABLES `vars` WRITE;
/*!40000 ALTER TABLE `vars` DISABLE KEYS */;
INSERT INTO `vars` VALUES ('NA',0);
/*!40000 ALTER TABLE `vars` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-30 12:00:00
