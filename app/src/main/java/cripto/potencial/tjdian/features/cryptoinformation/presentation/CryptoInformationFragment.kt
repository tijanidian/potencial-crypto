package cripto.potencial.tjdian.features.cryptoinformation.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import cripto.potencial.tjdian.app.presentation.UiState
import cripto.potencial.tjdian.databinding.FragmentInformationCryptoBinding
import cripto.potencial.tjdian.features.cryptoinformation.domain.DescriptionModel
import cripto.potencial.tjdian.features.cryptoinformation.presentation.adapter.CryptoInfoAdapter
import cripto.potencial.tjdian.features.main.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CryptoInformationFragment @Inject constructor() : Fragment() {

    private lateinit var binding: FragmentInformationCryptoBinding
    private val viewModel: CryptoInfoViewModel by viewModels()

    @Inject
    lateinit var cryptoInfoAdapter: CryptoInfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationCryptoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewStateObserver()
        viewModel.loadDescriptions()
    }

    private fun setupViewStateObserver() {
        val observer = Observer<UiState<List<DescriptionModel>>> {
            when (it) {
                is UiState.Loading -> showLoading()
                is UiState.Success -> loadEvents(it.data)
                is UiState.Error -> showEventError()
            }
        }
        viewModel.cryptoInfoUIState.observe(this.viewLifecycleOwner, observer)
    }
    private fun showEventError() {
        /*(requireActivity() as MainActivity).showStateView(
            StateView.UiState(
                getString(R.string.label_common_error),
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_loading_error)
            )
        )*/
    }
    private fun loadEvents(events: List<DescriptionModel>) {
        //Crear logica para comprobar si el listado es 0 o mayor
        if (events.isEmpty()) {
            showEmptyListView()
        } else {
            hideEmptyListView()
            cryptoInfoAdapter.submitList(events)
        }
        hideLoading()
    }

    private fun renderDescription(){

    }

    private fun showEmptyListView() {
        /*(requireActivity() as MainActivity).showStateView(
            StateView.UiState(
                getString(R.string.label_emptylist),
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_empty_list)
            )
        )*/
    }
    private fun hideEmptyListView() {
        //(requireActivity() as MainActivity).hideStateView()
    }

    private fun showLoading() {
        (requireActivity() as MainActivity).showLoadingProgress()
    }

    private fun hideLoading() {
        (requireActivity() as MainActivity).hideLoadingProgress()
    }
    companion object{
        fun createInstance()= CryptoInformationFragment()
    }
}