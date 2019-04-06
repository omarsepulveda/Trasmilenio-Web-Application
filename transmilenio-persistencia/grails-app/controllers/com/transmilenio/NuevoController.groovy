package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class NuevoController {

    NuevoService nuevoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    // def index = {
    //     redirect(action: "list", params: params)
    // }

    // def list = {
    //     params.max = Math.min(params.max ? params.int('max') : 10, 100)
    //     [nuevoInstanceList: Nuevo.list(params), nuevoInstanceTotal: Nuevo.count()]
    // }
    
     def index(Integer max) {
         params.max = Math.min(max ?: 10, 100)
         respond nuevoService.list(params), model:[nuevoCount: nuevoService.count()]
     }
    
    def show(Long id) {
         respond nuevoService.get(id)
     }
    def nuevo = Nuevo.findAll()
    
    def save(Nuevo nuevo) {
        if (nuevo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            nuevoService.save(nuevo)
        } catch (ValidationException e) {
            respond nuevo.errors, view:'create'
            return
        }

        respond nuevo, [status: CREATED, view:"show"]
    }

    def update(Nuevo nuevo) {
        if (nuevo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            nuevoService.save(nuevo)
        } catch (ValidationException e) {
            respond nuevo.errors, view:'edit'
            return
        }

        respond nuevo, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        nuevoService.delete(id)

        render status: NO_CONTENT
    }
}
