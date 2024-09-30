import java.util.ArrayList;
import java.util.List;

public class DeliveryAgentManager {
    private List<DeliveryAgent> agentsList;

    public DeliveryAgentManager() {
        this.agentsList = new ArrayList<>();
    }

    // adds a new agent to the list
    public void addAgent(DeliveryAgent agent) {
        agentsList.add(agent);
    }

    // removes an agent based on agentID
    public void removeAgent(int agentID) {
        agentsList.removeIf(agent -> agent.getAgentID() == agentID);
    }

    /* tentative
    public void updateAgent(DeliveryAgent updatedAgent) {
        for (int i = 0; i < agentsList.size(); i++) {
            if (agentsList.get(i).getAgentID() == updatedAgent.getAgentID()) {
                agentsList.set(i, updatedAgent);
                break;
            }
        }
    }
     */

    // returns a list of all registered agents
    public List<DeliveryAgent> getAllAgents() {
        return agentsList;
    }

    public DeliveryAgent getAgentById(int agentID) {
        for (DeliveryAgent agent : agentsList) {
            if (agent.getAgentID() == agentID) {
                return agent;
            }
        }
        return null;
    }

    public Vehicle getVehicleValidator() {
        return new Vehicle();
    }

    public Goods getGoodsValidator() {
        return new Goods();
    }
}
