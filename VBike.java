public class VBike extends Vehicle {
    public VBike(String vehicleType) {
        super("Bike");
    }

    @Override
    public String getVehicleDetails() {
        return "Two wheeled vehicle, suitable for food and document deliveries.";
    }
}
