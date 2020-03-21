INSERT INTO `db_camunda`.`scientific_field` (`id`, `name`, `number`) VALUES ('1', 'prirodne nauke', '1.');
INSERT INTO `db_camunda`.`scientific_field` (`id`, `name`, `number`) VALUES ('2', 'biologija', '1.01.');
INSERT INTO `db_camunda`.`scientific_field` (`id`, `name`, `number`) VALUES ('3', 'opšta biologija', '1.01.01.');

--nacini placanja
INSERT INTO `db_camunda`.`membership_fees` (`id`, `name`) VALUES ('1', 'bitcoin');
INSERT INTO `db_camunda`.`membership_fees` (`id`, `name`) VALUES ('2', 'paypal');
INSERT INTO `db_camunda`.`membership_fees` (`id`, `name`) VALUES ('3', 'bank');

INSERT INTO `db_camunda`.`magazine` (`id`, `is_active`,`issn`, `name`, `open_access`) VALUES ('1',true,'1111-1111','Časopis',true);
INSERT INTO `db_camunda`.`magazine` (`id`, `is_active`,`issn`, `name`, `open_access`) VALUES ('2',true,'2222-2222','ABC',true);
INSERT INTO `db_camunda`.`magazine` (`id`, `is_active`,`issn`, `name`, `open_access`) VALUES ('3',true,'3333-3333','Nacionalna geografija',true);

insert into db_camunda.user_role(name) values('ADMIN');
insert into db_camunda.user_role(name) values('EDITOR');
insert into db_camunda.user_role(name) values('REVIEWER');
insert into db_camunda.user_role(name) values('AUTHOR');
insert into db_camunda.user_role(name) values('NORMAL');

insert into db_camunda.user_roles(user_id, user_role_id) values('1','1');
insert into db_camunda.user_roles(user_id, user_role_id) values('2','3');
insert into db_camunda.user_roles(user_id, user_role_id) values('3','2');
insert into db_camunda.user_roles(user_id, user_role_id) values('4','4');
insert into db_camunda.user_roles(user_id, user_role_id) values('5','3');
insert into db_camunda.user_roles(user_id, user_role_id) values('6','3');

insert into db_camunda.user_roles(user_id, user_role_id) values('7','3');
insert into db_camunda.user_roles(user_id, user_role_id) values('8','3');
insert into db_camunda.user_roles(user_id, user_role_id) values('9','3');

INSERT INTO `db_camunda`.`user_model` (`discriminator`, `id`, `city`, `email`, `is_active`, `is_author`, `is_reviewer`, `name`, `password`, `state`, `surname`, `title`, `uniqueid`, `username`, `is_confirmed_reviewer`, `chief_in_magazine_id`, `editorscin_magazine_id`,`latitude`,`longitude`) VALUES ('U', '1', 'Novi Sad', 'demo@gmail.com',true,false,false,'demo','$2a$10$ORTUAPkjvJdVtWRJnnpxp.UhOGMhLK2lxdhj2r4FGqrzt6YELJtDW','Srbija','demo', 'nema', 'b71046b6-b331-46a1-89a3-b9a1b1971f83', 'demo', false, null, null, 45.267136, 19.833549);
INSERT INTO `db_camunda`.`user_model` (`discriminator`, `id`, `city`, `email`, `is_active`, `is_author`, `is_reviewer`, `name`, `password`, `state`, `surname`, `title`, `uniqueid`, `username`, `is_confirmed_reviewer`, `chief_in_magazine_id`, `editorscin_magazine_id`,`latitude`,`longitude`) VALUES ('R', '2', 'Sarajevo', 'bogdan@gmail.com',true,false,true,'Bogdan','$2a$10$STz4z5Ir9z4Y.xWtAgTMJOWfEYboeh0jv.O8BT9g/ah8OGOEKrXT2','Bosna i Hercegovina','Blagojevic', 'nema', '4b2bd4cd-5a30-4abb-a6a4-c2086b5c0f5f', 'boki', false, null, null, 43.856430, 18.413029);
INSERT INTO `db_camunda`.`user_model` (`discriminator`, `id`, `city`, `email`, `is_active`, `is_author`, `is_reviewer`, `name`, `password`, `state`, `surname`, `title`, `uniqueid`, `username`, `is_confirmed_reviewer`, `chief_in_magazine_id`, `editorscin_magazine_id`,`latitude`,`longitude`) VALUES ('E', '3', 'Zagreb', 'ivana96b@gmail.com',true,false,false,'Ivana','$2a$10$8vwJkZSZNHzcg9Emj69IFesCBgpuY1R6zBWbWT/KBddzoolFi.Jm2','Hrvatska','Blagojevic', 'dipl inz', '7dd52d17-6482-4433-ba88-0a39b7aa7f20', 'ivana', false, 1, null, 45.815399, 15.966568);
INSERT INTO `db_camunda`.`user_model` (`discriminator`, `id`, `city`, `email`, `is_active`, `is_author`, `is_reviewer`, `name`, `password`, `state`, `surname`, `title`, `uniqueid`, `username`, `is_confirmed_reviewer`, `chief_in_magazine_id`, `editorscin_magazine_id`,`latitude`,`longitude`) VALUES ('U', '4', 'Novi Sad', 'katicmilan7@gmail.com',true,false,true,'Milan','$2a$10$301PljgpGqlwyi5dNTwqXu8VTh4.0.iNL569kBhxmmqH2xfGfI3ha','Srbija','Katic', 'dipl inz', '0c069ebd-3384-4203-b15d-2c2a9af2a78f', 'milanKatic', false, null, null, 45.267136, 19.833549);
INSERT INTO `db_camunda`.`user_model` (`discriminator`, `id`, `city`, `email`, `is_active`, `is_author`, `is_reviewer`, `name`, `password`, `state`, `surname`, `title`, `uniqueid`, `username`, `is_confirmed_reviewer`, `chief_in_magazine_id`, `editorscin_magazine_id`,`latitude`,`longitude`) VALUES ('R', '5', 'Sarajevo', 'zoran@gmail.com',true,false,true,'Zoran','$2a$10$ltHOcQ42QfWlp3JCILZe9OkLHdWi1F8l5E7T0BlUVtQt3IPyp5HX.','Bosna i Hercegovina','Blagojevic', 'dipl inz', '0c725837-c3b1-4cc9-8eb6-0e8ed852789e', 'zoranzoran', false, null, null, 43.856430, 18.413029);
INSERT INTO `db_camunda`.`user_model` (`discriminator`, `id`, `city`, `email`, `is_active`, `is_author`, `is_reviewer`, `name`, `password`, `state`, `surname`, `title`, `uniqueid`, `username`, `is_confirmed_reviewer`, `chief_in_magazine_id`, `editorscin_magazine_id`,`latitude`,`longitude`) VALUES ('R', '6', 'Zagreb', 'novi@gmail.com',true,false,true,'Velinka','$2a$10$ltHOcQ42QfWlp3JCILZe9OkLHdWi1F8l5E7T0BlUVtQt3IPyp5HX.','Hrvatska','Blagojevic', 'dipl inz', '0c825837-c3b1-4cc9-8eb6-0e8ed852789e', 'zoranzoran', false, null, null, 45.815399, 15.966568);

