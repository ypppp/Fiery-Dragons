package game.assets;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * NOTE TO ANYONE WHOS TRYING TO USE THIS
 * 
 * Example usage:
 * Image playerOneToken = Assets.getPlayer1()
 */

public class Assets {

    public static final Image PLAYER1 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/player1.png")));
    public static final Image PLAYER2 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/player2.png")));
    public static final Image PLAYER3 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/player3.png")));
    public static final Image PLAYER4 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/player4.png")));

    public static final Image ANIMALCARD = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/animalcard.png")));
    public static final Image PIRATECARD = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/piratecard.png")));

    public static final Image BAT1 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/blue1.png")));
    public static final Image BAT2 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/blue2.png")));
    public static final Image BAT3 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/blue3.png")));

    public static final Image SPIDER1 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/red1.png")));
    public static final Image SPIDER2 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/red2.png")));
    public static final Image SPIDER3 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/red3.png")));

    public static final Image BABYDRAGON1 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/green1.png")));
    public static final Image BABYDRAGON2 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/green2.png")));
    public static final Image BABYDRAGON3 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/green3.png")));

    public static final Image SALAMANDER1 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/yellow1.png")));
    public static final Image SALAMANDER2 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/yellow2.png")));
    public static final Image SALAMANDER3 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/yellow3.png")));

    public static final Image PIRATE1 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/pirate1.png")));
    public static final Image PIRATE2 = new Image(Objects.requireNonNull(Assets.class.getResourceAsStream("/assets/dragoncards/pirate2.png")));

    // GETTERS

    public static Image getPlayer1() {
        return PLAYER1;
    }

    public static Image getPlayer2() {
        return PLAYER2;
    }

    public static Image getPlayer3() {
        return PLAYER3;
    }

    public static Image getPlayer4() {
        return PLAYER4;
    }

    public static Image getAnimalCard() {
        return ANIMALCARD;
    }

    public static Image getPirateCard() {
        return PIRATECARD;
    }

    public static Image getBat1() {
        return BAT1;
    }

    public static Image getBat2() {
        return BAT2;
    }

    public static Image getBat3() {
        return BAT3;
    }

    public static Image getSpider1() {
        return SPIDER1;
    }

    public static Image getSpider2() {
        return SPIDER2;
    }

    public static Image getSpider3() {
        return SPIDER3;
    }

    public static Image getBabyDragon1() {
        return BABYDRAGON1;
    }

    public static Image getBabyDragon2() {
        return BABYDRAGON2;
    }

    public static Image getBabyDragon3() {
        return BABYDRAGON3;
    }

    public static Image getSalamander1() {
        return SALAMANDER1;
    }

    public static Image getSalamander2() {
        return SALAMANDER2;
    }

    public static Image getSalamander3() {
        return SALAMANDER3;
    }

    public static Image getPirate1() {
        return PIRATE1;
    }

    public static Image getPirate2() {
        return PIRATE2;
    }
}