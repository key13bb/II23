CREATE TABLE TB_OBJETOS (
    NOMBRE VARCHAR2(128),
    CODIGO NUMBER,
    FECHA_CREACION DATE,
    FECHA_MODIFICACION DATE,
    TIPO VARCHAR2(23),
    ESQUEMA_ORIGINAL VARCHAR2(128)
)

DECLARE CURSOR KEYCURSOR IS
    SELECT OBJECT_NAME NOMBRE,
           OBJECT_ID CODIGO,
           CREATED FECHA_CREACION,
           LAST_DDL_TIME FECHA_MODIFICACION,
           OBJECT_TYPE TIPO,
           OWNER ESQUEMA_ORIGINAL
    FROM ALL_OBJECTS;
BEGIN
    FOR V_OBJECT IN KEYCURSOR LOOP
        INSERT INTO TB_OBJETOS VALUES (
                                       V_OBJECT.NOMBRE,
                                       V_OBJECT.CODIGO,
                                       V_OBJECT.FECHA_CREACION,
                                       V_OBJECT.FECHA_MODIFICACION,
                                       V_OBJECT.TIPO,
                                       V_OBJECT.ESQUEMA_ORIGINAL);
    END LOOP;
    COMMIT;
END;
/

