package tdtu.dp.Objects;

import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ParticleManager {
	protected List<Particle> particles;

	private GWorld gameWorld;

	public ParticleManager(GWorld gameWorld) {
		particles = Collections.synchronizedList(new LinkedList<Particle>());
		this.gameWorld = gameWorld;
	}

	public GWorld getGameWorld() {
		return gameWorld;
	}

	public void addObject(Particle Particle) {
		synchronized (particles) {
			particles.add(Particle);
		}
	}

	public void RemoveObject(Particle Particle) {
		synchronized (particles) {
			for (int id = 0; id < particles.size(); id++) {
				Particle object = particles.get(id);
				if (object == Particle)
					particles.remove(id);
			}
		}
	}

	public Particle getCollisionWidthEnemyObject(Particle object) {
		synchronized (particles) {
			for (int id = 0; id < particles.size(); id++) {
				Particle objectInList = particles.get(id);
				if (object.getTeamType() != objectInList.getTeamType() && object.getBoundForCollisionWithEnemy()
						.intersects(objectInList.getBoundForCollisionWithEnemy())) {
					return objectInList;
				}
			}
		}
		return null;
	}

	public void updateObjects() {
		synchronized (particles) {
			for (int id = 0; id < particles.size(); id++) {
				Particle object = particles.get(id);
				if (!object.isObjectOutOfCameraView())
					object.update();
				if (object.getState() == Particle.DEATH) {
					particles.remove(id);
				}
			}
		}
	}

	public void draw(Graphics g) {
		synchronized (particles) {
			for (Particle object : particles)
				if (!object.isObjectOutOfCameraView())
					object.draw(g);
		}
	}
}
