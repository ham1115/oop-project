import java.util.HashMap;
import java.util.Map;
public class DeliveryAgentManager implements ICRUD<DeliveryAgent>{
    private Map<String, DeliveryAgent> deliveryAgents = new HashMap<>(); // map for agents
    private ExceptionHandling exceptionHandler;


    @Override
    public void create(DeliveryAgent agent) {
        deliveryAgents.put(agent.getAgentID(), agent); // storing them by agentID
        System.out.println("Agent " + agent.getName() + " created with ID: " + agent.getAgentID());
    }

    @Override
    public DeliveryAgent read(String agentID) {
            return deliveryAgents.get(agentID);
        }
    
    @Override
    public void update(DeliveryAgent agent) {
        try {
            if (deliveryAgents.containsKey(agent.getAgentID())) {
                deliveryAgents.put(agent.getAgentID(), agent);
                System.out.println("Agent " + agent.getName() + " updated with ID: " + agent.getAgentID());
            } else {
                throw new Exception("Agent not found.");
            }
        } catch (Exception e) {
            exceptionHandler.handleAgentNotFoundException();
        }
    }

    @Override
    public boolean delete(String agentID) {
        DeliveryAgent agent = deliveryAgents.get(agentID);
        if (agent != null) {
            deliveryAgents.remove(agentID);
            System.out.println("Agent " + agent.getName() + " is deleted.");
            return true; // Deletion successful
        } else {
            System.out.println("Agent not found.");
            return false; // Agent not found
        }
    }
    public void displayAgents() {
        
        System.out.println("\n--- List of Delivery Agents ---");
    if (deliveryAgents.isEmpty()) {
        System.out.println("No delivery agents available.");
    } else {
        for (DeliveryAgent agent : deliveryAgents.values()) {
            System.out.println("-------------------------------------------------");
            System.out.println("ID: " + agent.getAgentID());
            System.out.println("Name: " + agent.getName());
            System.out.println("Contact: " + agent.getContactNumber());
            System.out.println("Vehicle: " + agent.getVehicleType());
            System.out.println("Available: " + (agent.isAvailable() ? "Yes" : "No"));
            System.out.println("Type: " + agent.getDeliveryType());
            System.out.println("-------------------------------------------------");
        }
    }
}}
