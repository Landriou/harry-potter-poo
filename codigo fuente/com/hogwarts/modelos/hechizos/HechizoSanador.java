package com.hogwarts.modelos.hechizos;

import com.hogwarts.modelos.magos.Mago;

import java.util.ArrayList;

// Tipo de hechizo que su efecto sana a su objetivo
public class HechizoSanador extends Hechizo {
    public HechizoSanador(String nombre, int costoEnergia, int coeficienteDePoder, AreaDeMagia area, ArrayList<Componente> componentes, ArrayList<PasoDeHechizo> pasos) {
        super(nombre, costoEnergia, coeficienteDePoder, area, componentes, pasos);
    }

    // Constructor de area medica
    public HechizoSanador(String nombre, int costoEnergia, int coeficienteDePoder, ArrayList<Componente> componentes, ArrayList<PasoDeHechizo> pasos) {
        super(nombre, costoEnergia, coeficienteDePoder, AreaDeMagia.Medica, componentes, pasos);
    }

    @Override
    public void efecto(Mago lanzador, Mago objetivo) {
        final int energiaLanzador = lanzador.getEnergia();
        lanzador.setEnergia(energiaLanzador - this.costoEnergia);
        if (objetivo.getVida() > 0) {
            final int cantidadSanada = this.costoEnergia * 2;
            System.out.println("El hechizo " + this.nombre + " de " + lanzador.getNombre() + " impacto en " + objetivo.getNombre() + " sanando " + cantidadSanada);
            objetivo.setVida(objetivo.getVida() + cantidadSanada);
            System.out.println("La salud resultante de " + objetivo.getNombre() + " es " + objetivo.getVida());
        } else {
            System.out.println("El objetivo esta muerto, no puedes sanarlo, pero tu energia se ha consumido de todas formas");
        }
    }
}
