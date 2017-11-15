package com.example.test

import android.os.Build.VERSION_CODES.LOLLIPOP
import com.example.R
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import org.scalatest.{FlatSpec, Matchers, RobolectricSuite}

@Config(sdk = Array(LOLLIPOP))
class Test extends FlatSpec with Matchers with RobolectricSuite {
  "Resources" should "be accessible via R" in {
    RuntimeEnvironment.application.getString(R.string.name) shouldBe "Hello Scala!"
  }
}
