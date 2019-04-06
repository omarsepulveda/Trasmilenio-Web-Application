package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ParaderoServiceSpec extends Specification {

    ParaderoService paraderoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Paradero(...).save(flush: true, failOnError: true)
        //new Paradero(...).save(flush: true, failOnError: true)
        //Paradero paradero = new Paradero(...).save(flush: true, failOnError: true)
        //new Paradero(...).save(flush: true, failOnError: true)
        //new Paradero(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //paradero.id
    }

    void "test get"() {
        setupData()

        expect:
        paraderoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Paradero> paraderoList = paraderoService.list(max: 2, offset: 2)

        then:
        paraderoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        paraderoService.count() == 5
    }

    void "test delete"() {
        Long paraderoId = setupData()

        expect:
        paraderoService.count() == 5

        when:
        paraderoService.delete(paraderoId)
        sessionFactory.currentSession.flush()

        then:
        paraderoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Paradero paradero = new Paradero()
        paraderoService.save(paradero)

        then:
        paradero.id != null
    }
}
