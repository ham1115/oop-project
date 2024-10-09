import java.util.ArrayList;
import java.util.List;

public class DeliveryAgentManager {
    private List<DeliveryAgent> agentsList = new ArrayList<>();

    public void addAgent(DeliveryAgent agent) {
        agentsList.add(agent);
    }

    public void removeAgent(int agentID) {
        DeliveryAgent agent = getAgentById(agentID);
        if (agent != null) {
            agentsList.remove(agent);
            System.out.println("Agent removed successfully.");
        } else {
            System.out.println("Error: Agent ID not found.");
        }
    }

    public DeliveryAgent getAgentById(int agentID) {
        for (DeliveryAgent agent : agentsList) {
            if (agent.getAgentID() == agentID) {
                return agent;
            }
        }
        return null;
    }

    public void updateAgent(int agentID, String name, long contactNumber, String vehicleType, String goodsType) {
        DeliveryAgent agent = getAgentById(agentID);
        if (agent != null) {
            agent.updateAgentDetails(name, contactNumber, vehicleType, goodsType);
            System.out.println("Agent updated successfully.");
        } else {
            System.out.println("Error: Agent ID not found.");
        }
    }

    public List<DeliveryAgent> getAllAgents() {
        return agentsList;
    }
}
