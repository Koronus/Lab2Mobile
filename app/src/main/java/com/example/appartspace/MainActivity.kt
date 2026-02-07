package com.example.appartspace
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textViewNameArt: TextView
    private lateinit var textViewAutor: TextView


    private val artWorks = listOf(
        PatternData(
            imageId = R.drawable.girlpeach,
            titleId = R.string.artwork1_title,
            authorId = R.string.artwork1_author
        ),
        PatternData(
            imageId = R.drawable.suvorov,
            titleId = R.string.artwork2_title,
            authorId = R.string.artwork2_author
        ),
        PatternData(
            imageId = R.drawable.learners,
            titleId = R.string.artwork3_title,
            authorId = R.string.artwork3_author
        ),
        PatternData(
            imageId = R.drawable.troica,
            titleId = R.string.artwork4_title,
            authorId = R.string.artwork4_author
        ),

        PatternData (
            imageId = R.drawable.petr,
            titleId = R.string.artwork5_title,
            authorId = R.string.artwork5_author

        )

    )


    private var i = 0
    private val KEY_CURRENT_INDEX = "current_index"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        imageView = findViewById(R.id.imageView)
        textViewNameArt = findViewById(R.id.NameArt)
        textViewAutor = findViewById(R.id.Autor)

        val nextButton = findViewById<Button>(R.id.buttonNext)
        val previousButton = findViewById<Button>(R.id.buttonPrevious)

        // Восстановление состояния
        if (savedInstanceState != null) {
            i = savedInstanceState.getInt(KEY_CURRENT_INDEX, 0)
        }

        // Первая картинка
        displayArtwork(i)
        updateButtons(previousButton, nextButton)

        // Обработка кнопок
        nextButton.setOnClickListener {
            if (i < artWorks.size - 1) {
                i++
                displayArtwork(i)
                updateButtons(previousButton, nextButton)
            }
        }

        previousButton.setOnClickListener {
            if (i > 0) {
                i--
                displayArtwork(i)
                updateButtons(previousButton, nextButton)
            }
        }
    }

    private fun displayArtwork(index: Int) {
        val artwork = artWorks[index]
        imageView.setImageResource(artwork.imageId)
        textViewNameArt.text = getString(artwork.titleId)
        textViewAutor.text = getString(artwork.authorId)


        val title = getString(artwork.titleId)
        val author = getString(artwork.authorId)

        val description = getString(
            R.string.image_content_description,
            title,
            author
        )

        imageView.contentDescription = description

    }

    private fun updateButtons(prevButton: Button, nextButton: Button) {
        prevButton.isEnabled = i > 0
        nextButton.isEnabled = i < artWorks.size - 1


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_CURRENT_INDEX, i)
    }


}