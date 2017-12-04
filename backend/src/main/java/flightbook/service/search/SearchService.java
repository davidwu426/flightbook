package flightbook.service.search;


import flightbook.dao.leg.ILegDao;
import flightbook.dao.search.ISearchDao;
import flightbook.entity.search.SearchEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SearchService implements ISearchService {
    @Autowired
    ILegDao legDao;

    @Autowired
    ISearchDao searchDao;

    @Override
    public List<SearchEntry> getOneWayResults(String depTime) {

        Calendar c = Calendar.getInstance();
        c.setTime(new Date(Long.parseLong(depTime)));
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        StringBuilder binary = new StringBuilder("0000000");
        binary.setCharAt(dayOfWeek - 1,'1');

        List<SearchEntry> flights = searchDao.getOneWaySearch(binary.toString());

        return flights;
    }
}
