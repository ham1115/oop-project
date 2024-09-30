public class DeliveryAgent {
    private int agentID;
    private int contactNumber;
    private String vehicleType;
    private String name;
    private String goodsType;
    private boolean availability;

    public DeliveryAgent(int agentID, String name, int contactNumber, String vehicleType, String goodsType, boolean availability) {
        this.agentID = agentID;
        this.name = name;
        this.contactNumber = contactNumber;
        this.vehicleType = vehicleType;
        this.goodsType = goodsType;
        this.availability = availability;
    }

    public int getAgentID() {
        return agentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
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

    public void updateAgentDetails(String name, int contactNumber, String vehicleType, String goodsType) {
        setName(name);
        setContactNumber(contactNumber);
        setVehicleType(vehicleType);
        setGoodsType(goodsType);
    }
}
