select A.GENERO, round(avg(decode(CALIFICACION, 'MH',10,'SB',9,'NT',7,'AP',5,'SP',0, 'NP', 0, 0)), 2) Media
    from ALUMNOS A join MATRICULAR M on A.DNI = M.ALUMNO
    where M.CURSO = '21/22'
    group by A.GENERO;

select M.ASIGNATURA, round(avg(decode(CALIFICACION, 'MH',10,'SB',9,'NT',7,'AP',5,'SP',0,0)), 2) Media
    from MATRICULAR M
    where M.CALIFICACION in ('MH', 'SB', 'NT', 'AP')
    group by M.ASIGNATURA
    order by M.ASIGNATURA;

select unique P.ID, sum(nvl(I.CARGA_CREDITOS, 0)) as CRÉDITOS, P.DEPARTAMENTO
    from PROFESORES P join IMPARTIR I on P.ID = I.PROFESOR
    group by P.DEPARTAMENTO, P.ID
    order by P.DEPARTAMENTO desc;

select substr(M.NOMBRE, 1, 1) as Letra, sum(M.HOMBRES + M.MUJERES) as Habitantes, (
        min(M.HOMBRES + M.MUJERES)
    ) as Menor, (
        max(M.HOMBRES + M.MUJERES)
    ) as Mayor
    from MUNICIPIO M join PROVINCIA P on M.CPRO = P.CODIGO
    where P.NOMBRE = 'Málaga'
    group by substr(M.NOMBRE, 1, 1)
    order by Letra;

select substr(M.NOMBRE, 1, 1) as Letra, sum(M.HOMBRES + M.MUJERES) as Habitantes, (
        min(M.HOMBRES + M.MUJERES)
    ) as Menor, (
        max(M.HOMBRES + M.MUJERES)
    ) as Mayor
    from MUNICIPIO M join PROVINCIA P on M.CPRO = P.CODIGO
    where P.NOMBRE = 'Málaga'
    group by substr(M.NOMBRE, 1, 1)
    having sum(M.HOMBRES + M.MUJERES) > 10000
    order by Letra;

/***************************/

select *
    from DOCENCIA.PROFESORES P
    where P.ANTIGUEDAD || P.DEPARTAMENTO in (
        select min(P.ANTIGUEDAD) || P.DEPARTAMENTO
            from DOCENCIA.PROFESORES P
            group by P.DEPARTAMENTO
        )
    order by P.DEPARTAMENTO;

select *
    from (
        select A.DNI,
                count(M.ASIGNATURA)                                                                    as Asignaturas,
                round(avg(decode(M.CALIFICACION, 'MH', 10, 'SB', 9, 'NT', 7, 'AP', 5, 'SP', 0, 0)), 2) as Media
            from ALUMNOS A
                join MATRICULAR M on A.DNI = M.ALUMNO
        where decode(M.CALIFICACION, 'MH', 10, 'SB', 9, 'NT', 7, 'AP', 5, 'SP', 0, 0) > 5
        group by A.DNI
        order by Media desc, Asignaturas desc
    ) where rownum <= 3;

select A.DNI, A.NOMBRE || ' ' || A.APELLIDO1 || ' ' || A.APELLIDO2 as Nombre, A.EMAIL, trunc(months_between(sysdate, A.FECHA_NACIMIENTO) / 12, 0) as Edad
    from ALUMNOS A
        join MATRICULAR M on A.DNI = M.ALUMNO
    where M.ASIGNATURA = (
        select M.ASIGNATURA
            from MATRICULAR M
            group by M.ASIGNATURA
            having count(distinct M.ALUMNO) = (
                select max(count(distinct M.ALUMNO))
                    from MATRICULAR M
                    group by M.ASIGNATURA
            )
        )
    order by A.DNI;

select M.CURSO, round(sum(AP.Créditos)/sum("ALL".Créditos),3) as Rendimento
    from MATRICULAR M
        join ASIGNATURAS A on M.ASIGNATURA = A.CODIGO

        /* Alumnos con créditos obtenidos, agrupados por alumno y año */
        join (select nvl(sum(A.CREDITOS), 0) as Créditos, M.ALUMNO, M.CURSO
              from DOCENCIA.MATRICULAR M
                       join DOCENCIA.ASIGNATURAS A on M.ASIGNATURA = A.CODIGO
              where M.CALIFICACION in ('MH', 'SB', 'NT', 'AP')
              group by M.ALUMNO, M.CURSO) AP on AP.CURSO = M.CURSO

        /* Créditos totales de los que se han matriculado los alumnos */
        join (select M.ALUMNO, M.CURSO, nvl(sum(A.CREDITOS), 0) as Créditos
              from DOCENCIA.MATRICULAR M
                       join DOCENCIA.ASIGNATURAS A on M.ASIGNATURA = A.CODIGO
              group by M.ALUMNO, M.CURSO
              order by M.CURSO) "ALL" on "ALL".CURSO = M.CURSO
    group by M.CURSO
    order by M.CURSO;