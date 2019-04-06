package com.transmilenio

import grails.gorm.services.Service

@Service(Nuevo)
interface NuevoService {

    Nuevo get(Serializable id)

    List<Nuevo> list(Map args)

    Long count()

    void delete(Serializable id)

    Nuevo save(Nuevo nuevo)

}