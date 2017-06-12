package valentin.bugs.war.agent;

import valentin.bugs.war.Element;

public abstract class Agent extends Element {
	
	public int vitesse;
	
	abstract public void perceive();
	
	abstract public void interact(Agent agent);
	
	abstract public void interact(Element element);
	
	abstract public void move();
}
