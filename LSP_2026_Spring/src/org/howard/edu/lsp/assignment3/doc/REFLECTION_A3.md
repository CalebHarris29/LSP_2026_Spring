# Reflection — Assignment 3 (ETL Pipeline Refactor)

## Overview
For Assignment 3, I refactored my Assignment 2 ETL pipeline into an object-oriented design while preserving the exact same input/output behavior, transformation rules, error handling, and relative file paths. The output remains `data/transformed_products.csv`.

## OOP Concepts Used
### Classes and Objects
I created multiple classes to represent the system components (Product, ProductParser, ETLPipeline, transformers, ProductWriter, ETLReport). Instances of these classes are created and used at runtime to run the pipeline.

### Encapsulation
Data for a product is encapsulated in the `Product` class (private fields with public getters). ETL run statistics are encapsulated in `ETLReport` with methods to increment counters and getters to retrieve results.

### Inheritance
`TransformedProduct` extends `Product` and adds the `priceRange` field. This demonstrates inheritance by reusing the base product attributes while extending the model for output requirements.

### Polymorphism
I used a `Transformer<T>` interface and implemented multiple concrete transformer classes. The pipeline stores them as a list of `Transformer<Product>` and applies them uniformly without needing to know the exact class type at runtime.

## Why the Refactor Improved the Design
In Assignment 2, all parsing, transformation, and writing logic lived inside `main`, which made the program harder to extend and test. In Assignment 3, responsibilities are separated:
- Parsing is handled by `ProductParser`
- Transformations are separate transformer classes
- Output formatting is handled by `ProductWriter`
- Pipeline control flow is handled by `ETLPipeline`

This improves readability, maintainability, and extensibility while keeping the same functional behavior.