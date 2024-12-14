-- Generado por Oracle SQL Developer Data Modeler 24.3.0.240.1210
--   en:        2024-12-14 02:46:58 CET
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE agente (
    correo VARCHAR2(500 CHAR) NOT NULL
);

ALTER TABLE agente ADD CONSTRAINT agente_pk PRIMARY KEY ( correo );

ALTER TABLE agente ADD CONSTRAINT agente_uk UNIQUE ( correo );

CREATE TABLE asset (
    url      VARCHAR2(1000 CHAR) NOT NULL,
    cuenta   VARCHAR2(300 CHAR) NOT NULL,
    producto INTEGER NOT NULL,
    nombre   VARCHAR2(100 CHAR) NOT NULL
);

ALTER TABLE asset ADD CONSTRAINT asset_pk PRIMARY KEY ( url );

CREATE TABLE atributo (
    cuenta    VARCHAR2(300 CHAR) NOT NULL,
    producto  INTEGER NOT NULL,
    nombre    VARCHAR2(50 CHAR) NOT NULL,
    numero    NUMBER,
    texto     VARCHAR2(1000 CHAR),
    "DECIMAL" NUMBER
);

ALTER TABLE atributo ADD CONSTRAINT atributo_pk PRIMARY KEY ( nombre,
                                                              producto );

CREATE TABLE canal (
    url    VARCHAR2(500 CHAR) NOT NULL,
    nombre VARCHAR2(100 CHAR) NOT NULL
);

ALTER TABLE canal ADD CONSTRAINT canal_pk PRIMARY KEY ( url );

CREATE TABLE categoria_ass (
    nombre VARCHAR2(100 CHAR) NOT NULL,
    asset  VARCHAR2(1000 CHAR) NOT NULL
);

ALTER TABLE categoria_ass ADD CONSTRAINT categoria_ass_pk PRIMARY KEY ( nombre );

CREATE TABLE categoria_prod (
    nombre   VARCHAR2(100 CHAR) NOT NULL,
    producto INTEGER NOT NULL
);

ALTER TABLE categoria_prod ADD CONSTRAINT categoria_prod_pk PRIMARY KEY ( nombre );

CREATE TABLE cuenta (
    nombre         VARCHAR2(300 CHAR) NOT NULL,
    plan           VARCHAR2(30) NOT NULL,
    propietario    VARCHAR2(500 CHAR) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    almacenamiento VARCHAR2(250 CHAR) NOT NULL,
    logo_url       VARCHAR2(500 CHAR)
);

ALTER TABLE cuenta ADD CONSTRAINT cuenta_pk PRIMARY KEY ( nombre );

CREATE TABLE cuenta_usuario (
    cuenta  VARCHAR2(300 CHAR) NOT NULL,
    usuario VARCHAR2(500 CHAR) NOT NULL
);

ALTER TABLE cuenta_usuario ADD CONSTRAINT cuenta_usuario_pk PRIMARY KEY ( usuario,
                                                                          cuenta );

CREATE TABLE galeria (
    nombre   VARCHAR2(50 CHAR) NOT NULL,
    producto INTEGER NOT NULL,
    imagen   VARCHAR2(1000) NOT NULL
);

ALTER TABLE galeria ADD CONSTRAINT galeria_pk PRIMARY KEY ( nombre,
                                                            producto );

ALTER TABLE galeria ADD CONSTRAINT galeria_uk UNIQUE ( nombre );

CREATE TABLE pago (
    tarjeta INTEGER NOT NULL,
    nombre  VARCHAR2(100 CHAR),
    url     VARCHAR2(500 CHAR)
);

ALTER TABLE pago ADD CONSTRAINT pago_pk PRIMARY KEY ( tarjeta );

CREATE TABLE plan (
    nombre              VARCHAR2(30) NOT NULL,
    sku                 INTEGER NOT NULL,
    assets              INTEGER NOT NULL,
    almacenamiento      NUMBER NOT NULL,
    categorias_producto INTEGER NOT NULL,
    categorias_assets   INTEGER NOT NULL,
    relaciones          INTEGER NOT NULL,
    amazon              NUMBER NOT NULL,
    precio              NUMBER NOT NULL
);

ALTER TABLE plan ADD CONSTRAINT plan_pk PRIMARY KEY ( nombre );

