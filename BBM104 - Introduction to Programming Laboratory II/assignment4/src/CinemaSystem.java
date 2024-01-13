import java.io.IOException;

public class CinemaSystem
{
    private Database database;

    public CinemaSystem(Database database) throws IOException
    {
        this.database = database;
    }


    public User obtainUser(String username)                                             // get user by username
    {
        for(User user : database.getUsers())
        {
            if(user.getUsername().equals(username))
            {
                return user;
            }
        }

        return null;
    }


    public Film obtainFilm(String filmName)                                             // get film by film name
    {
        for(Film film : database.getFilms())
        {
            if(film.getFilmName().equals(filmName))
            {
                return film;
            }
        }
        return null;
    }


    public Hall obtainHall(String hallName, Film film)                                  // get hall by hall name
    {
        for(Hall hall : database.getHalls())
        {
            if(hall.getHallName().equals(hallName) && hall.getFilmName().equals(film.getFilmName()))
            {
                return hall;
            }
        }
        return null;
    }


    public void addUser(String username, String password)                                                   // add user to the system
    {
        String hashedPassword = Constants.hashPassword(password);
        User user = new User(username, hashedPassword, false, false);
        database.getUsers().add(user);
    }


    public Database getDatabase()
    {
        return database;
    }

    public void setDatabase(Database database)
    {
        this.database = database;
    }

}
