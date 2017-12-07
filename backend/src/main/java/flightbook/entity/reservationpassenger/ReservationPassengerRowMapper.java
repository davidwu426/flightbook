package flightbook.entity.reservationpassenger;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationPassengerRowMapper implements RowMapper<ReservationPassenger> {
    @Override
    public ReservationPassenger mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ReservationPassenger(
                rs.getInt("ResrNo"),
                rs.getInt("Id"),
                rs.getInt("AccountNo"),
                rs.getString("SeatNo"),
                rs.getString("Class"),
                rs.getString("Meal")
        );
    }
}
