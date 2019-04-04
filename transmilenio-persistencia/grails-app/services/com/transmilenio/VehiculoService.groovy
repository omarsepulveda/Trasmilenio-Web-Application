package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(Vehiculo)
interface VehiculoService {

    Vehiculo get(Serializable id)

    List<Vehiculo> list(Map args)

    Long count()

    void delete(Serializable id)

    Vehiculo save(Vehiculo vehiculo)

}