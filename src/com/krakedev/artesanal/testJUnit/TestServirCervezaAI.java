package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {
    private static final double DELTA = 0.0001;

    @Test
    public void testServirCantidadMenorALaDisponible() {
        // Cobra cantidad x precio por ml y descuenta el stock.
        Maquina m = new Maquina("Pilsener", "Rubia", 0.02, 8000, "CER-001");
        assertTrue(m.recargarCerveza(1000));
        assertEquals(4.0, m.servirCerveza(200), DELTA);
        assertEquals(800.0, m.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirConSegundoConstructor() {
        // El constructor de cuatro argumentos tiene capacidad predeterminada.
        Maquina m = new Maquina("Club", "Negra", 0.03, "CER-002");
        assertTrue(m.recargarCerveza(1000));
        assertEquals(12.0, m.servirCerveza(400), DELTA);
        assertEquals(600.0, m.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirTodoLoDisponible() {
        // Permite servir exactamente la cantidad existente.
        Maquina m = new Maquina("Pilsener", "Rubia", 0.02, 8000, "CER-003");
        assertTrue(m.recargarCerveza(500));
        assertEquals(10.0, m.servirCerveza(500), DELTA);
        assertEquals(0.0, m.getCantidadActual(), DELTA);
    }

    @Test
    public void testNoServirMasDeLoDisponible() {
        // Se devuelve 0 y no se descuenta nada.
        Maquina m = new Maquina("Pilsener", "Rubia", 0.02, 8000, "CER-004");
        assertTrue(m.recargarCerveza(500));
        assertEquals(0.0, m.servirCerveza(700), DELTA);
        assertEquals(500.0, m.getCantidadActual(), DELTA);
    }

    @Test
    public void testNoServirCuandoEstaVacia() {
        // Sin cerveza disponible no cobra ni modifica la cantidad.
        Maquina m = new Maquina("Club", "Negra", 0.03, "CER-005");
        assertEquals(0.0, m.servirCerveza(100), DELTA);
        assertEquals(0.0, m.getCantidadActual(), DELTA);
    }

    @Test
    public void testDosServiciosConsecutivos() {
        // Ambos servicios deben cobrarse y descontarse por separado.
        Maquina m = new Maquina("Pilsener", "Rubia", 0.02, 8000, "CER-006");
        assertTrue(m.recargarCerveza(1000));
        assertEquals(4.0, m.servirCerveza(200), DELTA);
        assertEquals(800.0, m.getCantidadActual(), DELTA);
        assertEquals(2.0, m.servirCerveza(100), DELTA);
        assertEquals(700.0, m.getCantidadActual(), DELTA);
    }

    @Test
    public void testRechazarServicioDespuesDeAgotarElStock() {
        // Una segunda solicitud tras agotarse debe rechazarse.
        Maquina m = new Maquina("Pilsener", "Rubia", 0.02, 8000, "CER-007");
        assertTrue(m.recargarCerveza(200));
        assertEquals(4.0, m.servirCerveza(200), DELTA);
        assertEquals(0.0, m.servirCerveza(1), DELTA);
        assertEquals(0.0, m.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCantidadDecimal() {
        // Verifica multiplicacion y saldo con decimales.
        Maquina m = new Maquina("Club", "Negra", 0.03, "CER-008");
        assertTrue(m.recargarCerveza(100.5));
        assertEquals(0.375, m.servirCerveza(12.5), DELTA);
        assertEquals(88.0, m.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCeroMililitros() {
        // Servir cero no debe cobrar ni cambiar la cantidad existente.
        Maquina m = new Maquina("Pilsener", "Rubia", 0.02, 8000, "CER-009");
        assertTrue(m.recargarCerveza(250));
        assertEquals(0.0, m.servirCerveza(0), DELTA);
        assertEquals(250.0, m.getCantidadActual(), DELTA);
    }
}
