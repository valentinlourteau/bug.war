package valentin.bugs.war.agent;

import java.util.List;

import valentin.bugs.war.Element;
import valentin.bugs.war.environment.Environment;
import valentin.bugs.war.utils.GameUtils;
import valentin.bugs.war.utils.MathUtils;

/**
 * Classe abstraite représentant un agent
 * 
 * @author Valentin
 *
 */
public abstract class Agent extends Element {

	public Agent(double x, double y, double pas, double direction) {
		super(x, y);
		this.pas = pas;
		setVitesses(direction);
	}

	private List<Element> perceptedElements;

	private void setVitesses(double direction) {
		this.vitesseX = Math.cos(direction);
		this.vitesseY = Math.sin(direction);
	}

	private double vitesseX;
	private double vitesseY;
	private double pas;

	/**
	 * Méthode permettant de jouer un 'tour' L'agent va effectuer toutes les
	 * actions qui lui sont proposées
	 * 
	 * @param list
	 * 
	 * @param elements
	 */
	public void playTurn(List<Element> elements) {
		perceive(elements);
		if (!perceptedElements.isEmpty()) {
			perceptedElements.forEach(element -> {
				interact(element);
			});
		}
		move();
	}

	public void perceive(List<Element> elements) {
		perceptedElements = GameUtils.getElementsWithinRange(this, elements);
	}

	abstract public double getSightRange();

	abstract public void interact(Agent agent);

	abstract public void interact(Element element);

	abstract public void interact(Environment environment);

	protected void move() {
		changeDirectionIfNeeded();
		setPositionX(getPositionX() + pas * vitesseX);
		setPositionY(getPositionY() + pas * vitesseY);
	}

	// TODO recupérer la taille de la carte par rapport au canvas
	private void changeDirectionIfNeeded() {
		double tmpPosX = getPositionX() + pas * vitesseX;
		double tmpPosY = getPositionY() + pas * vitesseY;
		while (tmpPosX >= 800 || tmpPosX <= 0 || tmpPosY >= 800 || tmpPosY <= 0) {
			setVitesses(MathUtils.randomDouble(0, 360));
			tmpPosX = getPositionX() + pas * vitesseX;
			tmpPosY = getPositionY() + pas * vitesseY;
		}
	}

	public double getVitesseX() {
		return vitesseX;
	}

	public void setVitesseX(double vitesseX) {
		this.vitesseX = vitesseX;
	}

	public double getPas() {
		return pas;
	}

	public void setPas(double pas) {
		this.pas = pas;
	}

	public double getVitesseY() {
		return vitesseY;
	}

	public void setVitesseY(double vitesseY) {
		this.vitesseY = vitesseY;
	}

	public void setPerceptedElements(List<Element> perceptedElements) {
		this.perceptedElements = perceptedElements;
	}
}
