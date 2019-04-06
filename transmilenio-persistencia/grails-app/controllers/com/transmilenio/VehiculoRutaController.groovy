package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VehiculoRutaController {

    VehiculoRutaService vehiculoRutaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vehiculoRutaService.list(params), model:[vehiculoRutaCount: vehiculoRutaService.count()]
    }

    def show(Long id) {
        respond vehiculoRutaService.get(id)
    }

    def save(VehiculoRuta vehiculoRuta) {
        if (vehiculoRuta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            vehiculoRutaService.save(vehiculoRuta)
        } catch (ValidationException e) {
            respond vehiculoRuta.errors, view:'create'
            return
        }

        respond vehiculoRuta, [status: CREATED, view:"show"]
    }

    def update(VehiculoRuta vehiculoRuta) {
        if (vehiculoRuta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            vehiculoRutaService.save(vehiculoRuta)
        } catch (ValidationException e) {
            respond vehiculoRuta.errors, view:'edit'
            return
        }

        respond vehiculoRuta, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        vehiculoRutaService.delete(id)

        render status: NO_CONTENT
    }
}
