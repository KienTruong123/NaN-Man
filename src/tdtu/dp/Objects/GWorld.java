package tdtu.dp.Objects;

import java.awt.Graphics;

import tdtu.dp.UI.GFrame;

public class GWorld {


	private Man man;
	private GMap map;
	private Camera camera;
	private ParticleManager particleManager;
	
	public ParticleManager getParticleManager() {
		return particleManager;
	}

	public void setParticleManager(ParticleManager particleManager) {
		this.particleManager = particleManager;
	}

	public GWorld() {
		setMan(new Man(300, 400, this));
		getMan().setTeamType(Particle.LEAGUE);
		map = new GMap(0, 0, this);
		camera= new Camera(0, 0, GFrame.SCREEN_WIDTH,GFrame.SCREEN_HEIGHT, this);
		particleManager= new ParticleManager(this);
		particleManager.addObject(getMan());
	}

	public void update() {
		getCamera().update();
		particleManager.updateObjects();
	}

	public void render(Graphics g) {
		map.draw(g);
		particleManager.draw(g);
	}

	public Man getMan() {
		return man;
	}

	public void setMan(Man man) {
		this.man = man;
	}
	
	public GMap getMap() {
		return map;
	}

	public void setMap(GMap map) {
		this.map = map;
	}
	

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}

}