CREATE TABLE producto (
    gtin             INTEGER NOT NULL,
    sku              VARCHAR2(15 CHAR) NOT NULL,
    cuenta           VARCHAR2(300 CHAR) NOT NULL,
    fecha_creacion   TIMESTAMP NOT NULL,
    fecha_modificado TIMESTAMP,
    descripcion      VARCHAR2(100 CHAR),
    thumbnail        VARCHAR2(500 CHAR)
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( gtin );

ALTER TABLE producto ADD CONSTRAINT producto_sku_uk UNIQUE ( sku );

CREATE TABLE propietario (
    correo VARCHAR2(500 CHAR) NOT NULL,
    pago   INTEGER NOT NULL
);

CREATE UNIQUE INDEX propietario__idx ON
    propietario (
        pago
    ASC );

ALTER TABLE propietario ADD CONSTRAINT propietario_pk PRIMARY KEY ( correo );

ALTER TABLE propietario ADD CONSTRAINT propietario_uk UNIQUE ( correo );

CREATE TABLE relacionado (
    producto1 INTEGER NOT NULL,
    producto2 INTEGER NOT NULL
);

ALTER TABLE relacionado ADD CONSTRAINT relacionado_pk PRIMARY KEY ( producto1,
                                                                    producto2 );

CREATE TABLE similar (
    producto1 INTEGER NOT NULL,
    producto2 INTEGER NOT NULL
);

ALTER TABLE similar ADD CONSTRAINT similar_pk PRIMARY KEY ( producto1,
                                                            producto2 );

CREATE TABLE token (
    cuenta VARCHAR2(300 CHAR) NOT NULL,
    canal  VARCHAR2(500 CHAR) NOT NULL,
    token  VARCHAR2(100 CHAR) NOT NULL
);

ALTER TABLE token ADD CONSTRAINT token_pk PRIMARY KEY ( canal,
                                                        cuenta );

CREATE TABLE usuario (
    correo VARCHAR2(500 CHAR) NOT NULL,
    nombre VARCHAR2(250 CHAR) NOT NULL,
    passwd VARCHAR2(64 CHAR) NOT NULL,
    avatar VARCHAR2(500 CHAR)
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( correo );

ALTER TABLE agente
    ADD CONSTRAINT agente_usuario_fk FOREIGN KEY ( correo )
        REFERENCES usuario ( correo );

ALTER TABLE asset
    ADD CONSTRAINT asset_cuenta_fk FOREIGN KEY ( cuenta )
        REFERENCES cuenta ( nombre );

ALTER TABLE asset
    ADD CONSTRAINT asset_producto_fk FOREIGN KEY ( producto )
        REFERENCES producto ( gtin );

ALTER TABLE atributo
    ADD CONSTRAINT atributo_cuenta_fk FOREIGN KEY ( cuenta )
        REFERENCES cuenta ( nombre );

ALTER TABLE atributo
    ADD CONSTRAINT atributo_producto_fk FOREIGN KEY ( producto )
        REFERENCES producto ( gtin );

ALTER TABLE categoria_ass
    ADD CONSTRAINT categoria_ass_asset_fk FOREIGN KEY ( asset )
        REFERENCES asset ( url );

ALTER TABLE categoria_prod
    ADD CONSTRAINT categoria_producto_fk FOREIGN KEY ( producto )
        REFERENCES producto ( gtin );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_plan_fk FOREIGN KEY ( plan )
        REFERENCES plan ( nombre );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_propietario_fk FOREIGN KEY ( propietario )
        REFERENCES propietario ( correo );

ALTER TABLE cuenta_usuario
    ADD CONSTRAINT cuenta_usuario_cuenta_fk FOREIGN KEY ( cuenta )
        REFERENCES cuenta ( nombre );

ALTER TABLE cuenta_usuario
    ADD CONSTRAINT cuenta_usuario_usuario_fk FOREIGN KEY ( usuario )
        REFERENCES usuario ( correo );

ALTER TABLE galeria
    ADD CONSTRAINT galeria_asset_fk FOREIGN KEY ( imagen )
        REFERENCES asset ( url );

ALTER TABLE galeria
    ADD CONSTRAINT galeria_atributo_fk
        FOREIGN KEY ( nombre,
                      producto )
            REFERENCES atributo ( nombre,
                                  producto );

ALTER TABLE producto
    ADD CONSTRAINT producto_cuenta_fk FOREIGN KEY ( cuenta )
        REFERENCES cuenta ( nombre );

ALTER TABLE propietario
    ADD CONSTRAINT propietario_pago_fk FOREIGN KEY ( pago )
        REFERENCES pago ( tarjeta );

ALTER TABLE propietario
    ADD CONSTRAINT propietario_usuario_fk FOREIGN KEY ( correo )
        REFERENCES usuario ( correo );

ALTER TABLE relacionado
    ADD CONSTRAINT relacionado_producto1_fk FOREIGN KEY ( producto1 )
        REFERENCES producto ( gtin );

ALTER TABLE relacionado
    ADD CONSTRAINT relacionado_producto2_fk FOREIGN KEY ( producto2 )
        REFERENCES producto ( gtin );

ALTER TABLE similar
    ADD CONSTRAINT similar_producto1_fk FOREIGN KEY ( producto1 )
        REFERENCES producto ( gtin );

ALTER TABLE similar
    ADD CONSTRAINT similar_producto2_fk FOREIGN KEY ( producto2 )
        REFERENCES producto ( gtin );

ALTER TABLE token
    ADD CONSTRAINT token_canal_fk FOREIGN KEY ( canal )
        REFERENCES canal ( url );

ALTER TABLE token
    ADD CONSTRAINT token_cuenta_fk FOREIGN KEY ( cuenta )
        REFERENCES cuenta ( nombre );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            17
-- CREATE INDEX                             1
-- ALTER TABLE                             43
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
