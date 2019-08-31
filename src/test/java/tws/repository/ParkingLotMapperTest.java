package tws.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.Employee;
import tws.entity.ParkingLot;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingLotMapperTest {
	  @Autowired
	    private ParkingLotMapper parkingLotMapper;

	    JdbcTemplate jdbcTemplate;

	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }

	    @After
	    public void tearDown() throws Exception {
	        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingLot");
	    }
	    
	    @Test
	    public void shouldFetchAllparkingLots() {
	        // given
	       
	    	jdbcTemplate.execute("INSERT INTO PARKINGLOT VALUES(0,13,10,0);");
	       
	    	// when
	    	List<ParkingLot> ParkingLotList = parkingLotMapper.selectAll();
	       
	    	// then
	        assertEquals(1, ParkingLotList.size());
	    }
	    
	    @Test
	    public void should_fatch_part_parkingLots_when_findAllParkingLotsByPage_given_page_and_size(){
	     //given
	        jdbcTemplate.execute("INSERT INTO PARKINGLOT VALUES(1,10,10,2);");
	        int page = 1;
	        int pageSize = 1;
	        int skipCounts = page * (pageSize-1);
	        
	     //when
	        List<ParkingLot> parkingLots = parkingLotMapper.selectByPage(skipCounts,pageSize);
	    
	        //then
	        assertEquals(1, parkingLots.get(0).getParkingLotID());
	        assertEquals(10, parkingLots.get(0).getAvailablePositionCount());
	        assertEquals(10, parkingLots.get(0).getCapacity());
	        assertEquals(2, parkingLots.get(0).getParkingBoyID());
	    }

}
