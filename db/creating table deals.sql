DELETE FROM deals;

LOCK TABLES `deals` WRITE;

INSERT INTO `deals` 
VALUES (1,3,4,1,19.2,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Comment',NULL,'HB 1234567'),
	   (2,3,5,1,31.2,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Комментарий',NULL,'HB 1234567'),
       (3,3,1,1,31.2,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Комментарий',NULL,'HB 1234567'),
       (4,3,2,1,36,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Комментарий',NULL,'HB 1234567'),
       (5,3,3,2,96,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Comment',NULL,'HB 1234567'),
       (6,3,1,2,31,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Комментарий',NULL,'HB 1234567'),
       (7,3,3,3,96,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Comment',NULL,'HB 1234567'),
       (8,3,3,3,96,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Comment',NULL,'HB 1234567'),
       (9,3,4,3,19,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Comment',NULL,'HB 1234567'),
       (10,3,4,3,38,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Comment',NULL,'HB 1234567'),
       (11,3,4,3,19,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Comment',NULL,'HB 1234567'),
       (12,3,5,3,31,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Комментарий',NULL,'HB 1234567'),
       (13,3,5,3,31,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Комментарий',NULL,'HB 1234567'),
       (14,3,1,3,31,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Комментарий',NULL,'HB 1234567'),
       (15,3,1,3,31,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Комментарий',NULL,'HB 1234567'),
       (16,3,2,4,72,date_add(now(), interval 1 day),date_add(now(), interval 1 day),'Comment','Автомобиль находится в ремонте','HB 1234567');
       
UNLOCK TABLES;