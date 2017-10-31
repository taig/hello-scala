package com.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

class Hello extends AppCompatActivity {
    override def onCreate( savedInstanceState: Bundle ): Unit = {
        super.onCreate( savedInstanceState )

        val view: TypedViewHolder.main =
            TypedViewHolder.setContentView( this, TR.layout.main )

        setSupportActionBar( view.toolbar )
        getSupportActionBar.setDisplayHomeAsUpEnabled( true )

        view.welcome.setText( R.string.name )
    }

    override def onOptionsItemSelected( item: MenuItem ): Boolean =
        item.getItemId match {
            case android.R.id.home ⇒
                finish()
                true
            case _ ⇒ super.onOptionsItemSelected( item )
        }
}