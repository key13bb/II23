CREATE TABLE agente (
    cuenta_nombre VARCHAR2(300 CHAR) NOT NULL,
    correo        VARCHAR2(500 CHAR) NOT NULL
);

ALTER TABLE agente ADD CONSTRAINT agente_pk PRIMARY KEY ( correo );

CREATE TABLE archivo (
    nombre        VARCHAR2(100 CHAR) NOT NULL,
    url           VARCHAR2(1000 CHAR) NOT NULL,
    producto_gtin INTEGER NOT NULL,
    cuenta_nombre VARCHAR2(300 CHAR) NOT NULL
);

ALTER TABLE archivo ADD CONSTRAINT archivo_pk PRIMARY KEY ( producto_gtin,
                                                            url );

CREATE TABLE atributo (
    nombre        VARCHAR2(250 CHAR),
    contenido     VARCHAR2(500 CHAR),
    producto_gtin INTEGER NOT NULL
);

ALTER TABLE atributo ADD CONSTRAINT atributo_pk PRIMARY KEY ( producto_gtin );

CREATE TABLE canal (
    nombre VARCHAR2(100 CHAR) NOT NULL,
    url    VARCHAR2(500 CHAR) NOT NULL,
    token  VARCHAR2(1000 CHAR) NOT NULL
);

ALTER TABLE canal ADD CONSTRAINT canal_pk PRIMARY KEY ( url );

CREATE TABLE categoria (
    nombre                VARCHAR2(100 CHAR) NOT NULL,
    producto_gtin         INTEGER NOT NULL,
    archivo_producto_gtin INTEGER NOT NULL,
    archivo_url           VARCHAR2(1000 CHAR) NOT NULL
);

ALTER TABLE categoria
    ADD CONSTRAINT categoria_pk PRIMARY KEY ( producto_gtin,
                                              archivo_producto_gtin,
                                              nombre );

CREATE TABLE cuenta (
    nombre             VARCHAR2(300 CHAR) NOT NULL,
    fecha_creacion     TIMESTAMP NOT NULL,
    logo_url           VARCHAR2(500 CHAR),
    propietario_correo VARCHAR2(500 CHAR) NOT NULL,
    pago_tarjeta       VARCHAR2(20 CHAR) NOT NULL,
    plan               VARCHAR2(10 CHAR) NOT NULL
);

CREATE UNIQUE INDEX cuenta__idx ON
    cuenta (
        propietario_correo
    ASC );

ALTER TABLE cuenta ADD CONSTRAINT cuenta_pk PRIMARY KEY ( nombre );

CREATE TABLE galeria (
    etiqueta VARCHAR2(100 CHAR) NOT NULL,
    imagen   VARCHAR2(1000 CHAR) NOT NULL,
    gtin1    INTEGER NOT NULL
);

ALTER TABLE galeria ADD CONSTRAINT galeria_pk PRIMARY KEY ( gtin1 );

ALTER TABLE galeria ADD CONSTRAINT galeria_pkv1 UNIQUE ( etiqueta,
                                                         imagen );

CREATE TABLE pago (
    nombre  VARCHAR2(100 CHAR),
    url     VARCHAR2(500 CHAR),
    tarjeta VARCHAR2(20 CHAR) NOT NULL
);

ALTER TABLE pago ADD CONSTRAINT pago_pk PRIMARY KEY ( tarjeta );

