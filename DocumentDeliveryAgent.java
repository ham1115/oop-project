public class DocumentDeliveryAgent extends DeliveryAgent {
    public DocumentDeliveryAgent(String name, String contactNumber, boolean available, String agentID, String vehicle) {
        super(name, contactNumber, available, agentID, vehicle);
    }

    @Override
    public String getDeliveryType() {
        return "Document";
    }
}
