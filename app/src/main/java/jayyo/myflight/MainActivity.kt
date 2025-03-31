package jayyo.myflight

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.FirebaseApp
import com.google.firebase.appcheck.ktx.appCheck
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory
import com.google.firebase.installations.ktx.installations
import com.google.firebase.ktx.Firebase
import jayyo.myflight.databinding.ActivityMainBinding
import jayyo.myflight.ui.ExchangeFragment
import jayyo.myflight.ui.FlightFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment: Fragment = FlightFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }

        binding.btnFlight.setOnClickListener({
            val fragment: Fragment = FlightFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        })

        binding.btnExchange.setOnClickListener({
            val fragment: Fragment = ExchangeFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        })

        val firebaseApp = FirebaseApp.initializeApp(applicationContext)
        if (firebaseApp != null) {
            Firebase.installations(app = firebaseApp)
            Firebase.appCheck.installAppCheckProviderFactory(
                PlayIntegrityAppCheckProviderFactory.getInstance(),
            )
        }
    }
}