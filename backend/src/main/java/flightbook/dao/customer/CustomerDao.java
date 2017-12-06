package flightbook.dao.customer;

import flightbook.entity.customer.*;
import flightbook.entity.flight.Flight;
import flightbook.entity.flight.FlightRowMapper;
import flightbook.entity.person.Person;
import flightbook.entity.personCustomer.PersonCustomer;
import flightbook.entity.personCustomer.PersonCustomerRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class CustomerDao implements ICustomerDao {
	JdbcTemplate jdbcTemplate;

	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Customer> getAllCustomers() {
		String sql = "SELECT * FROM Customer ORDER BY Id";

		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<CustomerContact> getAllCustomerContacts() {
		String sql = "SELECT p.FirstName, p.LastName, p.Telephone, p.Address, p.City, p.State, p.ZipCode, c.Email " +
					 "FROM Person p, Customer c " +
					 "WHERE p.Id = c.Id";

		RowMapper<CustomerContact> rowMapper = new CustomerContactRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public List<Flight> getSuggestions(int accountNo) {
		String sql = "SELECT DISTINCT f.* " +
					 "FROM Flight f, Leg l, Reservation r, Trip t " +
					 "WHERE r.AccountNo = ? " +
					 "AND r.ResrNo = t.ResrNo " +
					 "AND l.AirlineID = f.AirlineID " +
					 "AND l.FlightNo = f.FlightNo " +
					 "AND t.Source IN (SELECT l2.ArrAirportId " +
					 "FROM Leg l2 " +
					 "WHERE f.AirlineID = l2.AirlineID " +
					 "AND f.FlightNo = l2.FlightNo " +
				 	 ") " +
					 "AND t.Destination IN (SELECT l3.DepAirportId " +
					 "FROM Leg l3 " +
					 "WHERE f.AirlineID = l3.AirlineID " +
					 "AND f.FlightNo = l3.FlightNo " +
					 ");";

		RowMapper<Flight> rowMapper = new FlightRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, accountNo);
	}

	@Override
	public List<CustomerAuction> getAuctionsByAccountNo(int accountNo) {
		String sql = "SELECT * " +
				"FROM Auctions " +
				"WHERE AccountNo = ?";

		RowMapper<CustomerAuction> rowMapper = new CustomerAuctionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, accountNo);
	}

	@Override
	public List<CustomerAuction> getAuction(String airlineId, int flightNo, String flightClass) {
		String sql = "SELECT * " +
				"FROM Auctions " +
				"WHERE AirlineId = ? " +
				"AND FlightNo = ? " +
				"AND Class = ?;";

		RowMapper<CustomerAuction> rowMapper = new CustomerAuctionRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, airlineId, flightNo, flightClass);
	}

	@Override
	public Customer getCustomerByAccountNo(int accountNo) {
		String sql = "SELECT * FROM Customer WHERE AccountNo = ?";

		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, accountNo);
	}

	@Override
	public Customer getCustomerById(int id) {
		String sql = "SELECT * FROM Customer WHERE Id = ?";

		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		String sql = "SELECT c.* " +
				"FROM Customer c, User u " +
				"WHERE u.Username = ? " +
				"AND c.Id = u.Id";

		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, username);
	}

	@Override
	public void insertCustomer(Customer customer) {
		String sql = "INSERT INTO Customer (Id, AccountNo, CreditCardNo, Email, CreationDate, Rating) VALUES (?, ?, ?, ?, ?, ?)";

		this.jdbcTemplate.update(sql,
				customer.getId(),
				customer.getAccountNo(),
				customer.getCreditCardNo(),
				customer.getEmail(),
				customer.getCreationDate(),
				customer.getRating());
	}

	@Override
	public void updateCustomer(Customer customer) {
		String sql = "UPDATE Customer " +
				"SET CreditCardNo = ?, " +
				"Email = ?, " +
				"CreationDate = ?, " +
				"Rating = ? " +
				"WHERE AccountNo = ?";

		this.jdbcTemplate.update(sql,
				customer.getCreditCardNo(),
				customer.getEmail(),
				customer.getCreationDate(),
				customer.getRating(),
				customer.getAccountNo());
	}

	@Override
	public void deleteCustomer(int accountNo) {
		String sql = "DELETE Person " +
				"FROM Person " +
				"INNER JOIN Customer ON Customer.Id = Person.Id " +
				"WHERE Customer.AccountNo = ?";

		this.jdbcTemplate.update(sql, accountNo);
	}

	@Override
	public int getNewAccountNo() {
		String sql = "SELECT AccountNo FROM Customer ORDER BY Id DESC LIMIT 1";

		Integer max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return max + 1;
	}

	@Override
	public int getBestCustomerRep() {
		String sql = "SELECT r.RepSSN\n" +
				"FROM Reservation r\n" +
				"WHERE r.RepSSN IS NOT NULL\n" +
				"GROUP BY r.RepSSN\n" +
				"ORDER BY SUM(r.TotalFare) DESC\n" +
				"LIMIT 1;";
		Integer id = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return id;
	}



	@Override
	public PersonCustomer getBestCustomer() {
		String sql = "SELECT c.id, p.FirstName, p.LastName, p.Telephone, p.Address, p.City, p.State, p.ZipCode, c.AccountNo, c.CreditCardNo, c.Email, c.CreationDate, c.Rating, r.BookingFee\n" +
				"FROM Customer c, Person p, Reservation r\n" +
				"WHERE c.Id = p.Id\n" +
				"\tAND c.AccountNo = r.AccountNo\n" +
				"GROUP BY c.AccountNo\n" +
				"ORDER BY SUM(r.BookingFee) DESC\n" +
				"LIMIT 1;";
		RowMapper<PersonCustomer> bestCust = new PersonCustomerRowMapper();
		return this.jdbcTemplate.queryForObject(sql,bestCust);
	}




}
