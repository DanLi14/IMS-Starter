Coverage: 79%
# Inventory Management System

Application which allows the end user to interact (through the Command-Line Interface (CLI)) with an inventory management system, to perform Create, Read, Update, Delete (CRUD) functions in connection with the following entities:

1. Customer
2. Item
3. Order

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* MySQL Server 5.7 or later (local or GCP instance)
* Java (local)
* Optional but recommended - MySQL Workbench
* Optional but recommended - Eclipse Integrated Development Environment (IDE) 

### Installing

**MySQL Server**
Follow the link and instructions to install on your Windows machine https://dev.mysql.com/downloads/installer/
(recommended) - select MySQL Workbench within the package installer. 
(optional) Guide to install on Mac machines https://flaviocopes.com/mysql-how-to-install/

**Java**
Download and install the corresponding java package which is compatible with your preferred operating system https://www.java.com/en/download/manual.jsp

**Eclipse (optional)**
Recommended IDE for Java developers https://www.eclipse.org/downloads/packages/release/neon/2/eclipse-ide-java-developers

**Running the IMS**
1. Git clone this repository into your local machine within your preferred location
2. Configure the db.properties file (found within src.main/resources) with your mysql credentials 
3. Execute the sql-schema.sql file (found within src/main/resources) within MySQL workbench  
4. Right-click on the Runner file (found within src/main/java/com.qa.ims), select "Run As" and then "Java Application"  
5. Create a customer by inputting CUSTOMER followed by CREATE then following the terminal instructions
6. Create an item by inputting ITEM followed by CREATE then following the terminal instructions
7. Create an order by inputting ORDER followed by CREATE then following the terminal instructions
8. ADD an item to an order, by inputting ORDERITEMS followed by CREATE then following the terminal instructions
9. Once the above steps have been completed, you should have access to the full suite of CRUD functions including calculating the cost of an order and deleting an item from an order. 

## Running the tests

To test the application, right click on the root folder within Eclipse, select "Run As" and then "JUnit Test"

This will run both the unit test files which uses Junit (see below for details) and the integration test files (see below for details) built on the Mockito framework.  

### Unit Tests 

The unit test files test whether each 'unit' i.e. method of the application is functioning as expected.

Unit tests have been written to cover the following file types:

1. classes e.g. Customer, Item etc.
2. Data Access Object (DAO) files e.g. CustomerDAO, ItemDAO etc. 

### Integration Tests 
Integration tests have been written using the Mockito framework, the purpose of which is to test the functioning of the software when modules are combined.

Integration tests have been written to test how the controller files (e.g. CustomerController, ItemController etc.) interacts with the corresponding DAO files and Logger methods found within the utilities file.  

## Deployment

The IMS application is deployed in a fat JAR file i.e. a JAR file that contains the Java program and all dependencies. 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Daniel Li** - *completed IMS* - [danielli](https://github.com/DanLi14)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
