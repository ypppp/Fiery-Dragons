package game.mechanics.dragons;

public abstract class Dragon {

    protected final String name ;
    protected final String shortName ;
    protected final Enum type;

    public Dragon(String name, String shortName, Enum type) {

        this.name = name ;
        this.shortName = shortName ;
        this.type = type;
    }

    public String getName() {
        return this.name ;
    }

    public String getShortName() {
        return this.shortName ;
    }
    
    public Enum getType(){
        return this.type ;
    }
}
