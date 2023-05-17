package com.example.blackoffferassignment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.Slider

class FragmentRefine : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PurposeAdapter
    private lateinit var SaveBtn: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_refine, container, false)
// access the items of the list
        val languages = resources.getStringArray(R.array.Availability)

        val pdtDescEditText: EditText = rootView.findViewById(R.id.pdtDescEditText)
        val defaultText = "Hi Community! I am open to new Connection \uD83D\uDE42"

        pdtDescEditText.setText(defaultText)

        pdtDescEditText.setOnClickListener {
            if (pdtDescEditText.text.toString() == defaultText) {
                pdtDescEditText.text.clear()
            }
        }

        // access the spinner
        val spinner = rootView.findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, languages)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner.setSelection(0)
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    view?.let {
                        val selectedText = parent.getItemAtPosition(position) as String
                        (it as TextView).text = selectedText
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        val slider = rootView.findViewById<Slider>(R.id.normalContinuousSlider)


        slider.setLabelFormatter { value ->
            value.toInt().toString()
        }

        // Set the minimum and maximum values for the slider
        slider.valueFrom = 1f
        slider.valueTo = 100f

        // Set the text values for the start and end labels
        val startLabel = rootView.findViewById<TextView>(R.id.start_label)
        startLabel.text = "1"
        val endLabel = rootView.findViewById<TextView>(R.id.end_label)
        endLabel.text = "100"

        // Set the listener for the slider value changes
        slider.addOnChangeListener { slider, value, fromUser ->
            // Update the start label text
            startLabel.text = value.toInt().toString()
        }
// Set the initial value of the slider
        slider.value = 1f
        // getting the recyclerview by its id
        recyclerView = rootView.findViewById(R.id.recyclerp)
        recyclerView.layoutManager = GridLayoutManager(context, 5, RecyclerView.VERTICAL, false)

        val items = listOf(
            Model("Coffee"),
            Model("Business"),
            Model("Hobbies"),
            Model("Friendship"),
            Model("Movie"),
            Model("Dinning"),
            Model("Dating"),
            Model("Matrimony")
        )

        adapter = PurposeAdapter(items)
        recyclerView.adapter = adapter

        SaveBtn = rootView.findViewById(R.id.BtnSave)
        SaveBtn.setOnClickListener {
            val selectedItems = adapter.getSelectedItems()
            Toast.makeText(
                requireContext(),
                " ${selectedItems.size} Items Saved!!",
                Toast.LENGTH_SHORT
            ).show()
            adapter.resetSelectedItems()
        }

        return rootView
    }
}