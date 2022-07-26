package com.herdal.breakingbad.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.herdal.breakingbad.R
import com.herdal.breakingbad.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.charactersFragment, R.id.episodesFragment
            )
        )

        // hide bottom nav
        val noBottomNavigationIds =
            listOf(R.id.filterCharactersFragment, R.id.filterCharactersFragment)
        // hide toolbar
        val noToolbarNavigationIds = listOf(R.id.filterCharactersFragment)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            val shouldShowBottomNavigationBars =
                noBottomNavigationIds.contains(destination.id).not()

            val shouldShowToolbar = noToolbarNavigationIds.contains(destination.id).not()

            binding.navView.isVisible = shouldShowBottomNavigationBars

            if (shouldShowToolbar) {
                supportActionBar?.show()
            } else {
                supportActionBar?.hide()
            }
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navCon = this.findNavController(R.id.nav_host_fragment_activity_main)
        return navCon.navigateUp()
    }
}