-- GNU GENERAL PUBLIC LICENSE
-- Version 3, 29 June 2007
--
-- Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
-- Everyone is permitted to copy and distribute verbatim copies
-- of this license document, but changing it is not allowed.

select P.NOMBRE,
       P.APELLIDO1,
       P.APELLIDO2
from PROFESORES P
where P.DEPARTAMENTO = 1;
select P.NOMBRE,
       P.APELLIDO1,
       P.APELLIDO2
from PROFESORES P
where P.DEPARTAMENTO != 3;
select P.NOMBRE,
       P.APELLIDO1,
       P.APELLIDO2
from PROFESORES P
where P.EMAIL like '%lcc.uma.es';
select A.NOMBRE,
       A.APELLIDO1,
       A.APELLIDO2
from DOCENCIA.ALUMNOS A
where A.EMAIL is null;
select A.NOMBRE,
       A.CREDITOS,
       ROUND(A.PRACTICOS / A.CREDITOS * 100) || '%' as PRÁCTICOS,
       ROUND(A.TEORICOS / A.CREDITOS * 100) || '%' as TEÓRICOS
from ASIGNATURAS A
where A.CURSO = 3;
select M.ALUMNO,
       M.CALIFICACION
from MATRICULAR M
where M.ASIGNATURA = 112
order by M.ALUMNO;
select M.NOMBRE,
       M.HOMBRES + M.MUJERES as POBLACIÓN
from MUNICIPIO M;
/* Funciones */
select (
              decode(
                     A.GENERO,
                     'MASC',
                     'El alumno ',
                     'FEM',
                     'La alumna ',
                     'La persona '
              ) || A.NOMBRE || ' ' || A.APELLIDO1 || ' ' || A.APELLIDO2 || ' no tiene correo'
       ) as "ALUMNOS SIN CORREO"
from DOCENCIA.ALUMNOS A
where A.EMAIL is null;
select P.NOMBRE,
       P.APELLIDO1,
       P.APELLIDO2
from PROFESORES P
where P.ANTIGUEDAD < TO_DATE('01/01/1990', 'DD/MM/YYYY');
select P.NOMBRE,
       P.APELLIDO1,
       P.APELLIDO2
from PROFESORES P
where MONTHS_BETWEEN(SYSDATE, P.FECHA_NACIMIENTO) / 12 < 30;
select UPPER(P.NOMBRE) as NOMBRE,
       UPPER(P.APELLIDO1) as APELLIDO1,
       UPPER(P.APELLIDO2) as APELLIDO2,
       TRUNC(MONTHS_BETWEEN(SYSDATE, P.ANTIGUEDAD) /(12 * 3)) as TRIENIOS
from PROFESORES P
where TRUNC(MONTHS_BETWEEN(SYSDATE, P.ANTIGUEDAD) / 12) >= 3;
select replace(
              upper(A.NOMBRE),
              'BASES DE DATOS',
              'ALMACENES DE DATOS'
       ) as NOMBRE
from ASIGNATURAS A
where upper(A.NOMBRE) like '%BASES DE DATOS%';
select A.NOMBRE,
       NVL(TO_CHAR(A.CREDITOS), 'No asignado') as CREDITOS
from ASIGNATURAS A
where A.CARACTER like 'O_';
select *
from ALUMNOS A
where MONTHS_BETWEEN(SYSDATE, A.FECHA_PRIM_MATRICULA) < 2;
select *
from ALUMNOS A
where MONTHS_BETWEEN(A.FECHA_PRIM_MATRICULA, A.FECHA_NACIMIENTO) / 12 < 18;
select *
from ALUMNOS A
where TO_CHAR(
              TO_DATE(A.FECHA_PRIM_MATRICULA, 'YYYY-MM-DD HH24:MI:SS'),
              'D',
              'NLS_DATE_LANGUAGE=SPANISH'
       ) = '1';
select *
from DOCENCIA.SOL_1_16;
