package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DiasRutaController {

    DiasRutaService diasRutaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond diasRutaService.list(params), model:[diasRutaCount: diasRutaService.count()]
    }

    def show(Long id) {
        respond diasRutaService.get(id)
    }

    def save(DiasRuta diasRuta) {
        if (diasRuta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            diasRutaService.save(diasRuta)
        } catch (ValidationException e) {
            respond diasRuta.errors, view:'create'
            return
        }

        respond diasRuta, [status: CREATED, view:"show"]
    }

    def update(DiasRuta diasRuta) {
        if (diasRuta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            diasRutaService.save(diasRuta)
        } catch (ValidationException e) {
            respond diasRuta.errors, view:'edit'
            return
        }

        respond diasRuta, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        diasRutaService.delete(id)

        render status: NO_CONTENT
    }
}
