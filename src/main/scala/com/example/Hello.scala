package com.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class Hello extends AppCompatActivity with TypedFindView
{
	override def onCreate( savedInstanceState: Bundle ): Unit =
	{
		super.onCreate( savedInstanceState )

		setContentView( R.layout.main )

		play.api.libs.json.Json.parse( "3" )

		findView( TR.welcome ).setText( "Hello Scala!" )
	}
}