package com.transmilenio

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TipoVehiculoServiceSpec extends Specification {

    TipoVehiculoService tipoVehiculoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TipoVehiculo(...).save(flush: true, failOnError: true)
        //new TipoVehiculo(...).save(flush: true, failOnError: true)
        //TipoVehiculo tipoVehiculo = new TipoVehiculo(...).save(flush: true, failOnError: true)
        //new TipoVehiculo(...).save(flush: true, failOnError: true)
        //new TipoVehiculo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tipoVehiculo.id
    }

    void "test get"() {
        setupData()

        expect:
        tipoVehiculoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TipoVehiculo> tipoVehiculoList = tipoVehiculoService.list(max: 2, offset: 2)

        then:
        tipoVehiculoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tipoVehiculoService.count() == 5
    }

    void "test delete"() {
        Long tipoVehiculoId = setupData()

        expect:
        tipoVehiculoService.count() == 5

        when:
        tipoVehiculoService.delete(tipoVehiculoId)
        sessionFactory.currentSession.flush()

        then:
        tipoVehiculoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TipoVehiculo tipoVehiculo = new TipoVehiculo()
        tipoVehiculoService.save(tipoVehiculo)

        then:
        tipoVehiculo.id != null
    }
}
