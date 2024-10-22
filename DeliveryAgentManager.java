import java.util.ArrayList;
import java.util.List;

public class DeliveryAgentManager {
    private List<DeliveryAgent> agentsList = new ArrayList<>();
    UserInterface userInterface = new UserInterface();

    public void addAgent(DeliveryAgent agent) {
        agentsList.add(agent);
    }

    public void removeAgent(int agentID) {
        DeliveryAgent agent = getAgentById(agentID);
        if (agent != null) {
            agentsList.remove(agent);
            userInterface.displayDeletionSuccess();
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
        } else {
            System.out.println("Error: Agent ID not found.");
        }
    }

    public List<DeliveryAgent> getAllAgents() {
        return agentsList;
    }
}
