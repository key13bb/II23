create table DOC_TEXTO
(
    ASCII          VARCHAR2(1),
    NUM_LINEAS     NUMBER(3),
    NUM_CARACTERES NUMBER(3),
    TIPO           VARCHAR2(5),
    NOMBRE         VARCHAR2(100) not null,
    DIRECTORIO     VARCHAR2(100) not null,
    constraint DOC_TEXTO_PK
        primary key (NOMBRE, DIRECTORIO),
    constraint DOC_TEXTO_DOCUMENTO_NOMBRE_DIRECTORIO_FK
        foreign key (NOMBRE, DIRECTORIO) references DOCUMENTO
)
/

INSERT INTO UBD1006.DOC_TEXTO (ASCII, NUM_LINEAS, NUM_CARACTERES, TIPO, NOMBRE, DIRECTORIO) VALUES (null, null, null, null, 'Prueba.txt', '/user/practicas');
INSERT INTO UBD1006.DOC_TEXTO (ASCII, NUM_LINEAS, NUM_CARACTERES, TIPO, NOMBRE, DIRECTORIO) VALUES (null, null, null, null, 'Tesis.doc', '/user/enciso');
