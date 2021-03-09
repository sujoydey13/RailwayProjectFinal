# Project Title: Railway Reservation System (Using Vue + Springboot)


This is the frontend repository for Railway Reservation System - <br>
(for zuul configuration repository go to: https://github.com/sujoydey13/ZuulApp) <br>
(for backend Booking and Searching Microservice repository go to: https://github.com/GamerbutCoder/RailwayBookingandSearching) <br>
(for backend Login Microservice repository go to: https://github.com/GamerbutCoder/RailwayLogin) <br>
(for Register Microservice repository go to: https://github.com/GamerbutCoder/RailwayRegistration) <br>
(for SearchAPI Microservice repository go to: https://github.com/GamerbutCoder/railwaySearchAPI) <br>
(for Admin Login Microservice repository go to: https://github.com/noyal727/adminlogin) <br>

 

<h2>Requirements</h2>
<li>Visual Studio Code (VS Code)</li>
<li>Vue-cli</li>
<li>All backend microservices mentioned above</li>

 

<h2>How to run</h2>
The following files contain the axios post requests, in order to run the project, you must change the IP address and Port number provided in the url paths of axios post requests for these files based on the <b>zuul configurations</b>. <br><br>
<li>src/components/navbar.vue --> Line no. 44, change IP address and port number in url path in axios post request with the IP address and port number (on which Zuul is running) of the machine running Zuul configurations</li> <br>
<br>
Do the same for the next files (line no.'s are specified) <br>
<br>
<li>src/components/admin.vue --> Line no. 74</li>
<li>src/components/book.vue --> Line no. 74</li>
<li>src/components/historypane.vue --> Line no. 58</li>
<li>src/components/login.vue --> Line no. 73</li>
<li>src/components/register.vue --> Line no. 126</li>
<li>src/components/search.vue --> Line no. 88</li>
<li>src/components/train.vue --> Line no. 64</li>
<li>src/components/userprofile.vue --> Line no. 47</li>
<br>
Open the project in VS Code. Then run the following commands in the integrated terminal. <br>
<br>
<li><b>npm install</b></li>
<li>To run the project -> <b>npm run serve</b></li>
<li>Compiles and minifies for production -> <b>npm run build</b></li>
<li>Lint and fixes -> <b>npm run lint</b></li>

 

## Project setup
```
npm install
```

 

### Compiles and hot-reloads for development
```
npm run serve
```

 

### Compiles and minifies for production
```
npm run build
```

 

### Lints and fixes files
```
npm run lint
```

 

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).


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



# AdminLogin API


This is Admin Microservice(Part of Railway Reservation System)

 

List of microservices:
    <li> AdminLogin </li>
   <li> AddingTrains </li>
   

 

 
<h2>Requirments: </h2>
<li>postgresql</li>
<li>mongodb</li>
<li>kafka 2.7.0</li>
<li>zookeper</li>
<h4> Used IntelliJ Idea as IDE<h4>

 

<h2>Steps:</h2>
<li> Clone the repository using "git.clone".</li>
<li> Open the prom.xml as a project in intelliJ.</li>
<li> create a database railway_admin in postgresql and place name in <b>application.properties</b>.</li>
<li> Start all the requried services.</li>
<li> Run the main method.</li>



# ZuulApp - The API Gateway
This repository is about the Zuul configuration for implementing API gateway for the project.<br>
<li>for backend Booking and Searching Microservice repository go to: https://github.com/GamerbutCoder/RailwayBookingandSearching</li>
<li>for backend Login Microservice repository go to: https://github.com/GamerbutCoder/RailwayLogin</li>
<li>for Register Microservice repository go to: https://github.com/GamerbutCoder/RailwayRegistration</li>
<li>for SearchAPI Microservice repository go to: https://github.com/GamerbutCoder/railwaySearchAPI</li>
<li>for AdminLoginAPI Microservice repository go to: https://github.com/noyal727/adminlogin</li>


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
<li>To configure the bookAndSearch, zuul.routes.railwayRegistration.url=<b>http://10.177.68.53:8081/</b></li>
<li>Change the blue part to the ip address and port in which the service is running</li>
