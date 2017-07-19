package valentin.bugs.war.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import valentin.bugs.war.manager.GameManager;

@ViewScoped
@Named
public class IndexController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GameManager canvasManager;

	@PostConstruct
	public void startGame() {
		canvasManager.init();
	}
	
	public void start() {
		canvasManager.start();
	}
	
	public void stop() {
		canvasManager.stop();
	}
	
	public void clear() {
		canvasManager.clear();
	}

	public GameManager getCanvasManager() {
		return canvasManager;
	}
	
	@PreDestroy
	public void onKillView() {
		canvasManager.stop();
	}

}
