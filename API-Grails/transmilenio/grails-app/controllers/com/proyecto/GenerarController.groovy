package com.proyecto

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GenerarController {

    GenerarService generarService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

   def index(Integer max) {

        for(int j = 0; j < max; j++){
            String[] letras = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"]
            String matricula = ""
            String codigo = ""
            int tipo = 0
            int aux = 1
            for (int i = 0; i < 6; i++) {
                aux = Math.abs(new Random().nextInt()%letras.length)
                matricula += letras[aux]
            }

            for (int i = 0; i < 3; i++) {
                aux = Math.abs(new Random().nextInt()%letras.length)
                codigo += letras[aux]
            }
            codigo += (Integer)(Math.random()*100)
            tipo = Math.abs(new Random().nextInt()%7)

            def v = new Vehiculo(matricula:matricula,codigo_interno:codigo,tipo:tipo)
            v.save()
        }
    }

}
