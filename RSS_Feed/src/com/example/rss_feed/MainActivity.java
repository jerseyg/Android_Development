package com.example.rss_feed;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rss_feed.data.*;
import com.example.rss_feed.listeners.*;
import com.example.rss_feed.util.*;


 
public class MainActivity extends Activity {

	 // A reference to the local object
    private MainActivity local;
     
    /**
     * This method creates main application view
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set view
        setContentView(R.layout.activity_main);
 
        // Set reference to this activity
        local = this;
         
        GetRSSDataTask task = new GetRSSDataTask();
         
        // Start download RSS task
        task.execute("http://www.tomshardware.com/feeds/atom/tom-s-hardware-us,18-2.xml");
       
    }
     
    private class GetRSSDataTask extends AsyncTask<String, Void, List<RssAtomItem> > {
        @Override
        protected List<RssAtomItem> doInBackground(String... urls) {
             
            try {
                // Create RSS reader
                RssAtomReader rssReader = new RssAtomReader(urls[0]);
             
                // Parse RSS, get items
                return rssReader.getItems();
             
            } catch (Exception e) {
                
            }
             
            return null;
        }
         
        @Override
        protected void onPostExecute(List<RssAtomItem> result) {
             
            // Get a ListView from main view
            ListView itcItems = (ListView) findViewById(R.id.listMainView);
                         
            // Create a list adapter
            ArrayAdapter<RssAtomItem> adapter = new ArrayAdapter<RssAtomItem>(local,android.R.layout.simple_list_item_1, result);
            // Set list adapter for the ListView
            itcItems.setAdapter(adapter);
                         
            // Set list view item click listener
            itcItems.setOnItemClickListener(new ListListener(result, local));
        }
    }

}
