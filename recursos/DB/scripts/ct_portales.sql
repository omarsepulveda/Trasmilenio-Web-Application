ALTER TABLE portales ADD CONSTRAINT por_fk_idt FOREIGN KEY (id_troncal) REFERENCES troncales (id_troncal) ON DELETE CASCADE ON UPDATE CASCADE;