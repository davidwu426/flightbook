package flightbook.dao.include;

import flightbook.entity.include.Include;

import java.util.List;

public interface IIncludeDao {
	List<Include> getIncludesByResrNo(int resrNo);

	void insertInclude(Include include);
}
