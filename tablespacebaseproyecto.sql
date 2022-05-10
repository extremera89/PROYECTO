CREATE TABLESPACE PROYECTOMUSEO DATAFILE 'F:\base de datos\PROYECTO\proyectomuseo.DBF' SIZE 600M;

CREATE USER administrador IDENTIFIED BY administrador;

GRANT ALL PRIVILEGES TO administrador;

GRANT EXECUTE ANY PROCEDURE TO administrador;

GRANT UNLIMITED TABLESPACE TO administrador;

drop table Cliente;

drop table Monitor;

drop table Reserva;

drop table Persona;

drop table Exp_VisitaGuiada;

drop table Exposicion;

drop table VisitaGuiada;

drop table Sala;

drop table Login;

SELECT * from exposicion;

Create Table Sala(
    NumSala int,
    DadaAlta NUMBER(1,0),
    Tamanio int,
    CONSTRAINT Sala_Pk PRIMARY KEY(NumSala),
    CONSTRAINT NumSala_Ck CHECK (NumSala>0 AND NumSala<=20)
);

ALTER TABLE Sala MOVE TABLESPACE PROYECTOMUSEO;


Create Table Exposicion(
    Nombre varchar2(30),
    Tematica varchar2(30),
    FechaInicio date,
    FechaFin date,
    Descripcion varchar2(100),
    NumSala int,
    CONSTRAINT Expo_Pk PRIMARY KEY(Nombre),
    -- Constraint fechaexpo_ck check (FechaInicio>=CURRENT_DATE), 
    CONSTRAINT fechafin_ck CHECK (FechaFin>FechaInicio),
    CONSTRAINT ExpoSala_Fk FOREIGN KEY(Numsala) 
                           REFERENCES Sala(NumSala) 
                           ON DELETE SET NULL
);

ALTER TABLE Exposicion MOVE TABLESPACE PROYECTOMUSEO;


Create Table Persona(
    DNI Varchar2(9),
    Nombre Varchar2(25),
    Apellido1 Varchar2(25),
    Apellido2 Varchar2(25),
    Telefono Varchar2(9),
    Email Varchar2(50),
    CONSTRAINT dni_PK PRIMARY KEY(DNI),
    CONSTRAINT dni_CK  CHECK (REGEXP_LIKE(DNI,'[0-9]{8}[A-Z]{1}')),
    CONSTRAINT telef_CK CHECK(REGEXP_LIKE(Telefono,'[0-9]{9}'))
);

ALTER TABLE Persona MOVE TABLESPACE PROYECTOMUSEO;


Create Table Cliente(
    DNI Varchar2(9),
    EsExpositor NUMBER(1,0),
    CONSTRAINT Cliente_Pk Primary Key(DNI),
    CONSTRAINT ClientePersona_Fk FOREIGN key(DNI) 
                                 REFERENCES Persona(DNI) 
                                 ON DELETE SET NULL
);

ALTER TABLE Cliente MOVE TABLESPACE PROYECTOMUSEO;

Create Table Reserva(
    DNI varchar2(9),
    NumSala int,
    FechaReserva date,
    FechaFin date,
    Confirmado NUMBER(1,0),
    HoraApertura float, -- DEBERIA DE IR UN TIME pero no hay
    HoraCierre float, -- DEBERIA DE IR UN TIME pero no hay
    MotivoReserva varchar2(100),
    CONSTRAINT Reserva_Pk PRIMARY KEY(DNI,numSala,FechaReserva),
    -- Constraint fechaRerserva_ck check (FechaReserva>=CURRENT_DATE), ARREGLAR
    CONSTRAINT ReserSala_Fk FOREIGN KEY(numSala) 
                            REFERENCES Sala(numSala) 
                            ON DELETE SET NULL,
    CONSTRAINT ReserPersona_Fk FOREIGN KEY(DNI) 
                               REFERENCES Cliente(DNI) 
                               ON DELETE SET NULL
);

ALTER TABLE Reserva MOVE TABLESPACE PROYECTOMUSEO;

CREATE TABLE Monitor(
    Titulacion varchar2(30),
    DNI varchar2(9),
    CONSTRAINT monitor_pk PRIMARY KEY(DNI),
    CONSTRAINT DNI_FK FOREIGN KEY(DNI)
                      REFERENCES Persona(DNI)
                      ON DELETE SET NULL
);

ALTER TABLE Monitor MOVE TABLESPACE PROYECTOMUSEO;



CREATE TABLE VisitaGuiada(
    numVisita int,
    numPersonas int,
    fecha date,
    centro varchar2(30),
    DNI_monitor varchar2(9),
    CONSTRAINT numVisita_pk PRIMARY KEY(numVisita),
    CONSTRAINT numPersonas_CK CHECK(numPersonas>=1),
    CONSTRAINT DNImon_fk FOREIGN KEY(DNI_monitor)
                         REFERENCES Monitor(DNI)
                         ON DELETE SET NULL
    -- CONSTRAINT fechaVisita_CK CHECK (fecha>)
);
CREATE SEQUENCE numVisitas MINVALUE 1 START WITH 1 INCREMENT BY 1;

ALTER TABLE VisitaGuiada MOVE TABLESPACE PROYECTOMUSEO;

CREATE TABLE Exp_VisitaGuiada(
    Nombre Varchar2(30),
    numVisita int,
    CONSTRAINT Exp_VisitaGuiada_pk2 PRIMARY KEY(numVisita, Nombre),
    CONSTRAINT nombre_FK FOREIGN KEY(Nombre)
                         REFERENCES Exposicion(Nombre)
                         ON DELETE SET NULL,
    CONSTRAINT numVisita_fk FOREIGN KEY(numVisita)
                            REFERENCES VisitaGuiada(numVisita)
                            ON DELETE SET NULL
);

ALTER TABLE Exp_VisitaGuiada MOVE TABLESPACE PROYECTOMUSEO;

CREATE TABLE Login(
    usuario varchar2(50) PRIMARY KEY,
    contrasenia varchar2(50) NOT NULL,
    tipoUsuario NUMBER(1,0) NOT NULL
);
ALTER TABLE Login MOVE TABLESPACE PROYECTOMUSEO;

insert into Login values('paco','paco',1);

select * from Login;
