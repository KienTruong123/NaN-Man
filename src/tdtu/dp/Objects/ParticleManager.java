package tdtu.dp.Objects;

import java.awt.Graphics;
import java.util.Collections;
import java.util.Iterator;
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

	public void addObjects(Iterator<Particle> objects) {
		synchronized (particles) {
			while (objects.hasNext()) {
				particles.add(objects.next());
			}
		}
	}

	public void addObject(Particle Particle) {
		synchronized (particles) {
			particles.add(Particle);
		}
	}

	public Particle getCollisionWidthEnemyObject(Particle object) {
		synchronized (particles) {
			for (Particle particleItor: particles) {
				if (object.getTeamType() != particleItor.getTeamType() && object.getBoundForCollisionWithEnemy()
						.intersects(particleItor.getBoundForCollisionWithEnemy())) {
					return particleItor;
			}
		}
		return null;
		}
	}

	public void updateObjects() {
		synchronized (particles) {
			for (int id = 0; id < particles.size(); id++) {
				Particle object = particles.get(id);
				if (!object.isObjectOutOfCameraView())
					object.update();
				else {particles.remove(id);}
				if (object.getState() == Particle.DEATH) {
					particles.remove(id);
				}
			}
//	System.out.println(particles.size());
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
