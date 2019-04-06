package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DiasRutaServiceSpec extends Specification {

    DiasRutaService diasRutaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new DiasRuta(...).save(flush: true, failOnError: true)
        //new DiasRuta(...).save(flush: true, failOnError: true)
        //DiasRuta diasRuta = new DiasRuta(...).save(flush: true, failOnError: true)
        //new DiasRuta(...).save(flush: true, failOnError: true)
        //new DiasRuta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //diasRuta.id
    }

    void "test get"() {
        setupData()

        expect:
        diasRutaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<DiasRuta> diasRutaList = diasRutaService.list(max: 2, offset: 2)

        then:
        diasRutaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        diasRutaService.count() == 5
    }

    void "test delete"() {
        Long diasRutaId = setupData()

        expect:
        diasRutaService.count() == 5

        when:
        diasRutaService.delete(diasRutaId)
        sessionFactory.currentSession.flush()

        then:
        diasRutaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        DiasRuta diasRuta = new DiasRuta()
        diasRutaService.save(diasRuta)

        then:
        diasRuta.id != null
    }
}
