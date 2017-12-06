package flightbook.controller;


import com.sun.org.apache.regexp.internal.RE;
import flightbook.service.revenue.IRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/revenue")
public class RevenueController {
    @Autowired
    private IRevenueService revenueService;

    @RequestMapping(method = RequestMethod.GET, value = "/{year}/{month}")
    public ResponseEntity<Double> getRevenueByMonth(@PathVariable int year,
                                        @PathVariable int month) {
        double totalRevenue = revenueService.getReservationByMonth(month,year);
        return new ResponseEntity<>(totalRevenue, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/flight/{airlineId}/{flightNo}")
    public ResponseEntity<Double> getRevenueByFlight(@PathVariable String airlineId,
                                                     @PathVariable int flightNo) {
        double totalRevenue = revenueService.getRevenueByFlight(airlineId, flightNo);
        return new ResponseEntity<>(totalRevenue, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/city/{city}")
    public ResponseEntity<Double> getRevenueByCity(@PathVariable String city) {
        double totalRevenue = revenueService.getRevenueByCity(city);
        return new ResponseEntity<>(totalRevenue, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer/{accountNo}")
    public ResponseEntity<Double> getRevenueByAccountNo(@PathVariable int accountNo) {
        double totalRevenue = revenueService.getRevenueByAccountNo(accountNo);
        return new ResponseEntity<>(totalRevenue, HttpStatus.OK);
    }

}
