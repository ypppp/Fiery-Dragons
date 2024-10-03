package game.mechanics;

import game.mechanics.dragons.*;

public class Player {

    protected int id ;
    private Dragon dragon ;
    private Token token ;

    private boolean hasShuffled;
    private boolean hasSkipped;

    public Player(int id, String selectedDragon) {
        switch (selectedDragon) {
            case "Salamander":
                this.dragon = new Salamander() ;
                break ;
            case "Spider":
                this.dragon = new Spider() ;
                break ;
            case "Baby Dragon":
                this.dragon = new BabyDragon() ;
                break ;
            case "Bat":
                this.dragon = new Bat() ;
                break ;
            default:
                break ;
        }
        this.id = id ;
        this.token = new Token(id, this.dragon) ;

        this.hasShuffled = false;
        this.hasSkipped = false;
    }

    public Token getToken() {
        return token;
    }

    public String getDragonName() {
        return dragon.getName() ;
    }

    public int getId() {
        return id;
    }

    public boolean hasShuffled() {
        return hasShuffled;
    }

    public void useShuffle() {
        this.hasShuffled = true;
    }

    public boolean hasSkipped() {
        return hasSkipped;
    }

    public void useSkipped() {
        this.hasSkipped = true;
    }
}