INSERT INTO `db_camunda`.`user_model` (`discriminator`, `id`, `city`, `email`, `is_active`, `is_author`, `is_reviewer`, `name`, `password`, `state`, `surname`, `title`, `uniqueid`, `username`, `is_confirmed_reviewer`, `chief_in_magazine_id`, `editorscin_magazine_id`,`latitude`,`longitude`) VALUES ('R', '7', 'Novi Sad', 'sara@gmail.com',true,false,true,'Sara','$2a$10$ltHOcQ42QfWlp3JCILZe9OkLHdWi1F8l5E7T0BlUVtQt3IPyp5HX.','Srbija','Zoric', 'dipl inz', '0c725837-c3b1-4cc9-8eb6-0e8ed852789e', 'sarasara', false, null, null, 45.267136, 19.833549);
INSERT INTO `db_camunda`.`user_model` (`discriminator`, `id`, `city`, `email`, `is_active`, `is_author`, `is_reviewer`, `name`, `password`, `state`, `surname`, `title`, `uniqueid`, `username`, `is_confirmed_reviewer`, `chief_in_magazine_id`, `editorscin_magazine_id`,`latitude`,`longitude`) VALUES ('R', '8', 'Zagreb', 'milica@gmail.com',true,false,true,'Milica','$2a$10$ltHOcQ42QfWlp3JCILZe9OkLHdWi1F8l5E7T0BlUVtQt3IPyp5HX.','Hrvatska','Vorkapic', 'dipl inz', '0c825837-c3b1-4cc9-8eb6-0e8ed852789e', 'milicamilica', false, null, null, 45.815399, 15.966568);
INSERT INTO `db_camunda`.`user_model` (`discriminator`, `id`, `city`, `email`, `is_active`, `is_author`, `is_reviewer`, `name`, `password`, `state`, `surname`, `title`, `uniqueid`, `username`, `is_confirmed_reviewer`, `chief_in_magazine_id`, `editorscin_magazine_id`,`latitude`,`longitude`) VALUES ('R', '9', 'Zrenjanin', 'isidora@gmail.com',true,false,true,'Isidora','$2a$10$ltHOcQ42QfWlp3JCILZe9OkLHdWi1F8l5E7T0BlUVtQt3IPyp5HX.','Srbija','Radulovic', 'dipl inz', '0c825837-c3b1-4cc9-8eb6-0e8ed852789e', 'isidoraisidora', false, null, null, 45.38361,20.38194);



INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('1', '2');
INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('2', '2');

INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('1', '3');
INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('2', '5');
INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('2', '6');


INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('2', '7');
INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('3', '7');
INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('1', '8');
INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('3', '8');
INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('3', '9');

--INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('2', '4');
--INSERT INTO `db_camunda`.`user_fields` (`scientific_field_id`, `user_id`) VALUES ('3', '4');

