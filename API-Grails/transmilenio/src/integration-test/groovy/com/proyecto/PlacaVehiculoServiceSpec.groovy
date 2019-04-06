package com.proyecto

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PlacaVehiculoServiceSpec extends Specification {

    PlacaVehiculoService placaVehiculoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PlacaVehiculo(...).save(flush: true, failOnError: true)
        //new PlacaVehiculo(...).save(flush: true, failOnError: true)
        //PlacaVehiculo placaVehiculo = new PlacaVehiculo(...).save(flush: true, failOnError: true)
        //new PlacaVehiculo(...).save(flush: true, failOnError: true)
        //new PlacaVehiculo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //placaVehiculo.id
    }

    void "test get"() {
        setupData()

        expect:
        placaVehiculoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PlacaVehiculo> placaVehiculoList = placaVehiculoService.list(max: 2, offset: 2)

        then:
        placaVehiculoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        placaVehiculoService.count() == 5
    }

    void "test delete"() {
        Long placaVehiculoId = setupData()

        expect:
        placaVehiculoService.count() == 5

        when:
        placaVehiculoService.delete(placaVehiculoId)
        sessionFactory.currentSession.flush()

        then:
        placaVehiculoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PlacaVehiculo placaVehiculo = new PlacaVehiculo()
        placaVehiculoService.save(placaVehiculo)

        then:
        placaVehiculo.id != null
    }
}
