--1--
SELECT d.nombre,
    COUNT(p.id) AS numero_profesores
FROM Departamentos d
    JOIN Profesores p ON d.codigo = p.departamento
GROUP BY d.nombre;
SELECT *
FROM SOL_3_1;
--2--
SELECT d.nombre,
    SUM(A.creditos) AS total_creditos
FROM Departamentos d
    JOIN Asignaturas A ON d.codigo = A.departamento
GROUP BY d.nombre;
SELECT *
FROM SOL_3_2;
--3--
SELECT A.curso,
    COUNT(DISTINCT m.alumno) AS "NUMERO ALUMNOS"
FROM asignaturas A
    JOIN Matricular m ON A.codigo = m.asignatura
WHERE A.curso IS NOT NULL
GROUP BY A.curso;
SELECT *
FROM SOL_3_3;
--4--
SELECT SUM(I.CARGA_CREDITOS) AS CREDITOS,
    P.DESPACHO
FROM PROFESORES P
    JOIN IMPARTIR I ON P.ID = I.PROFESOR
GROUP BY P.DESPACHO;
SELECT *
FROM SOL_3_4;
--5--
SELECT m.asignatura,
    COUNT(
        CASE
            WHEN A.genero = 'FEM' THEN 1
        END
    ) * 100 / COUNT(*) AS "PORCENTAJE ALUMNAS"
FROM matricular m
    JOIN alumnos A ON m.alumno = A.dni
GROUP BY m.asignatura
ORDER BY m.asignatura;
SELECT *
FROM SOL_3_5;
--6--
SELECT p.nombre,
    SUM(m.mujeres) + SUM(m.hombres) AS "SUMA"
FROM provincia p
    JOIN municipio m ON p.codigo = m.cpro
GROUP BY p.nombre
ORDER BY p.nombre;
SELECT *
FROM SOL_3_6;
--7--
SELECT d.nombre AS "DEPARTAMENTO",
    p.nombre || ' ' || p.apellido1 AS "PROFESOR"
FROM Profesores p
    JOIN departamentos d ON p.departamento = d.codigo
WHERE (p.departamento, p.fecha_nacimiento) IN (
        SELECT departamento,
            MIN(fecha_nacimiento)
        FROM Profesores
        GROUP BY departamento
    );
SELECT *
FROM SOL_3_7;
--8--
SELECT DISTINCT al.dni AS "ALUMNO",
    A.codigo,
    A.nombre
FROM Alumnos al
    JOIN Matricular m ON al.dni = m.alumno
    JOIN Asignaturas A ON m.asignatura = A.codigo
WHERE (al.dni, A.creditos) IN (
        SELECT m.alumno,
            MAX(A.creditos)
        FROM Asignaturas a2
            JOIN Matricular m2 ON a2.codigo = m2.asignatura
        GROUP BY m.alumno
    );
--9--
SELECT d.nombre AS "DEPARTAMENTO",
    p.nombre || ' ' || p.apellido1 AS "PROFESOR"
FROM Profesores p
    JOIN departamentos d ON p.departamento = d.codigo
WHERE (departamento, antiguedad) IN (
        SELECT departamento,
            MIN(antiguedad)
        FROM Profesores
        GROUP BY departamento
    );
--10--
SELECT d.nombre AS "DEPARTAMENTO",
    a.nombre AS "ASIGNATURA"
FROM Asignaturas a
    JOIN Departamentos d ON a.departamento = d.codigo
WHERE (departamento, creditos) IN (
        SELECT departamento,
            MIN(creditos)
        FROM Asignaturas
        GROUP BY departamento
    );
--11--
SELECT DISTINCT a.nombre AS "ASIGNATURA",
    al.nombre || ' ' || al.apellido1 || ' ' || al.apellido2 AS "ALUMNO",
    al.fecha_nacimiento
FROM Asignaturas a
    JOIN Matricular m ON a.codigo = m.asignatura
    JOIN Alumnos al ON m.alumno = al.dni
WHERE (m.asignatura, al.fecha_nacimiento) IN (
        SELECT m2.asignatura,
            MAX(al2.fecha_nacimiento)
        FROM Alumnos al2
            JOIN Matricular m2 ON al2.dni = m2.alumno
        WHERE m2.curso LIKE '20/21'
        GROUP BY m2.asignatura
    )
ORDER BY a.nombre;
--12--
SELECT p.nombre || ' ' || p.apellido1 AS "PROFESOR",
    SUM(i.carga_creditos) AS "CRÉDITOS"
