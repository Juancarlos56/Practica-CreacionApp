package ec.edu.ups.navegacionapp

import DataSqlLite.DataSQL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import ec.edu.ups.navegacionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerloyout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.title = "Universidad Poliectica Salesiana"
        binding.age = "22"
        binding.dni = "0106113301"

        drawerloyout = binding.drawerLayout
        var navController = this.findNavController(R.id.navigation_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerloyout)

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerloyout)
        NavigationUI.setupWithNavController(binding.navView, navController)



    }

    override fun onSupportNavigateUp(): Boolean {
        var navController = this.findNavController(R.id.navigation_fragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    companion object{

    }
}