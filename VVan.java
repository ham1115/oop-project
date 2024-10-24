public class VVan extends Vehicle {
    public VVan(String vehicleType) {
        super("Van");
    }

    @Override
    public String getVehicleDetails() {
        return "Four-wheeled vehicle, suitable for freight, medical, and hazardous materials deliveries.";
    }
}
