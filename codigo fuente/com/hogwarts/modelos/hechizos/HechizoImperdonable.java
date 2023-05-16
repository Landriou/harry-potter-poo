package com.hogwarts.modelos.hechizos;

import com.hogwarts.modelos.magos.Mago;

import java.util.ArrayList;
// Hechizos potentes que derrumban al oponente pero desgastan al lanzador por sus puntos de vida.
public class HechizoImperdonable extends Hechizo {
    public HechizoImperdonable(String nombre, int costoEnergia, int coeficienteDePoder, AreaDeMagia area, ArrayList<Componente> componentes, ArrayList<PasoDeHechizo> pasos) {
        super(nombre, costoEnergia, coeficienteDePoder, area,  componentes, pasos);
    }

    //Constructor con magia negra por defualt
    public HechizoImperdonable(String nombre, int costoEnergia, int coeficienteDePoder, ArrayList<Componente> componentes, ArrayList<PasoDeHechizo> pasos) {
        super(nombre, costoEnergia, coeficienteDePoder, AreaDeMagia.Negra,  componentes, pasos);
    }

    @Override
    public void efecto(Mago lanzador, Mago objetivo) {
        final int daño = this.coeficienteDePoder + 4 * lanzador.getSeguidores().size();
        lanzador.setVida(lanzador.getVida() - daño);
        objetivo.setVida(objetivo.getVida() - daño*2);

        System.out.println("El hechizo " + this.nombre + " de " + lanzador.getNombre() + " impacto en " + objetivo.getNombre() + " inflingiendo " + 2*daño);
    }
}
