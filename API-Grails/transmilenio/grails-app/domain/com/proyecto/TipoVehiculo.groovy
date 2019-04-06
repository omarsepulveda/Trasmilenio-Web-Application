package com.proyecto

class TipoVehiculo {

    String nombre_tipo_vehiculo
    String descripcion_tipo_vehiculo
    String imagen_tipo_vehiculo

    static constraints = {
        nombre_tipo_vehiculo nullable:false
        descripcion_tipo_vehiculo nullable:true
        imagen_tipo_vehiculo nullable:true
    }
}
