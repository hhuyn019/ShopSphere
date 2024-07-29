# SuperStore Project Overview

**SuperStore** is a comprehensive e-commerce platform designed to offer a seamless online shopping experience. Implemented using a microservice architecture, SuperStore ensures scalability, maintainability, and flexibility.

## Front-end Technologies:
- **Angular**: Provides a dynamic and responsive user interface.
- **Bootstrap**: Ensures a modern, mobile-friendly design with ready-to-use UI components.

## Back-end Technologies:
- **Java Spring Boot**: The core framework for building and running microservices.
- **Spring Data JPA**: Manages database interactions efficiently.
- **Spring Security with JWT**: Secures the application with JSON Web Tokens for authentication and authorization.
- **Spring Batch**: Handles batch processing tasks.
- **MySQL**: The relational database for storing persistent data.

## Core Functionalities:

### User Management:
- **Register**: Allows new users to create accounts.
- **Login**: Authenticates users using JWT tokens.
- **Authentication**: Secures endpoints, ensuring only authenticated users can access protected resources.

### Product Management:
- **Post Products**: Enables admins or sellers to list new products for sale.
- **View Products**: Users can browse and search for products.

### Shopping Cart:
- **Add to Cart**: Users can add products to their shopping cart.
- **Update Cart**: Users can modify the quantity of items in their cart.
- **Remove from Cart**: Users can remove items from their cart.

### Wishlist:
- **Add to Wishlist**: Users can add products they are interested in to their wishlist.
- **View Wishlist**: Users can view and manage their wishlist.

### Order Management:
- **Place Order**: Users can place orders for the items in their cart.
- **Order History**: Users can view a history of all their previous orders.

### Discount Management:
- **Create Discount Codes**: Admins can generate discount codes.
- **Apply Discounts**: Users can apply discount codes to their orders to receive discounts.

## Microservice Architecture:

1. **User Service**: Manages user registration, login, and authentication.
2. **Product Service**: Handles product listings and management.
3. **Cart Service**: Manages user shopping carts, including adding, updating, and removing items.
4. **Wishlist Service**: Manages user wishlists.
5. **Order Service**: Manages order placement and order history.
6. **Discount Service**: Administers discount code creation and application.

## Technical Details:

- **Angular Frontend**:
  - Interacts with backend microservices via REST APIs.
  - Uses Bootstrap for a responsive, user-friendly design.

- **Spring Boot Microservices**:
  - Each service is independently deployable and scalable.
  - Services communicate via RESTful APIs.
  - Spring Security and JWT ensure secure communication and resource access.

- **Spring Data JPA**:
  - Simplifies data access and manipulation.
  - Integrates seamlessly with MySQL.

- **Spring Batch**:
  - Used for batch processing tasks, such as listing multiple products for sale at once.

- **MySQL Database**:
  - Stores user data, product information, orders, wishlists, and discount codes.
  - Ensures data integrity and supports complex queries.

## Security:
- **JWT Authentication**:
  - Protects endpoints and ensures that only authenticated users can perform specific actions.
  - Tokens are used to manage user sessions securely.

## Conclusion:

SuperStore exemplifies a robust e-commerce platform leveraging modern technologies and best practices. The use of microservices enhances the application's scalability and maintainability, while Angular and Bootstrap provide an intuitive and responsive user interface. Through comprehensive user and product management features, SuperStore ensures a smooth and secure online shopping experience for its users.

