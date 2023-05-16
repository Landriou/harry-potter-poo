package com.hogwarts.modelos.instituciones.casas;

import com.hogwarts.modelos.instituciones.Casa;
import com.hogwarts.modelos.magos.Mago;

import java.util.ArrayList;
// Casa Ravenclaw con su propio metodo de seleccion.
public class Ravenclaw extends Casa {

    public Ravenclaw() {
        this.nombre = Ravenclaw.class.getSimpleName();
        this.miembros = new ArrayList<Mago>();
    }

    public Ravenclaw(ArrayList<Mago> magos) {
        this.nombre = Gryffindor.class.getSimpleName();
        this.miembros = magos;
    }

    @Override
    public boolean esSeleccionable(Mago mago) {
        return mago.getInteligencia() >= 120;
    }
}
