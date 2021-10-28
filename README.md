Coverage: 34%
# Inventory Management System

Application which allows the end user to interact (through the Command-Line Interface (CLI)) with an inventory management system, to perform Create, Read, Update, Delete (CRUD) functions in connection with the following entities:

1. Customer
2. Item
3. Order

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

MySQL Server 5.7 or later (local or GCP instance)
Java (local)
Optional but recommended - MySQL Workbench
Optional but recommended - Eclipse Integrated Development Environment (IDE) 


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
1. Git clone this repository into your local machine wihin your preferred location
2. Execute the sql-schema.sql file (found within src/main/resources) within MySQL workbench  
3. Right-click on the Runner file (found within src/main/java/com.qa.ims) and select the option to "Run As" and then "Java Application"  
4. Create a customer by inputting CUSTOMER then following the terminal instructions
5. Create an item by inputting ITEM then following the terminal instructions
6. Create an order by inputting ORDER then following the terminal instructions
7. ADD an item to an order, by inputting ORDERITEMS then following the terminal instructions
8. once the above is completed, you should have access to the full suite of CRUD functions including calculating the cost of an order and deleting an item from an order. 

## Running the tests

Explain how to run the automated tests for this system. Break down into which tests and what they do

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* ** Daniel Li - *completed IMS* - [danielli] (https://github.com/DanLi14)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
