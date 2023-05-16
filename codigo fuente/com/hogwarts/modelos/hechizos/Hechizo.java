package com.hogwarts.modelos.hechizos;

import com.hogwarts.modelos.magos.Mago;

import java.util.ArrayList;
// Super clase de hechizo que contiene casi todo el funcionamiento de hechizo, excepto el efecto polimorfico.
public abstract class Hechizo {
    protected final String nombre;
    protected final int costoEnergia;
    protected final int coeficienteDePoder;
    protected AreaDeMagia area;
    protected ArrayList<Componente> componentesNecesarios;
    protected ArrayList<PasoDeHechizo> pasosDeHechizos;

    protected Hechizo(String nombre, int costoEnergia, int coeficienteDePoder, AreaDeMagia area,ArrayList<Componente> componentesNecesarios, ArrayList<PasoDeHechizo> pasosDeHechizos) {
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.coeficienteDePoder = coeficienteDePoder;
        this.area = area;
        this.componentesNecesarios = componentesNecesarios;
        this.pasosDeHechizos = pasosDeHechizos;
    }

    protected Hechizo(String nombre, int costoEnergia, int coeficienteDePoder, AreaDeMagia area) {
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.coeficienteDePoder = coeficienteDePoder;
        this.area = area;
        this.componentesNecesarios = new ArrayList<Componente>();
        this.pasosDeHechizos = new ArrayList<PasoDeHechizo>();
    }

    private boolean tieneComponentes(Mago lanzador) {
        for (Componente componente:this.componentesNecesarios) {
            if (!lanzador.getInventario().contains(componente)) {
                System.out.println(lanzador.getNombre() + " no tiene los componentes para hacer este hechizo");
                return false;
            }
        }

        return true;
    }

    private  boolean sabeLosMovimientos(Mago lanzador){
        for (PasoDeHechizo paso:this.pasosDeHechizos) {
            if (!lanzador.getPasosDeHechizos().contains(paso)) {
                System.out.println(lanzador.getNombre() + " no sabe los movimientos para hacer este hechizo");
                return false;
            }
        }

        return true;
    }

    private boolean tieneLaEnergia(Mago lanzador) {
        return lanzador.getEnergia() >= this.costoEnergia;
    }

    public boolean esLanzable(Mago mago) {
        return sabeLosMovimientos(mago) && tieneComponentes(mago) && tieneLaEnergia(mago);
    }

    public abstract void efecto(Mago lanzador, Mago objetivo);

    public ArrayList<PasoDeHechizo> getPasosDeHechizos() {
        return this.pasosDeHechizos;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public String getNombre() {
        return nombre;
    }
}
