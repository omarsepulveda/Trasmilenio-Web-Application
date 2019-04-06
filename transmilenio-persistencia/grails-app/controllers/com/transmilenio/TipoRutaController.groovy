package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoRutaController {

    TipoRutaService tipoRutaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoRutaService.list(params), model:[tipoRutaCount: tipoRutaService.count()]
    }

    def show(Long id) {
        respond tipoRutaService.get(id)
    }

    def save(TipoRuta tipoRuta) {
        if (tipoRuta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            tipoRutaService.save(tipoRuta)
        } catch (ValidationException e) {
            respond tipoRuta.errors, view:'create'
            return
        }

        respond tipoRuta, [status: CREATED, view:"show"]
    }

    def update(TipoRuta tipoRuta) {
        if (tipoRuta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            tipoRutaService.save(tipoRuta)
        } catch (ValidationException e) {
            respond tipoRuta.errors, view:'edit'
            return
        }

        respond tipoRuta, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        tipoRutaService.delete(id)

        render status: NO_CONTENT
    }
}
