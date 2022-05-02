-- Listar todas las exposiciones

SELECT * 
FROM Exposicion;

-- Listar exposiciones fijas

SELECT * 
FROM Exposicion
WHERE FechaFin Is Null;

-- Listar exposiciones temporales

SELECT * 
FROM Exposicion
WHERE FechaFin IS NOT NULL;

-- Listar exposiciones temática "Prehistoria"

SELECT * 
FROM Exposicion
WHERE Tematica = 'Prehistoria';

-- Listar monitores
SELECT persona.dni, persona.nombre, persona.apellido1, persona.apellido2, persona.telefono, persona.email, monitor.titulacion 
FROM Persona INNER JOIN Monitor ON persona.DNI = monitor.DNI;


-- Listar monitores con una visita asignada
SELECT persona.dni, persona.nombre, persona.apellido1, persona.apellido2, persona.telefono, persona.email, monitor.titulacion, visitaguiada.centro
FROM Persona INNER JOIN Monitor ON persona.DNI = monitor.DNI INNER JOIN VisitaGuiada ON monitor.DNI = VisitaGuiada.DNI_monitor;

-- Listar clientes con reservas
SELECT cliente.DNI as "Clientes con Reserva"
FROM Cliente INNER JOIN Reserva ON cliente.DNI = reserva.DNI;

-- Listar clientes sin reserva

SELECT cliente.DNI AS "Clientes sin reserva"
FROM Cliente
WHERE cliente.DNI NOT IN(SELECT reserva.DNI FROM Reserva);

-- Listar clientes que hagan visitas

SELECT cliente.DNI AS "Clientes que son visitantes"
FROM Cliente
WHERE cliente.DNI NOT IN(SELECT reserva.DNI FROM Reserva);

-- Listar reservas

SELECT *
FROM Reserva;

-- Listar todas las salas

SELECT *
FROM Sala;

-- Listar salas libres

SELECT sala.NumSala, sala.tamanio 
FROM Sala 
WHERE sala.numSala NOT IN (SELECT exposicion.numSala FROM Exposicion);

-- Listar salas que tengan una exposición

SELECT sala.NumSala, sala.tamanio 
FROM Sala 
WHERE sala.numSala IN (SELECT exposicion.numSala FROM Exposicion);

-- Listar salas que no estén dadas de alta

SELECT *
FROM Sala
WHERE dadaalta = '0';

-- Listar salas con reserva

SELECT sala.numSala, sala.tamanio
FROM Sala 
WHERE sala.numSala IN (SELECT reserva.numSala FROM Reserva);










