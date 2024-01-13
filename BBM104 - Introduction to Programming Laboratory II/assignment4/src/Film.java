import java.util.ArrayList;

public class Film
{
    private String filmName;
    private String relativePath;
    private int duration;
    private ArrayList<Hall> filmsHalls;


    public Film(String filmName, String relativePath, int duration)
    {
        this.filmName = filmName;
        this.relativePath = relativePath;
        this.duration = duration;
        filmsHalls = new ArrayList<>();
    }


    public void addHallToFilm(Hall hall)
    {
        filmsHalls.add(hall);
    }


    @Override
    public String toString()
    {
        return "Film: {" +
                "filmName='" + filmName + '\'' +
                ", relativePath='" + relativePath + '\'' +
                ", duration=" + duration +
                '}';
    }

    public String getFilmName()
    {
        return filmName;
    }

    public void setFilmName(String filmName)
    {
        this.filmName = filmName;
    }

    public String getRelativePath()
    {
        return relativePath;
    }

    public void setRelativePath(String relativePath)
    {
        this.relativePath = relativePath;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public ArrayList<Hall> getFilmsHalls()
    {
        return filmsHalls;
    }

    public void setFilmsHalls(ArrayList<Hall> filmsHalls)
    {
        this.filmsHalls = filmsHalls;
    }
}
