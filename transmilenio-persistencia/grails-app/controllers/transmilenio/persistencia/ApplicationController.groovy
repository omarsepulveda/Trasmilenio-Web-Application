package transmilenio.persistencia

import com.transmilenio.Troncal

class ApplicationController {

    def index() {
        Troncal troncal = new Troncal(
            id_troncal: 1,
            letra_troncal: "A",
            nombre_troncal: "Caracas",
            color_troncal: "Azul"
        )
        [troncal: troncal]
    }
}
