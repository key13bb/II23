select unique I.ASIGNATURA
    from IMPARTIR I
    where I.PROFESOR in (
        select I.PROFESOR
            from IMPARTIR I
            where I.ASIGNATURA = 112
        );
select unique D.NOMBRE
    from DEPARTAMENTOS D
    where D.CODIGO in (
        select unique A.DEPARTAMENTO
            from ASIGNATURAS A
            where A.CREDITOS < 6
        );
select unique M.ALUMNO
    from MATRICULAR M
    where M.ASIGNATURA in (
        select unique I.ASIGNATURA
            from IMPARTIR I
            where I.PROFESOR =
                (select unique P.ID, P.ANTIGUEDAD from PROFESORES P order by ANTIGUEDAD desc limit 1)
        ); /*Ya se que está mal*/


select unique P1.NOMBRE || ' ' || P1.APELLIDO1 || ' ' || P1.APELLIDO2 as "Profesor 1",
              P2.NOMBRE || ' ' || P2.APELLIDO1 || ' ' || P2.APELLIDO2 as "Profesor 2"
    from PROFESORES P1
    join PROFESORES P2 on P1.ID < P2.ID
    WHERE NOT EXISTS (
    SELECT 1
    FROM ALUMNOS A1
    JOIN MATRICULAR M1 ON A1.DNI = M1.ALUMNO
    JOIN ASIGNATURAS ASIG1 ON M1.ASIGNATURA = ASIG1.CODIGO
    JOIN IMPARTIR I1 ON ASIG1.CODIGO = I1.ASIGNATURA
    JOIN ALUMNOS A2 ON A1.DNI = A2.DNI
    JOIN MATRICULAR M2 ON A2.DNI = M2.ALUMNO
    JOIN ASIGNATURAS ASIG2 ON M2.ASIGNATURA = ASIG2.CODIGO
    JOIN IMPARTIR I2 ON ASIG2.CODIGO = I2.ASIGNATURA
    WHERE I1.PROFESOR = P1.ID
      AND I2.PROFESOR = P2.ID
);