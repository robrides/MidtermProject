## City Sprouts
#### Skill Distillery Midterm Full-Stack Group Spring MVC Project

### Overview
This is a Java Persistence Application Programming Interface (JPA API), Spring Model View Controller (MVC), full-stack webapp with full CRUD functionality. The objective in developing this application was to reenforce the steps to build and deploy a full-stack webapp as well as provide experience with Agile and SCRUM methodologies.  

The inspiration for the application is connecting urban growers with their local market while connecting local consumers with local growers.  Everyone likes their fruits and vegetables to be fresh but access to such produce is limited. Perhaps consumers can go to the local farmer's market but these venues are limited to once or twice a week and not available in the winter months.  The alternative is the local grocery store but consumers do not know where that produce comes from nor when it was picked. A growing number of consumers are concerned with food freshness. We share this concern which is why we developed **City Sprouts**.  

City Sprouts allows local growers to connect with their local market.  It allows consumers to connect and buy local produce *anytime*.  It encourages entrepreneurship for those that like to garden, who may have excess produce they usually throw away, they can now sell through City Sprouts eliminating excessive waste.  Growers sell directly to consumers, eliminating the middleman.  City Sprouts serves to facilitate these connections.

#### Team members and roles:
* Rob Lounsbury (Developer, DBA)
* Randy Beach (Developer, Scrum Master)
* Adam Crawford (Developer, Repo Owner)

## How to Use

The application currently has two roles - buyer or seller.  A third role, driver, was not able to be implemented within the one week sprint and is a stretch goal.  An additional administrator role would be necessary as well. User can register as either a buyer or a seller as well as edit their account.  

As a buyer, the user can search for produce name, description, or category as well as seller store name. A buyer can add items to their cart as well as checkout.   

As a seller, the user can add an item along with a name, description, and select from predetermined categories as well as enter the quantity of the item they have for sale.  This provides an inventory of seller items.  As buyers add an item to their cart, the seller inventory is decremented.  If a buyer removes an item from their cart, the inventory quantity is incremented accordingly.  

Additional capability to include notification of an order to a seller, as well as selecting delivery for a buyer purchase along with desired window of delivery are features which would enhance this application.

#### View the application live...

[City Sprouts](http://citysprouts.robcodes.pro)

### Installation

* Prerequisites: Spring STS IDE, AWS Linux AMI, JDK, MySQL, your chosen port allowed for external traffic to your server.
* Run the SQL script provided to build the database.  Then, create accounts and populate a seller inventory.
* With a copy of the project in your Spring Tool Suite, create a .war file.
* Deploy the .war file to your server.
* Ensure the database account to be used by the app exists in MySQL.
* Connect to your app from a browser using `http://youripaddress:AppPort/nameofproject`

### UML Diagram

![UML Diagram](https://github.com/robrides/MidtermProject/blob/master/CitySprouts/CitySproutsUML.png)

### Entity Relationship Diagram

![ERD](https://github.com/robrides/MidtermProject/blob/master/DB/citysproutsERD.png)

### Technologies Used

Spring Tool Suite (STS/Eclipse), Spring MVC Framework, Java, JPA, Hibernate, Gradle, Tomcat, MySQL, MySQL WorkBench, C.R.U.D functionality, MAMP (MacOS, Apache, MySQL, PHP/Python/Perl(Not used)), log4j, JDK, HTML, CSS, JavaScript, Bootstrap, Atom, Bash Terminal, Gimp

### Lessons Learned
Team availability, making sure everyone is available for the duration of the sprint is key.  Never underestimate the challenge of frontend work. When you see your teammate starring at the screen intently and their fingers aren't typing, see if they need help...pair programming!

### Future Improvements

* Enforce unique constraints on the email and username in the database; handle MySQL error messages when this constraint is violated.
* Implement a robust authentication solution.
* Implement TLS (SSL) / https / server-side PKI certificates.
* Refine styling.
* Improve exception handling.
* Implement input validation.
* Implement Driver and administrator roles.
* Implement notifications.
* Allow buyer to indicate a quantity of an item when adding to their cart.
* Allow the seller to edit and delete an item.
* Implement seller ratings and comments.
* Mark the map with seller location (opt out by default)
* Implement the map API protecting the key (currently not functional)

### Contributions and Issues

This webapp was built for educational purposes.  Feel free to open issues as they are found but this repository is not actively monitored. The developers can not offer support beyond the initial release.
