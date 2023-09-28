import java.util.ArrayList;

public class Database
{
    private ArrayList<User> users;
    private ArrayList<Film> films;
    private ArrayList<Hall> halls;
    private ArrayList<Seat> seats;


    public Database(ArrayList<ArrayList<String>> data)
    {
        users = new ArrayList<>();
        films = new ArrayList<>();
        halls = new ArrayList<>();
        seats = new ArrayList<>();

        organizeData(data);
        addHallsToFilms();
    }


    public void organizeData(ArrayList<ArrayList<String>> data)                                                     // read data file and set users, films, halls and seats
    {
        if(data.size() == 1)
        {
            String username = data.get(0).get(1);
            String password = data.get(0).get(2);
            String hashed = Constants.hashPassword(password);
            boolean isClubMember = Boolean.parseBoolean(data.get(0).get(3));
            boolean isAdmin = Boolean.parseBoolean(data.get(0).get(4));

            User user = new User(username, hashed, isClubMember, isAdmin);
            users.add(user);
            System.out.println(user);

            return;
        }

        for(ArrayList<String> list : data)
        {
            if(list.size() == 0)
                continue;

            if(list.get(0).equals("user"))
            {
                String username = list.get(1);
                String password = list.get(2);
                boolean isClubMember = Boolean.parseBoolean(list.get(3));
                boolean isAdmin = Boolean.parseBoolean(list.get(4));

                User user = new User(username, password, isClubMember, isAdmin);
                users.add(user);
            }

            else if(list.get(0).equals("film"))
            {
                String filmName = list.get(1);
                String relativePath = list.get(2);
                int duration = Integer.parseInt(list.get(3));

                Film film = new Film(filmName, relativePath, duration);
                films.add(film);
            }

            else if(list.get(0).equals("hall"))
            {
                String filmName = list.get(1);
                String hallName = list.get(2);
                int pricePerSeat = Integer.parseInt(list.get(3));
                int numberOfRows = Integer.parseInt(list.get(4));
                int numberOfColumns = Integer.parseInt(list.get(5));

                Hall hall = new Hall(filmName, hallName, pricePerSeat, numberOfRows, numberOfColumns);
                halls.add(hall);
            }

            else if(list.get(0).equals("seat"))
            {
                String filmName = list.get(1);
                String hallName = list.get(2);
                int rowOfSeat = Integer.parseInt(list.get(3));
                int columnOfSeat = Integer.parseInt(list.get(4));
                String ownerName = list.get(5);
                int priceItHasBeenBought = Integer.parseInt(list.get(6));

                Seat seat = new Seat(filmName, hallName, rowOfSeat, columnOfSeat, ownerName, priceItHasBeenBought);
                seats.add(seat);
            }
        }
    }


    public void addHallsToFilms()
    {
        for(Film film : films)
        {
            for(Hall hall : halls)
            {
                if(hall.getFilmName().equals(film.getFilmName()))
                {
                    film.addHallToFilm(hall);
                }
            }
        }
    }


    public ArrayList<User> getUsers()
    {
        return users;
    }

    public ArrayList<Film> getFilms()
    {
        return films;
    }

    public ArrayList<Hall> getHalls()
    {
        return halls;
    }

    public ArrayList<Seat> getSeats()
    {
        return seats;
    }
}
