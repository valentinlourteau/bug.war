package valentin.bugs.war.utils;

public class MathUtils {
	
	public static double randomDouble(double min, double max) {
		return Math.random() * (max - min);
	}
}

