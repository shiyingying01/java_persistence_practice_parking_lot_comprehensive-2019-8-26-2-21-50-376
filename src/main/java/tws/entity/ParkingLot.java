package tws.entity;

import java.util.HashMap;
import java.util.Map;

public class  ParkingLot {
	private final int capacity;
	private Map<ParkingTicket, Car> cars = new HashMap<>();

	public Map<ParkingTicket, Car> getCars() {
		return cars;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCars(Map<ParkingTicket, Car> cars) {
		this.cars = cars;
	}

	public ParkingLot() {
		this(10);
	}

	public ParkingLot(int capacity) {
		this.capacity = capacity;
	}

	public int getAvailableParkingPosition() {
		return capacity - cars.size();
	}
	
	public double getAvaliableParkingLot() {
		return this.getAvailableParkingPosition()/this.capacity;
	}

	public ParkingTicket park(Car car) {
		if(this.getAvailableParkingPosition()==0) {
			return null;
		}
		ParkingTicket ticket = new ParkingTicket();
		cars.put(ticket, car);
		return ticket;
	}

	public Car fetchCar(ParkingTicket ticket) {
//		for (Map.Entry<ParkingTicket, Car> entry : cars.entrySet()) {
//			if (entry.getKey() == ticket) {
//				return entry.getValue();
//			}
//		}
		Car car = cars.get(ticket);
		if(car == null) {
			return null;
		}
		cars.remove(ticket);
		return car;
	}
	
	@Override
	public boolean equals(Object object){  
		if(this.getClass()==object.getClass()) {
			return true;
		}
		return false;
		
	}
}
