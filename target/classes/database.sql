create database BuiManhThanhEcormmerceSpringMVC;
use BuiManhThanhEcormmerceSpringMVC;
-- drop database BuiManhThanhEcormmerceSpringMVC;

create table `account` (
                           username varchar(50) primary key,
                           `password` varchar(64) not null,
                           enabled boolean not null,
                           email varchar(100) not null unique,
                           phone varchar(20) null unique,
                           full_name nvarchar(55) not null,
                           address nvarchar(255) null,
                           `rank_account` nvarchar(55) not null,
                           avatar nvarchar(255) null,
                           role_id int not null
);
create table `role`(
                       id int primary key auto_increment,
                       authority varchar(64) not null
);
create table `permission`(
                             role_id int not null,
                             access_id int not null,
                             primary key(role_id,access_id)
);
create table `access`(
                         id int primary key auto_increment,
                         `code` varchar(50) not null,
                         `description` varchar(255) null
);
create table `order_` (
                          id int primary key auto_increment,
                          username varchar(50) not null,
                          order_status varchar(20) not null,
                          ammount int not null,
                          payment_method varchar(50) not null,
                          create_time datetime not null,
                          discount_code_id int null,
                          phone varchar(20) null,
                          shiping_address varchar(255) null,
                          city varchar(50) null,
                          sum_money double not null
);
create table order_detail (
                              id int primary key auto_increment,
                              product_id int not null,
                              order_id int not null,
                              price double not null,
                              quantity int not null
);
create table product (
                         id int primary key auto_increment,
                         `name` varchar(55) not null,
                         price double not null,
                         category_id int not null,
                         `description` nvarchar(255) null,
                         thumbnail varchar(55) null,
                         represent varchar(255) null,
                         discount_id int null
);
create table product_detail(
                               id int primary key auto_increment,
                               product_id int not null,
                               size_id int not null,
                               color_id int not null,
                               quantity int not null,
                               `description` varchar(255) not null,
                               image varchar(255) null
);
create table category (
                          id int primary key auto_increment,
                          `name` nvarchar(50) not null,
                          `code` varchar(50) not null,
                          thumbnail varchar(50) null,
                          `description` nvarchar(255) null,
                          logo varchar(255) null
);
create table cart (
                      id int primary key auto_increment,
                      ammount int not null,
                      username varchar(50) not null
);
create table cart_detail (
                             id int primary key auto_increment,
                             product_id int not null,
                             cart_id int not null,
                             price double not null,
                             quantity int not null
);
create table discount_code (
                               id int primary key auto_increment,
                               `code` varchar(50) not null,
                               sale_percent int not null,
                               sale_money bigint not null,
                               start_day date not null,
                               end_day date not null,
                               max_discount bigint not null,
                               `description` nvarchar(255) null
);
create table discount(
                         id int primary key auto_increment,
                         sale_percent int not null,
                         start_day date not null,
                         end_day date not null,
                         `description` nvarchar(255) null
);
create table size(
                     id int primary key auto_increment,
                     `name` nvarchar(50) not null,
                     `code` varchar(50) not null,
                     `description` nvarchar(255) null
);
create table color(
                      id int primary key auto_increment,
                      `name` nvarchar(50) not null,
                      `code` varchar(50) not null,
                      `description` nvarchar(255) null
);

ALTER TABLE `account` ADD FOREIGN KEY (role_id) REFERENCES `role`(id);

ALTER TABLE `permission` ADD FOREIGN KEY (access_id) REFERENCES `access`(id);
ALTER TABLE `permission` ADD FOREIGN KEY (role_id) REFERENCES `role`(id);

ALTER TABLE `order_` ADD FOREIGN KEY (username) REFERENCES `account`(username);
ALTER TABLE `order_` ADD FOREIGN KEY (discount_code_id) REFERENCES `discount_code`(id);

ALTER TABLE order_detail ADD FOREIGN KEY (order_id) REFERENCES `order_`(id);
ALTER TABLE order_detail ADD FOREIGN KEY (product_id) REFERENCES product_detail(id);

ALTER TABLE `cart` ADD FOREIGN KEY (username) REFERENCES `account`(username);

ALTER TABLE cart_detail ADD FOREIGN KEY (cart_id) REFERENCES `cart`(id);
ALTER TABLE cart_detail ADD FOREIGN KEY (product_id) REFERENCES product_detail(id);

ALTER TABLE product ADD FOREIGN KEY (category_id) REFERENCES category(id);
ALTER TABLE product ADD FOREIGN KEY (discount_id) REFERENCES discount(id);

