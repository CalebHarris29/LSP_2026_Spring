# Design Evaluation of PriceCalculator

The current `PriceCalculator` design has maintenance and extensibility problems because it relies on a sequence of conditional statements to determine pricing behavior. Every time a new customer type or discount rule is added, the existing class must be modified. This makes the class harder to maintain over time and increases the risk of introducing errors into working code.

The design also violates the idea of separating behaviors into distinct objects. The discount logic for all customer types is tightly packed into one method, which reduces flexibility and makes the code less object-oriented. A better design would encapsulate each discount rule in its own strategy class so that new pricing behaviors can be added without changing the main calculator.

As the system evolves, this implementation becomes difficult to scale because the calculator must continue growing with more `if` statements. Using the Strategy Pattern improves the design by promoting low coupling, better organization, and easier extension.