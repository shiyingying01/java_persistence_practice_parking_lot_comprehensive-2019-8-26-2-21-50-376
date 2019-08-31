package tws.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.ParkingLot;
import tws.service.ParkingLotService;

import java.util.List;

@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {
	@Autowired
	private ParkingLotService parkingLotService;

	@GetMapping
	public ResponseEntity<List<ParkingLot>> getAll(@Param("page") Integer page, @Param("pageSize") Integer pageSize) {
		if (page == null && pageSize == null) {
			return ResponseEntity.ok(parkingLotService.selectAll());
		}
		return ResponseEntity.ok(parkingLotService.selectByPage(page, pageSize));
	}

	@PostMapping
	public ResponseEntity<ParkingLot> insert(@RequestBody ParkingLot parkingLot) {
		if(parkingLotService.insert(parkingLot)) {
			return ResponseEntity.ok(parkingLot);		
		}
		return ResponseEntity.badRequest().body(null);
	}
	}