ALTER TABLE product_detail ADD FOREIGN KEY (color_id) REFERENCES color(id);
ALTER TABLE product_detail ADD FOREIGN KEY (size_id) REFERENCES size(id);
ALTER TABLE product_detail ADD FOREIGN KEY (product_id) REFERENCES product(id);

insert into category values
                         (null, 'Nike','nike', 'Sieu ben', 'troi be bau troi','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/categories/nike-logo_xhlyy2.png'),
                         (null, 'Adidas','adidas', 'Sieu ben', 'troi be bau troi','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/categories/adidas-logo_b1ryvd.png'),
                         (null, 'Bitis','bitis', 'Sieu ben', 'troi be bau troi','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853218/shoes/categories/bitis-logo_wzebl7.png'),
                         (null, 'Fila','fila', 'Sieu ben', 'troi be bau troi','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853220/shoes/categories/fila-logo_kkxasd.png');


insert into `size` values (null,'Small Size','M','This is small size');

insert into color values (null,'red','RED','this is a red line');
insert into color values (null,'blue','BLUE','this is a blue line');
insert into color values (null,'green','GREEN','this is a green line');

insert into discount values
	(null,10,'2023-01-01','2023-01-01','Happy New Year <3'),
    (null,20,'2023-01-22','2023-01-25','Happy Lunar New Year x 20% !!!'),
    (null,25,'2023-02-14','2023-02-14','Valentine Dat <3'),
    (null,30,'2023-01-22','2023-01-26','Happy Lunar New Year x 30% !!!'),
    (null,30,'2022-12-27','2022-12-27','Test Discount x 30% !!!');

insert into discount_code values
	(null,"CODE1234567890123456",10,0,"2022-12-27","2022-12-27",200,"Return money up to 200$"),
	(null,"20001234567890123456",10,0,"2022-12-27","2022-12-27",2000,"Return money up to 2000$");
-- select * from product as p left join discount as d on p.discount_id = d.id where '2022-01-23' between d.start_day and d.end_day;

