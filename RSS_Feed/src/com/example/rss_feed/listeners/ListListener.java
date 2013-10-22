package com.example.rss_feed.listeners;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.rss_feed.data.*;
import com.example.rss_feed.*;


public class ListListener implements OnItemClickListener {

	// List item's reference
	List<RssAtomItem> listItems;
	// Calling activity reference
	Activity activity;
	
	public ListListener(List<RssAtomItem> aListItems, Activity anActivity) {
		listItems = aListItems;
		activity  = anActivity;
	}
	
	public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
		Intent i = new Intent(activity, DetailsActivity.class);
		i.setData(Uri.parse(listItems.get(pos).getContent()));
		
		i.putExtra("title", listItems.get(pos).getTitle());
		i.putExtra("content", listItems.get(pos).getContent());
		
		activity.startActivity(i);
		
	}
	
}

