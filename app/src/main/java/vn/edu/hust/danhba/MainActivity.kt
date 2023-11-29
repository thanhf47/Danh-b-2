package vn.edu.hust.danhba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {

    lateinit var navController : NavController
    lateinit var contactList: ArrayList<ItemModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        navController = navHostFragment.navController

        contactList = arrayListOf<ItemModel>(
            ItemModel("Batman", "bm@gmail.com", "0123456789"),
            ItemModel("Spiderman", "peter.parker@gmail.com", "9876543210")
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> goHome()
            R.id.add_contact -> addContact()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun addContact() {
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)?.findNavController()?.navigate(R.id.action_listFragment_to_addContactFragment)
    }

    private fun goHome() {
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)?.findNavController()?.navigate(R.id.listFragment)
    }
}