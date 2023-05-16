package com.hogwarts.modelos.instituciones.casas;

import com.hogwarts.modelos.instituciones.Casa;
import com.hogwarts.modelos.magos.Mago;

import java.util.ArrayList;
// Casa Hufflepuff con su propio metodo de seleccion.
public class Hufflepuff extends Casa {

    public Hufflepuff() {
        this.nombre = Hufflepuff.class.getSimpleName();
        this.miembros = new ArrayList<Mago>();
    }

    public Hufflepuff(ArrayList<Mago> magos) {
        this.nombre = Gryffindor.class.getSimpleName();
        this.miembros = magos;
    }

    @Override
    public boolean esSeleccionable(Mago mago) {
        return true;
    }
}
