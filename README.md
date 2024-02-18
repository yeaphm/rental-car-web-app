# Rental Car Web App

## Overview

Rental Car Web App is a Java-based MVC web application built using Spring Framework 3.2.1. It provides a platform for a rental car company to manage their fleet, facilitate test drives, and allow users to browse available cars. The application utilizes PostgreSQL as its database management system and Bootstrap for front-end styling.

## Features

- **Car Management**: Users can add new cars to the system, including details such as make, model, year, and availability.
- **Test Drive Scheduling**: Customers can schedule test drives for available cars, specifying their preferred date and time.
- **Car Listings**: Users can browse through a list of available cars, filtering by make, model, and availability.
- **User Authentication**: Secure user authentication system to ensure only authorized users can access and modify car listings or schedule test drives.

## Technologies Used

- Java 17
- Spring Framework 3.2.1
- PostgreSQL
- Bootstrap

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/rental-car-web-app.git
    ```

2. Navigate to the project directory:

    ```bash
    cd rental-car-web-app
    ```

3. Install dependencies using Maven:

    ```bash
    mvn install
    ```

4. Configure the PostgreSQL database by updating the database configuration in `application.properties`.

5. Run the application:

    ```bash
    mvn spring-boot:run
    ```

6. Access the application by visiting `http://localhost:8080` in your web browser.

## Usage

1. **Register/Login**: Users need to register an account or login to access the full functionality of the application.
2. **Add Cars**: As an admin or authorized user, add new cars to the system with relevant details.
3. **Schedule Test Drives**: Customers can schedule test drives for available cars, providing their preferred date and time.
4. **Browse Listings**: Users can browse through available car listings, filter by make, model, or availability, and view detailed information about each car.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or create a pull request.

## License

This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/). Feel free to use and modify the code as per the terms of the license.
