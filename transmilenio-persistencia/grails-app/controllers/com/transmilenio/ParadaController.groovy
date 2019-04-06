package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ParadaController {

    ParadaService paradaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond paradaService.list(params), model:[paradaCount: paradaService.count()]
    }

    def show(Long id) {
        respond paradaService.get(id)
    }

    def save(Parada parada) {
        if (parada == null) {
            render status: NOT_FOUND
            return
        }

        try {
            paradaService.save(parada)
        } catch (ValidationException e) {
            respond parada.errors, view:'create'
            return
        }

        respond parada, [status: CREATED, view:"show"]
    }

    def update(Parada parada) {
        if (parada == null) {
            render status: NOT_FOUND
            return
        }

        try {
            paradaService.save(parada)
        } catch (ValidationException e) {
            respond parada.errors, view:'edit'
            return
        }

        respond parada, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        paradaService.delete(id)

        render status: NO_CONTENT
    }
}
