package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.ParkingLot;
import tws.service.ParkingLotService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {
	@Autowired
	private ParkingLotService parkingLotService;

	@GetMapping
	public ResponseEntity<List<ParkingLot>> getAll() {
		return ResponseEntity.ok(parkingLotService.selectAll());
	}

	@PostMapping
	public ResponseEntity<ParkingLot> insert(@RequestBody ParkingLot parkingLot) {
		if(parkingLotService.insert(parkingLot)) {
			return ResponseEntity.ok(parkingLot);		
		}
		return ResponseEntity.badRequest().body(null);
	}
	}
