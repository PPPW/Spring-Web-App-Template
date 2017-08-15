# Spring MVC Web App Example

## Overview

This is a simple working example of a Spring MVC web app. The app has a login page and a main page with a table of restaurant information, where user can add/edit/delete restaurants. JDBC is used for database operations. The web app is a maven project and can be deployed by Tomcat server. 

The purpose is to provide a clean web app with basic functions for beginners to learn, play with and build on. There're a lot of Spring tutorials and working examples available online, however, as Spring framework is pretty complicated and is still evolving, a lot of examples used too much unnecessary configurations, or inconsistent methods to configure the app, which makes it hard for beginners to learn. I hope this example with minimal and consistent configurations will help beginners to get the basic ideas. 

## Demo

This website starts with a login page:

Two accounts are set in "": { pppw : pppw } (admin) and  { guest : guest } (guest). After logging in, you can see a list of restaurants: 

You can add/edit/delete restaurants. Clicking on adding or editing restaurants will bring you to this page:

If you are admin, you can add new users:

Not to make beginners more confused, in here, no CSS styles and JavaScript effects are used. 

## Purpose

There're a lot of Spring MVC tutorials and working examples online. However, when I first tried to build a very basic web app using Spring MVC, I found it's very difficult to get started:   
* A lot of working examples usually involve a lot of unnecessary configurations.    
* There're a lot of ways for configuration in Spring framework, and a lot of ways to write it. For example, you can achieve dependency injection by using xml, or a configuration class, or annotation. Another example, web view controller methods can take various arguments and return types.   

I believe you don't have a lot of time to go through the documents. Although they are well-written, these documents are full of technical details, it's impossible for beginners to know which part is important, so they will get lost by the above unnecessary complexities. It's much more efficient to learn by understanding every components in a simple example that only involves what's necessary. I hope this example can help beginners to get the big picture. 

## Structure

The structure of the app is:    

+-- src.main.java.com.pppw.SpringWebApp    
|   +-- (Java code)    
+-- WebContent    
|   +-- WEB-INF    
|   |   +-- dispatcher-servlet.xml    
|   |   +-- web.xml    
|   |   +-- views    
|   |   |   +-- (JSP webpages)    
+-- pom.xml    
+-- database.sqlite    


pom.xml: the maven configuration file.    
database.sqlite: the database file used in the app to store users and restaurants information. SQLite is used in here.    

WEB-INF:    
web.xml: the web configuration file.    
dispatcher-servlet.xml: configures the dependency injection. Dependency injection is another topic, there're a lot of great tutorials. The basic idea is, when the app needs an instance of a certain class, it will create the instance according to the dependency resolver (in this case, it's configured by this xml file). With this, the classes become less coupled. In Spring, you can configure dependency injection by using code, xml file, and annotations. In this app, I used this xml file and the "@Autowired" annotation.    

## Basic Idea

We're using MVC (model-view-controller) for this app, so where did we define the "model", "view" and "contorller" respectively? The "view" in here means the JSP webpages in the "views" folder. The "view" is the front-end user interface that users can view and interact with directly. The "view" is responsible for presenting information and collecting user inputs. They are usually written in HTML, CSS and JavaScript. The static HTML pages are usually replaced by JSP webpages, if Java is used as the server-side language. 

The "model" and the "controller" are Java classes defined in the "src/main/java/com/pppw/SpringWebApp" folder. The "model" classes are in the "" package. A "model" is an object representation of a database entry, which is usually dependent of the problem domain, but independent of the user interface ("view").  

The "controller" classes are in the "" package. When a URL request is sent, it will resort to the "controller". The method that matches the URL pattern will be responsible to handle this request. This method can manipulate the "model" or send user to "views". 

More explanation can be found in the code comments.

## Usage

With Tomcat 7 and Maven 3, the app can be deployed by using the Tomcat-Maven plugin, by running: 

```
mvn tomcat7:deploy
```



