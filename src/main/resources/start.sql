###############################################
# Create role table and add record to base    #
###############################################
create table if not exists role (
                                    role_id int(2) auto_increment primary key unique,
                                    role varchar(255) not null
);


insert into role (role_id, role) values (1, 'ADMIN');
insert into role (role_id, role) values (2, 'USER');


################################################
# Create user table and add record to base     #
################################################

create table if not exists  user (
                                     id int (100) auto_increment primary key unique,
                                     active int (9) not null,
                                     login varchar(20) not null,
                                     name varchar(20) not null,
                                     last_name varchar(20) not null,
                                     email varchar(40) not null,
                                     password varchar(100) not null
);

insert into user (id, active, login, name, last_name, email, password)
values (1,1,'admin','Lucjan', 'Pawarotti', 'lucjan@gmail.com',  '$2a$10$/r39t7RH7tykA33JbGt84eYeeMD.A3HbqT.Wh.H9W9h1LsdNiaZHG');

insert into user (id, active, login, name, last_name, email, password)
values (2,1,'user', 'Adaś', 'Nowakowski', 'adas@gmail.com', '$2a$10$3Mis/djdswmq63olMVNEjec2E.f5MGazqSQXkeZF.mT4j1lZFJAZu');

#################################################
# Create user_role table and add record to base #
#################################################

create table if not exists user_role (
                                         user_id int(5) auto_increment primary key unique,
                                         role_id int(5) not null
);

insert into user_role (user_id, role_id) values (1,1);
insert into user_role (user_id, role_id) values (2,2);

#################################################
# Create coin database and add record to base   #
#################################################

create table if not exists coin (
                                    id int(5) auto_increment primary key unique,
                                    name varchar(250) not null,
                                    series varchar(250),
                                    value int(10) not null,
                                    country varchar(15) not null,
                                    hallmark varchar(15) not null,
                                    stamp varchar(20) not null,
                                    dimansion varchar(20) not null,
                                    mass varchar(20) not null,
                                    emission int(20) not null,
                                    emissiondate varchar(30) not null,
                                    emissionprise varchar(10) not null,
                                    buyprise varchar(10),
                                    awers varchar(250) not null,
                                    rewers varchar(250) not null,
                                    note varchar(250)
);

