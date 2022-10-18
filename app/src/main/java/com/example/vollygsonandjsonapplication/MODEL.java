package com.example.vollygsonandjsonapplication;

import com.google.gson.annotations.SerializedName;

public class MODEL
{
    @SerializedName("name")
    public String gameCompanyName;
    @SerializedName("year")
    public String gameCompanyYearFounded;
    @SerializedName("recentConsole")
    public String gameCompanyLatestConsole;


    public MODEL (String name, String year, String console)
    {
        gameCompanyName = name;
        gameCompanyYearFounded = year;
        gameCompanyLatestConsole = console;
    }
    /** getters */
    public String getGameCompanyNameName()
    {
        return gameCompanyName;
    }

    public String getGameCompanyYearFounded()
    {
        return gameCompanyYearFounded;
    }

    public String getGameCompanyLatestConsole()
    {
        return gameCompanyLatestConsole;
    }

    /** setters */
    public void setGameCompanyName(final String mediaTitle)
    {
        this.gameCompanyName = mediaTitle;
    }

    public void setGameCompanyYearFounded(final String mediaDescription)
    {
        this.gameCompanyYearFounded = mediaDescription;
    }

    public void setGameCompanyLatestConsole(final String mediaYear)
    {
        this.gameCompanyLatestConsole = mediaYear;
    }
}
