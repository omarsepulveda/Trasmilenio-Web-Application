package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(VehiculoRuta)
interface VehiculoRutaService {

    VehiculoRuta get(Serializable id)

    List<VehiculoRuta> list(Map args)

    Long count()

    void delete(Serializable id)

    VehiculoRuta save(VehiculoRuta vehiculoRuta)

}