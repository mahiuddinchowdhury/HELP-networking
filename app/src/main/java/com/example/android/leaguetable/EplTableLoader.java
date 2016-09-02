package com.example.android.leaguetable;

import android.content.AsyncTaskLoader;
import android.content.Context;
import java.util.List;

/**
 * Loads a list of clubs data by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class EplTableLoader extends  AsyncTaskLoader<List<EplTable>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EplTableLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link EplTableLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public  EplTableLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<EplTable> loadInBackground(){
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of clubs data.
        List<EplTable> eplClubs = EplTableQueryUtils.fetchEplData(mUrl);

        return eplClubs;
    }
}
