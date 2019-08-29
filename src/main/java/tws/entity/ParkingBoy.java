package tws.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy implements Parking{
	protected String lastErrorMessage;
	public ParkingBoy() {
		super();
	}

	// private final ParkingLot parkingLot;
	protected final List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

	public List<ParkingLot> getParkingLots() {
		return parkingLots;
	}

	

	public void setLastErrorMessage(String lastErrorMessage) {
		this.lastErrorMessage = lastErrorMessage;
	}

	public ParkingBoy(ParkingLot parkingLot) {
		this.parkingLots.add(parkingLot);
	}

	public ParkingBoy(List<ParkingLot> parkingLots) {
		this.parkingLots.addAll(parkingLots);
	}
	
	public String getLastErrorMessage() {
		return this.lastErrorMessage;
	}

	@Override
	public ParkingTicket park(Car car) {
		this.lastErrorMessage = null;
		ParkingTicket ticket = null;
		for (ParkingLot parkingLot : parkingLots) {
			ticket = parkingLot.park(car);
			if (ticket != null) {
				break;
			}
		}
//    	ParkingTicket ticket=this.parkingLot.park(car);
		if (ticket == null) {
			this.lastErrorMessage = "The parking lot is full.";
			return null;
		}
		return ticket;
	}

	@Override
	public Car fetch(ParkingTicket ticket) {
		if (ticket == null) {
			this.lastErrorMessage = "Please provide your parking ticket.";
			return null;
		}
		Car car = null;
		for (ParkingLot parkingLot : parkingLots) {
			car = parkingLot.fetchCar(ticket);
		}
		if (car != null) {
			this.lastErrorMessage = null;
			return car;
		}
		this.lastErrorMessage = "Unrecognized parking ticket.";
		return null;
	}
	
	
}
