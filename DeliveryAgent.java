public class DeliveryAgent extends Person {
    private int agentID;
    private String vehicleType;
    private String goodsType;
    private boolean availability;

    public DeliveryAgent(int agentID, String name, long contactNumber, String vehicleType, String goodsType, boolean availability) {
        super(name, contactNumber);
        this.agentID = agentID;
        this.vehicleType = vehicleType;
        this.goodsType = goodsType;
        this.availability = availability;
    }

    public int getAgentID() {
        return agentID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void updateAgentDetails(String name, long contactNumber, String vehicleType, String goodsType) {
        setName(name);
        setContactNumber(contactNumber);
        setVehicleType(vehicleType);
        setGoodsType(goodsType);
    }

    @Override
    public String toString() {
        return "Agent ID: " + agentID + "\n" +
        "Name: " + getName() + "\n" +
        "Contact Number: " + getContactNumber() + "\n" +
        "Vehicle Type: " + getVehicleType() + "\n" +
        "Goods Type: " + getGoodsType() + "\n" +
        "Availability: " + isAvailability();
    }
}
