package rabochiyclasss.code.reservation_system;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {

    public Reservation getReservationById(Long id) {
        return new Reservation(id, 100L, 40L, LocalDate.now(),
                LocalDate.now().plusDays(5), ReservationStatus.APPROVED);
    }

}
