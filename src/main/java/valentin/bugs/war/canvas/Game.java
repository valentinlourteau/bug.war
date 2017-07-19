package valentin.bugs.war.canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import valentin.bugs.war.Element;
import valentin.bugs.war.agent.Agent;

/**
 * Réprésente une partie avec la liste des éléments qui la compose. Permet
 * également de communiquer auprès des agents.
 * 
 * @author Valentin
 *
 */
public class Game {

	/**
	 * La liste des élements qui composent le jeu
	 */
	private List<Element> elements = new ArrayList<>();

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

}
