package sample.be;

public class Genre {
    private String name;
    private  int ID;

    public Genre(int ID,String name){
        this.ID=ID;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return ID + " " + name;
    }
}
