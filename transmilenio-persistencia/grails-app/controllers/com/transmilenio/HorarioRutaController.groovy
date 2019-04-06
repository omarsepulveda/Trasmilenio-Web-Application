package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HorarioRutaController {

    HorarioRutaService horarioRutaService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond horarioRutaService.list(params), model:[horarioRutaCount: horarioRutaService.count()]
    }

    def show(Long id) {
        respond horarioRutaService.get(id)
    }

    def save(HorarioRuta horarioRuta) {
        if (horarioRuta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            horarioRutaService.save(horarioRuta)
        } catch (ValidationException e) {
            respond horarioRuta.errors, view:'create'
            return
        }

        respond horarioRuta, [status: CREATED, view:"show"]
    }

    def update(HorarioRuta horarioRuta) {
        if (horarioRuta == null) {
            render status: NOT_FOUND
            return
        }

        try {
            horarioRutaService.save(horarioRuta)
        } catch (ValidationException e) {
            respond horarioRuta.errors, view:'edit'
            return
        }

        respond horarioRuta, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        horarioRutaService.delete(id)

        render status: NO_CONTENT
    }
}
