package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TipoParadaController {

    TipoParadaService tipoParadaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond tipoParadaService.list(params), model:[tipoParadaCount: tipoParadaService.count()]
    }

    def show(Long id) {
        respond tipoParadaService.get(id)
    }

    def save(TipoParada tipoParada) {
        if (tipoParada == null) {
            render status: NOT_FOUND
            return
        }

        try {
            tipoParadaService.save(tipoParada)
        } catch (ValidationException e) {
            respond tipoParada.errors, view:'create'
            return
        }

        respond tipoParada, [status: CREATED, view:"show"]
    }

    def update(TipoParada tipoParada) {
        if (tipoParada == null) {
            render status: NOT_FOUND
            return
        }

        try {
            tipoParadaService.save(tipoParada)
        } catch (ValidationException e) {
            respond tipoParada.errors, view:'edit'
            return
        }

        respond tipoParada, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        tipoParadaService.delete(id)

        render status: NO_CONTENT
    }
}
