ALTER TABLE estaciones ADD CONSTRAINT est_fk_idt FOREIGN KEY (id_troncal) REFERENCES troncales (id_troncal) ON DELETE CASCADE ON UPDATE CASCADE;