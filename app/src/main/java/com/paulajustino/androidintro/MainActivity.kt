package com.paulajustino.androidintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    private var container: ConstraintLayout? = null
    private var nameLabel: EditText? = null
    private var button: Button? = null
    private var clicksLabel: TextView? = null
    private var numClicks: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponents()
        configureButtonListener()
        configureNameLabelListener()
    }

    private fun initializeComponents() {
        container = findViewById(R.id.container)
        nameLabel = findViewById(R.id.name)
        button = findViewById(R.id.button)
        clicksLabel = findViewById(R.id.clicksQuantity)
    }

    private fun configureButtonListener() {
        button?.setOnClickListener {
            numClicks++

            configureBackgroundImage()
            changeTextOnClicksLabel()
        }
    }

    private fun configureNameLabelListener() {
        nameLabel?.addTextChangedListener {
            changeTextOnClicksLabel()
        }
    }

    private fun configureBackgroundImage() {
        if (numClicks % 2 == 0) {
            container?.background = getDrawable(R.drawable.image2)
        } else {
            container?.background = getDrawable(R.drawable.image3)
        }

    }

    private fun changeTextOnClicksLabel() {
        clicksLabel?.text = getString(
            R.string.clicksQuantity_label_description,
            nameLabel?.text,
            numClicks
        )
    }
}