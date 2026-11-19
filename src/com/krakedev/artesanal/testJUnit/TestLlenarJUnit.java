package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {
    private static final double DELTA = 0.0001;

    @Test
    public void testLlenarMaquinaConCapacidadExplicita() {
        // Nueva regla: 8000 - 200 = 7800.
        Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "CER-001");
        rubia.llenarMaquina();
        assertEquals(7800.0, rubia.getCantidadActual(), DELTA);
        assertEquals("CER-001", rubia.getCodigo());
    }

    @Test
    public void testLlenarConCapacidadPorDefecto() {
        // Constructor de cuatro parametros: maxima 10000 -> 9800.
        Maquina negra = new Maquina("Club", "Cerveza negra", 0.03, "CER-002");
        negra.llenarMaquina();
        assertEquals(9800.0, negra.getCantidadActual(), DELTA);
    }
}
