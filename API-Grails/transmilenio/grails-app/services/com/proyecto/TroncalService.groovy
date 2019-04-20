package com.proyecto

import grails.gorm.services.Service

@Service(Troncal)
interface TroncalService {

    Troncal get(Serializable id)

    List<Troncal> list(Map args)

    Long count()

    void delete(Serializable id)

    Troncal save(Troncal troncal)

}