insert into product values
                        (null,'Air Force1 Pixel',1800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png',5),
                        (null,'Jordan1 Low Magenta',700,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png',5),
                        (null,'Jordan1 Midcanyon',1800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png',1),
                        (null,'Jordan1 Mid Peach',7000,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png',1),
                        (null,'Jordan1 Mid Signal',800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png',1),
                        (null,'Jordan1 UNC',700,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png',1),
                        (null,'Nike ACG Air Mowabb',800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png',2),
                        (null,'Nike Air Force 1 ID Bred Toe',720,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853236/shoes/shoes/Nike/Jordan1LowMagenta_qvdvnq.png',2),
                        (null,'Nike Air Force 1 KSA',180,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853236/shoes/shoes/Nike/Jordan1Midcanyon_fsitrl.png',null),
                        (null,'Nike Air Force 1 Low',180,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/Jordan1MidPeach_dmueqh.png',null),
                        (null,'Nike Air Force 1 Mid',800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/Jordan1MidSignal_gxjbxp.png',3),
                        (null,'Nike Air Force 107 Mismatched',180,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/Jordan1UNC_a1nq85.png',3),
                        (null,'Nike Air Huarache LE',800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeACGAirMowabb_ytqwwq.png',3),
                        (null,'Nike Air Max AP',1860,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce1IDBredToe_rsjbcz.png',3),
                        (null,'Nike Air Max Dawn',2800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce1KSA_owzzte.png',3),
                        (null,'Nike Air Max Genome',380,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce1Low_iozhbe.png',null),
                        (null,'Nike Air Max Pre Day Be True',2850,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirForce1Mid_tpxo9w.png',1),
                        (null,'Nike Air More Uptempo',1820,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce107Mismatched_nqumhn.png',1),
                        (null,'Nike Air Presto Premium',2800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirHuaracheLE_cxrvnn.png',2),
                        (null,'Nike Air Zoom Pulse',2800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirMaxAP_of81kl.png',2),
                        (null,'Nike Blazer Low X',2800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirMaxDawn_abzhpe.png',null),
                        (null,'Nike Blazer Xsacai',2800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirMaxGenome_cguz9l.png',null),
                        (null,'Nike Court Vision Low',3990,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirMaxPreDayBeTrue_b9vool.png',null),
                        (null,'Nike Dunk High By You',1800,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirMoreUptempo_nwkqfp.png',null),
                        (null,'Nike Dunk High Retro SE',3990,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirPrestoPremium_q2jdmk.png',null),
                        (null,'Nike KD14',3990,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirZoomPulse_ucvpc7.png',3),
                        (null,'Nike Killshot OG',3990,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeBlazerLowX_dmxhct.png',3),
                        (null,'Nike Kyrie Infinity EP',3990,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeBlazerXsacai_mzelnr.png',3),
                        (null,'Nike Metcon',3990,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeCourtVisionLow_psmxui.png',null),
                        (null,'Nike Over Break',3990,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeDunkHighByYou_fbc8sd.png',null),
                        (null,'Nike PG5EP',1180,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeDunkHighRetroSE_a4arle.png',null),
                        (null,'Nike React Metcon Turbo',1180,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeKD14_d8lkoz.png',4),
                        (null,'Nike Renew Elevate',1180,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeKillshotOG_l2d4y1.png',4),
                        (null,'Nike SBNyjah Free',1180,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeKyrieInfinityEP_mrwalp.png',2),
                        (null,'Nike Waffle One SE',2300,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeMetcon_ymk8lv.png',null),
                        (null,'Nike Zoom X Super Rep Surge',2300,1,'Fake description nike .... this is content .... haloo 123456789','Fake thumnail nike','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeOverBreak_gyq4jn.png',null),

                        (null,'Adidas Fusio',230,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikePG5EP_kxxhqx.png',1),
                        (null,'Adidas Pulse',1000,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeReactMetconTurbo_zgd7k4.png',1),
                        (null,'Adidas Adizero Boston',400,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeRenewElevate_mbyu7v.png',1),
                        (null,'Adidas Advantage',1000,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeSBNyjahFree_velmzh.png',1),
                        (null,'Addidas Alpha',180,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeWaffleOneSE_na5nta.png',1),
                        (null,'Adidas Duramo',1000,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853242/shoes/shoes/Nike/NikeZoomXSuperRepSurge_lbjnna.png',null),
                        (null,'Adidas EQT Black',1000,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/shoes/Adidas/Adidas4DFusio_du0vap.png',null),
                        (null,'Adidas Falcon Black',360,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Adidas/Adidas4DFWDPulse_vuyf0w.png',null),
                        (null,'Addidas FluidFlow',1000,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Adidas/AdidasAdizeroBoston10_i5dpuv.png',null),
                        (null,'Adidas Ozelia',370,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Adidas/AdidasAdvantage_yjcioz.png',null),
                        (null,'Adidas Ultra City Pack',375,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Adidas/AdidasAlphabounce_tbpsgj.png',null),
                        (null,'Adidas Forum84 Marvel',375,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Adidas/AdidasDuramo_netzjr.png',null),
                        (null,'Adidas ForumDipped',372,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Adidas/AdidasEQTSupportBlack_tx1mtz.png',null),
                        (null,'Adidas ForumExhibititLow',37,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Adidas/AdidasFalconBlack_tawopj.png',null),
                        (null,'Adidas MidMarvel',373,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853236/shoes/shoes/Adidas/AdidasFluidflow_p89cru.png',null),
                        (null,'Adidas Galaxy5',3444,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853248/shoes/shoes/Adidas/AdidasOzelia_jjlp2j.png',null),
                        (null,'Adidas GazelleVintage',2444,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853255/shoes/shoes/Adidas/AdidasUltraboost20CityPack_eprkep.png',null),
                        (null,'Adidas GrandCourt',1222,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661854607/shoes/shoes/Adidas/AdidasForum84HiMarvel_nr1vyx.png',null),
                        (null,'Adidas Super NovaM',3444,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661854681/shoes/shoes/Adidas/AdidasForumDippedJeremyScott_gsrymd.png',null),
                        (null,'Adidas Ultraboost20 Valentine',8888,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Adidas/AdidasForumExhibititLow_ws8pxh.png',null),
                        (null,'Adidas Swift RunBlue',1000,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853243/shoes/shoes/Adidas/AdidasForumMidMarvel_kmanh2.png',null),
                        (null,'Adidas SuperStar',2122,2,'This is fake description .... adidas hello 123456789 . . . . .','Fake thumbnail adidias','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853242/shoes/shoes/Adidas/AdidasGalaxy5_e6uimx.png',3),

                        (null,'Bitis CoreZ',222,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853245/shoes/shoes/Adidas/AdidasGazelleVintage_dmz1xh.png',2),
                        (null,'Core Americano',222,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853245/shoes/shoes/Adidas/AdidasGrandCourt_mj6toc.png',4),
                        (null,'CoreBlack',22,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853253/shoes/shoes/Adidas/AdidasSuperNovaM_odpd6w.png',2),
                        (null,'CoreClassic Blue',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853218/shoes/shoes/Adidas/AdidasUltraboost20Valentine_u76ain.png',null),
                        (null,'CoreClassic Grey',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853255/shoes/shoes/Adidas/AdidasSwiftRunBlue_zsxdpp.png',4),
                        (null,'CoreContrax',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853254/shoes/shoes/Adidas/AdidasSuperStar_xyxjb3.png',4),
                        (null,'CoreGrey',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/shoes/Bitis/BitisCoreZ_vhtqxd.png',null),
                        (null,'CoreMarios',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/shoes/Bitis/BitisHunterCoreAmericano_uwyjpu.png',null),
                        (null,'CoreMilky White',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreBlack_ksgjyn.png',4),
                        (null,'CoreSonik Blue',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreClassicBlue_uzmkve.png',4),
                        (null,'CoreTet Edition Red',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreClassicGrey_e69iek.png',null),
                        (null,'CoreWhite Snow',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreContrax_bxphbc.png',null),
                        (null,'BitisHunter CoreZBlack SuperStar',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreGrey_igxxdj.png',1),
                        (null,'BitisHunterCore ZVani',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreMarios_hqfaub.png',1),
                        (null,'BitisHunter Football Hightop Blue',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreMilkyWhite_vgag9w.png',1),
                        (null,'BitisHunter Football High top Orange',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreSonikBlue_ubn4pj.png',1),
                        (null,'BitisHunter Football Hightop Yellow',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreTetEditionRed_oznprf.png',null),
                        (null,'BitisHunter Football Yellow',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreWhiteSnow_pq2car.png',null),
                        (null,'BitisHunter Football Yellow',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreZBlack_cp9lse.png',null),
                        (null,'BitisHunter LayeredUpper White',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterCoreZVani_hudig6.png',4),
                        (null,'BitisHunter Street AmericanoBlack',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterFootballHightopBlue_s0tnbq.png',4),
                        (null,'BitisHunter Street Green',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballHightopOrange_p9mkcb.png',4),
                        (null,'BitisHunter Street Latte',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballHightopYellow_ciqagu.png',null),
                        (null,'BitisHunter Stre et Mid Americano',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballYellow_jmnyve.png',null),
                        (null,'BitisHunter Street Mid KumquatSoda',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballYellow_jmnyve.png',4),
                        (null,'BitisHunter StreetMid Orange',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterLayeredUpperWhite_tqij70.png',null),
                        (null,'BitisHunter StreetRed',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetAmericanoBlack_wk7ati.png',null),
                        (null,'BitisHunter Street TetEdition White2020',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetGreen_dmefsd.png',4),
                        (null,'BitisHunter StreetWhite',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetLatte_ctx0a5.png',3),
                        (null,'BitisHunter Street White',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetMidAmericano_hlm7fb.png',3),
                        (null,'BitisHunter Streetx Vietmax2020 Black',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetMidKumquatSoda_euq5ue.png',3),
                        (null,'BitisHunter Streetx VietMax2020 Brown',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetMidOrange_eqmx5g.png',1),
                        (null,'BitisHunter Street ZBlue',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetRed_q8wsip.png',null),
                        (null,'BitisHunter StreetZ High Purple',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetTetEditionWhite2020_alhfyi.png',null),
                        (null,'BitisHunter StreetZ HighWhite',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetWhite_fvvxf0.png',null),
                        (null,'BitisHunter Street ZPink',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetxVietMax2020Brown_fsz8e5.png',null),
                        (null,'BitisHunter StreetZ White',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetxVietmax2020Black_hau2re.png',null),
                        (null,'BitisHunter Vintage Black',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetxVietMax2020_hjklhn.png',null),
                        (null,'BitisHunter Vintage Blue',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZBlue_enuxph.png',null),
                        (null,'BitisHunterX2k19 Blue',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZHighPurple_zj1ikh.png',null),
                        (null,'BitisHunterX Classik Blackr',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZHighWhite_tlxgrr.png',1),
                        (null,'BitisHunterX ClassikXam',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZPink_koylot.png',1),
                        (null,'BitisHunterX Matcha',2122222,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZWhite_jkgzfs.png',1),
                        (null,'BitisHunterX Orange Tonic',2122222,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterVintageBlack_se4g09.png',1),
                        (null,'BitisHunterX Retro Essential White',2122222,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterVintageBlue_kge1e7.png',null),
                        (null,'BitisHunter XZReu',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterX2k19Blue_qhzymf.png',null),
                        (null,'BitisHunter XZWhiter',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXClassikBlack_x9bpzn.png',null),
                        (null,'BitisHunter XZXam',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXClassikXam_dyd3mc.png',null),
                        (null,'Bitis Medium Black',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisHunterXMatcha_amoolm.png',null),
                        (null,'Bitis Medium Vani',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXOrangeTonic_jutk8o.png',null),
                        (null,'Bitis Neutral200',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXRetroEssentialWhite_amskae.png',null),
                        (null,'Bitis Random100',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXZReu_dkuwfd.png',null),
                        (null,'Bitis Random200',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisHunterXZWhite_szwzo1.png',1),
                        (null,'Resizer_1',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisHunterXZXam_d2wa4f.png',1),
                        (null,'Resizer_2',2122,3,'This is fake description bitis ..... fake contennt 123456789 . . . . ','fake thumbnail bitis','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisMediumBlack_bjvc2a.png',1),

                        (null,'Fila Alpha Lite Men',930,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisMediumVani_izfv0g.png',null),
                        (null,'Fila Above Run',880,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisNeutral200_mcs1iy.png',3),
                        (null,'Fila AlPha Lite Men Maroon',730,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Bitis/BitisRandom100_j2jhd3.png',3),
                        (null,'Fila Alpha Lite Olive Green',830,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisRandom200_qrczse.png',3),
                        (null,'Fila Archive RJV',830,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Bitis/Resizer_164058677091153_jeltox.png',3),
                        (null,'Fila Bumber Slipon',2100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Bitis/Resizer_164058677091154_xbgtyb.png',null),
                        (null,'Fila Decypher',840,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteMenMaroon_dieg2e.png',null),
                        (null,'Fila Decypher White',2100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteMenMaroon_dieg2e.png',null),
                        (null,'Fila Disruptor 2 White',232222,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteMenMaroon_dieg2e.png',4),
                        (null,'Fila Electrove 2',2100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteOliveGreen_a2drlo.png',4),
                        (null,'Fila Electrove 2 Black',2100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaArchiveRJV_dwpbkm.png',4),
                        (null,'Fila Electrove 2 Cream',1100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaBumberSlipon_yrnbrv.png',null),
                        (null,'Fila Festivo 125',1100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaDecypher_eg3ptl.png',null),
                        (null,'Fila Festivo 720',1100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaDecypherWhite_tyjhpd.png',null),
                        (null,'Fila Filargb Flex Newday 401',1100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaDisruptor2White_odlhfn.png',null),
                        (null,'Fila Fixture Cement 77',1100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaElectrove2_kzmqce.png',null),
                        (null,'Fila Grant Hill 1 Tarvos',1100,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaElectrove2Black_m4y5ip.png',2),
                        (null,'Fila Grant Hill 2 Cement',150,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaElectrove2Cream_bcb0zz.png',2),
                        (null,'Fila Guard Slipon Canvas 103',150,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaFestivo125_ga6krd.png',2),
                        (null,'Fila Interation White',150,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaFestivo720_nfnbc5.png',2),
                        (null,'Fila Italia Real Conic',150,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaFilargbFlexNewday401_emzrhv.png',2),
                        (null,'Fila MB Men',5000,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaFixtureCement77_b0z73l.png',null),
                        (null,'Fila Multi Swif5',5000,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaGrantHill1Tarvos_xnd6wv.png',null),
                        (null,'Fila Oakmont TR Script',5000,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaGrantHill2Cement_kxjxlq.png',null),
                        (null,'Fila Project 7 Filargb Flex Newday 144',5000,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaGuardSliponCanvas103_cxx5xf.png',null),
                        (null,'Fila Project7 Modulus 155',5000,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaInterationWhite_h6t2qr.png',2),
                        (null,'Fila Project Court Plumpy',5040,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaItaliaRealConic_yv3i6r.png',2),
                        (null,'Fila Ray Tracer',5040,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaMBMen_qsogzn.png',1),
                        (null,'Fila Ray TracerTr 2 Black',5040,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaMultiSwif5_bjzgyr.png',null),
                        (null,'Fil aRay TracerTr 2 Pink',5040,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaOakmontTRScript_igynlo.png',null),
                        (null,'Fila Renno Blue',5040,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaProject7FilargbFlexNewday144_hry7lp.png',null),
                        (null,'Fila Renno Next Gen Trainers',5040,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaProject7Modulus155_ect6r2.png',null),
                        (null,'Fila Stac kHouse Spagetti',5040,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaProjectCourtPlumpy_nz81up.png',null),
                        (null,'Fila T1 Mid Men',120,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRayTracer_ot8gnw.png',null),
                        (null,'Fila Vintage Oxy',120,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRayTracerTr2Black_izjz6x.png',1),
                        (null,'Fila Wavelet Og',120,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRayTracerTr2Pink_sbx1eq.png',null),
                        (null,'Filax Flock Together Traiblazer',120,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRennoBlue_cpbubc.png',1),
                        (null,'Fila Wavelet Og',120,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRennoNextGenTrainers_ajtqgi.png',3),
                        (null,'Fila Xlite Click Run',12800,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaStackHouseSpagetti_hyhxp5.png',3),
                        (null,'Fila Zagato',12800,4,'This is fake description fila .... fake 123456 . . . . .','fake thumbnail fila ','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaStackHouseSpagetti_hyhxp5.png',null);

insert into product_detail values
                               (null,1,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png'),
                               (null,2,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png'),
                               (null,3,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png'),
                               (null,4,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png'),
                               (null,5,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png'),
                               (null,6,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png'),
                               (null,7,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png'),
                               (null,8,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png'),
                               (null,9,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853236/shoes/shoes/Nike/Jordan1LowMagenta_qvdvnq.png'),
                               (null,10,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853236/shoes/shoes/Nike/Jordan1Midcanyon_fsitrl.png'),
                               (null,11,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/Jordan1MidPeach_dmueqh.png'),
                               (null,12,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/Jordan1MidSignal_gxjbxp.png'),
                               (null,13,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/Jordan1UNC_a1nq85.png'),
                               (null,14,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeACGAirMowabb_ytqwwq.png'),
                               (null,15,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce1IDBredToe_rsjbcz.png'),
                               (null,16,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce1KSA_owzzte.png'),
                               (null,17,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce1Low_iozhbe.png'),
                               (null,18,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirForce1Mid_tpxo9w.png'),
                               (null,19,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce107Mismatched_nqumhn.png'),
                               (null,20,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirHuaracheLE_cxrvnn.png'),
                               (null,21,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirMaxAP_of81kl.png'),
                               (null,22,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirMaxDawn_abzhpe.png'),
                               (null,23,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirMaxGenome_cguz9l.png'),
                               (null,24,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirMaxPreDayBeTrue_b9vool.png'),
                               (null,25,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirMoreUptempo_nwkqfp.png'),
                               (null,26,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirPrestoPremium_q2jdmk.png'),
                               (null,27,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirZoomPulse_ucvpc7.png'),
                               (null,28,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeBlazerLowX_dmxhct.png'),
                               (null,29,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeBlazerXsacai_mzelnr.png'),
                               (null,30,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeCourtVisionLow_psmxui.png'),
                               (null,31,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeDunkHighByYou_fbc8sd.png'),
                               (null,32,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeDunkHighRetroSE_a4arle.png'),
                               (null,33,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeKD14_d8lkoz.png'),
                               (null,34,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeKillshotOG_l2d4y1.png'),
                               (null,35,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeKyrieInfinityEP_mrwalp.png'),
                               (null,36,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeMetcon_ymk8lv.png'),
                               (null,37,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeOverBreak_gyq4jn.png'),
                               (null,38,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikePG5EP_kxxhqx.png'),
                               (null,39,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeReactMetconTurbo_zgd7k4.png'),
                               (null,40,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeRenewElevate_mbyu7v.png'),
                               (null,41,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeSBNyjahFree_velmzh.png'),
                               (null,42,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeWaffleOneSE_na5nta.png'),
                               (null,43,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853242/shoes/shoes/Nike/NikeZoomXSuperRepSurge_lbjnna.png'),
                               (null,44,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/shoes/Adidas/Adidas4DFusio_du0vap.png'),
                               (null,45,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Adidas/Adidas4DFWDPulse_vuyf0w.png'),
                               (null,46,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Adidas/AdidasAdizeroBoston10_i5dpuv.png'),
                               (null,47,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Adidas/AdidasAdvantage_yjcioz.png'),
                               (null,48,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Adidas/AdidasAlphabounce_tbpsgj.png'),
                               (null,49,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Adidas/AdidasDuramo_netzjr.png'),
                               (null,50,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Adidas/AdidasEQTSupportBlack_tx1mtz.png'),
                               (null,51,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Adidas/AdidasFalconBlack_tawopj.png'),
                               (null,52,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853236/shoes/shoes/Adidas/AdidasFluidflow_p89cru.png'),
                               (null,53,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853248/shoes/shoes/Adidas/AdidasOzelia_jjlp2j.png'),
                               (null,54,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853255/shoes/shoes/Adidas/AdidasUltraboost20CityPack_eprkep.png'),
                               (null,55,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661854607/shoes/shoes/Adidas/AdidasForum84HiMarvel_nr1vyx.png'),
                               (null,56,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661854681/shoes/shoes/Adidas/AdidasForumDippedJeremyScott_gsrymd.png'),
                               (null,57,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Adidas/AdidasForumExhibititLow_ws8pxh.png'),
                               (null,58,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853243/shoes/shoes/Adidas/AdidasForumMidMarvel_kmanh2.png'),
                               (null,59,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853242/shoes/shoes/Adidas/AdidasGalaxy5_e6uimx.png'),
                               (null,60,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853245/shoes/shoes/Adidas/AdidasGazelleVintage_dmz1xh.png'),
                               (null,61,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853245/shoes/shoes/Adidas/AdidasGrandCourt_mj6toc.png'),
                               (null,62,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853253/shoes/shoes/Adidas/AdidasSuperNovaM_odpd6w.png'),
                               (null,63,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853218/shoes/shoes/Adidas/AdidasUltraboost20Valentine_u76ain.png'),
                               (null,64,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853255/shoes/shoes/Adidas/AdidasSwiftRunBlue_zsxdpp.png'),
                               (null,65,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853254/shoes/shoes/Adidas/AdidasSuperStar_xyxjb3.png'),
                               (null,66,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/shoes/Bitis/BitisCoreZ_vhtqxd.png'),
                               (null,67,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/shoes/Bitis/BitisHunterCoreAmericano_uwyjpu.png'),
                               (null,68,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreBlack_ksgjyn.png'),
                               (null,69,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreClassicBlue_uzmkve.png'),
                               (null,70,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreClassicGrey_e69iek.png'),
                               (null,71,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreContrax_bxphbc.png'),
                               (null,72,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreGrey_igxxdj.png'),
                               (null,73,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreMarios_hqfaub.png'),
                               (null,74,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreMilkyWhite_vgag9w.png'),
                               (null,75,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreSonikBlue_ubn4pj.png'),
                               (null,76,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreTetEditionRed_oznprf.png'),
                               (null,77,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreWhiteSnow_pq2car.png'),
                               (null,78,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreZBlack_cp9lse.png'),
                               (null,79,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterCoreZVani_hudig6.png'),
                               (null,80,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterFootballHightopBlue_s0tnbq.png'),
                               (null,81,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballHightopOrange_p9mkcb.png'),
                               (null,82,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballHightopYellow_ciqagu.png'),
                               (null,83,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballYellow_jmnyve.png'),
                               (null,84,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballYellow_jmnyve.png'),
                               (null,85,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterLayeredUpperWhite_tqij70.png'),
                               (null,86,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetAmericanoBlack_wk7ati.png'),
                               (null,87,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetGreen_dmefsd.png'),
                               (null,88,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetLatte_ctx0a5.png'),
                               (null,89,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetMidAmericano_hlm7fb.png'),
                               (null,90,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetMidKumquatSoda_euq5ue.png'),
                               (null,91,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetMidOrange_eqmx5g.png'),
                               (null,92,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetRed_q8wsip.png'),
                               (null,93,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetTetEditionWhite2020_alhfyi.png'),
                               (null,94,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetWhite_fvvxf0.png'),
                               (null,95,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetxVietMax2020Brown_fsz8e5.png'),
                               (null,96,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetxVietmax2020Black_hau2re.png'),
                               (null,97,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetxVietMax2020_hjklhn.png'),
                               (null,98,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZBlue_enuxph.png'),
                               (null,99,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZHighPurple_zj1ikh.png'),
                               (null,100,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZHighWhite_tlxgrr.png'),
                               (null,101,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZPink_koylot.png'),
                               (null,102,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZWhite_jkgzfs.png'),
                               (null,103,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterVintageBlack_se4g09.png'),
                               (null,104,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterVintageBlue_kge1e7.png'),
                               (null,105,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterX2k19Blue_qhzymf.png'),
                               (null,106,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXClassikBlack_x9bpzn.png'),
                               (null,107,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXClassikXam_dyd3mc.png'),
                               (null,108,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisHunterXMatcha_amoolm.png'),
                               (null,109,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXOrangeTonic_jutk8o.png'),
                               (null,110,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXRetroEssentialWhite_amskae.png'),
                               (null,111,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXZReu_dkuwfd.png'),
                               (null,112,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisHunterXZWhite_szwzo1.png'),
                               (null,113,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisHunterXZXam_d2wa4f.png'),
                               (null,114,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisMediumBlack_bjvc2a.png'),
                               (null,115,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisMediumVani_izfv0g.png'),
                               (null,116,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisNeutral200_mcs1iy.png'),
                               (null,117,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Bitis/BitisRandom100_j2jhd3.png'),
                               (null,118,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisRandom200_qrczse.png'),
                               (null,119,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Bitis/Resizer_164058677091153_jeltox.png'),
                               (null,120,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Bitis/Resizer_164058677091154_xbgtyb.png'),
                               (null,121,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteMenMaroon_dieg2e.png'),
                               (null,122,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteMenMaroon_dieg2e.png'),
                               (null,123,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteMenMaroon_dieg2e.png'),
                               (null,124,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteOliveGreen_a2drlo.png'),
                               (null,125,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaArchiveRJV_dwpbkm.png'),
                               (null,126,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaBumberSlipon_yrnbrv.png'),
                               (null,127,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaDecypher_eg3ptl.png'),
                               (null,128,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaDecypherWhite_tyjhpd.png'),
                               (null,129,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaDisruptor2White_odlhfn.png'),
                               (null,130,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaElectrove2_kzmqce.png'),
                               (null,131,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaElectrove2Black_m4y5ip.png'),
                               (null,132,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaElectrove2Cream_bcb0zz.png'),
                               (null,133,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaFestivo125_ga6krd.png'),
                               (null,134,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaFestivo720_nfnbc5.png'),
                               (null,135,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaFilargbFlexNewday401_emzrhv.png'),
                               (null,136,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaFixtureCement77_b0z73l.png'),
                               (null,137,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaGrantHill1Tarvos_xnd6wv.png'),
                               (null,138,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaGrantHill2Cement_kxjxlq.png'),
                               (null,139,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaGuardSliponCanvas103_cxx5xf.png'),
                               (null,140,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaInterationWhite_h6t2qr.png'),
                               (null,141,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaItaliaRealConic_yv3i6r.png'),
                               (null,142,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaMBMen_qsogzn.png'),
                               (null,143,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaMultiSwif5_bjzgyr.png'),
                               (null,144,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaOakmontTRScript_igynlo.png'),
                               (null,145,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaProject7FilargbFlexNewday144_hry7lp.png'),
                               (null,146,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaProject7Modulus155_ect6r2.png'),
                               (null,147,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaProjectCourtPlumpy_nz81up.png'),
                               (null,148,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRayTracer_ot8gnw.png'),
                               (null,149,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRayTracerTr2Black_izjz6x.png'),
                               (null,150,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRayTracerTr2Pink_sbx1eq.png'),
                               (null,151,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRennoBlue_cpbubc.png'),
                               (null,152,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRennoNextGenTrainers_ajtqgi.png'),
                               (null,153,1,1,2,'hehe1','https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaStackHouseSpagetti_hyhxp5.png');

insert into access values(null,'/shop','co the truy cap vao url /shop'),
                         (null,'/admin/**','co the truy cap vao tat ca admin');

insert into `role` values(null,'ADMIN'),
                         (null,'CUSTOMER');

insert into `permission` values(1,2),
                               (2,1);

insert into `account` values
                          ('AdminThanh','$2a$12$ddHf7yPdK5JuoclRSheqRu6BU1PHnbQg/nay3u6AxvNDs.JEvjnNm',true,'thanh12@gmail.com','0328735659','Bui Manh Thanh','Sai gon dau co lanh','member',null,1),
                          ('AdminThanh123','$2a$12$4cQpgGLVGBdZuiZib8cNteuK3tRiFGI5crbkrJ.XQfyYRv8C7ozzq',true,'thanh123@gmail.com','0328735658','Bui Manh Thanh','Sai gon dau co lanh','member',null,1),
                          ('CustomerThanh123','$2a$12$4cQpgGLVGBdZuiZib8cNteuK3tRiFGI5crbkrJ.XQfyYRv8C7ozzq',true,'thanh1234@gmail.com','0328735657','Bui Manh Thanh Customer','Sai gon dau co lanh','member',null,2),
                          ('Test123','$2a$12$NNbCQSF1CP7mJtGSp57JROD6m3F3t26qHHKZf175EWyGPd0A/EpO6',true,'thanh123434@gmail.com','123','Bui Manh Thanh','Sai gon dau co lanh','member',null,1),
                          ('Test1234','$2a$12$NNbCQSF1CP7mJtGSp57JROD6m3F3t26qHHKZf175EWyGPd0A/EpO6',true,'thanh123433334@gmail.com','1234','Bui Manh Thanh','Sai gon dau co lanh','member',null,2);

insert into cart values(null,2,'Test1234');
insert into cart_detail values(null,3,1,180000,1),
                              (null,4,1,570000,1);
select * from order_;
insert into `order_` values (null,'Test1234','COMPLETE',1,'MOMO','2022-10-10',null,"0328735659","27/8b ap moi 1, xa Tan Xuan, huyen Hoc Mon","HO CHI MINH CITY",180000);
insert into `order_detail` values (null,1,1,180000,1);

insert into `order_` values (null,'Test1234','DELIVERING',1,'MOMO','2022-10-10',null,"0328735659","27/8b ap moi 1, xa Tan Xuan, huyen Hoc Mon","HO CHI MINH CITY",180000);
insert into `order_detail` values (null,1,2,180000,1);

