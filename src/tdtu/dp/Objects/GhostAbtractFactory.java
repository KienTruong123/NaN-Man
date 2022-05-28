package tdtu.dp.Objects;

import java.util.Random;

public class GhostAbtractFactory {
    private static Random random = new Random();
    public static Ghost createRandomGhost(float x,
                                          float y,
                                          GWorld gameWorld){
        if(x<20)
            x=20;
        if(y<20)
            y=20;
        if(random.nextBoolean()){
            return new HappyGhost(x,y,gameWorld);
        }else {
            return new ShapeshiftingGhost(x,y,gameWorld);
        }
    }
}
