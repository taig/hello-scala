package com.example

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class Hello extends Activity with TypedFindView
{
	override def onCreate( savedInstanceState: Bundle ): Unit =
	{
		super.onCreate( savedInstanceState )

		setContentView( R.layout.main )

		play.api.libs.json.Json.parse( "3" )

		findView( TR.welcome ).setText( "Hello Scala!" )
	}
}