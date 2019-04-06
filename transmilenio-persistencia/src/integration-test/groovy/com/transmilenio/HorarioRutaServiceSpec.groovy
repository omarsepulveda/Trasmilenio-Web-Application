package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HorarioRutaServiceSpec extends Specification {

    HorarioRutaService horarioRutaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new HorarioRuta(...).save(flush: true, failOnError: true)
        //new HorarioRuta(...).save(flush: true, failOnError: true)
        //HorarioRuta horarioRuta = new HorarioRuta(...).save(flush: true, failOnError: true)
        //new HorarioRuta(...).save(flush: true, failOnError: true)
        //new HorarioRuta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //horarioRuta.id
    }

    void "test get"() {
        setupData()

        expect:
        horarioRutaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<HorarioRuta> horarioRutaList = horarioRutaService.list(max: 2, offset: 2)

        then:
        horarioRutaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        horarioRutaService.count() == 5
    }

    void "test delete"() {
        Long horarioRutaId = setupData()

        expect:
        horarioRutaService.count() == 5

        when:
        horarioRutaService.delete(horarioRutaId)
        sessionFactory.currentSession.flush()

        then:
        horarioRutaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        HorarioRuta horarioRuta = new HorarioRuta()
        horarioRutaService.save(horarioRuta)

        then:
        horarioRuta.id != null
    }
}
