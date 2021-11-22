package com.satriauno.recipecataloge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.satriauno.recipecataloge.R
import com.satriauno.recipecataloge.adapter.RecipesAdapter
import com.satriauno.recipecataloge.data.Recipes
import com.satriauno.recipecataloge.databinding.FragmentSeafoodBinding

class SeafoodFragment : Fragment() {

    private var _binding : FragmentSeafoodBinding? = null

    private val binding get() = _binding!!
    private var listSeafood: ArrayList<Recipes> = arrayListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSeafood.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipesAdapter(listSeafood)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentSeafoodBinding.inflate(inflater, container, false)
        initData()
        return binding.root
    }

    private fun initData() {
        resources.apply {
            val name = getStringArray(R.array.name_seafood)
            val category = getStringArray(R.array.category_seafood)
            val description = getStringArray(R.array.description_seafood)
            val ingredients = getStringArray(R.array.ingredients_seafood)
            val instruction = getStringArray(R.array.instructions_seafood)
            val photo = getStringArray(R.array.photo_seafood)
            val price = getStringArray(R.array.price_seafood)
            val calories = getStringArray(R.array.calories_seafood)
            val protein = getStringArray(R.array.protein_seafood)
            val carbo = getStringArray(R.array.carbo_seafood)

            for (data in protein.indices) {
                val seafood = Recipes(
                    name[data],
                    category[data],
                    description[data],
                    ingredients[data],
                    instruction[data],
                    photo[data],
                    price[data],
                    calories[data],
                    protein[data],
                    carbo[data]
                )
                listSeafood.add(seafood)
            }
        }
    }

}