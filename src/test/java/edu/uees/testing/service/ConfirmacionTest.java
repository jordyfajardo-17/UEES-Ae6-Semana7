package edu.uees.testing.service;

import edu.uees.testing.availability.DisponibilidadClient;
import edu.uees.testing.domain.EstadoReserva;
import edu.uees.testing.domain.Reserva;
import edu.uees.testing.notification.Notificador;
import edu.uees.testing.repository.ReservaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConfirmacionTest {
    @Mock DisponibilidadClient disponibilidad;
    @Mock ReservaRepository repository;
    @Mock Notificador notificador;

    @Test
    void disponibleConfirmaGuardaYNotificaLaMismaReserva() {
        // Arrange: disponibilidad actúa como stub; los otros colaboradores como mocks.
        Reserva reserva = new Reserva("R-001", "NORMAL");
        ReservaService servicio = new ReservaService(disponibilidad, repository, notificador);
        when(disponibilidad.estaDisponible(reserva)).thenReturn(true);
        // Act
        servicio.confirmar(reserva);
        // Assert
        assertEquals(EstadoReserva.CONFIRMADA, reserva.getEstado());
        verify(repository).guardar(same(reserva));
        verify(notificador).enviarConfirmacion(same(reserva));
    }

    @Test
    void noDisponibleConservaEstadoYNoGuardaNiNotifica() {
        Reserva reserva = new Reserva("R-002", "NORMAL");
        ReservaService servicio = new ReservaService(disponibilidad, repository, notificador);
        when(disponibilidad.estaDisponible(reserva)).thenReturn(false);

        IllegalStateException error = assertThrows(IllegalStateException.class,
                () -> servicio.confirmar(reserva));

        assertEquals("Horario no disponible", error.getMessage());
        assertEquals(EstadoReserva.PENDIENTE, reserva.getEstado());
        verifyNoInteractions(repository, notificador);
    }
}
