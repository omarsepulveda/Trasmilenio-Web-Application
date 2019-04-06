package transmilenio.persistencia

import com.transmilenio.Troncal

class ApplicationController {

    def index(int longitud) {
        // Troncal troncal = new Troncal(
        //     id_troncal: 1,
        //     letra_troncal: "A",
        //     nombre_troncal: "Caracas",
        //     color_troncal: "Azul"
        // )
        // [troncal: troncal]
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String palabra = "";
        int index = 0;
        for (int i = 0; i < longitud; i++) {
            index = ThreadLocalRandom.current().nextInt(0, letras.length);
            palabra += letras[index];
        }
        return palabra;
    }
}
