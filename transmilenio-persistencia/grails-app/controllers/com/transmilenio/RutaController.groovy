package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RutaController {

    RutaService rutaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rutaService.list(params), model:[rutaCount: rutaService.count()]
    }

    def show(Long id) {
        respond rutaService.get(id)
    }

    def save(Ruta ruta) {
        if (ruta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            rutaService.save(ruta)
        } catch (ValidationException e) {
            respond ruta.errors, view:'create'
            return
        }

        respond ruta, [status: CREATED, view:"show"]
    }

    def update(Ruta ruta) {
        if (ruta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            rutaService.save(ruta)
        } catch (ValidationException e) {
            respond ruta.errors, view:'edit'
            return
        }

        respond ruta, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        rutaService.delete(id)

        render status: NO_CONTENT
    }
}
