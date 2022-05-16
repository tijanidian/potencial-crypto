package cripto.potencial.tjdian.features.settings.presentation


import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
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
            //developersClicked()
            true
        }
        findPreference<Preference>("key_third_party")?.setOnPreferenceClickListener {
            //thirdPartiesClicked()
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


    companion object {
        fun createInstance() = SettingsFragment()
    }
}