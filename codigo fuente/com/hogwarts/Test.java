package com.hogwarts;

import com.hogwarts.modelos.hechizos.*;
import com.hogwarts.modelos.instituciones.Casa;
import com.hogwarts.modelos.instituciones.EscuelaDeMagos;
import com.hogwarts.modelos.instituciones.SombreroSeleccionador;
import com.hogwarts.modelos.instituciones.casas.Gryffindor;
import com.hogwarts.modelos.instituciones.casas.Hufflepuff;
import com.hogwarts.modelos.instituciones.casas.Ravenclaw;
import com.hogwarts.modelos.instituciones.casas.Slytherin;
import com.hogwarts.modelos.magos.*;
import com.hogwarts.modelos.magos.Color;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        // Requerimiento 13.
        ArrayList<Casa> casas = new ArrayList<Casa>();
        casas.add(new Gryffindor());
        casas.add(new Slytherin());
        casas.add(new Ravenclaw());
        casas.add(new Hufflepuff());
        SombreroSeleccionador Sombrero = new SombreroSeleccionador(casas);
        final EscuelaDeMagos Hogwarts = new EscuelaDeMagos("Hogwarts", Sombrero,casas );

        Alumno Harry = new Alumno("Harry Potter", 100, TipoDeSangre.Mestiza, Color.Negro);
        Alumno Ron = new Alumno("Ronald Weasley", 50, TipoDeSangre.Mestiza, Color.Rojo);
        Alumno Hermione = new Alumno("Hermonie Granger", 119, TipoDeSangre.Sucia, Color.Castaño);
        Alumno Malfoy = new Alumno("Draco Malfoy", 70, TipoDeSangre.Pura, Color.Rubio);
        Alumno VincentCrabbe = new Alumno("Vincent Crabbe", 60, TipoDeSangre.Pura, Color.Castaño);
        Alumno ErnieMacmillan = new Alumno("Ernie Macmillan", 70, TipoDeSangre.Sucia, Color.Negro);
        Alumno ZachariasSmith = new Alumno("Zacharias Smith", 50, TipoDeSangre.Sucia, Color.Rubio);
        Alumno TerryBoot = new Alumno("Terry Boot", 160, TipoDeSangre.Sucia, Color.Castaño);
        Alumno HannahAbbott = new Alumno("HannahAbbott", 170, TipoDeSangre.Sucia, Color.Castaño);
        Profesor SeverusSnape = new Profesor("Severus Snape",4000,3000,150, TipoDeSangre.Pura,Color.Negro);
        Profesor MinervaMcGonagall = new Profesor("Minerva McGonagall", 5000, 4000, 100, TipoDeSangre.Sucia, Color.Negro);

        // Hechizos
        // Experlliarmus
        ArrayList<PasoDeHechizo> pasosExperlliarmus = new ArrayList<PasoDeHechizo>();
        pasosExperlliarmus.add(PasoDeHechizo.Circulo);
        pasosExperlliarmus.add(PasoDeHechizo.HaciaAdelante);

        HechizoDeCombate Expelliarmus = new HechizoDeCombate("Expelliarmus", 30, AreaDeMagia.Combate,new ArrayList<Componente>(),pasosExperlliarmus);

        // Patronus
        ArrayList<PasoDeHechizo> pasosPatronus = new ArrayList<PasoDeHechizo>();
        pasosPatronus.add(PasoDeHechizo.HaciaAdelante);
        ArrayList<Componente> componentesPatronus = new ArrayList<Componente>();
        componentesPatronus.add(Componente.RecuerdoMasFelizDeTuVida);

        HechizoDeCombate EspectroPatronus = new HechizoDeCombate("Espectro Patronus", 60, AreaDeMagia.Patronus,componentesPatronus,pasosPatronus);

        // Episkey
        ArrayList<PasoDeHechizo> pasosEpiskey = new ArrayList<PasoDeHechizo>();
        pasosEpiskey.add(PasoDeHechizo.W);
        pasosEpiskey.add(PasoDeHechizo.HaciaAdelante);
        ArrayList<Componente> componentesEpiskey = new ArrayList<Componente>();
        componentesEpiskey.add(Componente.Mandragora);
        HechizoSanador Episkey = new HechizoSanador("Episkey",100,100, AreaDeMagia.Medica, componentesEpiskey, pasosEpiskey );

        ArrayList<PasoDeHechizo> pasosAvadaKedavra= new ArrayList<PasoDeHechizo>();
        pasosAvadaKedavra.add(PasoDeHechizo.Arriba);
        pasosAvadaKedavra.add(PasoDeHechizo.HaciaAdelante);
        ArrayList<Componente> componentesAvadaKedavra = new ArrayList<Componente>();
        componentesAvadaKedavra.add(Componente.AlientoDeDementor);
        HechizoImperdonable AvadaKedavra = new HechizoImperdonable("Avada Kedavra",150,500, AreaDeMagia.Negra, componentesAvadaKedavra, pasosAvadaKedavra );


        // Se agregan las varitas
        Harry.setVarita(new Varita(300));
        Malfoy.setVarita(new Varita(200));
        TerryBoot.setVarita(new Varita(200));
        MinervaMcGonagall.setVarita(new Varita(500));
        SeverusSnape.setVarita(new Varita(500));
        // Se aprenden hechizos para la batalla y se agregan componentes
        MinervaMcGonagall.aprenderHechizo(EspectroPatronus);
        MinervaMcGonagall.aprenderHechizo(Expelliarmus);
        SeverusSnape.aprenderHechizo(AvadaKedavra);
        MinervaMcGonagall.aprenderHechizo(Episkey);

        MinervaMcGonagall.enseñarHechizo(Harry,EspectroPatronus);
        MinervaMcGonagall.enseñarHechizo(Harry,Expelliarmus);
        MinervaMcGonagall.enseñarHechizo(Malfoy,Expelliarmus);
        MinervaMcGonagall.enseñarHechizo(TerryBoot,Episkey);
        SeverusSnape.enseñarHechizo(Malfoy, AvadaKedavra);

        Harry.agregarObjeto(Componente.RecuerdoMasFelizDeTuVida);
        Malfoy.agregarObjeto(Componente.AlientoDeDementor);
        TerryBoot.agregarObjeto(Componente.Mandragora);
        MinervaMcGonagall.agregarObjeto(Componente.Mandragora);
        SeverusSnape.agregarObjeto(Componente.AlientoDeDementor);

        // Requerimiento 2
        System.out.println("REQUERIMIENTO NUMERO 2 \n");
        Test.requerimiento2(Harry,Sombrero);

        // Requerimiento 3
        System.out.println("REQUERIMIENTO NUMERO 3 \n");
        ArrayList<Mago> listDeMagos = new ArrayList<Mago>();
        listDeMagos.add(Harry);
        listDeMagos.add(Ron);
        listDeMagos.add(Hermione);
        listDeMagos.add(Malfoy);
        listDeMagos.add(VincentCrabbe);
        listDeMagos.add(ErnieMacmillan);
        listDeMagos.add(ZachariasSmith);
        listDeMagos.add(HannahAbbott);
        listDeMagos.add(TerryBoot);


        Test.requerimiento3(listDeMagos,Sombrero);

        // Requerimiento 1
        System.out.println("REQUERIMIENTO NUMERO 1 \n");
        Test.requerimiento1(Hogwarts);




        // Requerimiento 4
        System.out.println("REQUERIMIENTO NUMERO 4 \n");
       Test.requerimiento4(Harry,Ron);
       Test.requerimiento4(Harry,Malfoy);

        // Requerimiento 5
        System.out.println("REQUERIMIENTO NUMERO 5 \n");
        Test.requerimiento5(Harry,Ron);
        Test.requerimiento5(Ron,Harry);
        Test.requerimiento5(Malfoy,Hermione);

        // Requerimiento 6
        System.out.println("REQUERIMIENTO NUMERO 6 \n");
        Test.requerimiento6(Ron,Harry);

        // Requerimiento 7
        System.out.println("REQUERIMIENTO NUMERO 7 \n");
        Test.requerimiento7(Hermione,Episkey);

        // Requerimiento 8
        System.out.println("REQUERIMIENTO NUMERO 8 \n");
        Test.requerimiento8(Hermione, Episkey);

        // Requerimiento 9
        System.out.println("REQUERIMIENTO NUMERO 9 \n");
        Test.requerimiento9(TerryBoot,Episkey,Hermione);
        System.out.println("Prueba con Ron que no sabe el hechizo Episkey");
        Test.requerimiento9(Ron,Episkey,Hermione);

        // Requerimiento 10
        System.out.println("REQUERIMIENTO NUMERO 10 \n");
        Test.requerimiento10(Harry,Hermione);

        // Requerimiento 11
        System.out.println("REQUERIMIENTO NUMERO 11 \n");
        System.out.println("Hay que matar un mago para ver si esta muerto despues del ataque");
        SeverusSnape.lanzarHechizo(AvadaKedavra,Ron);
        Test.requerimiento11(Ron);
        Test.requerimiento11(MinervaMcGonagall);

        // Requerimiento 12
        System.out.println("REQUERIMIENTO NUMERO 12 ");
        System.out.println("Se usan el metodo polimorfico efecto de los 3 tipos de hechizos");
        Test.requerimiento12(TerryBoot,SeverusSnape,Episkey);
        Test.requerimiento12(MinervaMcGonagall, SeverusSnape, Expelliarmus);
        Test.requerimiento12(SeverusSnape,MinervaMcGonagall, AvadaKedavra);


        System.out.println("El requerimiento 13 de las 20 instancias se comprueba con todas las instancias necesarias en esta clase");
        System.out.println(" Y ahora una pelea en Malfoy y Harry para comprobar el funcionamiento del sistema \n \n");
        Malfoy.mostrarHechizos();
        Harry.mostrarHechizos();


        System.out.println(Harry.getNombre() + " tiene " + Harry.getVida() + " de vida");
        System.out.println(Malfoy.getNombre() + " tiene " + Malfoy.getVida() + " de vida");
        System.out.println(Harry.getNombre() + " tiene " + Harry.getEnergia() + " de energia");
        System.out.println(Malfoy.getNombre() + " tiene " + Malfoy.getEnergia() + " de energia");

        Malfoy.lanzarHechizo(Expelliarmus,Harry);
        Harry.lanzarHechizo(Expelliarmus,Malfoy);

        System.out.println(Harry.getNombre() + " tiene " + Harry.getVida() + " de vida");
        System.out.println(Malfoy.getNombre() + " tiene " + Malfoy.getVida() + " de vida");
        System.out.println(Harry.getNombre() + " tiene " + Harry.getEnergia() + " de energia");
        System.out.println(Malfoy.getNombre() + " tiene " + Malfoy.getEnergia() + " de energia");

        Malfoy.lanzarHechizo(Expelliarmus,Harry);
        Harry.lanzarHechizo(Expelliarmus,Malfoy);

        System.out.println(Harry.getNombre() + " tiene " + Harry.getVida() + " de vida");
        System.out.println(Malfoy.getNombre() + " tiene " + Malfoy.getVida() + " de vida");
        System.out.println(Harry.getNombre() + " tiene " + Harry.getEnergia() + " de energia");
        System.out.println(Malfoy.getNombre() + " tiene " + Malfoy.getEnergia() + " de energia");

        System.out.println("Terry se mete a la pelea y sana a harry !");
        TerryBoot.lanzarHechizo(Episkey,Harry);
        System.out.println(Harry.getNombre() + " tiene " + Harry.getVida() + " de vida");

        Malfoy.lanzarHechizo(AvadaKedavra,Harry);
        Harry.lanzarHechizo(EspectroPatronus,Malfoy);

        System.out.println(Harry.getNombre() + " tiene " + Harry.getVida() + " de vida");
        System.out.println(Malfoy.getNombre() + " tiene " + Malfoy.getVida() + " de vida");
        System.out.println(Harry.getNombre() + " tiene " + Harry.getEnergia() + " de energia");
        System.out.println(Malfoy.getNombre() + " tiene " + Malfoy.getEnergia() + " de energia");
        Test.requerimiento11(Malfoy);
        Test.requerimiento11(Harry);
    }

    //Requerimiento 1 , exige que
    // Dado el colegio hogwartz saber cuántos alumnos tiene y listar sus nombres y escuela
    private static void requerimiento1(EscuelaDeMagos escuela) {
        escuela.listarMiembros();
    }

    //Requerimiento 2 , exige que
    // Dado un mago, saber a qué casa le corresponde ir
    private static void requerimiento2(Mago mago, SombreroSeleccionador sombrero) {
        final Casa casa = sombrero.determinarCasa(mago);
        System.out.println("La casa a la puede ir " + mago.getNombre() +  " es " + casa.getNombre());
    }

    //Requerimiento 3, exige que
    // Organizar en casas a todos los magos de la escuela
    private  static  void requerimiento3(ArrayList<Mago> listaDeMagos, SombreroSeleccionador sombrero) {
        listaDeMagos.forEach(sombrero::seleccionarCasa);
    }

    //Requerimiento 4, exige que
    // Averiguar si un mago está en la misma casa que otro
    private static void requerimiento4(Mago primerMago, Mago segundoMago) {
        System.out.println("Es " + primerMago.getNombre() + " de la misma casa que " + segundoMago.getNombre() + "? " + primerMago.esDeLaMismaCasa(segundoMago));
    }

    //Requerimiento 5, exige que
    // Saber si un mago puede seguir otro
    private static void requerimiento5(Mago seguidor, Mago seguido) {
        System.out.println(seguidor.getNombre() + " puede seguir a " + seguido.getNombre() + "? " + seguidor.esSeguible(seguido));
    }

    //Requerimiento 6, exige que
    // Hacer que un mago siga a otro
    private static void requerimiento6(Mago seguidor, Mago seguido) {
        seguidor.seguir(seguido);
        seguido.mostrarSeguidores();
    }

    //Requerimiento 7, exige que
    // Hacer que un mago aprenda un hechizo.
    private static void requerimiento7(Mago mago, Hechizo hechizo) {
        mago.aprenderHechizo(hechizo);
        mago.mostrarHechizos();
    }

    //Requerimiento 8, exige que
    //  Saber cuánta energía gastaría un mago al lanzar un hechizo
    private static void requerimiento8(Mago mago, Hechizo hechizo) {
        System.out.println("El costo del hechizo " + hechizo.getNombre() + " es " + mago.consultarCostoDeHechizo(hechizo));
    }

    //Requerimiento 9, exige que
    //  Representar que un mago lanza un hechizo dado, si es que puede hacerlo
    private static void requerimiento9(Mago lanzador, Hechizo hechizo, Mago objetivo) {
        lanzador.lanzarHechizo(hechizo,objetivo);
    }

    //Requerimiento 10, exige que
    // Representar que un mago lanza el hechizo que menos energía gasta
    private static void requerimiento10(Mago lanzador, Mago objetivo) {
        lanzador.lanzarHechizoMasBarato(objetivo);
    }

    //Requerimiento 11, exige que
    //  Saber si un mago está muerto.
    private static void requerimiento11(Mago mago) {
        System.out.println(mago.getNombre() + " esta muerto? " + mago.estaMuerto());
    }

    //Requerimiento 12, exige que
    //  Debe existir algún método polimórfico al menos.
    private static void requerimiento12(Mago lanzador, Mago objetivo, Hechizo hechizo) {
       hechizo.efecto(lanzador,objetivo);
    }
}
