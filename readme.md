# 🍲 Recipe Library API (Spring Boot & MongoDB)

RESTful API developed in Java with Spring Boot for managing recipes and their ratings.

The project uses MongoDB as the database and is fully containerized with Docker Compose.

## Architecture Diagram

![](./image.png)

## ✨ Main Features

* **Recipe Management:** Basic CRUD for recipes.

* **Category Management:** Definition of categories for organization.

* **Ratings:** Adding ratings and comments per recipe.

* **Auditing:** Automatic recording of the creation date of ratings (`@CreatedDate`).

* **Validation:** Centralized handling of validation errors and business rules.

## 🚀 How to Run the Project (Using Docker Compose)

The recommended way to run the API with MongoDB is using Docker Compose.

### Prerequisites

Make sure you have **Docker** and **Docker Compose** installed on your system.

### 1. Setting Up Environment Variables

Create a file named `.env` in the project root with the following environment variables:

```.env 

MONGO_HOST=mongodb

MONGO_PORT=27017

MONGO_DB=recipelibrary

MONGO_USER=admin

MONGO_PASSWORD=korzre123


````
### 2. Build and Run

Execute the following commands in the terminal, in the project root:

```bash
# 1. Packages the Java application (creates the .jar file)
./mvnw clean install

# 2. Builds and starts the services (API and MongoDB) in the background
docker-compose up --build -d

````

## 📚 API Endpoints

All endpoints use the base `http://localhost:8080/api/recipe`.

### 1. 🍽️ Recipes (`/api/recipe`)

| Method | Route | Description |
| :--- | :--- | :--- |
| **`POST`** | `/` | Saves a **new recipe**. Checks if the recipe already exists and if the category is valid. |
| **`GET`** | `/list` | **Lists all** recipes registered on the platform. |

### 2. ⭐ Evaluations (`/api/recipe/evaluation`)

| Method | Route | Description |
| :--- | :--- | :--- |
| **`POST`** | `/evaluation/{recipeId}` | Adds an **evaluation (score and comment)** to a specific recipe. |
| **`GET`** | `/evaluations` | Lists all evaluations from **all** recipes. |
| **`GET`** | `/evaluations/{recipeId}` | Fetches a specific recipe and **includes all of its evaluations**. |

### 3. 🏷️ Categories (`/api/recipe/category`)

| Method | Route | Description |
| :--- | :--- | :--- |
| **`POST`** | `/category` | Saves a **new category**. |
| **`GET`** | `/category/list` | **Lists all** registered categories. |


## 📄 Payload Examples

### A. Create New Category (`POST /api/recipe/category`)

```json
// INPUT PAYLOAD (CategoryRequest)
{
"categoryName": "Dessert"

}

```

### B. Create New Recipe (`POST /api/recipe`)

```json
// INPUT PAYLOAD (RecipeRequest)
{
"name": "Green Detox Smoothie",
"categoryName": "Drinks",

"preparationTime": 5,

"ingredients": "1 cup of spinach, 1 frozen banana, 1/2 apple, 1 cup of coconut water.",

"instructions": "Wash all ingredients. Place them in the blender in the order indicated (liquids first) and blend until smooth and homogeneous." }

```

### C. Create New Evaluation (`POST /api/recipe/evaluation/{idReceita}`)

The `{idReceita}` should be replaced with the recipe ID in the URL.

```json
// INPUT PAYLOAD (EvaluationRequest)

{
    "reviewerName": "Junior",

    "score": 3,

    "comment": "Fantastic recipe and very easy to follow! I loved the result."

}
```

### D. Detailed Search Response (`GET /api/recipe/evaluations/{idReceita}`)

```json
// OUTPUT PAYLOAD (Recipe with Embedded Reviews)
{
    "name": "Perfect Carrot Cake",
    "categoryName": "Pastry",
    "preparationTime": 45,
    "ingredients": "2 Carrots, 3 Eggs, 2 Cups of Flour, 1 Cup of Sugar",
    "instructions": "Mix the dry ingredients. Beat the eggs with the oil and carrots. Combine the mixtures and bake for 45 minutes.",

    "reviewResponse": [{
            "reviewerName": "João Silva",

            "score": 5,

            "comment": "Fantastic recipe and very easy to follow! I loved the result.",

            "date": "2025-12-10T06:42:05.810Z"

        }
    ]   
}
````