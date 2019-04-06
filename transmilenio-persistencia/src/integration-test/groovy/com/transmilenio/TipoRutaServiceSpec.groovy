package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoRutaServiceSpec extends Specification {

    TipoRutaService tipoRutaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoRuta(...).save(flush: true, failOnError: true)
        //new TipoRuta(...).save(flush: true, failOnError: true)
        //TipoRuta tipoRuta = new TipoRuta(...).save(flush: true, failOnError: true)
        //new TipoRuta(...).save(flush: true, failOnError: true)
        //new TipoRuta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoRuta.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoRutaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoRuta> tipoRutaList = tipoRutaService.list(max: 2, offset: 2)

        then:
        tipoRutaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoRutaService.count() == 5
    }

    void "test delete"() {
        Long tipoRutaId = setupData()

        expect:
        tipoRutaService.count() == 5

        when:
        tipoRutaService.delete(tipoRutaId)
        sessionFactory.currentSession.flush()

        then:
        tipoRutaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoRuta tipoRuta = new TipoRuta()
        tipoRutaService.save(tipoRuta)

        then:
        tipoRuta.id != null
    }
}
