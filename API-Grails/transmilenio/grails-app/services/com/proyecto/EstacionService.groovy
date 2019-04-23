package com.proyecto

import grails.gorm.services.Service

@Service(Estacion)
interface EstacionService {

    Estacion get(Serializable id)

    List<Estacion> list(Map args)

    Long count()

    void delete(Serializable id)

    Estacion save(Estacion estacion)

}