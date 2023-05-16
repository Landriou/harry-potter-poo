package com.hogwarts.modelos.magos;

import com.hogwarts.modelos.hechizos.AreaDeMagia;
import com.hogwarts.modelos.hechizos.Hechizo;

import java.util.ArrayList;
// Profesor de una escuela de magos, hereda de Mago Y domina areas de magias.
public class Profesor extends Mago {

    private ArrayList<AreaDeMagia> areasDeMagiaDominadas;
    private ArrayList<Alumno> alumnos;

    public Profesor(String nombre, int vida, int energia, int inteligencia, TipoDeSangre sangre, Color colorDePelo) {
        super(nombre, vida, energia, inteligencia, sangre, colorDePelo);
    }

    // Profesor por defecto
    public Profesor(String nombre, int vida, int energia, int inteligencia) {
        super(nombre, vida, energia, inteligencia, TipoDeSangre.Pura, Color.Negro);
    }

    public void enseñarHechizo(Alumno alumno, Hechizo hechizo) {
        if (this.sabeElHechizo(hechizo)) {
            alumno.aprenderHechizo(hechizo);
        }
    }
}
