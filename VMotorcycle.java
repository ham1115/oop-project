public class VMotorcycle extends Vehicle {
    public VMotorcycle(String vehicleType) {
        super("Motorcycle");
    }

    @Override
    public String getVehicleDetails() {
        return "Two-wheeled vehicle, suitable for food and document deliveries";
    }
}
