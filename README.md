# JWT Application Using Spring Boot, Spring Security, JWT, JPA and MySql

## Requirements

1. Java >= java 11

2. Maven - 3.x.x

3. Mysql - 5.x.x

4. lombok

5. Docker

## Steps to Setup

## way 1:

**1. Clone the application**

```bash
git clone https://github.com/nandhan7/JWT_Auth.git
```

**2. Change mysql username and password as per your Mysql installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**3. Running the application in the IDE**

+ after changing both the username and password as per your mysql installation
+ we can run it from NeatBeans or intellij IDEA.

The app will start running at http://localhost:8080/**.

## Way 2:
+ by using docker
+ open a terminal in the project folder, then run:

```bash
docker-compose up
```
+ we can see the application start.

## Creating New User.
+ We can Create a User To access our application using below endpoint. which needs to no privilege to access.

```bash
 POST http://localhost:8080/create/user
```

+ Body of the request is shown below.

```bash
{
    "username":"test",
    "password":"83355806",
    "authorities":"ADMIN"
}
```
+ authorities can be either READ or ADMIN only.

![img.png](https://user-images.githubusercontent.com/89990618/184499907-04edbe3d-6121-49e8-9505-ba83dcf7798a.png)

## Getting the JWT Token.

+ to access the post or get api's we need to have an JWT access token.

+ we can get that token when we log in to the server. using :

```bash
http://localhost:8080/login
```

![img_1.png](https://user-images.githubusercontent.com/89990618/184499954-c949e809-952e-48a5-9052-4da49218c8be.png)

## Accessing the API'S.

+ after we get the token when we want to access to any API we need to send the token in Authorization header
+ value of Authorization has to start with Bearer your_token. as shown

![img_2.png](https://user-images.githubusercontent.com/89990618/184500092-4e095b9c-02b3-4e0c-b73a-3b3c616b120e.png)

+ Accessing the Api's without JWT token or privilege gives 403 error.
