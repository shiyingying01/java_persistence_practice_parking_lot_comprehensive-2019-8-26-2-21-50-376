package tws.entity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy {

	public SmartParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
	}

	public ParkingLot getMaxCapacityParkingLot(List<ParkingLot> parkingLots) {
		List<ParkingLot> maxCapacityParkingLot = parkingLots.stream()
				//.sorted((p1, p2) -> p1.getAvailableParkingPosition().compareTo(p2.getAvailableParkingPosition()))
				.sorted(Comparator.comparing(ParkingLot::getAvailableParkingPosition).reversed()) 
				.limit(1)
				.collect(Collectors.toList());
		return maxCapacityParkingLot.get(0);
	}

	@Override
	public ParkingTicket park(Car car) {
		ParkingLot parkingLot = getMaxCapacityParkingLot(super.parkingLots);
		ParkingTicket ticket = parkingLot.park(car);
		if (ticket != null) {
			super.lastErrorMessage = null;
		} else {
			super.lastErrorMessage = "The parking lot is full.";
		}
		return ticket;
	}
	
	
	

}
