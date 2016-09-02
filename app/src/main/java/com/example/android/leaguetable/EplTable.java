package com.example.android.leaguetable;

/**
 * An {@link EplTable} object contains information related to EPL table.
 */
public class EplTable{

    /** Positions of the club in the table */
    private int mPosition;

    /** Name of the Club */
    private String mClubName;

    /** Number of games played */
    private int mGamesPlayed;

    /** Number of games won*/
    private int mGameWon;


    /** Number of games lost*/
    private int mGameLost;


    /** Number of goal scored for the club*/
    private int mGoalFor;


    /** Current total points of the club*/
    private int mTotalPoints;


    /**
     * Constructs a new {@link EplTable} object.
     */

    public EplTable(int position, String clubName, int gamesPlayed, int gameWon, int gameLost, int goalFor, int totalPoints) {
        mPosition = position;
        mClubName = clubName;
        mGamesPlayed = gamesPlayed;
        mGameWon = gameWon;
        mGameLost = gameLost;
        mGoalFor = goalFor;
        mTotalPoints = totalPoints;
    }

    /**
     * Returns the position of the club.
     */
    public int getClubPosition() {
        return mPosition;
    }

    /**
     * Returns the club name.
     */
    public String getClubName() {
        return mClubName;
    }

    /**
     * Returns the number of games played by the club.
     */
    public int getGamesPlayed() {
        return mGamesPlayed;
    }

    /**
     * Returns the number of games won by the club.
     */
    public int getGameWon() {
        return mGameWon;
    }

    /**
     * Returns the number of games lost by the club.
     */
    public int getGameLost() {
        return mGameLost;
    }


    /**
     * Returns the number of goal scored for the club.
     */
    public int getGoalFor() {
        return mGoalFor;
    }


    /**
     * Returns the current total points of the club.
     */
    public int getTotalPoints() {
        return mTotalPoints;
    }
}

