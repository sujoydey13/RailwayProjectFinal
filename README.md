# Project Title: Railway Reservation System


# RailwayLogin
Login Microservice
 
 


This is Login Microservice(Part of Railway Reservation System)

 


List of microservices:
   <li> Registration </li>
    <li> Login </li>
   <li> Search </li>
    <li> Booking </li>
   

 

<h2>Requirments: </h2>
<li>postgresql</li>
<li>mongodb</li>
<li>kafka 2.7.0</li>
<li>zookeper</li>
<h4> Used IntelliJ Idea as IDE<h4>
    
<h2>STEPS:</h2>

 

<li>Clone this repository into your machine</li>
<li>Open POM.xml file with IntelliJ as project and let maven resolve the required dependencies</li>
<li>create a Database named railwaylogin in postgres or change the database name to any name you want in <b>application.properties</b></li>
<li>Change the db username and password in <b>application.properties</b></li>
<li>Start all the required services</li>
<li>Run the main method</li>

# RailwayBookingandSearching API

 

Railway Booking and Searching Microservice

 

This is Booking and Searching Microservice(Part of Railway Reservation System)

 


List of microservices:
   <li> Registration </li>
    <li> Login </li>
   <li> Search </li>
    <li> Booking </li>
   

 

<h2>Requirments: </h2>
<li>postgresql</li>
<li>mongodb</li>
<li>kafka 2.7.0</li>
<li>zookeper</li>
<h4> Used IntelliJ Idea as IDE<h4>
    
<h2>STEPS:</h2>

 

<li>Clone this repository into your machine</li>
<li>Open POM.xml file with IntelliJ as project and let maven resolve the required dependencies</li>
<li>create a Database named railways in postgres or change the database name to any name you want in <b>application.properties</b></li>
<li>Change the db username and password in <b>application.properties</b></li>
<li>Start all the services in requirements</li>
<li>Run the main method</li>



# railwaySearchAPI

 

Railway search API
 


This is Internal-search Microservice(Part of Railway Reservation System)

 


List of microservices:
   <li> Registration </li>
    <li> Login </li>
   <li> Search </li>
    <li> Booking </li>
   

 

<h2>Requirments: </h2>
<li>postgresql</li>
<li>mongodb</li>
<li>kafka 2.7.0</li>
<li>zookeper</li>
<h4> Used IntelliJ Idea as IDE<h4>
    
<h2>STEPS:</h2>

 

<li>Clone this repository into your machine</li>
<li>Open POM.xml file with IntelliJ as project and let maven resolve the required dependencies</li>
<li>create a collection named railways in mongodb or change the database name to any name you want in <b>application.properties</b></li>
<li>Start all the required services</li>
<li>Run the main method</li>




# RailwayRegistration API

 


This is Registration Microservice(Part of Railway Reservation System)

 


List of microservices:
   <li> Registration </li>
    <li> Login </li>
   <li> Search </li>
    <li> Booking </li>
   

 

<h2>Requirments: </h2>
<li>postgresql</li>
<li>mongodb</li>
<li>kafka 2.7.0</li>
<li>zookeper</li>
<h4> Used IntelliJ Idea as IDE<h4>
    
<h2>STEPS:</h2>

 

<li>Clone this repository into your machine</li>
<li>Open POM.xml file with IntelliJ as project and let maven resolve the required dependencies</li>
<li>create a Database named railwaycustomers in postgres or change the database name to any name you want in <b>application.properties</b></li>
<li>Change the db username and password in <b>application.properties</b></li>
<li>Start all the services in requirements</li>
<li>Run the main method</li>



# ZuulApp - The API Gateway
This repository is about the Zuul configuration for implementing API gateway for the project.<br>
<li>for backend Booking and Searching Microservice repository go to: https://github.com/GamerbutCoder/RailwayBookingandSearching</li>
<li>for backend Login Microservice repository go to: https://github.com/GamerbutCoder/RailwayLogin</li>
<li>for Register Microservice repository go to: https://github.com/GamerbutCoder/RailwayRegistration</li>
<li>for SearchAPI Microservice repository go to: https://github.com/GamerbutCoder/railwaySearchAPI</li>


<h2>Requirments: </h2>
<li>JDK 1.8 or later</li>
<li>Gradle 4+ or Maven 3.2+</li>
<li>SpringBoot <2.4.0</li>
<li>Used IntelliJ Idea as IDE</li>

<h2>Configuration Steps</h2>
<li>Go to /src/main/resources/application.properties</li>
<li>Against the name of the particular api, configure the url</li>
<li>To do that change the zuul.routes.{application name}.url</li>
<li>For Example, to configure login service, change the zuul.routes.loginRailway.url to the ip address and the port in which that service is running</li>

<h2>Demo</h2>
<li>To configure the bookAndSearch</li>
<p>zuul.routes.railwayRegistration.url=<b>http://10.177.68.53:8081/</b><p>
<li>Change the blue part to the ip address and port in which the service is running</li>
