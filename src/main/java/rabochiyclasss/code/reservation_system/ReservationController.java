package rabochiyclasss.code.reservation_system;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable("id") Long id) {
        log.info("Called getReservationById: id = {}", id);
        return reservationService.getReservationById(id);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        log.info("Called getAllReservations");
        return ResponseEntity.ok(reservationService.findAllReservation());//201
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation (@RequestBody Reservation reservationToCreate) {
        log.info("Called createReservation");
        return ResponseEntity.status(201)
                .header("test-header", "123")
                .body(reservationService.createResevation(reservationToCreate));
    }

}
