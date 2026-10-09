package com.gitkey.build

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.gitkey.build.crypto.KeystoreGenerator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

  @Test
  fun testAppNameString() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("GitKey", appName)
  }

  @Test
  fun testKeystoreGenerator() {
    val config = KeystoreGenerator.KeystoreConfig()
    config.projectName = "TestApp"
    config.alias = "testalias"
    config.storePassword = "password123"
    config.keyPassword = "password123"

    val result = KeystoreGenerator.generate(config)
    assertNotNull(result.keystoreBytes)
    assertNotNull(result.base64Secret)
    assertEquals("testalias", result.alias)
  }
}
