
public class FactoryDesignPattern {
	public static void main(String[] args) {
		Vehicle carVehicle=VehicleFactory.vehicleProvider(VehicleType.CAR);
		carVehicle.vehicleFuel();
		carVehicle.vehicleRunning();
		Vehicle aeroplaneVehicle=VehicleFactory.vehicleProvider(VehicleType.AEROPLANE);
		aeroplaneVehicle.vehicleFuel();
		aeroplaneVehicle.vehicleRunning();
	}
}

class VehicleFactory {

	public static Vehicle vehicleProvider(VehicleType vehicleType) {
		Vehicle vehicle;
		switch (vehicleType) {
		case BICYCLE:
			vehicle = new Bicycle();
			break;
		case CAR:
			vehicle = new Car();
			break;
		case AEROPLANE:
			vehicle = new Aeroplane();
			break;
		case SHIP:
			vehicle = new Ship();
			break;
		default:
			throw new RuntimeException("Invalid input....");
		}
		return vehicle;
	}
}

enum VehicleType {
	BICYCLE, CAR, AEROPLANE, SHIP
}

abstract class Vehicle {

	private VehicleType type;

	Vehicle(VehicleType type) {
		this.type = type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public VehicleType getType() {
		return type;
	}

	public void vehicleRunning() {
		System.out.println(type + " is running...");
	}

	public abstract void vehicleFuel();
}

class Bicycle extends Vehicle {

	Bicycle() {
		super(VehicleType.BICYCLE);
	}

	@Override
	public void vehicleFuel() {
		System.out.println(VehicleType.BICYCLE + " requires manpower as fuel....");
	}
}

class Car extends Vehicle {

	Car() {
		super(VehicleType.CAR);
	}

	@Override
	public void vehicleFuel() {
		System.out.println(VehicleType.CAR + " runs on Diesel...");
	}
}

class Aeroplane extends Vehicle {

	Aeroplane() {
		super(VehicleType.AEROPLANE);
	}

	@Override
	public void vehicleFuel() {
		System.out.println(VehicleType.AEROPLANE + " runs on hydrogen fuel...");
	}

}

class Ship extends Vehicle {

	Ship() {
		super(VehicleType.SHIP);
	}

	@Override
	public void vehicleFuel() {
		System.out.println(VehicleType.SHIP + " runs on ship fuel Oil...");
	}

}
