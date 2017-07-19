package valentin.bugs.war.agent.ants;

import valentin.bugs.war.Element;
import valentin.bugs.war.agent.Agent;
import valentin.bugs.war.environment.Environment;
import valentin.bugs.war.utils.MathUtils;

/**
 * Implémentation d'un agent En l'occurence la fourmie
 * 
 * @author Valentin
 *
 */
public class Ant extends Agent {

	public Ant() {
		super(MathUtils.randomDouble(0, 800), MathUtils.randomDouble(0, 800), 5, MathUtils.randomDouble(0, 360));
	}

	public Ant(double x, double y, double pas, double direction) {
		super(MathUtils.randomDouble(0, 800), MathUtils.randomDouble(0, 800), 5, MathUtils.randomDouble(0, 360));
	}

	@Override
	public double getSightRange() {
		return 10;
	}

	@Override
	public void interact(Agent agent) {
		System.out.println("I'm interacting with some other agent bitch");
	}

	@Override
	public void interact(Element element) {
		if (element instanceof Agent)
			interact((Agent) element);
		else if (element instanceof Environment)
			interact((Environment) element);
	}

	@Override
	public void interact(Environment environment) {
		System.out.println("I'm interacting with some other environment bitch");
	}

}
