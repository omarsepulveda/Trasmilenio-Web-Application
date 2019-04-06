package com.proyecto

import grails.gorm.services.Service

@Service(TipoVehiculo)
interface TipoVehiculoService {

    TipoVehiculo get(Serializable id)

    List<TipoVehiculo> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoVehiculo save(TipoVehiculo tipoVehiculo)

}