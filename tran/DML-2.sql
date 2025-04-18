-- GNU GENERAL PUBLIC LICENSE
-- Version 3, 29 June 2007
--
-- Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
-- Everyone is permitted to copy and distribute verbatim copies
-- of this license document, but changing it is not allowed.

select A.NOMBRE, A.APELLIDO1, A.APELLIDO2, M.CALIFICACION
    from ALUMNOS A join MATRICULAR M on A.DNI = M.ALUMNO
    where M.ASIGNATURA = 112
        and M.CALIFICACION in ('AP', 'NT', 'SB', 'MH');

select AL.NOMBRE, AG.NOMBRE, M.GRUPO
    from ALUMNOS AL
        join MATRICULAR M on AL.DNI = M.ALUMNO
        join ASIGNATURAS AG on M.ASIGNATURA = AG.CODIGO;

select unique AL.NOMBRE, AG.NOMBRE, M.CALIFICACION, P.NOMBRE
    from ALUMNOS AL
        join MATRICULAR M on AL.DNI = M.ALUMNO
        join ASIGNATURAS AG on M.ASIGNATURA = AG.CODIGO
        join IMPARTIR I on AG.CODIGO = I.ASIGNATURA
        join PROFESORES P on I.PROFESOR = P.ID
    where M.CALIFICACION in ('AP', 'NT', 'SB', 'MH') and M.GRUPO = I.GRUPO;

select P.*, PR.* from PROFESORES P
    left join PROFESORES PR on P.ID = PR.DIRECTOR_TESIS
    where P.ID is not null order by PR.ID;
