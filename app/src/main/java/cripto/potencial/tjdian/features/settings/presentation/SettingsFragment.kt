package cripto.potencial.tjdian.features.settings.presentation


import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.app.extensions.ImageUrlCallback
import cripto.potencial.tjdian.app.extensions.getDrawableFromUrl
import cripto.potencial.tjdian.app.presentation.UiState
import cripto.potencial.tjdian.databinding.FragmentSettingsBinding
import cripto.potencial.tjdian.features.login.domain.UserModel
import cripto.potencial.tjdian.features.login.presentation.SettingsViewModel
import cripto.potencial.tjdian.features.main.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SettingsFragment : PreferenceFragmentCompat() {

    private lateinit var binding: FragmentSettingsBinding

    private val viewModel: SettingsViewModel by viewModels()

    private var count = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(activity as MainActivity) {
            setTitleToolbar("Ajustes")
            supportActionBar?.setDisplayHomeAsUpEnabled(false)


        }
        setUpObserver()
        setupViewStateObservables()
        viewModel.loadUserInfo()


    }

    private fun setUpObserver() {
        val appVersionObserver = Observer<UiState<String>> {
            when (it) {
                is UiState.Loading -> showLoading()
                is UiState.Success -> successAppVersion(it.data)
                is UiState.Error -> errorVersionApp()
            }
        }
        viewModel.appProperties.observe(viewLifecycleOwner, appVersionObserver)
    }

    private fun showLoading() {
        (requireActivity() as MainActivity).showLoadingProgress()
    }

    private fun successAppVersion(data: String) {
        TODO()
    }

    private fun errorVersionApp() {
        TODO()
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings_fragment, rootKey)
        findPreference<Preference>("key_developers")?.setOnPreferenceClickListener {
            developersClicked()
            true
        }
        findPreference<Preference>("key_third_party")?.setOnPreferenceClickListener {
            thirdParties()
            true
        }

        findPreference<Preference>("key_data_user")?.setOnPreferenceClickListener {
            loginClicked()
            true
        }
        findPreference<Preference>("key_policy_privacity")?.setOnPreferenceClickListener {
            //policyPrivacityListener()

            true
        }
        findPreference<Preference>("key_login")?.setOnPreferenceClickListener {

            true
        }
        findPreference<Preference>("key_dark_mode")?.setOnPreferenceClickListener {
            darkMode()
            true
        }

    }

    private fun darkMode() {
        val sharedPreferences: SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(requireContext())
        val nightMode = sharedPreferences.getBoolean("key_dark_mode", false)
        if (nightMode) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) else {
            if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P) AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
            ) else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

    private fun developersClicked() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.linkedin.com/in/tjdian/")
        startActivity(intent)
    }

    private fun setupViewStateObservables() {
        val observer = Observer<UiState<UserModel>> {
            when (it) {
                is UiState.Success -> setInfoUser(it.data)
                is UiState.Error -> errorUserInfo()
                else -> {}
            }
        }
        viewModel.userObservable.observe(requireActivity(), observer)
    }

    private fun errorUserInfo() {
        findPreference<Preference>(getString(R.string.key_data_user))?.let {
            it.isEnabled = false
            it.isIconSpaceReserved = false
            it.icon = null
            it.title = getString(R.string.example_name_user)
            it.summary = getString(R.string.example_email)
        }
    }

    private fun loginClicked() {
        (activity as MainActivity).showFragment(UserSettingsFragment.createInstance())
    }

    private fun setInfoUser(data: UserModel) {
        findPreference<Preference>("key_data_user")?.let {
            it.title = data.name ?: "label_unknow_user"
            it.summary = data.email ?: "label_unknow_email"
            data.urlPhoto?.let { url ->
                it.isIconSpaceReserved = true
                requireContext().getDrawableFromUrl(url, object : ImageUrlCallback {
                    override fun imageLoaded(image: Drawable) {
                        it.icon = image
                    }
                })
            }
        }

    }

    private fun thirdParties() {
        val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {}
            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        }

        val bottomSheetView = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView.parent as View)
        bottomSheetBehavior.setBottomSheetCallback(bottomSheetCallback)


        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        bottomSheetDialog.show()



    }


    companion object {
        fun createInstance() = SettingsFragment()
    }
}