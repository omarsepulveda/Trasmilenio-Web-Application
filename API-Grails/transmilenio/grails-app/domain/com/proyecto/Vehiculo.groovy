package com.proyecto

class Vehiculo {
    static belongsTo = [tipo: TipoVehiculo]
    String matricula
    String codigo_interno

    static constraints = {
    }
}
