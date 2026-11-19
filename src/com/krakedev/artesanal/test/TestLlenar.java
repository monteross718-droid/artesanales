package com.krakedev.artesanal.test;
import com.krakedev.artesanal.Maquina;

public class TestLlenar {
    public static void main(String[] args) {
        Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "CER-001");
        System.out.println("ANTES DE LLENAR");
        rubia.imprimir();
        rubia.llenarMaquina();
        System.out.println("DESPUES DE LLENAR (esperado: 7800 ml)");
        rubia.imprimir();
    }
}
