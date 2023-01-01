package com.example.mazaady.ui.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mazaady.domain.model.Category
import com.example.mazaady.domain.model.Property
import com.example.mazaady.domain.use_case.FormUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(private val formUseCase: FormUseCase) : ViewModel() {

    private val _category: MutableLiveData<List<Category>> = MutableLiveData()
    val category: LiveData<List<Category>> = _category

    private val _property: MutableLiveData<List<Property>> = MutableLiveData()
    val property: LiveData<List<Property>> = _property

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _category.postValue(formUseCase.getAllCategories())
        }
    }

    fun getProperty(categoryId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _property.postValue(formUseCase.getCategoryProps(categoryId))
        }
    }
}