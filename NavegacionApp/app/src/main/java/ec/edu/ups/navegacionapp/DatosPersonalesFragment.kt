package ec.edu.ups.navegacionapp

import DataSqlLite.DataSQL
import DataSqlLite.LecturaDatosSQL
import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import ec.edu.ups.navegacionapp.databinding.FragmentDatosPersonalesBinding
import ec.edu.ups.navegacionapp.databinding.FragmentHomeBinding

class DatosPersonalesFragment : Fragment() {

    private lateinit var binding: FragmentDatosPersonalesBinding
    var db: LecturaDatosSQL? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_datos_personales, container, false)
        //val args: DatosPersonalesFragmentArgs by navArgs()
        //binding.editTextTextPersonName.setText(args.name)

        binding.buttonRegresar.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_datosPersonalesFragment_to_homeFragment)
        }
        db = LecturaDatosSQL(this)

        var arrayAdapter: ArrayAdapter<Double>
        arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, db!!.getData())
        binding.lvDatos.adapter = arrayAdapter

        //binding.editTextTextPersonName.setText(db!!.getData().toString())
        // Inflate the layout for this fragment
        return binding.root
    }
}