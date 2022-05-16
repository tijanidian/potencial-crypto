package cripto.potencial.tjdian.features.settings.presentation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import cripto.potencial.tjdian.R
import cripto.potencial.tjdian.features.main.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserSettingsFragment : PreferenceFragmentCompat() {

    private val userViewModel: UserSettingsViewModel by viewModels()

    private val viewModelUserSettings: UserSettingsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).setTitleToolbar(getString(R.string.settings_title_user))
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setHasOptionsMenu(true)

    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.user_settings_fragment, rootKey)
        findPreference<Preference>(getString(R.string.key_close_session))?.setOnPreferenceClickListener {
            singOutWarning()
            true
        }

        findPreference<Preference>(getString(R.string.key_remove_account))?.setOnPreferenceClickListener {
            removeAccountWarning()
            true
        }
    }

    private fun singOutWarning() {
        val dialogBuilder = AlertDialog.Builder(requireContext(), R.style.AlertDialogMaterialTheme)
        MaterialAlertDialogBuilder(requireContext())
        dialogBuilder.setTitle(R.string.title_sing_out_app_are_you_sure)
        dialogBuilder.setMessage(R.string.message_sing_out_app_are_you_sure)
        dialogBuilder.setPositiveButton(R.string.no_exit) { dialog, _ ->
            dialog?.dismiss()
        }
            .setNegativeButton(
                R.string.alert_dialog_positive
            ) { dialog, _ ->
                singOut()
                dialog?.dismiss()
            }
            .show()
    }

    private fun removeAccountWarning() {
        val dialogBuilder = AlertDialog.Builder(requireContext(), R.style.AlertDialogMaterialTheme)
        MaterialAlertDialogBuilder(requireContext())
        dialogBuilder.setTitle(R.string.title_remove_account_app_are_you_sure)
        dialogBuilder.setMessage(R.string.message_remove_account_out_app_are_you_sure)
        dialogBuilder.setPositiveButton(R.string.no_exit) { dialog, _ ->
            dialog?.dismiss()
        }
            .setNegativeButton(
                R.string.alert_dialog_positive
            ) { dialog, _ ->
                removeAccount()
                dialog?.dismiss()
            }
            .show()
    }

    private fun singOut() {
        viewModelUserSettings.singOutUser()
        Toast.makeText(requireContext(), getString(R.string.sing_out), Toast.LENGTH_LONG).show()
    }

    private fun removeAccount() {
        viewModelUserSettings.removeAccountUser()
        Toast.makeText(requireContext(), R.string.removed_account, Toast.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                (activity as MainActivity).showFragment(SettingsFragment.createInstance())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        fun createInstance() = UserSettingsFragment()
    }

}