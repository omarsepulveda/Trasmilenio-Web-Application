package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RutaServiceSpec extends Specification {

    RutaService rutaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ruta(...).save(flush: true, failOnError: true)
        //new Ruta(...).save(flush: true, failOnError: true)
        //Ruta ruta = new Ruta(...).save(flush: true, failOnError: true)
        //new Ruta(...).save(flush: true, failOnError: true)
        //new Ruta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ruta.id
    }

    void "test get"() {
        setupData()

        expect:
        rutaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ruta> rutaList = rutaService.list(max: 2, offset: 2)

        then:
        rutaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rutaService.count() == 5
    }

    void "test delete"() {
        Long rutaId = setupData()

        expect:
        rutaService.count() == 5

        when:
        rutaService.delete(rutaId)
        sessionFactory.currentSession.flush()

        then:
        rutaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ruta ruta = new Ruta()
        rutaService.save(ruta)

        then:
        ruta.id != null
    }
}
