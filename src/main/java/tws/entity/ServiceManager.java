package tws.entity;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager implements Parking {
	private ParkingLot parkingLot;
	private ParkingBoy parkingBoy;

	public ServiceManager(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public ServiceManager(ParkingBoy parkingBoy) {
		this.parkingBoy = parkingBoy;
	}

	@Override
	public ParkingTicket park(Car car) {
		if (parkingBoy == null) {
			ParkingTicket ticket = this.parkingLot.park(car);

			return ticket;
		}
		return parkingBoy.park(car);
	}

	@Override
	public Car fetch(ParkingTicket ticket) {
		if (parkingBoy == null) {
			Car car = this.parkingLot.fetchCar(ticket);

			return car;
		}
		return parkingBoy.fetch(ticket);
	}

}
