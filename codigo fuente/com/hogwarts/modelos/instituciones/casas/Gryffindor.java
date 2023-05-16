package com.hogwarts.modelos.instituciones.casas;

import com.hogwarts.modelos.instituciones.Casa;
import com.hogwarts.modelos.magos.Color;
import com.hogwarts.modelos.magos.Mago;

import java.util.ArrayList;
// Casa Gryffindor con su propio metodo de seleccion.
public class Gryffindor extends Casa {

    public Gryffindor() {
        this.nombre = Gryffindor.class.getSimpleName();
        this.miembros = new ArrayList<Mago>();
    }

    public Gryffindor(ArrayList<Mago> magos) {
        this.nombre = Gryffindor.class.getSimpleName();
        this.miembros = magos;
    }

    @Override
    public boolean esSeleccionable(Mago mago) {
        return (mago.getInteligencia() >= 80 && mago.getInteligencia() < 120) || mago.getColorDePelo() == Color.Rojo;
    }
}
