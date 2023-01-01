package com.example.mazaady.ui.form

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.mazaady.databinding.FragmentFormBinding
import com.example.mazaady.ui.BindFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormFragment : BindFragment<FragmentFormBinding>() {

    private val vm: FormViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm.category.observe(viewLifecycleOwner) {
            binding.form.setCategory(it)
        }
        vm.property.observe(viewLifecycleOwner) {
            binding.form.setProperty(it)
        }
        binding.form.onSubCategoryClickListener {
            vm.getProperty(it.id.toString())
        }
    }

}