public class MedicalDeliveryAgent extends DeliveryAgent{
    public MedicalDeliveryAgent(String name, String contactNumber, boolean available, String agentID, String vehicle) {
        super(name, contactNumber, available, agentID, vehicle);
    }
    @Override
    public String getDeliveryType() {
        return "Medical";
    }
}