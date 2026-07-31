package sri.example.rulebasedaiagent

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputText: EditText
    private lateinit var outputText: TextView
    private lateinit var workflowText: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var btnAsk: Button
    private lateinit var btnClear: Button

    private val agent = Agent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputText = findViewById(R.id.inputText)
        outputText = findViewById(R.id.outputText)
        workflowText = findViewById(R.id.workflowText)
        progressBar = findViewById(R.id.progressBar)
        btnAsk = findViewById(R.id.btnAsk)
        btnClear = findViewById(R.id.btnClear)

        btnAsk.setOnClickListener {

            val question = inputText.text.toString().trim()

            if (question.isEmpty()) {
                inputText.error = "Please enter a question"
                return@setOnClickListener
            }

            progressBar.visibility = View.VISIBLE

            outputText.text = "🤖 Thinking..."

            workflowText.text =
                "👁 Perception\nReading your input...\n\n🧠 Reasoning\nChecking rules...\n\n⚡ Action\nPreparing response..."

            Handler(Looper.getMainLooper()).postDelayed({

                val answer = agent.process(question)

                progressBar.visibility = View.GONE

                outputText.text = answer

                workflowText.text =
                    "✅ Perception Completed\n\n✅ Reasoning Completed\n\n✅ Action Completed"

            }, 1200)
        }

        btnClear.setOnClickListener {

            inputText.text.clear()

            outputText.text = "Waiting for your question..."

            workflowText.text =
                "👁 Perception\n⬇\n🧠 Reasoning\n⬇\n⚡ Action"
        }
    }

    private fun showAbout() {

        AlertDialog.Builder(this)
            .setTitle("RuleBot")
            .setMessage(
                "Rule-Based AI Assistant\n\n" +
                        "Uses Perception, Reasoning and Action.\n\n" +
                        "Developed using Kotlin and Android Studio."
            )
            .setPositiveButton("OK", null)
            .show()
    }
}