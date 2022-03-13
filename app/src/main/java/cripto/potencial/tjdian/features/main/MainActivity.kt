package cripto.potencial.tjdian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import cripto.potencial.tjdian.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupMenuButtonListener()
    }

    private fun setupMenuButtonListener() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_crypto -> {
                    text()
                    true
                }
                R.id.action_potential_crypto -> {
                    text()
                    true
                }
                R.id.action_info_crypto -> {
                   text()
                    true
                }
                R.id.action_settings -> {
                   text()
                    true
                }
                else -> super.onOptionsItemSelected(it)
            }
        }
    }

    private fun text(){
        Toast.makeText(this,"Bien",Toast.LENGTH_LONG).show()
    }

    private fun showFragment(fragment:Fragment){

    }
}