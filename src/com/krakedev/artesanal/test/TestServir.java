package com.krakedev.artesanal.test;
import com.krakedev.artesanal.Maquina;

public class TestServir {
    public static void main(String[] args) {
        Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "CER-001");
        rubia.llenarMaquina();
        System.out.println("Antes de servir: " + rubia.getCantidadActual()); // 7800
        double precio = rubia.servirCerveza(1000);
        System.out.println("Valor a pagar: " + precio); // 20.0
        System.out.println("Despues de servir: " + rubia.getCantidadActual()); // 6800
    }
}
