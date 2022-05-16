package cripto.potencial.tjdian.features.main.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.databinding.ActivityMainBinding
import cripto.potencial.tjdian.features.cryptocurrency.presentation.CryptoCurrencyFragment
import cripto.potencial.tjdian.features.cryptoinformation.presentation.CryptoInformationFragment
import cripto.potencial.tjdian.features.cryptopotential.presentation.CryptoPotentialFragment
import cripto.potencial.tjdian.features.settings.presentation.SettingsFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(binding.root)
        setUpView()
        loadDefaultScreen()

    }

    private fun setUpView() {
        setupMenuButtonListener()
    }

    private fun setupToolbar(title: String) {
        setSupportActionBar(binding.customToolbar.mainBar)
        setTitleToolbar(title)
    }

    private fun setupMenuButtonListener() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_crypto -> {
                    showFragment(CryptoCurrencyFragment.createInstance())
                    setupToolbar(getString(R.string.action_crypto))
                    true
                }
                R.id.action_potential_crypto -> {
                    showFragment(CryptoPotentialFragment.createInstance())
                    setupToolbar(getString(R.string.action_potential_crypto))
                    true
                }
                R.id.action_info_crypto -> {
                    showFragment(CryptoInformationFragment.createInstance())
                    setupToolbar(getString(R.string.action_info_crypto))
                    true
                }
                R.id.action_settings -> {
                    showFragment(SettingsFragment.createInstance())
                    setupToolbar(getString(R.string.action_settings))
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }
    }
    fun setTitleToolbar(title: String) {
        supportActionBar?.title = title
    }

     fun showFragment(fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.container_fragment, fragment)
        fragmentTransition.commit()
    }

    private fun loadDefaultScreen() {
        showFragment(CryptoCurrencyFragment.createInstance())
        setupToolbar(getString(R.string.action_crypto))
    }


    fun showLoadingProgress() = binding.viewProgressIndicator.show()

    fun hideLoadingProgress() = binding.viewProgressIndicator.hide()
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