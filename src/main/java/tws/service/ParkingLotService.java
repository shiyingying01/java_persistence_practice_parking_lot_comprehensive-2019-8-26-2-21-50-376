package tws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

@Service
public class ParkingLotService {
	@Autowired
	private ParkingLotMapper parkingLotMapper;
	
	
    public void insert(ParkingLot parkingLot) {
    	parkingLotMapper.insert(parkingLot);
	}
    
    public List<ParkingLot> selectByParkingBoyId(int id) {
		return parkingLotMapper.selectByParkingBoyId(id);
	}
    
	public List<ParkingLot>  selectAll() {
		return parkingLotMapper.selectAll();
	}
}
