package vn.edu.hust.danhba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_detail, container, false)

        val iconView = view.findViewById<TextView>(R.id.icon)
        val nameView = view.findViewById<TextView>(R.id.name)
        val emailView = view.findViewById<TextView>(R.id.email)
        val phoneView = view.findViewById<TextView>(R.id.phone)

        val name = arguments?.getString("name")
        val email = arguments?.getString("email")
        val phone = arguments?.getString("phone")

        if (name != null && email != null && phone != null) {
            iconView.text = name[0].toString()
            nameView.text = name
            emailView.text = email
            phoneView.text = phone
        }
        return view
    }

}