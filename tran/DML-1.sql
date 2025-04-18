-- GNU GENERAL PUBLIC LICENSE
-- Version 3, 29 June 2007
--
-- Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
-- Everyone is permitted to copy and distribute verbatim copies
-- of this license document, but changing it is not allowed.

select GRUPO, CALIFICACION from DOCENCIA.MATRICULAR where DOCENCIA.MATRICULAR.ASIGNATURA = 112;
select ID from DOCENCIA.PROFESORES where DIRECTOR_TESIS is null;
select unique ID from PROFESORES left join DOCENCIA.IMPARTIR on PROFESORES.ID = IMPARTIR.PROFESOR where PROFESORES.DIRECTOR_TESIS is not null or IMPARTIR.ASIGNATURA is not null;
select substr(NOMBRE, 2) from DOCENCIA.ALUMNOS;
select NOMBRE from DOCENCIA.ASIGNATURAS where NOMBRE like 'B%';

select ALUMNO from DOCENCIA.MATRICULAR
where CALIFICACION is not null
  and CALIFICACION not like 'NP'
  and CALIFICACION not like 'SP';

select NOMBRE || ' -> ' || FECHA_PRIM_MATRICULA from DOCENCIA.ALUMNOS where LENGTH(NOMBRE) > 5;
select NOMBRE, MONTHS_BETWEEN(FECHA_PRIM_MATRICULA, '01-12-2013') as Meses from DOCENCIA.ALUMNOS;
select NOMBRE from DOCENCIA.ASIGNATURAS where CREDITOS < 6 and rownum = 1;
