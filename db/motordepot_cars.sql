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
-- Table structure for table `cars`
--

DROP TABLE IF EXISTS `cars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cars` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_model` varchar(70) NOT NULL,
  `c_volume` float NOT NULL,
  `c_power` int(11) NOT NULL,
  `c_year` int(11) NOT NULL,
  `c_prise` float NOT NULL,
  `c_description` text,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cars`
--

LOCK TABLES `cars` WRITE;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` VALUES (85,'Renault Logan',1.6,102,2016,1.3,'Renault Logan третьего поколения является одним из самых технически продвинутых и популярных автомобилей эконом класса. Этот городской седан отлично подойдет для решения повседневных задач быстро и с комфортом. Главными отличительными особенностями модели выступают повышенная надежность и безопасность в пути, что, безусловно, крайне важно. Обновленный дизайн кузова и салона станет приятным дополнением.\r\nСделав выбор в пользу Renault Logan, Вы получаете надежный и удобный транспорт для коротких поездок и длительных путешествий.\r\nЕго выбирает большинство потому, что:\r\n- Он имеет экономичный двигатель и надежную трансмиссию;\r\n- Комфортная работа подвески не утомит Вас в пути;\r\n- Предусмотрен большой просторный багажник, который пригодится для дальних путешествий и командировок;\r\n- Улучшенная эргономика и простое управление лучше всего подойдет малоопытным водителям;\r\n- Вы и Ваши спутники по достоинству оцените мягкие приятные сидения, не сковывающие при движении;\r\n- Наличие кондиционера создаст необходимый микроклимат в салоне;\r\nНе откажите себе в удовольствии и попробуйте новый комфортный автомобиль Renault Logan. Он Вас точно не подведет.'),(86,'Hyandai Solaris',1.6,123,2016,1.5,'Hyandai Solaris – один из самых востребованных автомобилей. Достоинства этой модели уже оценили миллионы покупателей по всему миру – если для вас главную роль играет качество транспортного средства, а также его безопасность и красота внешнего вида, то сложно выбрать что-то лучше, чем шикарное авто премиум-класса.\r\nСреди отличительных особенностей этой модели:\r\n- Прекрасная звукоизоляция – вы сможете в полной мере оценить отсутствие посторонних шумов, -\r\nпутешествуя с водителем и сосредоточившись на текущих делах или просто отдыхая\r\n- Универсальное решение – свидание, встреча с друзьями, деловые переговоры, поездки по городу. Куда бы вы ни отправились, будь то семейный выезд, либо важные переговоры, вы будете чувствовать себя, уверено и комфортно\r\n- Продуманная эргономика салона – широкие кожаные кресла, достаточное количество свободного пространства на задних сидениях\r\nПрекрасная акустическая система, отличная управляемость и комфортный микроклимат – насладившись поездкой за рулем Hyandai Solaris, вы не захотите расставаться с этой машиной.'),(87,'Kia Rio',1.6,123,2017,2,'Дизайн Киа Рио мало кого оставит равнодушным. Красивый автомобиль с качественными эксплуатационными характеристиками доставит удовольствие любителям быстрой езды.  Красивый коричневый цвет придется по душе любителям классического стиля.\r\nПросторный салон с хорошей системой кондиционирования воздуха сделает поездку комфортной.\r\nВыбрать Киа Рио стоит по ряду характеристик:\r\n- надежность в эксплуатации;\r\n- красивый дизайн;\r\n- хороший обогрев салона;\r\nАренда Киа Рио правильное решение для тех, кто любит быструю езду. Этот универсальный автомобиль идеально подходит для разных поездок. Он приходится по душе деловым мужчинам, романтичным женщинам. Прост в управлении. Хорошо подходит для поездок в условиях русской зимы, в межсезонье. Летом есть все условия для прохладной езды.\r\nСделав свой выбор на Киа Рио, вы поймете, что нашли свой автомобиль! Максимум удобств! Идеально подходит для деловых поездок, семейных путешествий, романтических круизов.\r\nАренда Киа Рио по выгодным ценам сэкономит бюджет. Чем больше количество дней проката – тем меньше стоимость поездки.\r\nЭтот уникальный по своим возможностям автомобиль сделает вашу поездку приятной и запоминающейся.'),(88,'VW Polo',1,75,2016,0.8,'Компактные седаны VW Polo никого не оставят равнодушным! Небольшой с виду автомобиль привлекает эргономичным вместительным салоном, маневренностью на дорогах и легкостью парковки даже в самых загруженных автомобильным трафиком местах. Впрочем, VW Polo ценят еще и за их экологичность и экономичность: потребляя всего 8 литров топлива на 100 км пробега VW Polo по праву считается примером топливной экономии в компакт-классе. Безопасность автомобиля обеспечивается обширным перечнем систем активного и пассивного сопровождения во время вождения: датчики парковки, система помощи на подъемах (HAC), управление курсовой устойчивостью (ESC) и многие другие.'),(89,'Toyota Corolla',1.4,97,2015,1.3,'Любой, кто  путешествовал в течение длительного периода времени, знает, что комфорт и эффективность использования топлива имеет важное значение. Toyota Corolla — это экономичный, доступный компактный седан, который отвечает потребностям аренды автомобиля. В нем много места, практических возможностей и достаточно энергии, чтобы путешествовать. Это идеальный вариант для тех, кто ищет лучшее. Можно обратиться в службу проката если хотите купить автомобиль, но сомневаетесь: за 2-3 езды дня точно разрешите любые сомнения по поводу выбора. Прокат  Toyota Corolla является доступным и надежным.');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;
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
