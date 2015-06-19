package com.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.TextView

class Hello extends AppCompatActivity with TypedFindView
{
	override def onCreate( savedInstanceState: Bundle ): Unit =
	{
		super.onCreate( savedInstanceState )

		setContentView( R.layout.main )

		setSupportActionBar( findView( TR.toolbar ) )
		getSupportActionBar.setDisplayHomeAsUpEnabled( true )

		findView( TR.welcome ).setText( R.string.name )
	}

	override def onOptionsItemSelected( item: MenuItem ) = item.getItemId match
	{
		case android.R.id.home =>
		{
			finish()
			true
		}
		case _ => super.onOptionsItemSelected( item )
	}
}