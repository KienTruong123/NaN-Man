package tdtu.dp.Objects;

import java.awt.*;

public abstract class Ghost extends Human{
    protected Image ghostImage;
    public Ghost(float x, float y, float width, float height, float mass, int blood, int power, GWorld gameWorld) {
        super(x, y, width, height, mass, blood, power, gameWorld);
    }

    @Override
    public void draw(Graphics g) {

    }
}
