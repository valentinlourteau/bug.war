package valentin.bugs.war.agent;

public class AgentRequest {

	public AgentRequest(Agent agent, AgentRequestTypeEnum agentRequestType) {
		super();
		this.agent = agent;
		this.agentRequestType = agentRequestType;
	}

	private Agent agent;
	private AgentRequestTypeEnum agentRequestType;
	
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public AgentRequestTypeEnum getAgentRequestType() {
		return agentRequestType;
	}
	public void setAgentRequestType(AgentRequestTypeEnum agentRequestType) {
		this.agentRequestType = agentRequestType;
	}

}
