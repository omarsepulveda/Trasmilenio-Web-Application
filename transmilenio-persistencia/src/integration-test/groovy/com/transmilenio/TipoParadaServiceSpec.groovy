package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoParadaServiceSpec extends Specification {

    TipoParadaService tipoParadaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoParada(...).save(flush: true, failOnError: true)
        //new TipoParada(...).save(flush: true, failOnError: true)
        //TipoParada tipoParada = new TipoParada(...).save(flush: true, failOnError: true)
        //new TipoParada(...).save(flush: true, failOnError: true)
        //new TipoParada(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoParada.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoParadaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoParada> tipoParadaList = tipoParadaService.list(max: 2, offset: 2)

        then:
        tipoParadaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoParadaService.count() == 5
    }

    void "test delete"() {
        Long tipoParadaId = setupData()

        expect:
        tipoParadaService.count() == 5

        when:
        tipoParadaService.delete(tipoParadaId)
        sessionFactory.currentSession.flush()

        then:
        tipoParadaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoParada tipoParada = new TipoParada()
        tipoParadaService.save(tipoParada)

        then:
        tipoParada.id != null
    }
}
