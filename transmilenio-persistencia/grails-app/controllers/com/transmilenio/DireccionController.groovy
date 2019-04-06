package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DireccionController {

    DireccionService direccionService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond direccionService.list(params), model:[direccionCount: direccionService.count()]
    }

    def show(Long id) {
        respond direccionService.get(id)
    }

    def save(Direccion direccion) {
        if (direccion == null) {
            render status: NOT_FOUND
            return
        }

        try {
            direccionService.save(direccion)
        } catch (ValidationException e) {
            respond direccion.errors, view:'create'
            return
        }

        respond direccion, [status: CREATED, view:"show"]
    }

    def update(Direccion direccion) {
        if (direccion == null) {
            render status: NOT_FOUND
            return
        }

        try {
            direccionService.save(direccion)
        } catch (ValidationException e) {
            respond direccion.errors, view:'edit'
            return
        }

        respond direccion, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        direccionService.delete(id)

        render status: NO_CONTENT
    }
}
