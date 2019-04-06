package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoVehiculoController {

    TipoVehiculoService tipoVehiculoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoVehiculoService.list(params), model:[tipoVehiculoCount: tipoVehiculoService.count()]
    }

    def show(Long id) {
        respond tipoVehiculoService.get(id)
    }

    def save(TipoVehiculo tipoVehiculo) {
        if (tipoVehiculo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            tipoVehiculoService.save(tipoVehiculo)
        } catch (ValidationException e) {
            respond tipoVehiculo.errors, view:'create'
            return
        }

        respond tipoVehiculo, [status: CREATED, view:"show"]
    }

    def update(TipoVehiculo tipoVehiculo) {
        if (tipoVehiculo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            tipoVehiculoService.save(tipoVehiculo)
        } catch (ValidationException e) {
            respond tipoVehiculo.errors, view:'edit'
            return
        }

        respond tipoVehiculo, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        tipoVehiculoService.delete(id)

        render status: NO_CONTENT
    }
}
