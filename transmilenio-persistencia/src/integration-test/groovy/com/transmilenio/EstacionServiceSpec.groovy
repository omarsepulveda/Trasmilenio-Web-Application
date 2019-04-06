package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class EstacionServiceSpec extends Specification {

    EstacionService estacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Estacion(...).save(flush: true, failOnError: true)
        //new Estacion(...).save(flush: true, failOnError: true)
        //Estacion estacion = new Estacion(...).save(flush: true, failOnError: true)
        //new Estacion(...).save(flush: true, failOnError: true)
        //new Estacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //estacion.id
    }

    void "test get"() {
        setupData()

        expect:
        estacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Estacion> estacionList = estacionService.list(max: 2, offset: 2)

        then:
        estacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        estacionService.count() == 5
    }

    void "test delete"() {
        Long estacionId = setupData()

        expect:
        estacionService.count() == 5

        when:
        estacionService.delete(estacionId)
        sessionFactory.currentSession.flush()

        then:
        estacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Estacion estacion = new Estacion()
        estacionService.save(estacion)

        then:
        estacion.id != null
    }
}
