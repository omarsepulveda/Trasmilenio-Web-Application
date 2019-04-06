package com.proyecto

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GenerarServiceSpec extends Specification {

    GenerarService generarService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Generar(...).save(flush: true, failOnError: true)
        //new Generar(...).save(flush: true, failOnError: true)
        //Generar generar = new Generar(...).save(flush: true, failOnError: true)
        //new Generar(...).save(flush: true, failOnError: true)
        //new Generar(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //generar.id
    }

    void "test get"() {
        setupData()

        expect:
        generarService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Generar> generarList = generarService.list(max: 2, offset: 2)

        then:
        generarList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        generarService.count() == 5
    }

    void "test delete"() {
        Long generarId = setupData()

        expect:
        generarService.count() == 5

        when:
        generarService.delete(generarId)
        sessionFactory.currentSession.flush()

        then:
        generarService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Generar generar = new Generar()
        generarService.save(generar)

        then:
        generar.id != null
    }
}
