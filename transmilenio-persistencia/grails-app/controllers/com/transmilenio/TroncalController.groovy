package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TroncalController {

    TroncalService troncalService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond troncalService.list(params), model:[troncalCount: troncalService.count()]
    }

    def show(Long id) {
        respond troncalService.get(id)
    }

    def save(Troncal troncal) {
        if (troncal == null) {
            render status: NOT_FOUND
            return
        }

        try {
            troncalService.save(troncal)
        } catch (ValidationException e) {Troncal
            respond troncal.errors, view:'create'
            return
        }

        respond troncal, [status: CREATED, view:"show"]
    }

    def update(Troncal troncal) {
        if (troncal == null) {
            render status: NOT_FOUND
            return
        }

        try {
            troncalService.save(troncal)
        } catch (ValidationException e) {
            respond troncal.errors, view:'edit'
            return
        }

        respond troncal, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            returnTroncal
        }

        troncalService.delete(id)

        render status: NO_CONTENTTroncal
    }
}