INSERT INTO `db_camunda`.`magazine_reviewers` (`magazine_id`, `user_id`) VALUES ('1', '2');
INSERT INTO `db_camunda`.`magazine_reviewers` (`magazine_id`, `user_id`) VALUES ('1', '5');
INSERT INTO `db_camunda`.`magazine_reviewers` (`magazine_id`, `user_id`) VALUES ('1', '6');

INSERT INTO `db_camunda`.`magazine_reviewers` (`magazine_id`, `user_id`) VALUES ('2', '7');
INSERT INTO `db_camunda`.`magazine_reviewers` (`magazine_id`, `user_id`) VALUES ('2', '8');
INSERT INTO `db_camunda`.`magazine_reviewers` (`magazine_id`, `user_id`) VALUES ('3', '9');


INSERT INTO `db_camunda`.`subscription_model` (`id`, `magazine_id`, `till_date`) VALUES ('1', '1', '2020-12-17');

--INSERT INTO `db_camunda`.`user_model_sub_magazines` (`user_model_id`, `sub_magazines_id`) VALUES ('4', '1');
INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (1,'epidemija', true, 'korona virus','virus zaraza kina', 4, 1, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\korona virus.pdf');
INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (2,'ekologija', true, 'plastične kese', 'životna sredina deponije okeani', 4, 1, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\plastične kese.pdf');
INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (3,'nauka', true, 'naučnotehnološki park', 'prosveta it ftn', 4, 1, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\naučnotehnološki park.pdf');


INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (4,'zavisnost', true, 'Deca zavisna od video igara','kompjuteri bolesti zavisnosti', 4, 2, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\Deca zavisna od video igara.pdf');
INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (5,'nauka', true, 'Fizika', 'sila prirodna nauka', 4, 2, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\Fizika.pdf');
INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (6,'zdravlje', true, 'Iznenadni srčani zastoj', 'zdravlje srce arterije', 4, 2, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\Iznenadni srčani zastoj.pdf');


INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (7,'priroda', true, 'Nacionalni parkovi Srbije','priroda zaštićena područja', 4, 3, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\Nacionalni parkovi Srbije.pdf');
INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (8,'deca', true, 'Tijanin zakon', 'doživotna kazna zakon deca', 4, 3, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\Tijanin zakon.pdf');
INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (9,'potrošači', true, 'Za potrošače', 'zaštita potrošača prava', 4, 3, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\Za potrošače.pdf');
INSERT INTO `db_camunda`.`article` (`id`, `abs`, `approved`,`heading`,`key_terms`, `author_id`, `magazine_id`, `main_id`, `url`) VALUES (10,'vazduh', true, 'Zagađenje vazduha', 'PEM čestice automobili saobraćaj fabrike', 4, 3, 1,'D:\\MASTER\\UDD\\PROJEKATscientificCentralService\\files\\Zagađenje vazduha.pdf');

INSERT INTO `db_camunda`.`review` (`id`, `reviewer_id`, `article_id`) VALUES (1,2,1);
INSERT INTO `db_camunda`.`review` (`id`, `reviewer_id`, `article_id`) VALUES (2,5,2);

INSERT INTO `db_camunda`.`review` (`id`, `reviewer_id`, `article_id`) VALUES (3,7,4);
INSERT INTO `db_camunda`.`review` (`id`, `reviewer_id`, `article_id`) VALUES (4,8,4);
INSERT INTO `db_camunda`.`review` (`id`, `reviewer_id`, `article_id`) VALUES (5,7,5);
INSERT INTO `db_camunda`.`review` (`id`, `reviewer_id`, `article_id`) VALUES (6,8,6);


INSERT INTO `db_camunda`.`coauthor` (`id`, `name`, `surname`, `city`, `state`, `email`, `id_author`, `latitude`, `longitude`) VALUES (1,"Nikola","Grujčić", "Boka", "Srbija", "nikolagrujcic@gmail.com",4,45.38361,20.38194);
INSERT INTO `db_camunda`.`coauthor` (`id`, `name`, `surname`, `city`, `state`, `email`, `id_author`, `latitude`, `longitude`) VALUES (2,"Danica","Marković", "Sremska Kamenica", "Srbija", "danicamarkovic@gmail.com",4,45.205622, 19.838617);

INSERT INTO `db_camunda`.`coauthor_article` (`coauthor_id`, `article_id`) VALUES (1,1);
INSERT INTO `db_camunda`.`coauthor_article` (`coauthor_id`, `article_id`) VALUES (2,2);

INSERT INTO `db_camunda`.`coauthor_article` (`coauthor_id`, `article_id`) VALUES (1,3);
INSERT INTO `db_camunda`.`coauthor_article` (`coauthor_id`, `article_id`) VALUES (2,3);

INSERT INTO `db_camunda`.`coauthor_article` (`coauthor_id`, `article_id`) VALUES (1,4);
INSERT INTO `db_camunda`.`coauthor_article` (`coauthor_id`, `article_id`) VALUES (2,5);