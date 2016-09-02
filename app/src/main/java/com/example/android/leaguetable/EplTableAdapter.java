package com.example.android.leaguetable;



import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * An {@link EplTableAdapter} knows how to create a list item layout for each clubs
 * in the data source (a list of {@link EplTable} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class EplTableAdapter extends ArrayAdapter<EplTable> {

    private static final String LOG_TAG = EplTableAdapter.class.getSimpleName();


    /**
     * Constructs a new {@link EplTable}.
     *
     * @param context of the app
     * @param eplClubs is the list of club, which is the data source of the adapter
     */
    public EplTableAdapter(Activity context, ArrayList<EplTable> eplClubs) {
        super(context, 0, eplClubs);
    }

    /**
     * Returns a list item view that displays information about the club (table) at the given position
     * in the list of eplClubs.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.epl_table_list, parent, false);
        }

        // Find the EPL club at the given position in the list of eplTables
        EplTable currentClub = getItem(position);


        // Find the TextView with view ID club position
        TextView clubPositionView = (TextView) listItemView.findViewById(R.id.club_position);
        // Display the club position of the current club in that TextView
        String formattedPosition = formatToString(currentClub.getClubPosition());
        clubPositionView.setText(formattedPosition);


        // Find the TextView with view ID club name
        TextView clubNameView = (TextView) listItemView.findViewById(R.id.club_name);
        // Display the current club name in that TextView
        clubNameView.setText(currentClub.getClubName().replaceAll("\\bFC\\b", ""));


        // Find the TextView with view ID games played
        TextView gamesPlayedView = (TextView) listItemView.findViewById(R.id.games_played);
        // Display the number of games played by the club int that TextView
        String formattedGamesPlayed = formatToString(currentClub.getGamesPlayed());
        gamesPlayedView.setText(formattedGamesPlayed);


        // Find the TextView with view ID game won
        TextView gameWonView = (TextView) listItemView.findViewById(R.id.game_won);
        // Display the number of games won by the club in that TextView
        String formattedGameWon = formatToString(currentClub.getGameWon());
        gameWonView.setText(formattedGameWon);


        // Find the TextView with view ID game lost
        TextView gameLostView = (TextView) listItemView.findViewById(R.id.game_lost);
        // Display the number of games lost by the club in that TextView
        String formattedGameLost = formatToString(currentClub.getGameLost());
        gameLostView.setText(formattedGameLost);


        // Find the TextView with view ID goal for
        TextView goalForView = (TextView) listItemView.findViewById(R.id.goal_for);
        // Display the number of goal scored for the club in that TextView
        String formattedGoalFor = formatToString(currentClub.getGoalFor());
        goalForView.setText(formattedGoalFor);


        // Find the TextView with view ID total points
        TextView totalPointsView = (TextView) listItemView.findViewById(R.id.total_points);
        // Display the current total points of the club in that TextView
        String formattedTotalPoints = formatToString(currentClub.getTotalPoints());
        totalPointsView.setText(formattedTotalPoints);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView clubIcon = (ImageView) listItemView.findViewById(R.id.club_image_view);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        clubIcon.setImageResource(getImageResourceId(currentClub.getClubName()));

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    private String formatToString(int x) {
        String rntStr = Integer.toString(x);
        return rntStr;
    }


    private int getImageResourceId(String name) {
        int clubImageResourceId = 0;
        switch (name) {
            case "Arsenal FC":
                clubImageResourceId = R.drawable.arsenal;
                break;
            case "AFC Bournemouth":
                clubImageResourceId = R.drawable.bournemouth;
                break;
            case "Burnley FC":
                clubImageResourceId = R.drawable.burnlby;
                break;
            case "Chelsea FC":
                clubImageResourceId = R.drawable.chelsea;
                break;
            case "Crystal Palace FC":
                clubImageResourceId = R.drawable.crystalpalace;
                break;
            case "Everton FC":
                clubImageResourceId = R.drawable.everton;
                break;
            case "Hull City FC":
                clubImageResourceId = R.drawable.hullcity;
                break;
            case "Leicester City FC":
                clubImageResourceId = R.drawable.leicestercity;
                break;
            case "Liverpool FC":
                clubImageResourceId = R.drawable.liverpool;
                break;
            case "Manchester City FC":
                clubImageResourceId = R.drawable.manchestercity;
                break;
            case "Manchester United FC":
                clubImageResourceId = R.drawable.mufc;
                break;
            case "Middlesbrough FC":
                clubImageResourceId = R.drawable.middlesbrough;
                break;
            case "Southampton FC":
                clubImageResourceId = R.drawable.southampton;
                break;
            case "Stoke City FC":
                clubImageResourceId = R.drawable.stokecity;
                break;
            case "Sunderland AFC":
                clubImageResourceId = R.drawable.sunderland;
                break;
            case "Swansea City FC":
                clubImageResourceId = R.drawable.swansea;
                break;
            case "Tottenham Hotspur FC":
                clubImageResourceId = R.drawable.tottenham;
                break;
            case "Watford FC":
                clubImageResourceId = R.drawable.watford;
                break;
            case "West Bromwich Albion FC":
                clubImageResourceId = R.drawable.westbromwichalbion;
                break;
            case "West Ham United FC":
                clubImageResourceId = R.drawable.westham;
                break;
            default:
                clubImageResourceId = R.drawable.defaultbadge;
                break;
        }
        return clubImageResourceId;
     }
}

