# Question 5

Heuristic 1:
Name:
Hide internal data and implementation details.

Explanation:
This heuristic means that a class should not expose its internal variables directly. In our assignments, we followed this by using private variables and accessing them through methods instead of modifying them directly. This improves maintainability because changes to the internal logic do not affect other classes using the object.

Heuristic 2:
Name:
Keep related data and behavior in the same class.

Explanation:
This heuristic emphasizes that data and the methods that operate on that data should be grouped together. In assignments like the IntegerSet and midterm TaskManager, we kept operations like add, remove, and contains inside the same class as the data. This improves readability because everything related to that data is in one place and easier to understand.

Heuristic 3:
Name:
Avoid large classes that do too many things.

Explanation:
This heuristic suggests that each class should have a single responsibility. In the midterm, we separated responsibilities between classes like Task and TaskManager instead of putting everything into one class. This improves maintainability because smaller, focused classes are easier to test, debug, and extend.