package tws.entity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy{

	public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
		super(parkingLots);
		// TODO Auto-generated constructor stub
	}
	
	public ParkingLot getMaxAvaliableParkingLot(List<ParkingLot> parkingLots) {
		List<ParkingLot> maxAvaliableParkingLot = parkingLots.stream()
				.sorted(Comparator.comparing(ParkingLot::getAvaliableParkingLot).reversed()) 
				.limit(1)
				.collect(Collectors.toList());
		return maxAvaliableParkingLot.get(0);
	}

	@Override
	public ParkingTicket park(Car car) {
		ParkingLot parkingLot = getMaxAvaliableParkingLot(super.parkingLots);
		ParkingTicket ticket = parkingLot.park(car);
		if (ticket != null) {
			super.lastErrorMessage = null;
		} else {
			super.lastErrorMessage = "The parking lot is full.";
		}
		return ticket;
	}

}
