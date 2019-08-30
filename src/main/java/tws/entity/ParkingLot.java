package tws.entity;



public class  ParkingLot {
	private int  parkingLotID;
	private int availablePositionCount;
	private int capacity;  //(0-100)
	private int parkingBoyID;

	public ParkingLot() {
	}

	public ParkingLot(int parkingLotID, int availablePositionCount, int capacity, int parkingBoyID) {
		this.parkingLotID = parkingLotID;
		this.availablePositionCount = availablePositionCount;
		this.capacity = capacity;
		this.parkingBoyID = parkingBoyID;
	}

	public int getParkingBoyID() {
		return parkingBoyID;
	}

	public void setParkingBoyID(int parkingBoyID) {
		this.parkingBoyID = parkingBoyID;
	}

	public int getParkingLotID() {
		return parkingLotID;
	}

	public void setParkingLotID(int parkingLotID) {
		this.parkingLotID = parkingLotID;
	}

	public int getAvailablePositionCount() {
		return availablePositionCount;
	}

	public void setAvailablePositionCount(int availablePositionCount) {
		this.availablePositionCount = availablePositionCount;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
