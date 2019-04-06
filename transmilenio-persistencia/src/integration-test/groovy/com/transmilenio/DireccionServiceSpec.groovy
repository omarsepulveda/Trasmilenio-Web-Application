package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DireccionServiceSpec extends Specification {

    DireccionService direccionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Direccion(...).save(flush: true, failOnError: true)
        //new Direccion(...).save(flush: true, failOnError: true)
        //Direccion direccion = new Direccion(...).save(flush: true, failOnError: true)
        //new Direccion(...).save(flush: true, failOnError: true)
        //new Direccion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //direccion.id
    }

    void "test get"() {
        setupData()

        expect:
        direccionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Direccion> direccionList = direccionService.list(max: 2, offset: 2)

        then:
        direccionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        direccionService.count() == 5
    }

    void "test delete"() {
        Long direccionId = setupData()

        expect:
        direccionService.count() == 5

        when:
        direccionService.delete(direccionId)
        sessionFactory.currentSession.flush()

        then:
        direccionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Direccion direccion = new Direccion()
        direccionService.save(direccion)

        then:
        direccion.id != null
    }
}
