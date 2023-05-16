package com.hogwarts.modelos.instituciones;

import com.hogwarts.modelos.magos.Mago;

import java.util.ArrayList;
// Entidad que se encarga de asignar a los alumnos a las casas correspondientes
public class SombreroSeleccionador {
    
    private final ArrayList<Casa> casas;

    public SombreroSeleccionador(ArrayList<Casa> casas) {
        this.casas = casas;
    }

    public SombreroSeleccionador() {
        this.casas = new ArrayList<Casa>();
    }

    public Casa determinarCasa(Mago mago) {
        for (Casa casa : casas) {
            if (casa.esSeleccionable(mago)) {
                return casa;
            }
        }

        return null;
    }

    public void seleccionarCasa(Mago mago) {
        final Casa casa = determinarCasa(mago);
        mago.setCasa(casa);
        casa.agregarMiembro(mago);
        System.out.println("El mago " + mago.getNombre() + " quedo seleccionado en la casa " + casa.getNombre());
    }
}

