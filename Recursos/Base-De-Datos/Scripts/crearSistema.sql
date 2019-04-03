CREATE OR REPLACE DATABASE transmilenio
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci

CREATE TABLE `troncales` (
  `id_troncal` int(11) AUTO_INCREMENT,
  `letra_troncal` char(1) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre_troncal` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `color_troncal` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_troncal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `portales` (
  `id_portal` int(11) AUTO_INCREMENT,
  `nombre_portal` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `imagen_portal` varchar(70) COLLATE utf8mb4_unicode_ci,
  `id_troncal` int(11),
  PRIMARY KEY (`id_portal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `estaciones` (
  `id_estacion` int(11) AUTO_INCREMENT,
  `nombre_estacion` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `imagen_estacion` varchar(70) COLLATE utf8mb4_unicode_ci,
  `id_troncal` int(11),
  PRIMARY KEY (`id_estacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `tipo_paradas` (
  `id_tipo_parada` int(11) AUTO_INCREMENT,
  `nombre_tipo_parada` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `imagen_tipo_parada` varchar(70) COLLATE utf8mb4_unicode_ci,
  `id_padre_tipo_parada` int(11),
  PRIMARY KEY (`id_tipo_parada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `direcciones` (
  `id_direccion` int(11) AUTO_INCREMENT,
  `nombre_direccion` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_padre_direccion` int(11),
  PRIMARY KEY (`id_direccion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `paraderos` (
  `id_paradero` int(11) AUTO_INCREMENT,
  `codigo_paradero` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_direccion` int(11),
  PRIMARY KEY (`id_paradero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `tipos_rutas` (
  `id_tipo_ruta` int(11) AUTO_INCREMENT,
  `nombre_tipo_ruta` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `color_tipo_ruta` varchar(6) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id_tipo_ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `rutas` (
  `id_ruta` int(11) AUTO_INCREMENT,
  `codigo_ruta` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre_ruta` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion_ruta` varchar(200) COLLATE utf8mb4_unicode_ci,
  `id_tipo_ruta` int(11) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id_ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `tipo_vehiculos` (
  `id_tipo_vehiculo` int(11) AUTO_INCREMENT,
  `nombre_tipo_vehiculo` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion_tipo_vehiculo` text COLLATE utf8mb4_unicode_ci,
  `imagen_tipo_vehiculo` varchar(70) COLLATE utf8mb4_unicode_ci,
  PRIMARY KEY (`id_tipo_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `vehiculos` (
  `id_vehiculo` int(11) AUTO_INCREMENT,
  `matricula` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL,
  `codigo_interno` varchar(6) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_tipo_vehiculo` int(11),
  PRIMARY KEY (`id_vehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `vehiculos_rutas` (
  `id_vehiculo` int(11),
  `id_ruta` int(11)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `dias_rutas` (
  `id_dias_ruta` int(11) AUTO_INCREMENT,
  `nombre_dias_ruta` varchar(70) COLLATE utf8mb4_unicode_ci NOT NULL,
  `siglas_dias_ruta` varchar(3) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id_dias_ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `horarios_rutas` (
  `id_horario_ruta` int(11) AUTO_INCREMENT,
  `dias_semana` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
  `hora_inicial` time COLLATE utf8mb4_unicode_ci NOT NULL,
  `hora_final` time COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_dias_ruta` int(11),
  `id_ruta` int(11),
  PRIMARY KEY (`id_horario_ruta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

CREATE TABLE `paradas` (
  `id_lugar_parada` int(11) AUTO_INCREMENT,
  `vagon` int(1) COLLATE utf8mb4_unicode_ci,
  `plataforma` int(10) COLLATE utf8mb4_unicode_ci,
  `id_tipo_parada` int(11),
  `id_ruta` int(11),
  `id_estacion` int(11),
  `id_paradero` int(11),
  `id_portal` int(11),
  PRIMARY KEY (`id_lugar_parada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci
