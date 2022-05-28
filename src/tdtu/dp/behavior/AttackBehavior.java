package tdtu.dp.behavior;

import tdtu.dp.Objects.GWorld;

public interface AttackBehavior {
    public void attack(float x, float y, float speedX,float speedY, int direction,boolean teamType , GWorld gWorld);

}
