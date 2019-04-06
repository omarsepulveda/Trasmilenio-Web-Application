package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VehiculoRutaServiceSpec extends Specification {

    VehiculoRutaService vehiculoRutaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VehiculoRuta(...).save(flush: true, failOnError: true)
        //new VehiculoRuta(...).save(flush: true, failOnError: true)
        //VehiculoRuta vehiculoRuta = new VehiculoRuta(...).save(flush: true, failOnError: true)
        //new VehiculoRuta(...).save(flush: true, failOnError: true)
        //new VehiculoRuta(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vehiculoRuta.id
    }

    void "test get"() {
        setupData()

        expect:
        vehiculoRutaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VehiculoRuta> vehiculoRutaList = vehiculoRutaService.list(max: 2, offset: 2)

        then:
        vehiculoRutaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vehiculoRutaService.count() == 5
    }

    void "test delete"() {
        Long vehiculoRutaId = setupData()

        expect:
        vehiculoRutaService.count() == 5

        when:
        vehiculoRutaService.delete(vehiculoRutaId)
        sessionFactory.currentSession.flush()

        then:
        vehiculoRutaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VehiculoRuta vehiculoRuta = new VehiculoRuta()
        vehiculoRutaService.save(vehiculoRuta)

        then:
        vehiculoRuta.id != null
    }
}
