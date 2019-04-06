package transmilenio

import grails.core.GrailsApplication
import grails.plugins.*

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
        print(this.letra(3))
        print(hola)
    }

    def letra(int longitud){
        String[] letras = ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"];
        String palabra = "";
        int index = 0;
        for (int i = 0; i < longitud; i++) {
            index = ThreadLocalRandom.current().nextInt(0, letras.length);
            palabra += letras[index];
        }
        return palabra;
    }
}
