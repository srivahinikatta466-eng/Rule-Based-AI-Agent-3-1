package sri.example.rulebasedaiagent

class RuleEngine {

    fun getResponse(input: String): String {

        val text = input.lowercase().trim()

        return when {

            text.contains("help") ->
                """
Available Commands:

• cold
• fever
• headache
• cough
• stomach pain
• diabetes
• bp
• hello
• hi
• bye
                """.trimIndent()

            text.contains("hello") || text.contains("hi") ->
                "Hello! How can I help you today?"

            text.contains("bye") ->
                "Goodbye! Take care."

            text.contains("cold") ->
                "For a common cold:\n\n• Drink warm water\n• Take proper rest\n• Eat healthy food\n• Consult a doctor if symptoms continue."

            text.contains("fever") ->
                "If you have fever:\n\n• Drink plenty of fluids\n• Take Paracetamol if advised\n• Visit a doctor if fever is high."

            text.contains("headache") ->
                "For headache:\n\n• Rest\n• Drink water\n• Avoid bright screens\n• Consult a doctor if severe."

            text.contains("cough") ->
                "For cough:\n\n• Drink warm water\n• Honey may help\n• Visit a doctor if it lasts more than a week."

            text.contains("stomach") ->
                "For stomach pain:\n\n• Eat light food\n• Stay hydrated\n• Visit a doctor if pain is severe."

            text.contains("diabetes") ->
                "Diabetes patients should monitor blood sugar regularly and follow their doctor's advice."

            text.contains("bp") || text.contains("blood pressure") ->
                "Maintain a healthy diet, reduce salt intake and check blood pressure regularly."

            else ->
                "❌ Sorry, I don't understand.\n\nType 'Help' to see available commands."
        }
    }
}