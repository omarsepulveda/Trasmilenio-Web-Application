package com.proyecto

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EstacionController {

    EstacionService estacionService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond estacionService.list(params), model:[estacionCount: estacionService.count()]
    }

    def show(Long id) {
        respond estacionService.get(id)
    }

    def save(Estacion estacion) {
        if (estacion == null) {
            render status: NOT_FOUND
            return
        }

        try {
            estacionService.save(estacion)
        } catch (ValidationException e) {
            respond estacion.errors, view:'create'
            return
        }

        respond estacion, [status: CREATED, view:"show"]
    }

    def update(Estacion estacion) {
        if (estacion == null) {
            render status: NOT_FOUND
            return
        }

        try {
            estacionService.save(estacion)
        } catch (ValidationException e) {
            respond estacion.errors, view:'edit'
            return
        }

        respond estacion, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        estacionService.delete(id)

        render status: NO_CONTENT
    }
}
