package vn.edu.hust.danhba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class AddContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_contact, container, false)

        val name = view.findViewById<EditText>(R.id.name_input)
        val email = view.findViewById<EditText>(R.id.email_input)
        val phone = view.findViewById<EditText>(R.id.phone_input)

        name.setText("")
        email.setText("")
        phone.setText("")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<EditText>(R.id.name_input)
        val email = view.findViewById<EditText>(R.id.email_input)
        val phone = view.findViewById<EditText>(R.id.phone_input)
        val btn_enter = view.findViewById<Button>(R.id.btn_enter)
        btn_enter.setOnClickListener{
            if (name.text.isEmpty()) {
                Toast.makeText(requireContext(), "Name is required field", Toast.LENGTH_SHORT).show()
            }
            else if (email.text.isEmpty()) {
                Toast.makeText(requireContext(), "Email is required field", Toast.LENGTH_SHORT).show()
            }
            else if (phone.text.isEmpty()) {
                Toast.makeText(requireContext(), "Phone is required field", Toast.LENGTH_SHORT).show()
            }
            else {
                val bundle = Bundle()
                bundle.putString("name", name.text.toString())
                bundle.putString("email", email.text.toString())
                bundle.putString("phone", phone.text.toString())

                findNavController().navigate(R.id.action_addContactFragment_to_listFragment, bundle)
            }
        }
    }

}