insert into coin values (1,'100-lecie powstania PKO Banku Polskiego','' , 10 ,'Polska', 'Ag925', 'lustrzany',32, 14.14, 20000, '2019','bd', 'bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_02___pko_A.jpg', 'https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_02___pko_R.jpg' ,'Moneta kupiona w sklepie internetowym');
insert into coin values (2,'100. rocznica podpisania Dekretu o archiwach państwowych', '',10, 'Polska','Ag925',	'lustrzany',32, 14.14, 12000, '2019', 'bd', 'bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_03___archiwa_A.jpg', 'https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_03___archiwa_R.jpg', 'Moneta kupiona w sklepie internetowym');
insert into coin values (3,'Sejm Ustawodawczy 1919-1922', '', 10,'Polska', 'Ag925',	'lustrzany', 32, 14.14, 15000, '2019', 'bd', 'bd', 'https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_04___sejm_A.jpg',	'https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_04___sejm_R.jpg', 'Moneta kupiona w sklepie internetowym');
insert into coin values (4,'100 lat złotego – zestaw srebrnych monet','',0, 'Polska', 'Ag925', 'lustrzany', 'mieszane',	0, 5000, '2019','bd','bd', 'https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_05___100lat_Ag_A.jpg', 'https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_05___100lat_Ag_R.jpg','Moneta kupiona w sklepie internetowym');
insert into coin values (5,'Wyprawa wileńska','',10,'Polska','Ag925','lustrzany','32',14.14	,13000,'2019','bd', 'bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_06___wyprawa_wilenska_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_06___wyprawa_wilenska_R.jpg','Moneta kupiona w sklepie internetowym');
insert into coin values (6,'200-lecie Akademii Sztuk Pięknych im. Jana Matejki w Krakowie','',10,'Polska','Ag925','lustrzany','32', 14.14,15000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_07___asp_10zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_07___asp_10zl_R.jpg','Moneta kupiona w sklepie internetowym');
insert into coin values (7,'100-lecie Katolickiego Uniwersytetu Lubelskiego','',10,'Polska','Ag925','lustrzany','32',14.14,15000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_08___kul_10zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_08___kul_10zl_R.jpg','Moneta kupiona w NBP');
insert into coin values (8,'Stanisław Kasznica „Wąsowski”',	'Wyklęci przez komunistów żołnierze niezłomni',10,'Polska','Ag925','lustrzany','32',14.14,13000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_09___kasznica_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_09___kasznica_R.jpg','Moneta kupiona w NBP');
insert into coin values (9,'Roman Rybarski','Wielcy polscy ekonomiści',10,'Polska','Ag925','lustrzany','32',14.14,13000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_10___rybarski_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_10___rybarski_R.jpg','Moneta kupiona w NBP');
insert into coin values (10,'100-lecie utworzenia Uniwersytetu Poznańskiego','',10,'Polska','Ag925','lustrzany','32',14.14,15000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_11___up_10zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_11___up_10zl_R.jpg','Moneta kupiona w NBP');
insert into coin values (11,'Zabytki Fromborka','Odkryj Polskę',5,'Polska','MN25, CuAl6Ni2','zwykły','24',6.54,1200000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_12___frombork_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_12___frombork_R.jpg','Moneta kupiona w NBP');
insert into coin values (12,'420. rocznica urodzin Hetmana Stefana Czarnieckiego','',10,'Polska','Ag925','lustrzany','32',14.14,15000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_13___czarniecki_10zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_13___czarniecki_10zl_R.jpg','Moneta kupiona w NBP');
insert into coin values (13,'Helena Modrzejewska','Wielkie aktorki',10,'Polska','Ag925','lustrzany','40x28',28.28,16000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_14___modrzejewska_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_14___modrzejewska_R.jpg','Moneta kupiona w NBP');
insert into coin values (14,'450. rocznica unii lubelskiej','',20,'Polska','Ag925','lustrzany','40x28',	28.28,15000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_15___unia_lubelska_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_15___unia_lubelska_R.jpg','Moneta od Wujka Stefana');
insert into coin values (15,'Szóstak Jana Sobieskiego',	'Historia Monety Polskiej',20,'Polska','Ag925','lustrzany','38,61',28.28,13000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_16___szostak_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_16___szostak_R.jpg','Moneta od Wujka Stefana');
insert into coin values (16,'75. rocznica zagłady Romów i Sinti','',10,'Polska','Ag925','lustrzany','32',14.14,13000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_17___romowie_sinti_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_17___romowie_sinti_R.jpg','Moneta od Wujka Stefana');
insert into coin values (17,'100-lecie polskiej flagi państwowej','',10,'Polska','Ag925','lustrzany','32',14.14,13000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_18___flaga_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_18___flaga_R.jpg','Moneta od Wujka Stefana');
insert into coin values (18,'Wizna','Polskie Termopile',20,'Polska','Ag925','lustrzany','38,61',28.28,15000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_19___wizna_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_19___wizna_R.jpg','Moneta od Wujka Stefana');
insert into coin values (19,'90. rocznica urodzin Anny Walentynowicz','',10,'Polska','Ag925','lustrzany','32',14.14,12000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_20___walentynowicz_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_20___walentynowicz_R.jpg','Moneta od Wujka Stefana');
insert into coin values (20,'140-lecie Muzeum Narodowego w Krakowie','',20,'Polska','Ag925','lustrzany','38,61',28.28,13000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_21___mn_krakow_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_21___mn_krakow_R.jpg','Moneta od Wujka Stefana');
insert into coin values (21,'Łukasz Ciepliński „Pług”',	'Wyklęci przez komunistów żołnierze niezłomni',10,'Polska','Ag925','lustrzany','32',14.14,13000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_23___plug_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_23___plug_R.jpg','Prezent w spadku');
insert into coin values (22,'Wojciech Korfanty','Stulecie odzyskania przez Polskę niepodległości',10,'Polska','Ag925','lustrzany','32x22,4',14.14,13000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_24___korfanty_10zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_24___korfanty_10zl_R.jpg','Prezent w spadku');
insert into coin values (23,'Kopiec Wyzwolenia','Odkryj Polskę',5,'Polska','MN25, CuAl6Ni2','zwykły','24',6.54,1200000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_25___kopiec_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_25___kopiec_R.jpg','Prezent w spadku');
insert into coin values (24,'Hołd ruski','',10,'Polska','Ag925','lustrzany','32',14.14,10000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_26___hold_ruski_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_26___hold_ruski_R.jpg','Prezent w spadku');
insert into coin values (25,'Hołd pruski','',10,'Polska','Ag925','lustrzany','32',14.14,10000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_26___hold_pruski_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_26___hold_pruski_R.jpg','Inwestycja, zakup na Allegro');
insert into coin values (26,'100-lecie polskiego lotnictwa wojskowego','',	10	,'Polska','Ag925','lustrzany','32',14.14,15000,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_27___lotnictwo_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_27___lotnictwo_R.jpg','Inwestycja, zakup na Allegro');
insert into coin values (27,'Stefan Batory','Skarby Stanisława Augusta',500	,'Polska','Au999,9','zwykły','45',62.2,600,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_01___batory_500zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_01___batory_500zl_R.jpg','Inwestycja, zakup na Allegro');
insert into coin values (28,'200-lecie Akademii Sztuk Pięknych im. Jana Matejki w Krakowie','',200,'Polska','Au999','lustrzany','27',15.5,1500,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_07___asp_200zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_07___asp_200zl_R.jpg','Inwestycja, zakup na Allegro');
insert into coin values (29,'100-lecie Katolickiego Uniwersytetu Lubelskiego','',200,'Polska','Au990','lustrzany','27',15.5,1500,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_08___kul_200zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_08___kul_200zl_R.jpg','Inwestycja, zakup na Allegro');
insert into coin values (30,'100-lecie utworzenia Uniwersytetu Poznańskiego','',200,'Polska','Au990','lustrzany','27',15.5,1500,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_11___up_200zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_11___up_200zl_R.jpg','Inwestycja, zakup na Allegro');
insert into coin values (31,'420. rocznica urodzin Hetmana Stefana Czarnieckiego','',200,'Polska','Au990','lustrzany','27',15.5,1500,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_13___czarniecki_200zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_13___czarniecki_200zl_R.jpg','Moneta kupiona w NBP');
insert into coin values (32,'Wojciech Korfanty','Stulecie odzyskania przez Polskę niepodległości',100,'Polska','Au990','lustrzany','21',8,1500,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_24___korfanty_100zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_24___korfanty_100zl_R.jpg','Moneta kupiona w NBP');
insert into coin values (33,'Powrót złota do Polski','',100	,'Polska','Au999,9','lustrzany','23,43x13,97',8,2019,'2019','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_28___powrot_zlota_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2019/2019_28___powrot_zlota_R.jpg','Moneta kupiona w NBP');
insert into coin values (34,'Zygmunt III Waza','Skarby Stanisława Augusta',50,'Polska','Ag999','zwykły','45',62.2,5000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_01___zygmunt_waza_50zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_01___zygmunt_waza_50zl_R.jpg','Moneta kupiona w NBP');
insert into coin values (35,'Zygmunt III Waza',	'Skarby Stanisława Augusta',500	,'Polska','Au999,9','zwykły','45',62.2,600,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_01___zygmunt_waza_500zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_01___zygmunt_waza_500zl_R.jpg','Prezent od znajomego');
insert into coin values (36,'100-lecie zaślubin Polski z Bałtykiem','',50,'Polska','Ag999','zwykły','45',62.2,5000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_02___zaslubiny_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_02___zaslubiny_R.jpg','Prezent od znajomego');
insert into coin values (37,'Katyń – Palmiry 1940','',10,'Polska','Ag925','lustrzany','32',14.14,11000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_03___katyn_palmiry_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_03___katyn_palmiry_R.jpg','Prezent od znajomego');
insert into coin values (38,'10. rocznica tragedii smoleńskiej','',10,'Polska','Ag925','lustrzany','32',31.1,14000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_04___smolensk_10zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_04___smolensk_10zl_R.jpg','Prezent od znajomego');
insert into coin values (39,'10. rocznica tragedii smoleńskiej','',100,'Polska','Au900','lustrzany','21',8,15000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_04___smolensk_100zl_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_04___smolensk_100zl_R.jpg','Prezent od znajomego');
insert into coin values (40,'100. rocznica urodzin Świętego Jana Pawła II','',10,'Polska','Ag925','lustrzany','32',14.14,16000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_05___jan_pawel_ii_ag925_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_05___jan_pawel_ii_ag925_R.jpg','Zakup okazjonalny');
insert into coin values (41,'100. rocznica urodzin Świętego Jana Pawła II','',10,'Polska','Ag999','lustrzany','32',31.1,12000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_05___jan_pawel_ii_ag999_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_05___jan_pawel_ii_ag999_R.jpg','Zakup okazjonalny');
insert into coin values (42,'100. rocznica urodzin Świętego Jana Pawła II','',500,'Polska','Au999,9','lustrzany','40x40',62.2,966,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_05___jan_pawel_ii_au_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_05___jan_pawel_ii_au_R.jpg','Zakup okazjonalny');
insert into coin values (43,'700-lecie konsekracji kościoła Mariackiego w Krakowie','',	50,'Polska','Ag999','zwykły','45',62.2,6000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_06___mariacki_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_06___mariacki_R.jpg','Inwestycja');
insert into coin values (44,'Kościół Mariacki','Odkryj Polskę',	5,'Polska','MN25, CuAl6Ni2','zwykły','24',6.54,1200000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_07___op_mariacki_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_07___op_mariacki_R.jpg','Inwestycja');
insert into coin values (45,'Zotówka gdańska Augusta III','Historia Monety Polskiej',20,'Polska','Ag925','lustrzany','38,61',28.28,12000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_08___zlotowka_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_08___zlotowka_R.jpg','Moneta kupiona na Allegro');
insert into coin values (46,'Stanisław Głąbiński','Wielcy polscy ekonomiści',10,'Polska','Ag925','lustrzany','32',14.14	,12000,'2020','bd','bd','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_09___glabinski_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_09___glabinski_R.jpg','Moneta kupiona na Allegro');


insert into coin values (57,'Stanisław','Wielcy polscy ekonomiści',10,'Polska','Ag925','lustrzany','32',14.14	,12000,'2020','bd','aaaWart','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_09___glabinski_A.jpg','https://www.nbp.pl/banknoty_i_monety/monety_okolicznosciowe/2020/2020_09___glabinski_R.jpg','Moneta kupiona na Allegro');
