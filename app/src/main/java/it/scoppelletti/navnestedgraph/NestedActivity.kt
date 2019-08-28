package it.scoppelletti.navnestedgraph

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.nested_activity.*

class NestedActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.nested_activity)
        setSupportActionBar(toolbar)

        navController = findNavController(R.id.nav_host_fragment)
        bottomNavView.setupWithNavController(navController)

        appBarConfig = AppBarConfiguration(setOf(R.id.dest_top, R.id.dest_first,
                R.id.dest_second, R.id.dest_third))
        setupActionBarWithNavController(navController, appBarConfig)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.dest_top -> {
                    bottomNavView.visibility = View.GONE
                }

                R.id.dest_first -> {
                    bottomNavView.visibility = View.VISIBLE
                }

                R.id.dest_second -> {
                    bottomNavView.visibility = View.VISIBLE
                }

                R.id.dest_third -> {
                    bottomNavView.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.onNavDestinationSelected(navController) == true) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig)
    }
}