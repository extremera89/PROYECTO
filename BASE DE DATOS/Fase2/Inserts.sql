-- INSERT DE SALAS
insert into Sala values (1,0,20);
insert into Sala values (2,1,20);
insert into Sala values (3,1,40);
insert into Sala values (4,0,40);
insert into Sala values (5,1,20);
insert into Sala values (6,0,20);
insert into Sala values (7,1,30);
insert into Sala values (8,0,40);
insert into Sala values (9,1,30);
insert into Sala values (10,1,40);
insert into Sala values (11,0,20);
insert into Sala values (12,1,20);
insert into Sala values (13,1,40);
insert into Sala values (14,0,40);
insert into Sala values (15,1,20);
insert into Sala values (16,0,20);
insert into Sala values (17,1,30);
insert into Sala values (18,0,40);
insert into Sala values (19,1,30);
insert into Sala values (20,1,40);

-- INSERT DE EXPOSICION

insert into Exposicion values ('Ars Noveau','Arte','24-2-2022','28-4-2022','Una exposicion de cuadros de artistas franceses',1);
insert into Exposicion values ('Esculturas Boteke','Esculturas','24-2-2022'',2-7-2022','Una exposicion de esculturas modernas',3);
insert into Exposicion values ('Arte ABS','Arte','20-3-2022','18-6-2022','Una exposicion de arte abstracto',4);
insert into Exposicion values ('Siglo XV','Arte','14-2-2022','1-9-2022','Una exposicion sobre el siglo XV',7);
insert into Exposicion values ('Machine vap','Máquinas','18-1-2022','8-5-2022','Exposicion de maquinas a vapor',15);

INSERT INTO Exposicion VALUES('Exposicion de videoconsolas', 'Tecnologíca','23/07/2022','29/08/2022','Dicha exposición trata sobre las videoconsolas',10);
INSERT INTO Exposicion VALUES('Exposicion de dinosaurios', 'Prehistoria','1/09/2022','15/09/2022','La exposición tratará sobre los diferentes dinousarios que pudieron estar en la provincia',15);
INSERT INTO Exposicion VALUES('Enseres prehistoricos', 'Prehistoria','1/09/2022','15/09/2022','Las últimas novedades de la moda del sigo XVII en el museo',12);
INSERT INTO Exposicion VALUES('Moda Siglo XVII', 'Moda','1/09/2022','15/09/2022','La exposición tratará sobre los diferentes dinousarios que pudieron estar en la provincia',6);
INSERT INTO Exposicion VALUES('Tech Expo', 'Tecnologíca','1/5/2022','4/5/2022','La exposición tratará sobre los diferentes dinousarios que pudieron estar en la provincia',8);


-- DATOS DE PERSONAS
INSERT INTO Persona values('75483467A','José','Sánchez','Mesa','657821963','jsanrom75@gmail.com');
INSERT INTO Persona values('77089536E','Nerea','Quesada','Martínez','659195476','nerea19quesada@hotmail.com');
INSERT INTO Persona values('20839184B','Diego','Cabrero','Gonzalez','625195448','diegocabgon23@gmail.com');
INSERT INTO Persona values('55073956L','Carlota','Espinosa','Serrano','758491642','carlotser477@outlook.com');
INSERT INTO Persona values('04276694M','Manuel','Moya','Molina','721733225','molinamoyamanuel@gmail.com');
INSERT INTO Persona values('26651583B','Jesús','Labrador','Cobos','796708833','jesuscobos54@hotmail.com');
INSERT INTO Persona values('94465347T','Cristian ','Valbuena','Manzano','648563340','valman1crist@gmail.com');
INSERT INTO Persona values('70611743H','Rubén','Iglesia ','Mariño','701601551','rubeniglesiamariño@yahoo.com');


-- INSERT DE RESERVA

insert into Reserva values ('20839184B',19,'20-3-2022','8-5-2022',1,14.5,20,'Reserva sobre una exposicion del propio artista');
insert into Reserva values ('94465347T',12,'14-1-2022','23-3-2022',0,12,18.5,'Reserva para exponer arte digital');
insert into Reserva values ('70611743H',3,'2-5-2022','13-8-2022',0,8.5,15,'Reserva para exponer arte conceptual');

-- INSERT DE CLIENTE

insert into Cliente values('20839184B',1);
insert into Cliente values('55073956L',0);
insert into Cliente values('04276694M',0);
insert into Cliente values('94465347T',1);
insert into Cliente values('70611743H',1);

-- DATOS DE MONITOR
INSERT INTO Monitor VALUES('Graduado en Historia del arte','75483467A');
INSERT INTO Monitor VALUES('Graduado en Informática','77089536E');
INSERT INTO Monitor VALUES('Graduado en Historia','26651583B');
INSERT INTO Monitor VALUES('Graduado en Paleontología', '94465347T');
INSERT INTO Monitor VALUES('Graduado en Historia', '04276694M');


-- DATOS DE VISITA_GUIADA

INSERT INTO VisitaGuiada VALUES(1,8,'29/04/2022','Museo Ibero','75483467A');
INSERT INTO VisitaGuiada VALUES(2,25,'15/05/2022','Museo Provincial','75483467A');
INSERT INTO VisitaGuiada VALUES(3,3,'14/06/2022','Museo Ibero','77089536E');
INSERT INTO VisitaGuiada VALUES(4,14,'23/08/2022','Universidad de Jaén', '77089536E');
INSERT INTO VisitaGuiada VALUES(5,9,'2/09/2022','Museo Ibero', '26651583B');


-- DATOS DE Exp_VisitaGuiada

INSERT INTO Exp_VisitaGuiada VALUES('Arte ABS',2);
INSERT INTO Exp_VisitaGuiada VALUES('Moda Siglo XVII',1);
INSERT INTO Exp_VisitaGuiada VALUES('Siglo XV',4);