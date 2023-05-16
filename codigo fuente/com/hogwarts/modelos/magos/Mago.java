package com.hogwarts.modelos.magos;

import com.hogwarts.modelos.hechizos.Componente;
import com.hogwarts.modelos.hechizos.Hechizo;
import com.hogwarts.modelos.hechizos.PasoDeHechizo;
import com.hogwarts.modelos.instituciones.Casa;

import java.util.ArrayList;
// Clase principal y entidad de la cual convergen todas las relaciones, modela un mago en el mundo de Harry Potter.
public class Mago {
    private final String nombre;
    private Casa casa;
    private ArrayList<Mago> seguidores;
    private ArrayList<Hechizo> hechizos;
    private final int inteligencia;
    private int vida;
    private int energia;
    private Varita varita;
    private TipoDeSangre sangre;
    private Color colorDePelo;
    private ArrayList<Componente> inventario;
    private ArrayList<PasoDeHechizo> pasosDeHechizos;

    //Constructor para magos que ya tienen trayectoria y no son inicializados como estudiantes basicos
    public Mago(String nombre,int vida, int energia, int inteligencia, TipoDeSangre sangre, Color colorDePelo) {
        this.nombre =  nombre;
        this.inteligencia = inteligencia;
        this.sangre = sangre;
        this.colorDePelo = colorDePelo;
        this.vida = vida;
        this.energia = energia;
        this.seguidores = new ArrayList<Mago>();
        this.pasosDeHechizos = new ArrayList<PasoDeHechizo>();
        this.hechizos = new ArrayList<Hechizo>();
        this.inventario = new ArrayList<Componente>();
    }
    //Constructor para magos basicos, recien iniciados en una academia
    public Mago(String nombre, int inteligencia, TipoDeSangre sangre, Color colorDePelo) {
        this.nombre =  nombre;
        this.inteligencia = inteligencia;
        this.sangre = sangre;
        this.colorDePelo = colorDePelo;
        this.vida = 1000;
        this.energia = 1000;
        this.seguidores = new ArrayList<Mago>();
        this.pasosDeHechizos = new ArrayList<PasoDeHechizo>();
        this.hechizos = new ArrayList<Hechizo>();
        this.inventario = new ArrayList<Componente>();
    }

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Casa getCasa() {
        return casa;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public TipoDeSangre getSangre() {
        return sangre;
    }

    public Color getColorDePelo() {
        return colorDePelo;
    }

    public void setVarita(Varita varita) {
        this.varita = varita;
    }

    public Varita getVarita() {
        return varita;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public ArrayList<Mago> getSeguidores() {
        return seguidores;
    }

    public ArrayList<Componente> getInventario() {
        return inventario;
    }

    public void setInventario(ArrayList<Componente> inventario) {
        this.inventario = inventario;
    }

    public void agregarObjeto(Componente objeto) {
        this.inventario.add(objeto);
    }

    public void aprenderPasoDeHechizo(PasoDeHechizo pasoDeHechizo) {
        this.pasosDeHechizos.add(pasoDeHechizo);
    }

    public ArrayList<PasoDeHechizo> getPasosDeHechizos() {
        return pasosDeHechizos;
    }

    // Metodos Privados

    private void agregarSeguidor(Mago mago) {
        this.seguidores.add(mago);
        System.out.println("Ahora " + mago.getNombre() + " es seguidor de " + this.nombre);
    }

    private boolean esFamoso() {
        return this.seguidores.size() > 3;
    }

    private boolean tieneVarita(){
        if (this.varita != null) {
            return true;
        } else {
            System.out.println(this.nombre + " no tiene varita!");
            return false;
        }
    }

    protected boolean sabeElHechizo(Hechizo hechizo) {
        return this.hechizos.contains(hechizo);
    }

    //Metodos publicos

    public void lanzarHechizo(Hechizo hechizo, Mago objetivo) {
        if (this.hechizos.contains(hechizo) && this.tieneVarita()) {
            if (hechizo.esLanzable(this)) {
                hechizo.efecto(this , objetivo);
            }
        } else {
            System.out.println(this.nombre + " no sabe ese hechizo!");
        }

    }

    public int consultarCostoDeHechizo(Hechizo hechizo) {
        if (this.sabeElHechizo(hechizo)) {
           return hechizo.getCostoEnergia();
        }
        return 0;
    }

    public void lanzarHechizoMasBarato(Mago objetivo) {
        Hechizo hechizoMasBarato = this.hechizos.get(1);
        for (int i = 1; i < this.hechizos.size(); i++) {
            if (hechizoMasBarato.getCostoEnergia() > this.hechizos.get(i).getCostoEnergia()) {
                hechizoMasBarato = this.hechizos.get(i);
            }
        }
        this.lanzarHechizo(hechizoMasBarato,objetivo);

    }

    public boolean esDeLaMismaCasa(Mago mago) {
        return mago.getCasa() == this.casa;
    }

    public boolean esSeguible(Mago mago) {
        if (this.esDeLaMismaCasa(mago) && this != mago) {
            if (mago.esFamoso() || mago.getInteligencia() > this.inteligencia) {
                return true;
            }
        }
            return false;
    }

    public void mostrarSeguidores() {
        System.out.println("Los seguidores de " + this.nombre + " son:");
        for (Mago seguidor: this.seguidores) {
            System.out.println(seguidor.getNombre());
        }
    }

    public void mostrarHechizos() {
        System.out.println("Los hechizos de " + this.nombre + " son:");
        for (Hechizo hechizo: this.hechizos) {
            System.out.println(hechizo.getNombre());
        }
    }

    public void seguir(Mago mago){
            if(this.esSeguible(mago)) {
                mago.agregarSeguidor(this);
        }
    }

    public void aprenderHechizo(Hechizo hechizo) {
        this.pasosDeHechizos.addAll(hechizo.getPasosDeHechizos());
        this.hechizos.add(hechizo);
    }

     public boolean estaMuerto() {
        return this.vida <= 0;
     }
}
