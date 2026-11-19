package com.krakedev.artesanal.test;
import com.krakedev.artesanal.Maquina;

public class TestRecargar {
    public static void main(String[] args) {
        Maquina negra = new Maquina("Club", "Cerveza negra", 0.03, 8000, "CER-002");
        System.out.println("Recarga 7000: " + negra.recargarCerveza(7000));
        System.out.println("Intento 1000 mas (desborda): " + negra.recargarCerveza(1000));
        System.out.println("Cantidad actual esperada: 7000; real: " + negra.getCantidadActual());
        negra.imprimir();
    }
}
