package com.example.mazaady.ui.form.views

import android.R
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.core.widget.doAfterTextChanged
import com.example.mazaady.databinding.OutlineDropDownMenuBinding
import com.example.mazaady.databinding.OutlineEditTextBinding
import com.example.mazaady.domain.model.Option

class PropertyMenuView : LinearLayout {

    private val bind = OutlineDropDownMenuBinding.inflate(LayoutInflater.from(context), this, true)
    private var otherBind: OutlineEditTextBinding? = null
    private var options: List<Option> = arrayListOf()
    private var onOptionSelected: ((String) -> Unit)? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        orientation = VERTICAL
        bind.menu.setOnItemClickListener { _, _, index, _ ->
            if (index == options.size) {
                otherBind = OutlineEditTextBinding.inflate(LayoutInflater.from(context), this, true)
                otherBind?.et?.doAfterTextChanged {
                    onOptionSelected?.invoke(it.toString())
                }
            } else {
                if (childCount > 1) {
                    removeView(otherBind?.root)
                }
                onOptionSelected?.invoke(options[index].name ?: "")
            }
        }
    }

    fun setHint(hint: String) {
        bind.textInputLayout.hint = hint
    }

    fun setOptions(options: List<Option>) {
        this.options = options
        if (options.isNotEmpty()) {
            val list = options.map { it.name }
                .toMutableList()
                .apply { add("other") }
            val adapter = getArrayAdapter(list)
            bind.menu.setAdapter(adapter)
        }
    }

    fun setOnoOptionSelectedListener(listener: (String) -> Unit) {
        onOptionSelected = listener
    }

    private fun getArrayAdapter(list: List<String?>): ArrayAdapter<String> {
        return ArrayAdapter<String>(context, R.layout.simple_dropdown_item_1line, list)
    }

}