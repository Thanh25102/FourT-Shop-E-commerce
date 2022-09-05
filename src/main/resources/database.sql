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
create table `order` (
                         id int primary key auto_increment,
                         username varchar(50) not null,
                         order_status varchar(20) not null,
                         ammount int not null,
                         payment_method varchar(50) not null,
                         create_time datetime not null,
                         discount_code_id int null
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
                         repesent varchar(255) null,
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
                      customer_id int not null,
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

ALTER TABLE `order` ADD FOREIGN KEY (username) REFERENCES `account`(username);
ALTER TABLE `order` ADD FOREIGN KEY (discount_code_id) REFERENCES `discount_code`(id);

ALTER TABLE order_detail ADD FOREIGN KEY (order_id) REFERENCES `order`(id);
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
                         (null, "Nike","nike", "Sieu ben", "troi be bau troi","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/categories/nike-logo_xhlyy2.png"),
                         (null, "Adidas","adidas", "Sieu ben", "troi be bau troi","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/categories/adidas-logo_b1ryvd.png"),
                         (null, "Bitis","bitis", "Sieu ben", "troi be bau troi","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853218/shoes/categories/bitis-logo_wzebl7.png"),
                         (null, "Fila","fila", "Sieu ben", "troi be bau troi","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853220/shoes/categories/fila-logo_kkxasd.png");

insert into product values
                        (null,'Air Force1 Pixel',180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853252/shoes/product-thumb-4_vptfsm.jpg",null),
                        (null,'Jordan1 Low Magenta',570000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853250/shoes/h4-slide_ghh6oh.png",null),
                        (null,'Jordan1 Midcanyon',180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853250/shoes/h4-slide2_jpwhf6.png",null),
                        (null,'Jordan1 Mid Peach',570000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853250/shoes/h4-slide3_bwk0ds.png",null),
                        (null,'Jordan1 Mid Signal',180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853250/shoes/h4-slide4_hhwvgn.png",null),
                        (null,'Jordan1 UNC',570000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853251/shoes/h4-slide7_fl6lx6.png",null),
                        (null,'Nike ACG Air Mowabb',180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Nike/AirForce1Pixel_csvstu.png",null),
                        (null,'Nike Air Force 1 ID Bred Toe',570000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853236/shoes/shoes/Nike/Jordan1LowMagenta_qvdvnq.png",null),
                        (null,'Nike Air Force 1 KSA',800000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853236/shoes/shoes/Nike/Jordan1Midcanyon_fsitrl.png",null),
                        (null,'Nike Air Force 1 Low',180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/Jordan1MidPeach_dmueqh.png",null),
                        (null,'Nike Air Force 1 Mid',800000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/Jordan1MidSignal_gxjbxp.png",null),
                        (null,'Nike Air Force 107 Mismatched',180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/Jordan1UNC_a1nq85.png",null),
                        (null,'Nike Air Huarache LE',800000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeACGAirMowabb_ytqwwq.png",null),
                        (null,'Nike Air Max AP',180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce1IDBredToe_rsjbcz.png",null),
                        (null,'Nike Air Max Dawn',800000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce1KSA_owzzte.png",null),
                        (null,'Nike Air Max Genome',180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce1Low_iozhbe.png",null),
                        (null,'Nike Air Max Pre Day Be True',280000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirForce1Mid_tpxo9w.png",null),
                        (null,'Nike Air More Uptempo',800000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853237/shoes/shoes/Nike/NikeAirForce107Mismatched_nqumhn.png",null),
                        (null,'Nike Air Presto Premium',280000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirHuaracheLE_cxrvnn.png",null),
                        (null,'Nike Air Zoom Pulse',280000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirMaxAP_of81kl.png",null),
                        (null,'Nike Blazer Low X',280000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirMaxDawn_abzhpe.png",null),
                        (null,'Nike Blazer Xsacai',280000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Nike/NikeAirMaxGenome_cguz9l.png",null),
                        (null,'Nike Court Vision Low',399000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirMaxPreDayBeTrue_b9vool.png",null),
                        (null,'Nike Dunk High By You',180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirMoreUptempo_nwkqfp.png",null),
                        (null,'Nike Dunk High Retro SE',399000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirPrestoPremium_q2jdmk.png",null),
                        (null,'Nike KD14',399000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeAirZoomPulse_ucvpc7.png",null),
                        (null,'Nike Killshot OG',399000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeBlazerLowX_dmxhct.png",null),
                        (null,'Nike Kyrie Infinity EP',399000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853239/shoes/shoes/Nike/NikeBlazerXsacai_mzelnr.png",null),
                        (null,'Nike Metcon',399000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeCourtVisionLow_psmxui.png",null),
                        (null,'Nike Over Break',399000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeDunkHighByYou_fbc8sd.png",null),
                        (null,'Nike PG5EP',1180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeDunkHighRetroSE_a4arle.png",null),
                        (null,'Nike React Metcon Turbo',1180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeKD14_d8lkoz.png",null),
                        (null,'Nike Renew Elevate',1180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeKillshotOG_l2d4y1.png",null),
                        (null,'Nike SBNyjah Free',1180000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeKyrieInfinityEP_mrwalp.png",null),
                        (null,'Nike Waffle One SE',2300000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853240/shoes/shoes/Nike/NikeMetcon_ymk8lv.png",null),
                        (null,'Nike Zoom X Super Rep Surge',2300000,1,"Fake description nike .... this is content .... haloo 123456789","Fake thumnail nike","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeOverBreak_gyq4jn.png",null),

                        (null,'Adidas Fusio',10000000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikePG5EP_kxxhqx.png",null),
                        (null,'Adidas Pulse',10000000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeReactMetconTurbo_zgd7k4.png",null),
                        (null,'Adidas Adizero Boston',4000000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeRenewElevate_mbyu7v.png",null),
                        (null,'Adidas Advantage',10000000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeSBNyjahFree_velmzh.png",null),
                        (null,'Addidas Alpha',1800000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853241/shoes/shoes/Nike/NikeWaffleOneSE_na5nta.png",null),
                        (null,'Adidas Duramo',10000000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853242/shoes/shoes/Nike/NikeZoomXSuperRepSurge_lbjnna.png",null),
                        (null,'Adidas EQT Black',10000000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/shoes/Adidas/Adidas4DFusio_du0vap.png",null),
                        (null,'Adidas Falcon Black',3600000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Adidas/Adidas4DFWDPulse_vuyf0w.png",null),
                        (null,'Addidas FluidFlow',10000000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Adidas/AdidasAdizeroBoston10_i5dpuv.png",null),
                        (null,'Adidas Ozelia',370000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Adidas/AdidasAdvantage_yjcioz.png",null),
                        (null,'Adidas Ultra City Pack',370000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Adidas/AdidasAlphabounce_tbpsgj.png",null),
                        (null,'Adidas Forum84 Marvel',370000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Adidas/AdidasDuramo_netzjr.png",null),
                        (null,'Adidas ForumDipped',370000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Adidas/AdidasEQTSupportBlack_tx1mtz.png",null),
                        (null,'Adidas ForumExhibititLow',370000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853235/shoes/shoes/Adidas/AdidasFalconBlack_tawopj.png",null),
                        (null,'Adidas MidMarvel',370000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853236/shoes/shoes/Adidas/AdidasFluidflow_p89cru.png",null),
                        (null,'Adidas Galaxy5',34444444,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853248/shoes/shoes/Adidas/AdidasOzelia_jjlp2j.png",null),
                        (null,'Adidas GazelleVintage',2444444,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853255/shoes/shoes/Adidas/AdidasUltraboost20CityPack_eprkep.png",null),
                        (null,'Adidas GrandCourt',1222222,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661854607/shoes/shoes/Adidas/AdidasForum84HiMarvel_nr1vyx.png",null),
                        (null,'Adidas Super NovaM',3444444,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661854681/shoes/shoes/Adidas/AdidasForumDippedJeremyScott_gsrymd.png",null),
                        (null,'Adidas Ultraboost20 Valentine',8888888,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853238/shoes/shoes/Adidas/AdidasForumExhibititLow_ws8pxh.png",null),
                        (null,'Adidas Swift RunBlue',10000000,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853243/shoes/shoes/Adidas/AdidasForumMidMarvel_kmanh2.png",null),
                        (null,'Adidas SuperStar',2122222,2,"This is fake description .... adidas hello 123456789 . . . . .","Fake thumbnail adidias","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853242/shoes/shoes/Adidas/AdidasGalaxy5_e6uimx.png",null),

                        (null,'Bitis CoreZ',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853245/shoes/shoes/Adidas/AdidasGazelleVintage_dmz1xh.png",null),
                        (null,'Core Americano',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853245/shoes/shoes/Adidas/AdidasGrandCourt_mj6toc.png",null),
                        (null,'CoreBlack',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853253/shoes/shoes/Adidas/AdidasSuperNovaM_odpd6w.png",null),
                        (null,'CoreClassic Blue',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853218/shoes/shoes/Adidas/AdidasUltraboost20Valentine_u76ain.png",null),
                        (null,'CoreClassic Grey',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853255/shoes/shoes/Adidas/AdidasSwiftRunBlue_zsxdpp.png",null),
                        (null,'CoreContrax',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853254/shoes/shoes/Adidas/AdidasSuperStar_xyxjb3.png",null),
                        (null,'CoreGrey',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/shoes/Bitis/BitisCoreZ_vhtqxd.png",null),
                        (null,'CoreMarios',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853221/shoes/shoes/Bitis/BitisHunterCoreAmericano_uwyjpu.png",null),
                        (null,'CoreMilky White',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreBlack_ksgjyn.png",null),
                        (null,'CoreSonik Blue',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreClassicBlue_uzmkve.png",null),
                        (null,'CoreTet Edition Red',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreClassicGrey_e69iek.png",null),
                        (null,'CoreWhite Snow',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreContrax_bxphbc.png",null),
                        (null,'BitisHunter CoreZBlack SuperStar',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreGrey_igxxdj.png",null),
                        (null,'BitisHunterCore ZVani',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853222/shoes/shoes/Bitis/BitisHunterCoreMarios_hqfaub.png",null),
                        (null,'BitisHunter Football Hightop Blue',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreMilkyWhite_vgag9w.png",null),
                        (null,'BitisHunter Football High top Orange',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreSonikBlue_ubn4pj.png",null),
                        (null,'BitisHunter Football Hightop Yellow',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreTetEditionRed_oznprf.png",null),
                        (null,'BitisHunter Football Yellow',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreWhiteSnow_pq2car.png",null),
                        (null,'BitisHunter Football Yellow',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterCoreZBlack_cp9lse.png",null),
                        (null,'BitisHunter LayeredUpper White',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterCoreZVani_hudig6.png",null),
                        (null,'BitisHunter Street AmericanoBlack',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853223/shoes/shoes/Bitis/BitisHunterFootballHightopBlue_s0tnbq.png",null),
                        (null,'BitisHunter Street Green',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballHightopOrange_p9mkcb.png",null),
                        (null,'BitisHunter Street Latte',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballHightopYellow_ciqagu.png",null),
                        (null,'BitisHunter Stre et Mid Americano',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballYellow_jmnyve.png",null),
                        (null,'BitisHunter Street Mid KumquatSoda',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterFootballYellow_jmnyve.png",null),
                        (null,'BitisHunter StreetMid Orange',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterLayeredUpperWhite_tqij70.png",null),
                        (null,'BitisHunter StreetRed',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetAmericanoBlack_wk7ati.png",null),
                        (null,'BitisHunter Street TetEdition White2020',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetGreen_dmefsd.png",null),
                        (null,'BitisHunter StreetWhite',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetLatte_ctx0a5.png",null),
                        (null,'BitisHunter Street White',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetMidAmericano_hlm7fb.png",null),
                        (null,'BitisHunter Streetx Vietmax2020 Black',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853224/shoes/shoes/Bitis/BitisHunterStreetMidKumquatSoda_euq5ue.png",null),
                        (null,'BitisHunter Streetx VietMax2020 Brown',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetMidOrange_eqmx5g.png",null),
                        (null,'BitisHunter Street ZBlue',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetRed_q8wsip.png",null),
                        (null,'BitisHunter StreetZ High Purple',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetTetEditionWhite2020_alhfyi.png",null),
                        (null,'BitisHunter StreetZ HighWhite',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetWhite_fvvxf0.png",null),
                        (null,'BitisHunter Street ZPink',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetxVietMax2020Brown_fsz8e5.png",null),
                        (null,'BitisHunter StreetZ White',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetxVietmax2020Black_hau2re.png",null),
                        (null,'BitisHunter Vintage Black',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853225/shoes/shoes/Bitis/BitisHunterStreetxVietMax2020_hjklhn.png",null),
                        (null,'BitisHunter Vintage Blue',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZBlue_enuxph.png",null),
                        (null,'BitisHunterX2k19 Blue',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZHighPurple_zj1ikh.png",null),
                        (null,'BitisHunterX Classik Blackr',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZHighWhite_tlxgrr.png",null),
                        (null,'BitisHunterX ClassikXam',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZPink_koylot.png",null),
                        (null,'BitisHunterX Matcha',2122222222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterStreetZWhite_jkgzfs.png",null),
                        (null,'BitisHunterX Orange Tonic',2122222222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterVintageBlack_se4g09.png",null),
                        (null,'BitisHunterX Retro Essential White',2122222222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterVintageBlue_kge1e7.png",null),
                        (null,'BitisHunter XZReu',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853226/shoes/shoes/Bitis/BitisHunterX2k19Blue_qhzymf.png",null),
                        (null,'BitisHunter XZWhiter',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXClassikBlack_x9bpzn.png",null),
                        (null,'BitisHunter XZXam',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXClassikXam_dyd3mc.png",null),
                        (null,'Bitis Medium Black',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisHunterXMatcha_amoolm.png",null),
                        (null,'Bitis Medium Vani',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXOrangeTonic_jutk8o.png",null),
                        (null,'Bitis Neutral200',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXRetroEssentialWhite_amskae.png",null),
                        (null,'Bitis Random100',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853227/shoes/shoes/Bitis/BitisHunterXZReu_dkuwfd.png",null),
                        (null,'Bitis Random200',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisHunterXZWhite_szwzo1.png",null),
                        (null,'Resizer_1',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisHunterXZXam_d2wa4f.png",null),
                        (null,'Resizer_2',2122222,3,"This is fake description bitis ..... fake contennt 123456789 . . . . ","fake thumbnail bitis","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisMediumBlack_bjvc2a.png",null),

                        (null,'Fila Alpha Lite Men',930000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisMediumVani_izfv0g.png",null),
                        (null,'Fila Above Run',880000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisNeutral200_mcs1iy.png",null),
                        (null,'Fila AlPha Lite Men Maroon',730000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Bitis/BitisRandom100_j2jhd3.png",null),
                        (null,'Fila Alpha Lite Olive Green',830000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853228/shoes/shoes/Bitis/BitisRandom200_qrczse.png",null),
                        (null,'Fila Archive RJV',830000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Bitis/Resizer_164058677091153_jeltox.png",null),
                        (null,'Fila Bumber Slipon',2100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853229/shoes/shoes/Bitis/Resizer_164058677091154_xbgtyb.png",null),
                        (null,'Fila Decypher',840000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteMenMaroon_dieg2e.png",null),
                        (null,'Fila Decypher White',2100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteMenMaroon_dieg2e.png",null),
                        (null,'Fila Disruptor 2 White',232222,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteMenMaroon_dieg2e.png",null),
                        (null,'Fila Electrove 2',2100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaAlphaLiteOliveGreen_a2drlo.png",null),
                        (null,'Fila Electrove 2 Black',2100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaArchiveRJV_dwpbkm.png",null),
                        (null,'Fila Electrove 2 Cream',1100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaBumberSlipon_yrnbrv.png",null),
                        (null,'Fila Festivo 125',1100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853230/shoes/shoes/Fila/FilaDecypher_eg3ptl.png",null),
                        (null,'Fila Festivo 720',1100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaDecypherWhite_tyjhpd.png",null),
                        (null,'Fila Filargb Flex Newday 401',1100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaDisruptor2White_odlhfn.png",null),
                        (null,'Fila Fixture Cement 77',1100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaElectrove2_kzmqce.png",null),
                        (null,'Fila Grant Hill 1 Tarvos',1100000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaElectrove2Black_m4y5ip.png",null),
                        (null,'Fila Grant Hill 2 Cement',150000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaElectrove2Cream_bcb0zz.png",null),
                        (null,'Fila Guard Slipon Canvas 103',150000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaFestivo125_ga6krd.png",null),
                        (null,'Fila Interation White',150000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaFestivo720_nfnbc5.png",null),
                        (null,'Fila Italia Real Conic',150000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaFilargbFlexNewday401_emzrhv.png",null),
                        (null,'Fila MB Men',5000000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853231/shoes/shoes/Fila/FilaFixtureCement77_b0z73l.png",null),
                        (null,'Fila Multi Swif5',5000000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaGrantHill1Tarvos_xnd6wv.png",null),
                        (null,'Fila Oakmont TR Script',5000000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaGrantHill2Cement_kxjxlq.png",null),
                        (null,'Fila Project 7 Filargb Flex Newday 144',5000000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaGuardSliponCanvas103_cxx5xf.png",null),
                        (null,'Fila Project7 Modulus 155',5000000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853232/shoes/shoes/Fila/FilaInterationWhite_h6t2qr.png",null),
                        (null,'Fila Project Court Plumpy',5040000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaItaliaRealConic_yv3i6r.png",null),
                        (null,'Fila Ray Tracer',5040000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaMBMen_qsogzn.png",null),
                        (null,'Fila Ray TracerTr 2 Black',5040000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaMultiSwif5_bjzgyr.png",null),
                        (null,'Fil aRay TracerTr 2 Pink',5040000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaOakmontTRScript_igynlo.png",null),
                        (null,'Fila Renno Blue',5040000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaProject7FilargbFlexNewday144_hry7lp.png",null),
                        (null,'Fila Renno Next Gen Trainers',5040000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853233/shoes/shoes/Fila/FilaProject7Modulus155_ect6r2.png",null),
                        (null,'Fila Stac kHouse Spagetti',5040000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaProjectCourtPlumpy_nz81up.png",null),
                        (null,'Fila T1 Mid Men',120000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRayTracer_ot8gnw.png",null),
                        (null,'Fila Vintage Oxy',120000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRayTracerTr2Black_izjz6x.png",null),
                        (null,'Fila Wavelet Og',120000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRayTracerTr2Pink_sbx1eq.png",null),
                        (null,'Filax Flock Together Traiblazer',120000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRennoBlue_cpbubc.png",null),
                        (null,'Fila Wavelet Og',120000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaRennoNextGenTrainers_ajtqgi.png",null),
                        (null,'Fila Xlite Click Run',12800000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaStackHouseSpagetti_hyhxp5.png",null),
                        (null,'Fila Zagato',12800000,4,"This is fake description fila .... fake 123456 . . . . .","fake thumbnail fila ","https://res.cloudinary.com/com-buimahthanh/image/upload/v1661853234/shoes/shoes/Fila/FilaStackHouseSpagetti_hyhxp5.png",null);
