package vn.edu.hust.danhba

import android.content.ClipData.Item
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    lateinit var rvContact: RecyclerView
    lateinit var contactList: ArrayList<ItemModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        rvContact = view.findViewById<RecyclerView>(R.id.rvContact)

        rvContact.adapter = ContactAdapter((activity as MainActivity).contactList, this)
        rvContact.layoutManager = LinearLayoutManager( requireContext(), LinearLayoutManager.VERTICAL, false)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = arguments?.getString("name")
        val email = arguments?.getString("email")
        val phone = arguments?.getString("phone")


        if (name != null && email != null && phone != null)
            (activity as MainActivity).contactList.add(ItemModel(name, email, phone))
        rvContact.adapter = ContactAdapter((activity as MainActivity).contactList, this)

        super.onViewCreated(view, savedInstanceState)
    }

    fun getDetail(name: String, email: String, phone: String) {
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("email", email)
        bundle.putString("phone", phone)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }
}