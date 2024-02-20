## Web Store

Web Store is a Spring Boot Backend Application which manages a web store. It is implemented with three microservices: Product, Order and Inventory.

The products are created by [`Fake Store API`](https://fakestoreapi.com/), and stored into MongoDB. Once one order is made, the Inventory Service ensures that the Products exists in the stock. If not, the order in not completed. Both Order and Inventory Services have its data stored into PostgreSQL.

## Architecture:

## Functionalities:

The program exposes some endpoints:

> http://localhost:8080/webstore/create <br />
> POST method which create the Products and stored into MongoDB. In the Body, a JSON parameter with the Id of the Product is passed, and through [`Fake Store API`](https://fakestoreapi.com/), a requisition is made, and the Product is created via Product microservice.

> http://localhost:8080/webstore/products <br />
> GET method which returns a list with all the Products stored into Products database (MongoDB).

> http://localhost:8081/webstore/order <br />
> POST method to perform a purchase order. In the Body, a JSON parameters list is passed, with the Id of the Product, and the quantity.

> http://localhost:8082/webstore/inventory?productId=4&productId=5 <br />
> GET method to check whether the Product is in stock or not. In the URI format, the productId of the Product is passed, as productId 4 and 5 showed above.

## Program:

Under development...

## How to run the Project?

Prerequisite: Java 21, MongoDB Compass and pgAdmin.

## MongoDB

✅ Install [MongoDB Compass](https://www.mongodb.com/docs/compass/current/install/). <br />
✅ Create a database as `spring-product-database`. <br />
✅ Inside this database, create a collection as `product`. <br />

## pgAdmin

✅ Install [pgAdmin](https://www.pgadmin.org/download/). <br />
✅ Create a database as `db_web_store_inventory_service`. <br />
✅ Create a database as `db_web_store_order_service`. <br />

## Project

```bash
# clone repository
git clone https://github.com/JoaoAccorsi/Web-Store.git

# run each of the services (Product, Order and Inventory) as
./mvnw spring-boot:run
```

## Technologies 

- Java
- Spring Boot
- Maven
- JSON
- API
- MongoDB
- PostgressSQL
- Microservices
- JUnit tests
