public class VCar extends Vehicle{
    public VCar(String vehicleType) {
        super("Car");
    }

    @Override
    public String getVehicleDetails() {
        return "Four-wheeled vehicle, suitable for document, medical, and food deliveries.";
    }
}