CREATE TABLE producto (
    gtin          INTEGER NOT NULL,
    sku           VARCHAR2(5 CHAR) NOT NULL,
    creacion      TIMESTAMP NOT NULL,
    modificado    TIMESTAMP,
    img_principal BLOB,
    cuenta_nombre VARCHAR2(300 CHAR) NOT NULL
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( gtin );

CREATE TABLE propietario (
    cuenta_nombre VARCHAR2(300 CHAR) NOT NULL,
    correo        VARCHAR2(500 CHAR) NOT NULL
);

CREATE UNIQUE INDEX propietario__idx ON
    propietario (
        cuenta_nombre
    ASC );

ALTER TABLE propietario ADD CONSTRAINT propietario_pk PRIMARY KEY ( correo );

CREATE TABLE relacion (
    archivo_gtin   INTEGER NOT NULL,
    producto_gtin  INTEGER NOT NULL,
    producto_gtin2 INTEGER NOT NULL,
    es_similar     CHAR(1) NOT NULL,
    archivo_url    VARCHAR2(1000 CHAR) NOT NULL
);

ALTER TABLE relacion
    ADD CONSTRAINT relacion_pk PRIMARY KEY ( producto_gtin,
                                             producto_gtin2,
                                             archivo_gtin );

CREATE TABLE usuario (
    nombre        VARCHAR2(250 CHAR) NOT NULL,
    correo        VARCHAR2(500 CHAR) NOT NULL,
    avatar        VARCHAR2(500 CHAR),
    cuenta_nombre VARCHAR2(300 CHAR) NOT NULL,
    canal_url     VARCHAR2(500 CHAR) NOT NULL
);

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( correo );

ALTER TABLE agente
    ADD CONSTRAINT agente_cuenta_fk FOREIGN KEY ( cuenta_nombre )
        REFERENCES cuenta ( nombre );

ALTER TABLE agente
    ADD CONSTRAINT agente_usuario_fk FOREIGN KEY ( correo )
        REFERENCES usuario ( correo );

ALTER TABLE archivo
    ADD CONSTRAINT archivo_cuenta_fk FOREIGN KEY ( cuenta_nombre )
        REFERENCES cuenta ( nombre );

ALTER TABLE archivo
    ADD CONSTRAINT archivo_producto_fk FOREIGN KEY ( producto_gtin )
        REFERENCES producto ( gtin );

ALTER TABLE atributo
    ADD CONSTRAINT atributo_producto_fk FOREIGN KEY ( producto_gtin )
        REFERENCES producto ( gtin );

ALTER TABLE categoria
    ADD CONSTRAINT categoria_archivo_fk
        FOREIGN KEY ( archivo_producto_gtin,
                      archivo_url )
            REFERENCES archivo ( producto_gtin,
                                 url );

ALTER TABLE categoria
    ADD CONSTRAINT categoria_producto_fk FOREIGN KEY ( producto_gtin )
        REFERENCES producto ( gtin );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_pago_fk FOREIGN KEY ( pago_tarjeta )
        REFERENCES pago ( tarjeta );

ALTER TABLE cuenta
    ADD CONSTRAINT cuenta_propietario_fk FOREIGN KEY ( propietario_correo )
        REFERENCES propietario ( correo );

ALTER TABLE galeria
    ADD CONSTRAINT galeria_atributo_fk FOREIGN KEY ( gtin1 )
        REFERENCES atributo ( producto_gtin );

ALTER TABLE producto
    ADD CONSTRAINT producto_cuenta_fk FOREIGN KEY ( cuenta_nombre )
        REFERENCES cuenta ( nombre );

ALTER TABLE propietario
    ADD CONSTRAINT propietario_cuenta_fk FOREIGN KEY ( cuenta_nombre )
        REFERENCES cuenta ( nombre );

ALTER TABLE propietario
    ADD CONSTRAINT propietario_usuario_fk FOREIGN KEY ( correo )
        REFERENCES usuario ( correo );

ALTER TABLE relacion
    ADD CONSTRAINT relacion_archivo_fk
        FOREIGN KEY ( archivo_gtin,
                      archivo_url )
            REFERENCES archivo ( producto_gtin,
                                 url );

ALTER TABLE relacion
    ADD CONSTRAINT relacion_producto_fk FOREIGN KEY ( producto_gtin )
        REFERENCES producto ( gtin );

ALTER TABLE relacion
    ADD CONSTRAINT relacion_producto_fkv2 FOREIGN KEY ( producto_gtin2 )
        REFERENCES producto ( gtin );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_canal_fk FOREIGN KEY ( canal_url )
        REFERENCES canal ( url );

ALTER TABLE usuario
    ADD CONSTRAINT usuario_cuenta_fk FOREIGN KEY ( cuenta_nombre )
        REFERENCES cuenta ( nombre );