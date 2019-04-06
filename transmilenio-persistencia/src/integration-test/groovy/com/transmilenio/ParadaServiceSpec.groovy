package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ParadaServiceSpec extends Specification {

    ParadaService paradaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Parada(...).save(flush: true, failOnError: true)
        //new Parada(...).save(flush: true, failOnError: true)
        //Parada parada = new Parada(...).save(flush: true, failOnError: true)
        //new Parada(...).save(flush: true, failOnError: true)
        //new Parada(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //parada.id
    }

    void "test get"() {
        setupData()

        expect:
        paradaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Parada> paradaList = paradaService.list(max: 2, offset: 2)

        then:
        paradaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        paradaService.count() == 5
    }

    void "test delete"() {
        Long paradaId = setupData()

        expect:
        paradaService.count() == 5

        when:
        paradaService.delete(paradaId)
        sessionFactory.currentSession.flush()

        then:
        paradaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Parada parada = new Parada()
        paradaService.save(parada)

        then:
        parada.id != null
    }
}
