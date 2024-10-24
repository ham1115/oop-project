public abstract class DeliveryAgent {
    private String name;
    private String contactNumber;
    private boolean available;
    private String agentID;
    private String vehicleType;
    
    // constructor
    public DeliveryAgent(String name, String contactNumber, boolean available, String agentID, String vehicleType) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.available = available;
        this.agentID = agentID;
        this.vehicleType = vehicleType;
    }

    // getters and setters

    public String getName() {
        return name; 
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getAgentID() {
        return agentID;   
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;     
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    

    // abstract methods

    public abstract String getDeliveryType();

}
