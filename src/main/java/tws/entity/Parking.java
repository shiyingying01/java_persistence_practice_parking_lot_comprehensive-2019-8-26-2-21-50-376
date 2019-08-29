package tws.entity;

public interface Parking {
	
	public ParkingTicket park(Car car); 
	public Car fetch(ParkingTicket ticket);
}
