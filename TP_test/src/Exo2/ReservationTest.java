package Exo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ReservationTest {

    private ReservationSystem reservationSystem;

    @BeforeEach
    public void setUp() {
        reservationSystem = new ReservationSystem();
    }

    @Test
    public void testReservationValide() {
        int patientId = 1;
        int doctorId = 1;
        LocalDateTime appointmentDateTime = LocalDateTime.now().plusDays(1);

        assertTrue(reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime));
    }
    
    @Test
    public void testReservationPatientInvalide() {
        int patientId = 100;
        int doctorId = 1;
        LocalDateTime appointmentDateTime = LocalDateTime.now().plusDays(1);

        assertFalse(reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime));
    }


    @Test
    public void testReservationMedecinInvalide() {
        int patientId = 1;
        int doctorId = 100;
        LocalDateTime appointmentDateTime = LocalDateTime.now().plusDays(1);

        assertFalse(reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime));
    }

    @Test
    public void testReservationDateIndisponible() {
        int patientId = 1;
        int doctorId = 1;
        LocalDateTime appointmentDateTime = LocalDateTime.now().plusDays(1);

        reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime);

        assertFalse(reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime));
    }

    @Test
    public void testReservationPatientOccupe() {
        int patientId = 1;
        int doctorId = 1;
        LocalDateTime appointmentDateTime = LocalDateTime.now().plusDays(1);

        reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime);

        assertFalse(reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime));
    }

    @Test
    public void testReservationMedecinOccupe() {
        int patientId = 1;
        int doctorId = 1;
        LocalDateTime appointmentDateTime = LocalDateTime.now().plusDays(1);

        reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime);
        reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime);
        reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime);
        reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime);

        assertFalse(reservationSystem.makeReservation(patientId, doctorId, appointmentDateTime));
    }
}
