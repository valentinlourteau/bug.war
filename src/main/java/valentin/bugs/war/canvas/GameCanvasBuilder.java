package valentin.bugs.war.canvas;

import java.lang.reflect.InvocationTargetException;

import valentin.bugs.war.Element;
import valentin.bugs.war.agent.Agent;
import valentin.bugs.war.environment.Environment;

public final class GameCanvasBuilder {

	private GameCanvasBuilder() {

	}

	private Game gameCanvas;

	public static GameCanvasBuilder getInstance() {
		GameCanvasBuilder gc = new GameCanvasBuilder();
		gc.gameCanvas = new Game();
		return gc;
	}

	public GameCanvasBuilder addRandomEnvironment(int amount) {
		for (int i = 0; i < amount; i++) {
			Element element = new Environment();
			this.gameCanvas.getElements().add(element);
		}
		return this;
	}

	public <E extends Agent> GameCanvasBuilder addRandomAgent(int amount, Class<E> classs) {
		for (int i = 0; i < amount; i++) {
			Agent agent = null;
			try {
				agent = classs.getConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
			if (agent != null)
				this.gameCanvas.getElements().add(agent);
		}
		return this;
	}
	
	public Game build() {
		return this.gameCanvas;
	}

}
