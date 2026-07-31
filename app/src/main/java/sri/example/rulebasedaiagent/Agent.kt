package sri.example.rulebasedaiagent

class Agent {

    private val ruleEngine = RuleEngine()

    fun process(input: String): String {

        val perception = input.trim()

        val reasoning = perception.lowercase()

        return ruleEngine.getResponse(reasoning)
    }
}