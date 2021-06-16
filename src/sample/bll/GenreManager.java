package sample.bll;

import sample.be.Genre;
import sample.dal.DALGenre;
import sample.dal.DAOGenre;

import java.util.List;

public class GenreManager {
    DALGenre dalGenre;

    public GenreManager(){
        dalGenre = new DAOGenre();
    }

    public List<Genre> getAllGenres(){
        return dalGenre.getAllGenres();
    }
}
