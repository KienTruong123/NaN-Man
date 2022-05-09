package tdtu.dp.Objects;

import java.awt.Rectangle;

public abstract class Human extends Particle{
	private boolean isJumping;
    private boolean isDicking;
    
    private boolean isLanding;

    public Human(float x, float y, float width, float height, float mass, int blood, GWorld gameWorld) {
        super(x, y, width, height, mass, blood, gameWorld);
        setState(ALIVE);
    }

    public abstract void run();
    
    public abstract void jump();
    
    public abstract void dick();
    
    public abstract void standUp();
    
    public abstract void stop();

    public boolean getIsJumping() {
        return isJumping;
    }
    
    public void setIsLanding(boolean isLanding){
        this.isLanding = isLanding;
    }
    
    public boolean getIsLanding(){
        return isLanding;
    }
    
    public void setIsJumping(boolean isJumping) {
        this.isJumping = isJumping;
    }

    public boolean getIsDicking() {
        return isDicking;
    }

    public void setIsDicking(boolean isDicking) {
        this.isDicking = isDicking;
    }
    
    @Override
    public void update(){
        super.update();
        
        if(getState() == ALIVE || getState() == NOBEHURT){
        	
            if(!getIsLanding()){
                setX(getX() + getSpeedX());
                if(getDirection() == LEFT_DIR && 
                        getGameWorld().getMap().getLeftWallCollision(getBoundForCollisionWithMap())!=null){
                    Rectangle rectLeftWall = getGameWorld().getMap().getLeftWallCollision(getBoundForCollisionWithMap());
                    setX(rectLeftWall.x + rectLeftWall.width + getWidth()/2);
                }
                else if(getDirection() == RIGHT_DIR && 
                        getGameWorld().getMap().getRightWallCollision(getBoundForCollisionWithMap())!=null){
                    Rectangle rectRightWall = getGameWorld().getMap().getRightWallCollision(getBoundForCollisionWithMap());
                    setX(rectRightWall.x - getWidth()/2);
                }
          
                Rectangle boundForCollisionWithMapFuture = getBoundForCollisionWithMap();
                boundForCollisionWithMapFuture.y += (getSpeedY()!=0?getSpeedY(): 2);
                
                Rectangle rectLand = getGameWorld().getMap().getLandCollision(boundForCollisionWithMapFuture);
                Rectangle rectTop = getGameWorld().getMap().getTopCollision(boundForCollisionWithMapFuture);
                
                if(rectTop !=null){
                    setSpeedY(0);
                    setY(rectTop.y + getGameWorld().getMap().getBrickSize() + getHeight()/2);
                    
                }else if(rectLand != null){
                    setIsJumping(false);
                    if(getSpeedY() > 0) setIsLanding(true);
                    setSpeedY(0);
                    setY(rectLand.y - getHeight()/2 - 1);
                }else{
                    setIsJumping(true);
                    setSpeedY(getSpeedY() + getMass());
                    setY(getY() + getSpeedY());
                }
                
            }
        }
    }
    
}
