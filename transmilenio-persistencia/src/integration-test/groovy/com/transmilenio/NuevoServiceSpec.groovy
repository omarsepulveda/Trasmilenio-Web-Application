package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class NuevoServiceSpec extends Specification {

    NuevoService nuevoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Nuevo(...).save(flush: true, failOnError: true)
        //new Nuevo(...).save(flush: true, failOnError: true)
        //Nuevo nuevo = new Nuevo(...).save(flush: true, failOnError: true)
        //new Nuevo(...).save(flush: true, failOnError: true)
        //new Nuevo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //nuevo.id
    }

    void "test get"() {
        setupData()

        expect:
        nuevoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Nuevo> nuevoList = nuevoService.list(max: 2, offset: 2)

        then:
        nuevoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        nuevoService.count() == 5
    }

    void "test delete"() {
        Long nuevoId = setupData()

        expect:
        nuevoService.count() == 5

        when:
        nuevoService.delete(nuevoId)
        sessionFactory.currentSession.flush()

        then:
        nuevoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Nuevo nuevo = new Nuevo()
        nuevoService.save(nuevo)

        then:
        nuevo.id != null
    }
}
