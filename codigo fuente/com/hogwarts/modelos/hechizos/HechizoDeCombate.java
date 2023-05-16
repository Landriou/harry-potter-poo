package com.hogwarts.modelos.hechizos;

import com.hogwarts.modelos.magos.Mago;

import java.util.ArrayList;
// Tipo de hechizo basico de combate.
public class HechizoDeCombate extends Hechizo {
    public HechizoDeCombate(String nombre, int coeficienteDePoder, AreaDeMagia area, ArrayList<Componente> componentes, ArrayList<PasoDeHechizo> pasos) {
        super(nombre, 200, coeficienteDePoder, area, componentes, pasos );
    }

    // Area de magia de combate por defecto.
    public HechizoDeCombate(String nombre, int coeficienteDePoder, ArrayList<Componente> componentes, ArrayList<PasoDeHechizo> pasos) {
        super(nombre, 200, coeficienteDePoder, AreaDeMagia.Combate, componentes, pasos );
    }

    @Override
    public void efecto(Mago lanzador, Mago objetivo) {
        // Gasto de recursos.
        final int energiaLanzador = lanzador.getEnergia();
        lanzador.setEnergia(energiaLanzador - this.costoEnergia);

        //Aplicar Daño
        final int daño =  5 * this.coeficienteDePoder + lanzador.getVarita().poder;
        objetivo.setVida(objetivo.getVida() - daño);

        // Anunciar Daño
        System.out.println("El hechizo " + this.nombre + " de " + lanzador.getNombre() + " impacto en " + objetivo.getNombre() + " inflingiendo " + daño);
    }
}
