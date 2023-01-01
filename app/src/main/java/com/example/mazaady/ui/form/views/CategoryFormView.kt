package com.example.mazaady.ui.form.views

import android.R
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import com.example.mazaady.databinding.CategoryFormBinding
import com.example.mazaady.domain.model.Category
import com.example.mazaady.domain.model.Property

class CategoryFormView : FrameLayout {

    private val bind: CategoryFormBinding =
        CategoryFormBinding.inflate(LayoutInflater.from(context), this, true)
    private var categories: List<Category> = arrayListOf()
    private var properties: List<Property> = arrayListOf()

    private var selectedProperty: HashMap<Int, String> = hashMapOf()
    private var selectedCategory: Category? = null
    private var selectedSubCategory: Category? = null

    private var onSubCategoryClickListener: ((Category) -> Unit)? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        initMainCategory()
        initSubmitButton()
    }

    private fun initMainCategory() {
        bind.mainCat.setOnItemClickListener { _, _, position, _ ->
            selectedCategory = categories[position]
            clearProperty()
            updateSubCategory(position)
        }
    }

    fun onSubCategoryClickListener(listener: (Category) -> Unit) {
        onSubCategoryClickListener = listener
    }

    private fun updateSubCategory(position: Int) {
        val subCategories = categories[position].children
        val adapter = getArrayAdapter(subCategories.map { category -> category.name })
        bind.subCat.setAdapter(adapter)
        bind.subCat.setText("")
        selectedSubCategory = null
        bind.subCat.setOnItemClickListener { _, _, index, _ ->
            clearProperty()
            selectedSubCategory = subCategories[index]
            onSubCategoryClickListener?.invoke(subCategories[index])
        }
    }

    private fun clearProperty() {
        bind.properties.removeAllViews()
        this.selectedProperty.clear()
    }

    fun setCategory(categories: List<Category>) {
        this.categories = categories
        val adapter = getArrayAdapter(categories.map { category -> category.name })
        bind.mainCat.setAdapter(adapter)
    }

    fun setProperty(properties: List<Property>) {
        this.properties = properties
        properties.forEachIndexed { index, property ->
            addOutlineDropDownMean(index, property, bind.properties)
        }
    }

    private fun addOutlineDropDownMean(
        propertyIndex: Int,
        property: Property,
        parent: ViewGroup
    ): View {
        val propertyMenuView = PropertyMenuView(context)
        propertyMenuView.setOptions(property.options)
        propertyMenuView.setHint(property.name)
        propertyMenuView.setOnoOptionSelectedListener {
            selectedProperty[propertyIndex] = it
        }
        parent.addView(propertyMenuView)
        return propertyMenuView
    }

    private fun getArrayAdapter(list: List<String?>): ArrayAdapter<String> {
        return ArrayAdapter<String>(context, R.layout.simple_dropdown_item_1line, list)
    }

    private fun initSubmitButton() {
        bind.btnSubmit.setOnClickListener {
            Log.i("form>>", selectedCategory?.name ?: "")
            Log.i("form>>", selectedSubCategory?.name ?: "")
            Log.i("form>>", "======================")
            selectedProperty.map {
                Log.i("form>>", "${properties[it.key].name} : ${it.value}")
            }
        }
    }

}