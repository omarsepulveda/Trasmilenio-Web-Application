ALTER TABLE horarios_rutas ADD CONSTRAINT horr_fk_idd FOREIGN KEY (id_dias_ruta) REFERENCES dias_rutas (id_dias_ruta) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE horarios_rutas ADD CONSTRAINT horr_fk_idr FOREIGN KEY (id_ruta) REFERENCES rutas (id_ruta) ON DELETE CASCADE ON UPDATE CASCADE;