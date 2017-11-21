package flightbook.dao.customer;

import flightbook.entity.customer.Customer;
import flightbook.entity.customer.CustomerRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@Repository
public class CustomerDao implements ICustomerDao {
	JdbcTemplate jdbcTemplate;

	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Customer> getAllCustomers() {
		String sql = "SELECT * FROM Customer";

		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public Customer getCustomerByAccountNo(int accountNo) {
		String sql = "SELECT * FROM Customer WHERE AccountNo = ?";

		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		return this.jdbcTemplate.queryForObject(sql, rowMapper, accountNo);
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
	public void deleteCustomer(int accountNo) {
		String sql = "DELETE FROM Customer WHERE AccountNo = ?";

		this.jdbcTemplate.update(sql, accountNo);
	}

	@Override
	public int getNewAccountNo() {
		String sql = "SELECT AccountNo FROM Customer ORDER BY Id DESC LIMIT 1";

		Integer max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return max + 1;
	}
}