ALTER TABLE portales ADD CONSTRAINT por_fk_idt FOREIGN KEY (id_troncal) REFERENCES troncales (id_troncal) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE estaciones ADD CONSTRAINT est_fk_idt FOREIGN KEY (id_troncal) REFERENCES troncales (id_troncal) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE tipos_paradas ADD CONSTRAINT tpa_fk_idp FOREIGN KEY (id_padre_tipo_parada) REFERENCES tipos_paradas (id_tipo_parada) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE direcciones ADD CONSTRAINT dir_fk_idp FOREIGN KEY (id_padre_direccion) REFERENCES direcciones (id_direccion) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE paraderos ADD CONSTRAINT par_fk_idd FOREIGN KEY (id_direccion) REFERENCES direcciones (id_direccion) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE vehiculos ADD CONSTRAINT veh_fk_idt FOREIGN KEY (id_tipo_vehiculo) REFERENCES tipos_vehiculos (id_tipo_vehiculo) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE rutas ADD CONSTRAINT rut_fk_idt FOREIGN KEY (id_tipo_ruta) REFERENCES tipos_rutas (id_tipo_ruta) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE horarios_rutas ADD CONSTRAINT horr_fk_idd FOREIGN KEY (id_dias_ruta) REFERENCES dias_rutas (id_dias_ruta) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE horarios_rutas ADD CONSTRAINT horr_fk_idr FOREIGN KEY (id_ruta) REFERENCES rutas (id_ruta) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE vehiculos_rutas ADD CONSTRAINT ver_fk_idv FOREIGN KEY (id_vehiculo) REFERENCES vehiculos (id_vehiculo) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE vehiculos_rutas ADD CONSTRAINT ver_fk_idr FOREIGN KEY (id_ruta) REFERENCES rutas (id_ruta) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE paradas ADD CONSTRAINT par_fk_tip FOREIGN KEY (id_tipo_parada) REFERENCES tipos_paradas (id_tipo_parada) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE paradas ADD CONSTRAINT par_fk_idr FOREIGN KEY (id_ruta) REFERENCES rutas (id_ruta) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE paradas ADD CONSTRAINT par_fk_ide FOREIGN KEY (id_estacion) REFERENCES estaciones (id_estacion) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE paradas ADD CONSTRAINT par_fk_idpa FOREIGN KEY (id_paradero) REFERENCES paraderos (id_paradero) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE paradas ADD CONSTRAINT par_fk_idpo FOREIGN KEY (id_portal) REFERENCES portales (id_portal) ON DELETE CASCADE ON UPDATE CASCADE;
