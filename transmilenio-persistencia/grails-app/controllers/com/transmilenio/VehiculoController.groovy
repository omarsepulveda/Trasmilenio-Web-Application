package com.transmilenio

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class VehiculoController {

    VehiculoService vehiculoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vehiculoService.list(params), model:[vehiculoCount: vehiculoService.count()]
        def book = new Vehiculo(id_vehiculo: 1, matricula:"ABC123", codigo_interno:"UTR89", id_tipo_vehiculo: 1)  
        println (book.id_vehiculo)
        println (book.save())
    }

    def show(Long id) {
        respond vehiculoService.get(id)
    }

    def save(Vehiculo vehiculo) {
        if (vehiculo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            vehiculoService.save(vehiculo)
        } catch (ValidationException e) {
            respond vehiculo.errors, view:'create'
            return
        }

        respond vehiculo, [status: CREATED, view:"show"]
    }

    def update(Vehiculo vehiculo) {
        if (vehiculo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            vehiculoService.save(vehiculo)
        } catch (ValidationException e) {
            respond vehiculo.errors, view:'edit'
            return
        }

        respond vehiculo, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        vehiculoService.delete(id)

        render status: NO_CONTENT
    }
}