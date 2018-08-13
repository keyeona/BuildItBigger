package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    private JokeListener jokeListener = null;



    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;
        String name = params[0].second;
        int position = Integer.parseInt(params[0].second);

        try {
            //return myApiService.sayHi(name).execute().getData();
            if (jokeListener != null){
                jokeListener.onError("");
            }
            return myApiService.makeJokes(position).execute().getData();
        } catch (IOException e) {
            if (jokeListener != null){
                Log.e("error",e.getMessage());
                jokeListener.onError(e.getMessage());
            }
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Should I do anything here
        if (jokeListener != null){
            jokeListener.onResult(result);
        }


    }

    public void setJokeListener(JokeListener jokeListener) {
        this.jokeListener = jokeListener;
    }

    public interface JokeListener {
        void onResult(String joke);
        void onError(String error);
    }
}