ALTER TABLE rutas ADD CONSTRAINT rut_fk_idt FOREIGN KEY (id_tipo_ruta) REFERENCES tipos_rutas (id_tipo_ruta) ON DELETE CASCADE ON UPDATE CASCADE;