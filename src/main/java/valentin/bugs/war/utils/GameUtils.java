package valentin.bugs.war.utils;

import java.util.List;
import java.util.stream.Collectors;

import valentin.bugs.war.Element;
import valentin.bugs.war.agent.Agent;

/**
 * Un utilitaire pour la game. Méthodes pour les agents etc
 * @author Valentin
 *
 */
public class GameUtils {

	public static List<Element> getElementsWithinRange(Agent agent, List<Element> elements) {
		return elements.stream().filter(element -> !agent.equals(element) && element.distanceTo(agent) < agent.getSightRange())
				.collect(Collectors.toList());		
	}

}
