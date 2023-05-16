package com.hogwarts.modelos.magos;
// Alumno basico de una escuela
public class Alumno extends Mago {
    public Alumno(String nombre, int inteligencia, TipoDeSangre sangre, Color colorDePelo) {
        super(nombre, inteligencia, sangre, colorDePelo);
    }
    // Inteligencia por defecto
    public Alumno(String nombre, TipoDeSangre sangre, Color colorDePelo) {
        super(nombre, 80, sangre, colorDePelo);
    }
}
