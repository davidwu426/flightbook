package flightbook.dao.reservationpassenger;

import flightbook.entity.reservationpassenger.ReservationPassenger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class ReservationPassengerDao implements IReservationPassengerDao {
    JdbcTemplate jdbcTemplate;

    public ReservationPassengerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertReservationPassenger(ReservationPassenger rp) {
        String sql = "INSERT INTO ReservationPassenger VALUES (?, ?, ?, ?, ?, ?)";

        this.jdbcTemplate.update(sql, rp.getResrNo(), rp.getId(), rp.getAccountNo(), rp.getSeatNo(), rp.getFlightClass(), rp.getMeal());
    }
}
