package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PortalServiceSpec extends Specification {

    PortalService portalService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Portal(...).save(flush: true, failOnError: true)
        //new Portal(...).save(flush: true, failOnError: true)
        //Portal portal = new Portal(...).save(flush: true, failOnError: true)
        //new Portal(...).save(flush: true, failOnError: true)
        //new Portal(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //portal.id
    }

    void "test get"() {
        setupData()

        expect:
        portalService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Portal> portalList = portalService.list(max: 2, offset: 2)

        then:
        portalList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        portalService.count() == 5
    }

    void "test delete"() {
        Long portalId = setupData()

        expect:
        portalService.count() == 5

        when:
        portalService.delete(portalId)
        sessionFactory.currentSession.flush()

        then:
        portalService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Portal portal = new Portal()
        portalService.save(portal)

        then:
        portal.id != null
    }
}
