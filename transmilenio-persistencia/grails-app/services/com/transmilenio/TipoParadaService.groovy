package com.transmilenio

import grails.gorm.services.Service
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic

@SuppressWarnings(['UnusedVariable', 'SpaceAfterOpeningBrace', 'SpaceBeforeClosingBrace'])
@CompileStatic
@Service(TipoParada)
interface TipoParadaService {

    TipoParada get(Serializable id)

    List<TipoParada> list(Map args)

    Long count()

    void delete(Serializable id)

    TipoParada save(TipoParada tipoParada)

}