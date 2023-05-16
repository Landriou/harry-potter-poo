package com.hogwarts.modelos.instituciones.casas;

import com.hogwarts.modelos.instituciones.Casa;
import com.hogwarts.modelos.magos.Mago;
import com.hogwarts.modelos.magos.TipoDeSangre;

import java.util.ArrayList;
// Casa Slytherin con su propio metodo de seleccion.
public class Slytherin extends Casa {

    public Slytherin() {
        this.nombre = Slytherin.class.getSimpleName();
        this.miembros = new ArrayList<Mago>();
    }

    public Slytherin(ArrayList<Mago> magos) {
        this.nombre = Gryffindor.class.getSimpleName();
        this.miembros = magos;
    }

    @Override
    public boolean esSeleccionable(Mago mago) {
        return mago.getSangre() != TipoDeSangre.Sucia;
    }

}
