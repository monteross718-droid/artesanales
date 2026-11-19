package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {
    private static final double DELTA = 0.0001;

    @Test
    public void testRecargaExitosa() {
        // Recarga inferior al limite permitido.
        Maquina rubia = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "CER-001");
        boolean resultado = rubia.recargarCerveza(3000);
        assertTrue(resultado);
        assertEquals(3000.0, rubia.getCantidadActual(), DELTA);
    }

    @Test
    public void testRecargaFallidaPorDesborde() {
        // 7000 + 1000 = 8000, supera limite de 7800. No modifica la cantidad.
        Maquina negra = new Maquina("Club", "Cerveza fria", 0.03, 8000, "CER-002");
        assertTrue(negra.recargarCerveza(7000));
        boolean resultado = negra.recargarCerveza(1000);
        assertFalse(resultado);
        assertEquals(7000.0, negra.getCantidadActual(), DELTA);
    }

    @Test
    public void testRecargarExactamenteHastaElNuevoLimite() {
        // Se permite llegar a 7800 exactamente.
        Maquina maquina = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "CER-003");
        assertTrue(maquina.recargarCerveza(7800));
        assertEquals(7800.0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testRecargarUnMililitroPorEncimaDelLimite() {
        // Un valor apenas superior al limite se rechaza.
        Maquina maquina = new Maquina("Pilsener", "Cerveza fria", 0.02, 8000, "CER-004");
        assertFalse(maquina.recargarCerveza(7801));
        assertEquals(0.0, maquina.getCantidadActual(), DELTA);
    }
}
