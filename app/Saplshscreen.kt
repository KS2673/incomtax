package com.example.incomtax
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class Saplshscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.OnCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIMEOUT.toLong())
    }

    companion object {
        private const val SPLASH_TIMEOUT = 2000
    }
}