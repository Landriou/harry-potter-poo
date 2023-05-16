package com.hogwarts.modelos.magos;
// Objeto varita en el mundo de harry potter, es necesario para lanzar hechizos
public class Varita {
    public final int poder;

    public Varita(int poder) {
        this.poder = poder;
    }
    // Varita basica por defecto.
    public Varita() {
        this.poder = 100;
    }
}
