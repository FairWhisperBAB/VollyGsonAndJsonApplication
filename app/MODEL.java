import com.google.gson.annotations.SerializedName;

public class MODEL
{
    @SerializedName ("name")
    public String gameCompanyName;
    @SerializedName ("year")
    public int gameCompanyYearFounded;
    @SerializedName ("recentConsoles")
    public String gameCompanyLatestConsole;


    public MODEL(String name, int year, String console)
    {
        gameCompanyName = name;
        gameCompanyYearFounded = year;
        gameCompanyLatestConsole = console;
    }
}
