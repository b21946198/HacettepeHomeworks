import java.util.ArrayList;

public class Hall
{
    private String filmName;
    private String hallName;
    private int pricePerSeat;
    private int numberOfRows;
    private int numberOfColumns;
    private ArrayList<int[]> takenSeats;


    public Hall(String filmName, String hallName, int pricePerSeat, int numberOfRows, int numberOfColumns)
    {
        this.filmName = filmName;
        this.hallName = hallName;
        this.pricePerSeat = pricePerSeat;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        takenSeats = new ArrayList<>();
    }


    @Override
    public String toString()
    {
        return "Hall: {" +
                "filmName='" + filmName + '\'' +
                ", hallName='" + hallName + '\'' +
                ", pricePerSeat=" + pricePerSeat +
                ", numberOfRows=" + numberOfRows +
                ", numberOfColumns=" + numberOfColumns +
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

    public String getHallName()
    {
        return hallName;
    }

    public void setHallName(String hallName)
    {
        this.hallName = hallName;
    }

    public int getPricePerSeat()
    {
        return pricePerSeat;
    }

    public void setPricePerSeat(int pricePerSeat)
    {
        this.pricePerSeat = pricePerSeat;
    }

    public int getNumberOfRows()
    {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows)
    {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns()
    {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns)
    {
        this.numberOfColumns = numberOfColumns;
    }

    public ArrayList<int[]> getTakenSeats()
    {
        return takenSeats;
    }

    public void setTakenSeats(ArrayList<int[]> takenSeats)
    {
        this.takenSeats = takenSeats;
    }
}
