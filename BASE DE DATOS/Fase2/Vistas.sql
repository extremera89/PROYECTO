-- VISTA DE LAS EXPOSICIONES

CREATE OR REPLACE VIEW ListarExposiciones AS SELECT * FROM EXPOSICION;

SELECT * FROM ListarExposiciones;

-- VISTA DE TODAS LAS SALAS

CREATE OR REPLACE VIEW ListarSalasExp AS SELECT sala.NumSala, sala.tamanio, sala.dadaalta FROM Sala;

SELECT * FROM ListarSalasExp;

-- VISTA DE TODAS LAS SALAS QUE ESTÁN LIBRES

CREATE OR REPLACE VIEW ListarSalasLibres AS SELECT sala.NumSala, sala.tamanio FROM Sala 
WHERE sala.numSala not in (SELECT exposicion.numSala FROM Exposicion) WITH CHECK OPTION;

SELECT * FROM ListarSalasLibres;