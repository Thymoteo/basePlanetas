use planetas_db;

INSERT INTO classe_planeta
	VALUES ('A','Gigante Gasoso'),
		   ('B','Sulfurico'),
           ('C','Tóxico'),
           ('D','Habitável');
           
INSERT INTO quadrante_estelar
	VALUES (1,'Alfa'),
		   (2,'Beta'),
           (3,'Gama'),
           (4,'Delta');
           
INSERT INTO tipo_atmosfera
	VALUES (1,'Oxigênio'),
		   (2,'Metano'),
           (3,'Hidrogênio');
           
INSERT INTO planeta 
	VALUES (1,'Titã',10000,5000,true,'1994/12/22','C',1,3),
		   (2,'Terra',10000,5000,true,'1994/12/01','A',1,3);
           (3,'Marte',50000,5000,false,'2000/05/01','B',2,4);
