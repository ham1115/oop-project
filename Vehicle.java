public abstract class Vehicle {
    private String vehicleType;

    // constructor
    public Vehicle(String vehicleType) {
        this.vehicleType = vehicleType;
    }
   
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    // abstract method
    public abstract String getVehicleDetails();
}
