# Invillia recruitment challenge

[![Build Status](https://travis-ci.org/shelsonjava/invillia.svg?branch=master)](https://travis-ci.org/shelsonjava/invillia)

![Invillia Logo](https://invillia.com/public/assets/img/logo-invillia.svg)
[Invillia](https://https://www.invillia.com/) - A transformação começa aqui.

The ACME company is migrating their monolithic system to a microservice architecture and you’re responsible to build their MVP (minimum viable product)  .
https://en.wikipedia.org/wiki/Minimum_viable_product

Your challenge is:
Build an application with those features described below, if you think the requirements aren’t detailed enough please leave a comment (portuguese or english) and proceed as best as you can.

You can choose as many features you think it’s necessary for the MVP,  IT’S NOT necessary build all the features, we strongly recommend to focus on quality over quantity, you’ll be evaluated by the quality of your solution.

If you think something is really necessary but you don’t have enough time to implement please at least explain how you would implement it.

## Tasks

Your task is to develop one (or more, feel free) RESTful service(s) to:
* Create a **Store**
* Update a **Store** information
* Retrieve a **Store** by parameters
* Create an **Order** with items
* Create a **Payment** for an **Order**
* Retrieve an **Order** by parameters
* Refund **Order** or any **Order Item**

Fork this repository and submit your code with partial commits.

## Business Rules

* A **Store** is composed by name and address
* An **Order** is composed by address, confirmation date and status
* An **Order Item** is composed by description, unit price and quantity.
* A **Payment** is composed by status, credit card number and payment date
* An **Order** just should be refunded until ten days after confirmation and the payment is concluded.

## Non functional requirements

Your service(s) must be resilient, fault tolerant, responsive. You should prepare it/them to be highly scalable as possible.

The process should be closest possible to "real-time", balancing your choices in order to achieve the expected
scalability.

## Nice to have features (describe or implement):
* Asynchronous processing
* Database
* Docker
* AWS
* Security
* Swagger
* Clean Code

## Added Features
Most of the features requested were added.

### Asynchronous processing
Asynchronous processing has been configured for application. All iterations performed by the gateway classes are done asynchronously, through the Future interface of java, to work asynchronously and concurrently with concurrent processing.

### Database
The database used was MySQL in its latest stable version. The generation of the tables, as well as the change management, is carried out with the help of Liquibase. The model mapping is done using JPA and the base data communication made by the Spring Data tools.

### Docker
A simple, small docker container was set up for the application to run. Two base images were used: one containing MySQL and the other the Java with Maven. Through docker-compose, the MySQL instance is started and then the application is executed. The build is relatively time-consuming as downloads will be made from various project dependencies.

### AWS
It was not applied to the project due to the short time and availability for the configuration, as well as the lack of tools for this activity. As a result, a lot of effort is required for the availability and scalability requirements. This does not mean that you are not interested in setting up and applying, quite the opposite.

### Security
The security of the application was under the responsibility of the structure offered by Spring Security. Classes have been configured in the project for the correct display of resources for certain types of users. Access is made via JWT Token, obtained through login to a certain URL.

### Swagger
Swagger is configured and displaying the main routes of the application, with some descriptions of the models. It needs to be better detailed for a more advantageous immersion experience.

### Clean Code
The project was developed trying to put into practice the main knowledge obtained to the logo of the professional trajectory, along with the use of conventions and standards of projects, aiming at a better future maintenance. Some unit tests have been developed to ensure greater security in the use of resources.

## Prerequisites and Build

It is necessary to have docker installed on the machine to perform the application build. More information is available on the [Docker official website] (https://docs.docker.com/install/).

In addition, docker-compose installation is required. With docker installed, just follow the following [from this page] (https://docs.docker.com/compose/install/).

With the environment set up, you can do the project build. Just run the following command while at the root of the project:

```sh
docker-compose up --build
```

When executing the above command, the container docker will be constructed and configured, then starting the application.

The first build becomes time-consuming due to the fact that there are no dependencies in the container. It could be chosen to create build through maven in one of the build phases, but this would make it necessary for users to configure the maven instance locally to perform the build.

## Running the application
   
At the end of the build and execution of the docker container, the application is available for execution. To execute the basic resources, you must register in the application, via POST, through the URL http://localhost:8080/users/signup
   
You should be informed of a Json object containing the "username" and "password" attributes. After registration, the user will receive a token to use the API. This Token is valid for 1 hour.
   
The other features of the application can be seen in the Swagger documentation, located at the link http://localhost:8080/swagger-ui.html#/

## Final considerations

Thank you for the opportunity to have performed this test for the company and I am available for any questions.

Contact: roberto.jrnj@gmail.com