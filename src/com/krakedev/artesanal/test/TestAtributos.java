package com.krakedev.artesanal.test;
import com.krakedev.artesanal.Maquina;

public class TestAtributos {
    public static void main(String[] args) {
        // Verifica que codigo sea consultable con getter y los datos iniciales se conserven.
        Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "CER-001");
        Maquina negra = new Maquina("Club", "Cerveza negra", 0.03, "CER-002");
        rubia.imprimir();
        negra.imprimir();
        System.out.println("Codigo primera maquina: " + rubia.getCodigo());
        System.out.println("Codigo segunda maquina: " + negra.getCodigo());
        System.out.println("Capacidad por defecto: " + negra.getCapacidadMaxima());
    }
}
