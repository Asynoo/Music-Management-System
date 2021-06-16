package sample.be;

public class Artist {
    private String name;
    private int ID;

    public Artist (int ID,String name){
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return ID + " " + name;
    }
}
