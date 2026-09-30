package edu.uees.testing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Punto de partida.
 * El estudiante debe ampliar esta suite durante las actividades.
 */
class ReservaServiceTest {

    private final ReservaService servicio = new ReservaService(null, null, null);

    @ParameterizedTest(name = "{0} horas permiten cancelar: {1}")
    @CsvSource({"5,true", "2,true", "1,false", "0,false", "-1,false"})
    void cancelacionRespetaDosHorasMinimas(int horas, boolean esperado) {
        // Arrange: entradas definidas en la tabla. Act y Assert:
        assertEquals(esperado, servicio.puedeCancelar(horas));
    }

    @ParameterizedTest(name = "{0} sobre {1} produce {2}")
    @CsvSource({"NORMAL,100,100", "VIP,100,85", "ESTUDIANTE,100,90", "VIP,0,0",
            "vip,100,85", "estudiante,100,90"})
    void descuentosRespetanTipoYTotal(String tipo, double base, double esperado) {
        double resultado = servicio.calcularTotal(tipo, base);
        assertEquals(esperado, resultado, 0.000001);
    }

    @Test
    void totalNegativoSeRechaza() {
        IllegalArgumentException error = assertThrows(IllegalArgumentException.class,
                () -> servicio.calcularTotal("NORMAL", -1));
        assertEquals("Total base inválido", error.getMessage());
    }

    @Test
    void entornoJUnitFunciona() {
        assertTrue(true);
    }
}
