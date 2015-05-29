package com.example

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class Hello extends Activity with TypedActivity
{
  override def onCreate( savedInstanceState: Bundle ): Unit =
  {
    super.onCreate( savedInstanceState )

    setContentView( R.layout.main )

    findView( TR.welcome ).setText( "Hello Scala!" )
  }
}