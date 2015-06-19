package com.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class Activity extends AppCompatActivity with TypedFindView
{
	override def onCreate( savedInstanceState: Bundle ): Unit =
	{
		super.onCreate( savedInstanceState )

		setContentView( R.layout.main )

		findView( TR.welcome ).setText( R.string.name )
	}
}