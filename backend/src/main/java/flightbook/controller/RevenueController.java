package flightbook.controller;


import flightbook.entity.personCustomer.PersonCustomer;
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
    public ResponseEntity<Double> getReservationByMonth(@PathVariable int year,
                                        @PathVariable int month) {
        double totalRevenue = revenueService.getReservationByMonth(month,year);
        return new ResponseEntity<>(totalRevenue, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bestRep")
    public ResponseEntity<Integer> getBestCustomerRep(){
        Integer id = revenueService.getBestCustomerRep();
        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/bestCust")
    public ResponseEntity<PersonCustomer> getBestCustomer(){
        PersonCustomer bestCustomer = revenueService.getBestCustomer();
        return new ResponseEntity<>(bestCustomer, HttpStatus.OK);
    }

}
