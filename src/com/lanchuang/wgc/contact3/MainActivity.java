package com.lanchuang.wgc.contact3;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

@SuppressWarnings("deprecation")
public class MainActivity extends ListActivity
{

	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);

		listView = new ListView(this);

		Cursor cursor = getContentResolver().query(People.CONTENT_URI ,null ,null ,null ,null);

		startManagingCursor(cursor);
		ListAdapter listAdapter = new SimpleCursorAdapter(this , android.R.layout.simple_expandable_list_item_2 , cursor , new String []
		{ People.NAME, People.NUMBER } , new int []
		{ android.R.id.text1, android.R.id.text2 });

		listView.setAdapter(listAdapter);

		setContentView(listView);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu )
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main ,menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item )
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
