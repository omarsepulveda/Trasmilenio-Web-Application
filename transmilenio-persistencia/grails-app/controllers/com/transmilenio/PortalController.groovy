package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PortalController {

    PortalService portalService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [get: "GET", save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond portalService.list(params), model:[portalCount: portalService.count()]
    }

    def show(Long id) {
        respond portalService.get(id)
    }

    def save(Portal portal) {
        if (portal == null) {
            render status: NOT_FOUND
            return
        }
        
        try {
            portalService.save(portal)
        } catch (ValidationException e) {
            respond portal.errors, view:'create'
            return
        }

        respond portal, [status: CREATED, view:"show"]
    }

    def update(Portal portal) {
        if (portal == null) {
            render status: NOT_FOUND
            return
        }

        try {
            portalService.save(portal)
        } catch (ValidationException e) {
            respond portal.errors, view:'edit'
            return
        }

        respond portal, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        portalService.delete(id)

        render status: NO_CONTENT
    }
}
