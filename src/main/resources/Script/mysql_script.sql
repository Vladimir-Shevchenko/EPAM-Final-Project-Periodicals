use sys;


CREATE TABLE sys.member
(
    uname VARCHAR(45) NOT NULL PRIMARY KEY,
    password VARCHAR(450) NOT NULL ,
    email VARCHAR(45) NOT NULL ,
    phone VARCHAR(45) NOT NULL

);

insert into member  values('volya', 'dva','@','03');
insert into member  values('admin', 'admin','','');



ALTER DATABASE sys CHARACTER SET utf8 COLLATE utf8_general_ci;
 ALTER DATABASE sys CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


##############################################Periodicals

drop table if exists periodicals;
CREATE TABLE sys.periodicals
(
    periodicals_id   INT  NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(75) NOT NULL,
    price int NOT NULL ,
    type VARCHAR(45) NOT NULL ,
    description VARCHAR(450) NOT NULL

);
insert into sys.periodicals (name, price, type, description) values('Natural Geographic','15','Nature','About nature, animals and exploring wildlife');
insert into sys.periodicals (name, price, type, description) values('Around the World','8','Nature','About life in jungle and underwater life');
insert into sys.periodicals (name, price, type, description) values('Big Cats','17','Nature','About big cats likes lions, leopards, clouded leopards and other cats');
insert into sys.periodicals (name, price, type, description) values('Animal Planet','15','Nature','About wild animals');
insert into sys.periodicals (name, price, type, description) values('Beautiful mountains and Waterfalls','13','Nature','About wild and the most beautiful views in our planet');

insert into sys.periodicals (name, price, type, description) values('Soccer','7','Sport','About World Cup and UEFA Champions Legue');
insert into sys.periodicals (name, price, type, description) values('Judo','9','Sport','About judo competitions');
insert into sys.periodicals (name, price, type, description) values('Running','5','Sport','About sprints and marathons');
insert into sys.periodicals (name, price, type, description) values('Big Water','9','Sport','About swimming');
insert into sys.periodicals (name, price, type, description) values('The most strange game','3','Sport','About curling');

insert into sys.periodicals (name, price, type, description) values('Adventures','10','Travels','About new people and countries');
insert into sys.periodicals (name, price, type, description) values('Interesting Adventures','12','Travels','About interesting travelings');
insert into sys.periodicals (name, price, type, description) values('Traveling','11','Travels','About  trips without money');
insert into sys.periodicals (name, price, type, description) values('Hikes','12','Travels','About wild travels');
insert into sys.periodicals (name, price, type, description) values('Travelings and freedom','10','Travels','About all kinds of travels');


#################CREATE ORDER


drop table if exists sys.orders;
CREATE TABLE sys.orders
(
    order_id INT  NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    periodicals_id   INT  NOT NULL ,
    username VARCHAR(75) NOT NULL

);



############### money          #################################################













drop table if exists sys.money;
CREATE TABLE sys.money
(
    username varchar(50)  NOT NULL  PRIMARY KEY,
    money   INT  NOT NULL
);


ALTER TABLE member
    ADD isBlocked varchar(5);

ALTER TABLE sys.member MODIFY isBlocked varchar(10);


