package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ParaderoController {

    ParaderoService paraderoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond paraderoService.list(params), model:[paraderoCount: paraderoService.count()]
    }

    def show(Long id) {
        respond paraderoService.get(id)
    }

    def save(Paradero paradero) {
        if (paradero == null) {
            render status: NOT_FOUND
            return
        }

        try {
            paraderoService.save(paradero)
        } catch (ValidationException e) {
            respond paradero.errors, view:'create'
            return
        }

        respond paradero, [status: CREATED, view:"show"]
    }

    def update(Paradero paradero) {
        if (paradero == null) {
            render status: NOT_FOUND
            return
        }

        try {
            paraderoService.save(paradero)
        } catch (ValidationException e) {
            respond paradero.errors, view:'edit'
            return
        }

        respond paradero, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        paraderoService.delete(id)

        render status: NO_CONTENT
    }
}
