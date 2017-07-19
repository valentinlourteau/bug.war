package valentin.bugs.war.agent;

public enum AgentRequestTypeEnum {
	
	PERCEIVE {
		@Override
		public int getReference() {
			return 1;
		}
	};
	
	public abstract int getReference();

}
