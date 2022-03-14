package cripto.potencial.tjdian.features.main.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.databinding.ActivityMainBinding
import cripto.potencial.tjdian.features.cryptocurrency.presentation.CryptoCurrencyFragment
import cripto.potencial.tjdian.features.cryptoinformation.presentation.CryptoInformationFragment
import cripto.potencial.tjdian.features.cryptopotential.presentation.CryptoPotentialFragment
import cripto.potencial.tjdian.features.settings.presentation.SettingsFragment


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpView()
        loadDefaultScreen()

    }

    private fun setUpView(){
        setupToolbar()
        setupMenuButtonListener()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.customToolbar.mainBar)
        supportActionBar?.title = getString(R.string.action_crypto)
    }

    private fun setupMenuButtonListener() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_crypto -> {
                    showFragment(CryptoCurrencyFragment.createInstance())
                    true
                }
                R.id.action_potential_crypto -> {
                    showFragment(CryptoPotentialFragment.createInstance())
                    true
                }
                R.id.action_info_crypto -> {
                    showFragment(CryptoInformationFragment.createInstance())
                    true
                }
                R.id.action_settings -> {
                    showFragment(SettingsFragment.createInstance())
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.container_fragment, fragment)
        fragmentTransition.commit()
    }

    private fun loadDefaultScreen() {
        showFragment(CryptoCurrencyFragment.createInstance())
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.title_exit_app_are_you_sure)
                .setMessage(R.string.message_exit_app_are_you_sure)
                .setNegativeButton(R.string.yes_exit) { dialog, _ ->
                    dialog?.dismiss()
                    finish()
                }
                .setPositiveButton(R.string.no_exit) { dialog, _ -> dialog?.dismiss() }
                .show()
        } else {
            super.onBackPressed()
        }
    }
}