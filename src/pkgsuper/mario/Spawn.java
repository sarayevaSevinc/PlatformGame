package pkgsuper.mario;

import java.util.Random;


/**
 *
 * @author Sevinc Sarayeva
 */
public class Spawn {

    private final Handler handler;
    private final Player player;
    private int counter;
    private int coins;
    private boolean isFastEnemyExist;
    private boolean isBasicEnemyExist;
    private boolean isSmartEnemyExist;
    private final Random random;
    private int width = 1200;
    private int height = 800;

    public Spawn() {
        this.handler = StaticFields.handler;
        this.player = StaticFields.player;
        this.random = new Random();
        isFastEnemyExist = StaticFields.isFastEnemyExist;
    }

    public void tick() {
//        counter++;
//        coins++;
//        if (player.getCoin() >= 7 && !isFastEnemyExist) {
//            handler.addObject(new FastAndUnpredictableEnemy(random.nextInt(width),
//                    random.nextInt(height), ID.FastEnemy));
//            isFastEnemyExist = true;
//        }
//        if (!isSmartEnemyExist) {
//            handler.addObject(new SmartEnemy(random.nextInt(width), random.nextInt(height), ID.SimpleEnemy));
//            counter = 0;
//            isSmartEnemyExist = true;
//        }
//        if (player.getHealth() <= 50 && counter > 60 && player.getHealth() > 0) {
//            handler.addObject(new Health(random.nextInt(width), random.nextInt(height), ID.Health));
//            counter = 0;
//        }
//        if (player.getCoin() == 5 && !isSmartEnemyExist) {
//            handler.addObject(new SmartEnemy(random.nextInt(width), random.nextInt(height), ID.SimpleEnemy));
//            isSmartEnemyExist = true;
//        }
//        if (coins == 300 && player.getHealth() > 0) {
//            handler.addObject(new Coin(random.nextInt(width), random.nextInt(height), ID.Coin));
//            coins = 0;
//        }
//        if (coins >= 200) {
//            player.velX = player.velX + 5;
//            player.velY = player.velY + 5;
//        }
    }

}