FROM Impartir i
    JOIN Profesores p ON i.profesor = p.id
GROUP BY p.nombre,
    p.apellido1
HAVING SUM(i.carga_creditos) = (
        SELECT MAX(carga_total_creditos)
        FROM (
                SELECT SUM(i2.carga_creditos) AS carga_total_creditos
                FROM Impartir i2
                GROUP BY i2.profesor
            )
    );
--13--
SELECT d.nombre
FROM Asignaturas a
    JOIN Departamentos d ON a.departamento = d.codigo
GROUP BY d.nombre
HAVING COUNT(a.codigo) = (
        SELECT MAX(numero_asignaturas)
        FROM (
                SELECT COUNT(codigo) AS numero_asignaturas
                FROM Asignaturas
                GROUP BY departamento
            )
    );
--14--
SELECT profesor,
    SUM(carga_creditos) AS "CRÉDITOS"
FROM Impartir
GROUP BY profesor
HAVING SUM(carga_creditos) < 10;
--15--
SELECT p.nombre,
    p.apellido1,
    p.apellido2
FROM Impartir i
    JOIN Profesores p ON i.profesor = p.id
GROUP BY p.nombre,
    p.apellido1,
    p.apellido2
HAVING SUM(i.carga_creditos) > (
        SELECT AVG(total_creditos)
        FROM (
                SELECT SUM(carga_creditos) AS total_creditos
                FROM Impartir
                GROUP BY profesor
            )
    );
--16--
SELECT i.profesor
FROM Impartir i
    JOIN Asignaturas a ON i.asignatura = a.codigo
WHERE i.curso = '22/23'
GROUP BY i.profesor
HAVING COUNT(i.asignatura) >= 2
    AND AVG(a.creditos) < 6.5;
--17--
SELECT a.nombre
FROM Asignaturas a
WHERE a.codigo NOT IN (
        SELECT asignatura
        FROM Matricular
        WHERE calificacion IN ('AP', 'NT', 'SB')
    );
--18--
SELECT nombre
FROM Departamentos
WHERE codigo NOT IN (
        SELECT departamento
        FROM Asignaturas
        WHERE creditos > 6
    );
--19--
SELECT p.nombre
FROM Profesores p
    JOIN Impartir i ON p.id = i.profesor
    JOIN Asignaturas a ON i.asignatura = a.codigo
WHERE a.caracter = 'OP'
    AND i.asignatura NOT IN (
        SELECT m.asignatura
        FROM Matricular m
    )
ORDER BY p.nombre;
SELECT p.nombre,
    p.apellido1,
    p.apellido2
FROM profesores p
    JOIN impartir i ON (p.id = i.profesor)
    JOIN asignaturas a ON (i.asignatura = a.codigo)
WHERE a.caracter = 'OP'
    AND (i.asignatura, i.curso, i.grupo) NOT IN (
        SELECT asignatura,
            curso,
            grupo
        FROM matricular
    )
ORDER BY p.apellido1,
    p.apellido2,
    p.nombre;
--20--
SELECT DISTINCT p1.nombre || ' ' || p1.apellido1 || ' ' || p1.apellido2 "PROFESOR 1",
    p2.nombre || ' ' || p2.apellido1 || ' ' || p2.apellido2 "PROFESOR 2"
FROM profesores p1,
    profesores p2
WHERE p1.id < p2.id
    AND NOT EXISTS (
        (
            SELECT alumno
            FROM matricular
                NATURAL JOIN impartir
            WHERE profesor = p1.id
        )
        INTERSECT
        (
            SELECT alumno
            FROM matricular
                NATURAL JOIN impartir
            WHERE profesor = p2.id
        )
    );
--21--
SELECT p1.nombre || ' ' || p1.apellido1 || ' ' || p1.apellido2 AS profesor1,
    p2.nombre || ' ' || p2.apellido1 || ' ' || p2.apellido2 AS profesor2
FROM profesores p1
    JOIN profesores p2 ON p1.id < p2.id
WHERE (p1.id, p2.id) NOT IN (
        SELECT i1.profesor,
            i2.profesor
        FROM impartir i1
            JOIN impartir i2 ON i1.asignatura = i2.asignatura
    )
ORDER BY p1.nombre,
    p1.apellido1,
    p1.apellido2;
