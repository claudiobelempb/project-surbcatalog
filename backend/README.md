# Surb Catalog 2023

Java RESTful Api

## Diagramas de Classes

```mermaid
classDiagram
    class User {
        -UUID userId
        -String firstName
        -String lastName
        -String email
        -String password
    }
     class Role {
        -UUID roleId
        -String authority
    }

     class Product {
        -UUID productId
        -String name
        -String description
        -Double price
        -String imgUri
    }

     class Category {
        -UUID categoryId
        -String name
    }


    User "1..*" --> "*" Role
    Product "*" -- "1..*" Category
```
