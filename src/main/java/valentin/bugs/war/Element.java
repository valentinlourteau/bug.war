package valentin.bugs.war;

import javax.inject.Inject;

import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

public class Element {
	
	@Inject @Push
	protected PushContext canvas;

	private double positionX;
	private double positionY;

	public Element(double x, double y) {
		this.positionX = x;
		this.positionY = y;
	}

	public double distanceTo(Element o) {
		return Math.sqrt((o.positionX - positionX) * (o.positionX - positionX)
				+ (o.positionY - positionY) * (o.positionY - positionY));
	}

	public double distanceToCarre(Element o) {
		return (o.positionX - positionX) * (o.positionX - positionX)
				+ (o.positionY - positionY) * (o.positionY - positionY);
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

}