--22--
SELECT asi.nombre
FROM asignaturas asi
WHERE asi.codigo NOT IN (
        SELECT m1.asignatura
        FROM matricular m1
            JOIN alumnos a1 ON m1.alumno = a1.dni
            JOIN matricular m2 ON m1.asignatura = m2.asignatura
            JOIN alumnos a2 ON m2.alumno = a2.dni
        WHERE a1.cmun = a2.cmun
            AND a1.dni < a2.dni
    );
--23--
SELECT DISTINCT alumno
FROM matricular
    NATURAL JOIN impartir
    JOIN profesores p ON (profesor = p.id)
WHERE p.fecha_nacimiento NOT IN (
        SELECT MIN(fecha_nacimiento)
        FROM profesores
    );
--24--
SELECT m.alumno
FROM matricular m
GROUP BY m.alumno
HAVING COUNT(*) > 2
    AND m.alumno NOT IN (
        SELECT alumno
        FROM matricular m
            NATURAL JOIN impartir im
            JOIN profesores p ON (p.id = im.profesor)
            JOIN departamentos d ON (p.departamento = d.codigo)
        WHERE d.nombre = 'Matematica Aplicada'
    );
--25--
SELECT a.codigo,
    a.departamento
FROM asignaturas a
WHERE a.creditos = (
        SELECT MAX(creditos)
        FROM asignaturas
        WHERE a.departamento = departamento
    )
    AND a.codigo NOT IN (
        SELECT im.asignatura
        FROM impartir im
            JOIN profesores p ON (im.profesor = p.id)
        WHERE TO_CHAR (p.fecha_nacimiento, 'YYYY') < 1970
    );
--26--
SELECT d.nombre AS departamento,
    SUM(a.creditos) AS carga_total_creditos
FROM departamentos d
    JOIN asignaturas a ON d.codigo = a.departamento
WHERE d.codigo IN (
        SELECT a2.departamento
        FROM asignaturas a2
            JOIN matricular m ON a2.codigo = m.asignatura
        GROUP BY a2.departamento
        HAVING COUNT(DISTINCT m.alumno) > 10
    )
GROUP BY d.nombre
ORDER BY carga_total_creditos DESC;
--27--
SELECT profesor,
    COUNT(alumno) AS "Alumnos"
FROM impartir
    NATURAL JOIN matricular
WHERE profesor IS NOT NULL
    AND profesor IN (
        SELECT i.profesor
        FROM impartir i
            JOIN asignaturas a ON a.codigo = asignatura
        WHERE NVL (a.practicos, 0) > NVL (a.teoricos, 0)
    )
GROUP BY profesor;
--28--
SELECT al.nombre,
    al.apellido1
FROM (
        SELECT m.asignatura
        FROM matricular m
        WHERE m.curso = '20/21'
        GROUP BY m.asignatura
        HAVING COUNT(m.alumno) > 3
    ) a
    JOIN matricular m ON (m.asignatura = a.asignatura)
    JOIN alumnos al ON (al.dni = m.alumno)
WHERE al.fecha_prim_matricula = (
        SELECT MIN(al2.fecha_prim_matricula)
        FROM alumnos al2
            JOIN matricular m2 ON (m2.alumno = al2.dni)
        WHERE m2.asignatura = a.asignatura
    );
--29--
SELECT a.nombre AS "ASIGNATURA",
    (
        SELECT COUNT(DISTINCT im.profesor)
        FROM impartir im
        WHERE im.asignatura = a.codigo
            AND im.curso = '21/22'
    ) AS "NÚMERO DE PROFESORES"
FROM asignaturas a
WHERE a.codigo IN (
        SELECT m.asignatura
        FROM matricular m
        WHERE m.curso = '21/22'
        GROUP BY m.asignatura
        HAVING COUNT(m.alumno) < 16
    )
    AND a.departamento = (
        SELECT codigo
        FROM departamentos
        ORDER BY fecha_creacion
        FETCH FIRST 1 ROWS ONLY
    )
ORDER BY a.nombre;
--30--
SELECT DISTINCT im.profesor AS "PROFESOR"
FROM impartir im
    JOIN matricular m ON im.asignatura = m.asignatura
WHERE im.profesor IN (
        SELECT im2.profesor
        FROM impartir im2
        GROUP BY im2.profesor
        HAVING COUNT(DISTINCT im2.asignatura) >= 2
    )
    AND m.alumno IN (
        SELECT al.dni
        FROM alumnos al
        WHERE TO_CHAR (al.fecha_nacimiento, 'YYYY') < '2001'
    )
ORDER BY im.profesor;