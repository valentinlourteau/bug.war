package valentin.bugs.war.manager;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

import valentin.bugs.war.Element;
import valentin.bugs.war.agent.Agent;
import valentin.bugs.war.agent.ants.Ant;
import valentin.bugs.war.canvas.Game;
import valentin.bugs.war.canvas.GameCanvasBuilder;

@Dependent
public class GameManager implements Serializable {
	
	@Inject @Push
	private PushContext canvas;

	private static final long serialVersionUID = 1L;

	private Game game;
	private Timer timer;

	/**
	 * Permet d'initialiser la game en lui ajoutant une liste d'élements, des fourmis, de l'environnement..
	 */
	public void init() {
		this.game = GameCanvasBuilder.getInstance().addRandomAgent(10, Ant.class).addRandomEnvironment(5).build();
	}

	public void stop() {
		timer.cancel();
	}

	public void start() {
		TimerTask tache = new TimerTask() {
			@Override
			public void run() {
				canvas.send("CLEAR");
				game.getElements().forEach(element -> {
					if (element instanceof Agent) {
						((Agent) element).playTurn(game.getElements());
						CallJSDraw(element);
					}
				});
			}
		};
		timer = new Timer();
		timer.schedule(tache, 0, 20);
	}
	
	public void clear() {
		init();
		canvas.send("CLEAR");
	}

	public void CallJSDraw(Element e) {
		canvas.send(e);
	}

	public Game getgame() {
		return game;
	}

	public void setgame(Game game) {
		this.game = game;
	}

}
