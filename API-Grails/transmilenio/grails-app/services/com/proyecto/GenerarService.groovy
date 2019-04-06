package com.proyecto

import grails.gorm.services.Service

@Service(Generar)
interface GenerarService {

    Generar get(Serializable id)

}