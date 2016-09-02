package com.example.android.leaguetable;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class EplTableActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<EplTable>> {

    public static final String LOG_TAG = EplTableActivity.class.getName();

    /** Adapter for the list of earthquakes */
    private EplTableAdapter mAdapter;

    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;

    /** URL for EPL league table data from the api.football-data.org dataset */
    private static final String DATA_REQUEST_URL =
            "http://api.football-data.org/v1/competitions/425/leagueTable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.epl_table_activity);

        // Find a reference to the {@link ListView} in the layout
        ListView eplTableListView = (ListView) findViewById(R.id.list);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        eplTableListView.setEmptyView(mEmptyStateTextView);

        // Create a new adapter that takes the list of earthquakes as input
        mAdapter = new EplTableAdapter (this, new ArrayList<EplTable>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        eplTableListView.setAdapter(mAdapter);

    }

    /**
     * onCreateLoader(), for when the LoaderManager has determined
     * that the loader with our specified ID isn't running, so we should create a new one.
     */
    @Override
    public EplTableLoader onCreateLoader (int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new EplTableLoader(this, DATA_REQUEST_URL);
    }

    /**
     * onLoadFinished(), where we'll use the earthquake data to update our UI
     * - by updating the dataset in the adapter.
     */
    @Override
    public void onLoadFinished(Loader<List<EplTable>> loader, List<EplTable> eplClubs){
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No earthquakes found."
        mEmptyStateTextView.setText(R.string.no_earthquakes);

        // Clear the adapter of previous clubs data
        mAdapter.clear();

        // If there is a valid list of {@link EplTable}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.

        if(eplClubs != null && !eplClubs.isEmpty()){
            mAdapter.addAll(eplClubs);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<EplTable>> loader) {
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }
}