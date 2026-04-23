# Question 2 – Design Explanation

The Template Method pattern is implemented in the `Report` abstract class through the `generateReport()` method, which defines the fixed workflow: `loadData()`, `formatHeader()`, `formatBody()`, and `formatFooter()`. This method ensures that all reports follow the same structure while allowing flexibility in specific steps.

The methods `loadData()`, `formatHeader()`, `formatBody()`, and `formatFooter()` are declared as abstract, allowing subclasses like `StudentReport` and `CourseReport` to provide their own implementations. This enables each report type to customize its content while maintaining a consistent format.

Polymorphism is demonstrated in the `Driver` class, where a `List<Report>` is used to store different report types and call `generateReport()` on each object. This design improves maintainability by separating the overall process from the specific details of each report.