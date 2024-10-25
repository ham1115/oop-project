public abstract class DeliveryAgent {
    private String name;
    private String contactNumber;
    private boolean available;
    private String agentID;
    private Vehicle vehicle; 

    public DeliveryAgent(String name, String contactNumber, boolean available, String agentID, String vehicleType) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.available = available;
        this.agentID = agentID;
        this.vehicle = createVehicle(vehicleType); 
    }

    public abstract String getDeliveryType();

    public String getAgentID() {
        return agentID;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public Vehicle getVehicle() {
        return vehicle; 
    }

    
    private Vehicle createVehicle(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return new VCar(vehicleType);
            case "bike":
                return new VBike(vehicleType);
            case "motorcycle":
                return new VMotorcycle(vehicleType);
            case "truck":
                return new VTruck(vehicleType);
            case "van":
                return new VVan(vehicleType);
            default:
                return null;
        }
    }
}
