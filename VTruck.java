public class VTruck extends Vehicle {
    public VTruck(String vehicleType) {
        super("Truck");
    }

    @Override 
    public String getVehicleDetails() {
        return "Huge vehicle, suitable for freight and hazardous materials deliveries.";
    }
}
