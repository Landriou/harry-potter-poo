package com.hogwarts.modelos.instituciones;

import com.hogwarts.modelos.magos.Mago;

import java.util.ArrayList;
// Abstraccion completa de casa, hereda los metodos y atributos a las demas casas.
public abstract class Casa {
    protected String nombre;
    protected ArrayList<Mago> miembros;

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Mago> getMiembros() {
        return miembros;
    }

    public void agregarMiembro(Mago mago) {
        miembros.add(mago);
    }

    public void listarMiembros(){
        for (Mago mago:this.miembros) {
            System.out.println("Miembro " + mago.getNombre() + " perteneciente a la casa " + this.nombre);
        }
    }

    public abstract boolean esSeleccionable(Mago mago);
}
