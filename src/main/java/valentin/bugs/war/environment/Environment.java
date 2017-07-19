package valentin.bugs.war.environment;

import valentin.bugs.war.Element;

public class Environment extends Element {
	
	public double rayon;

	public Environment(double x, double y, double rayon) {
		super(x, y);
	}

	public Environment() {
		super((0 + Math.random() * (800 - 0)), (0 + Math.random() * (800 - 0)));
		rayon = 0 + Math.random() * (20 - 0);
	}

}
