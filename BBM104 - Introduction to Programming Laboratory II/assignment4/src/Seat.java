public class Seat
{
    private String filmName;
    private String hallName;
    private int rowOfSeat;
    private int columnOfSeat;
    private String ownerName;                            // null if not owned
    private int priceItHasBeenBought;                   // it can be any number if seat is not bought yet


    public Seat(String filmName, String hallName, int rowOfSeat, int columnOfSeat, String ownerName, int priceItHasBeenBought)
    {
        this.filmName = filmName;
        this.hallName = hallName;
        this.rowOfSeat = rowOfSeat;
        this.columnOfSeat = columnOfSeat;
        this.ownerName = ownerName;
        this.priceItHasBeenBought = priceItHasBeenBought;
    }


    @Override
    public String toString()
    {
        return "Seat: {" +
                "filmName='" + filmName + '\'' +
                ", hallName='" + hallName + '\'' +
                ", rowOfSeat=" + rowOfSeat +
                ", columnOfSeat=" + columnOfSeat +
                ", ownerName='" + ownerName + '\'' +
                ", priceItHasBeenBought=" + priceItHasBeenBought +
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

    public int getRowOfSeat()
    {
        return rowOfSeat;
    }

    public void setRowOfSeat(int rowOfSeat)
    {
        this.rowOfSeat = rowOfSeat;
    }

    public int getColumnOfSeat()
    {
        return columnOfSeat;
    }

    public void setColumnOfSeat(int columnOfSeat)
    {
        this.columnOfSeat = columnOfSeat;
    }

    public String getOwnerName()
    {
        return ownerName;
    }

    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public int getPriceItHasBeenBought()
    {
        return priceItHasBeenBought;
    }

    public void setPriceItHasBeenBought(int priceItHasBeenBought)
    {
        this.priceItHasBeenBought = priceItHasBeenBought;
    }
}
