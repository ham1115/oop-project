import java.util.HashMap;
import java.util.Map;
public class DeliveryAgentManager implements ICRUD<DeliveryAgent> {
    private Map<String, DeliveryAgent> deliveryAgents = new HashMap<>();
    private ExceptionHandling exceptionHandler;

    public DeliveryAgentManager() {
        this.exceptionHandler = new ExceptionHandling(); 
    }

    @Override
    public void create(DeliveryAgent agent) {
        deliveryAgents.put(agent.getAgentID(), agent);
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
            return true;
        } else {
            System.out.println("Agent not found.");
            return false;
        }
    }

    public void displayAgents() {
        System.out.println("\n==================== List of Delivery Agents ===================");
        System.out.println("================================================================");
    
        if (deliveryAgents.isEmpty()) {
            System.out.printf("%-40s\n", "No delivery agents available.");
        } else {
            for (DeliveryAgent agent : deliveryAgents.values()) {
                System.out.println("┌──────────────────────────────────────────────────────────────┐");
                System.out.printf("│ %-60s │\n", "Agent ID: " + agent.getAgentID());
                System.out.printf("│ %-60s │\n", "Name: " + agent.getName());
                System.out.printf("│ %-60s │\n", "Contact: " + agent.getContactNumber());
                System.out.printf("│ %-60s │\n", "Vehicle Type: " + agent.getVehicle().getVehicleType());
                System.out.println("│ Vehicle Details:                                             │");
                wrapText(agent.getVehicle().getVehicleDetails(), 52); // Set width to match format
                System.out.printf("│ %-60s │\n", "Available: " + (agent.isAvailable() ? "Yes" : "No"));
                System.out.printf("│ %-60s │\n", "Delivery Type: " + agent.getDeliveryType());
                System.out.println("└──────────────────────────────────────────────────────────────┘");
                System.out.println("----------------------------------------------------------------");
            }
        }
    }
    
    private void wrapText(String text, int width) {
        String[] words = text.split(" ");
        StringBuilder currentLine = new StringBuilder("│     "); // Padding for wrapped lines
    
        for (String word : words) {
            if (currentLine.length() + word.length() + 1 > width) {
                System.out.printf("%-62s │\n", currentLine.toString());
                currentLine = new StringBuilder("│     " + word); // New line starts with padding
            } else {
                currentLine.append(" ").append(word);
            }
        }
        System.out.printf("%-62s │\n", currentLine.toString()); // Print the last line
    }
    
}
