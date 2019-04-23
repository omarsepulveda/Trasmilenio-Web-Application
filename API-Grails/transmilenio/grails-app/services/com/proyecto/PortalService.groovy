package com.proyecto

import grails.gorm.services.Service

@Service(Portal)
interface PortalService {

    Portal get(Serializable id)

    List<Portal> list(Map args)

    Long count()

    void delete(Serializable id)

    Portal save(Portal portal)

}