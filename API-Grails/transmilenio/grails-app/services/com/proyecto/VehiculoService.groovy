package com.proyecto

import grails.gorm.services.Service

@Service(Vehiculo)
interface VehiculoService {

    Vehiculo get(Serializable id)

    List<Vehiculo> list(Map args)

    Long count()

    void delete(Serializable id)

    Vehiculo save(Vehiculo vehiculo)

}