INSERT INTO TB_Documento (nombre, tipo, contenido,fecha_creacion) 
VALUES ('documento1.doc', 'doc', null,CURRENT_DATE);

INSERT INTO TB_Documento (nombre, tipo, contenido,fecha_creacion) 
VALUES ('documento2.doc', 'doc', null,CURRENT_DATE);

INSERT INTO TB_Documento (nombre, tipo, contenido,fecha_creacion)
VALUES ('imagen1.jpg', 'jpg', null,CURRENT_DATE);

INSERT INTO TB_Documento (nombre, tipo, contenido,fecha_creacion)
VALUES ('imagen2.jpg', 'jpg', null,CURRENT_DATE);

INSERT INTO TB_Documento (nombre, tipo, contenido,fecha_creacion)
VALUES ('documento3.doc', 'doc', null,CURRENT_DATE);

INSERT INTO TB_Documento (nombre, tipo, contenido,fecha_creacion)
VALUES ('documento09042024.jpg', 'jpg', null,CURRENT_DATE);

INSERT INTO TB_Documento (nombre, tipo, contenido,fecha_creacion)
VALUES ('documento09042024.doc', 'doc', null,CURRENT_DATE);
INSERT INTO TB_Documento (nombre, tipo, contenido,fecha_creacion)
VALUES ('status.json', 'json', null,CURRENT_DATE);
INSERT INTO TB_Documento (nombre, tipo, contenido,fecha_creacion)
VALUES ('documento22.doc', 'doc', null,CURRENT_DATE);

select * from TB_Documento;
select * from TB_Documento where fecha_creacion::date = CURRENT_DATE;
select * from tb_documentodoc;
select * from tb_documentoimg;
--delete from tb_documentodoc;
--delete from tb_documentoimg;

--Prueba aplicacion: he creado dos documentos en la tabla TB_Documento:documento09042024.jpg,documento09042024.doc,status.json y me tiene que meter en la tabla 
--tb_documentodoc un documento y en la tb_documentoimg otro. No tiene que almacenar el status.json
--y en el servidor tiene que meter los 3 ficheros

SELECT * FROM TB_Documento WHERE fecha_creacion >= CURRENT_DATE AND fecha_creacion < CURRENT_DATE + INTERVAL '1 day'
--decodificar el churro de bites del documento
--=======================================================
SELECT id, nombre, FROM_BASE64(contenido) AS contenido_decodificado
FROM TB_Documento;

SELECT id, nombre, decode(contenido, 'base64') AS contenido_decodificado
FROM TB_Documento;

SQL Error [42883]: ERROR: no existe la función decode(bytea, unknown)
  Hint: Ninguna función coincide en el nombre y tipos de argumentos. Puede ser necesario agregar conversión explícita de tipos.
  Position: 20
  
  SELECT id, nombre, convert_from(decode(contenido, 'base64'), 'UTF8') AS contenido_decodificado
FROM TB_Documento;
SQL Error [42883]: ERROR: no existe la función decode(bytea, unknown)
  Hint: Ninguna función coincide en el nombre y tipos de argumentos. Puede ser necesario agregar conversión explícita de tipos.
  Position: 33

