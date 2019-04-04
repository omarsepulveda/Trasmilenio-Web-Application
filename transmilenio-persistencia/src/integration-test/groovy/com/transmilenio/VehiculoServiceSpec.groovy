package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VehiculoServiceSpec extends Specification {

    VehiculoService vehiculoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vehiculo(...).save(flush: true, failOnError: true)
        //new Vehiculo(...).save(flush: true, failOnError: true)
        //Vehiculo vehiculo = new Vehiculo(...).save(flush: true, failOnError: true)
        //new Vehiculo(...).save(flush: true, failOnError: true)
        //new Vehiculo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vehiculo.id
    }

    void "test get"() {
        setupData()

        expect:
        vehiculoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vehiculo> vehiculoList = vehiculoService.list(max: 2, offset: 2)

        then:
        vehiculoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vehiculoService.count() == 5
    }

    void "test delete"() {
        Long vehiculoId = setupData()

        expect:
        vehiculoService.count() == 5

        when:
        vehiculoService.delete(vehiculoId)
        sessionFactory.currentSession.flush()

        then:
        vehiculoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vehiculo vehiculo = new Vehiculo()
        vehiculoService.save(vehiculo)

        then:
        vehiculo.id != null
    }
}
