package ec.edu.ups.navegacionapp

import DataSqlLite.DataSQL
import DataSqlLite.Persona
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import ec.edu.ups.navegacionapp.databinding.FragmentHomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    private lateinit var binding: FragmentHomeBinding
    var db: DataSQL? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        //Logica para obtener resultado
        binding.buttonIniciarSesion.setOnClickListener{

            //Stirng user =
            //String password =
            //guardarHistorial(resultado as Double)
            var valores = recupearHistorial(binding.editTextName.text.toString(), binding.editTextPassword.text.toString())
            //if (true == true){
            //        View ->view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDatosPersonalesFragment())
            //}
        }

        db = DataSQL(this)

        binding.buttonRegistrar.setOnClickListener { view: View ->
            //view.findNavController().navigate(R.id.action_homeFragment_to_datosPersonalesFragment)
            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDatosPersonalesFragment())

        }

        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.home_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }


    //Funcion para guardar el resultado con clave-valor
    private fun guardarHistorial(resultado: Double){
        //db!!.insert(resultado)
    }

    //Funcion para guardar el resultado con clave-valor
    private fun recupearHistorial(username: String, password: String): Boolean{
        return db!!.checkUser(username, password)
    }

    //Funcion para eliminar todo el historial
    private fun eliminarHistorial(){

    }



}