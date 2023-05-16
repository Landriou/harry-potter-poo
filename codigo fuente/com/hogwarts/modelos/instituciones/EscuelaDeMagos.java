package com.hogwarts.modelos.instituciones;

import java.util.ArrayList;
// Modelo de escuela de magos, por ejemplo hogwartz
public class EscuelaDeMagos {
    private final String nombre;
    private ArrayList<Casa> casas;
    private final SombreroSeleccionador sombrero;

    public EscuelaDeMagos(String nombre, SombreroSeleccionador sombrero, ArrayList<Casa> casas) {
        this.nombre = nombre;
        this.sombrero = sombrero;
        this.casas = casas;
    }

    public EscuelaDeMagos(String nombre, SombreroSeleccionador sombrero) {
        this.nombre = nombre;
        this.sombrero = sombrero;
        this.casas = new ArrayList<Casa>();
    }

    public void listarMiembros() {
        int miembros = 0;
        for (Casa casa : this.casas) {
            casa.listarMiembros();
            miembros = casa.getMiembros().size() + miembros;
        }

        System.out.println("La cantidad de miembros total de la escuela " + this.nombre + " es " + miembros );
    }
}
