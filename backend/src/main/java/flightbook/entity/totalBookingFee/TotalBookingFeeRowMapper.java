package flightbook.entity.totalBookingFee;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TotalBookingFeeRowMapper implements RowMapper<TotalBookingFee> {
    @Override
    public TotalBookingFee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TotalBookingFee(
                rs.getDouble("BookingFee")
        );
    }


}
