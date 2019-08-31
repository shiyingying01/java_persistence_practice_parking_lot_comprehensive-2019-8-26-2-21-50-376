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
	
	
    public boolean insert(ParkingLot parkingLot) {
    	ParkingLot parkingLot1 = parkingLotMapper.selectByParkingLotId(parkingLot.getParkingLotID());
		if(parkingLot1 == null) {
			parkingLotMapper.insert(parkingLot);
			return true;
		}else {
			return false;
		}
	}
    
    public List<ParkingLot> selectByParkingBoyId(int id) {
		return parkingLotMapper.selectByParkingBoyId(id);
	}
    
	public List<ParkingLot>  selectAll() {
		return parkingLotMapper.selectAll();
	}
	

	public List<ParkingLot> selectByPage(Integer page, Integer pageSize) {
		return parkingLotMapper.selectByPage(page, pageSize);
	}
}
