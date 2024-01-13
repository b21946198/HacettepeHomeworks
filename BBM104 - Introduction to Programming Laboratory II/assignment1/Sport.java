public class Sport
{
    private String sportID;                             // ID starts w/ 20..
    private String nameOfSport;
    private int calorieBurned;                          // this calculated for 1 hour


    public Sport(String sportID, String nameOfSport, int calorieBurned)
    {
        this.sportID = sportID;
        this.nameOfSport = nameOfSport;                             // constructor
        this.calorieBurned = calorieBurned;
    }


    public String getSportID() {
        return sportID;
    }

    public String getNameOfSport() { return nameOfSport; }              // for access private fields

    public int getCalorieBurned() {
        return calorieBurned;
    }
}
