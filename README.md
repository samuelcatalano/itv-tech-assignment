# Tech Assignment - ITV
Tech Assignment - ITV


**Checkout Kata**  

Implement the code for a supermarket checkout that calculates the total price of a number of items.
In a normal supermarket, items are identified by ‘stock keeping units’ or ‘SKUs’. In our store, we will use
individual letters of the alphabet, A, B, C etc, as the SKUs. Our goods are priced individually. In addition,
some items are multipriced: buy n of them and which will cost you y. For example, item A might cost 50
pence individually but this week we have a special offer where you can buy 3 As for £1.30.
This week’s prices are the following:


| Item | Unit Price | Special Price |
|:-	|:-	|:-	|
|A 	|50  	| 3 for 130 	|
|B 	|30  	| 2 for £45 	|
|C 	|20  	|  	|
|D 	|15  	|  	|


Our checkout accepts items in any order so if we scan a B, then an A, then another B, we will recognise
the two B’s and price them at 45 (for a total price so far of 95).

Extra points: Because the pricing changes frequently we will need to be able to pass in a set of pricing
rules each time we start handling a checkout transaction.

### Tech Stack:
| Technology | Version |
|--|--|
| **Java** | 11.0.3-2018-01-14 |
| **Project Lombok** | 1.18.20 |
| **Jupiter JUnit 5** | 5.7.1 |
| **Hamcrest Core** | 2.2 |
| **Gradle** | 7.0 |


### How to run the application:
> IDE (IntelliJ, Eclipse, NetBeans):
- Importing the project as Maven project on your favourite IDE.
- Build project using Java 11
- Run/Debug project from Main Application Class :: ItvAssignmentApp

### Program arguments example:
> IDE (IntelliJ, Eclipse, NetBeans):

- You can just run the main class with the default arguments or change them randomly:
- `Arrays.asList("A", "B", "C", "D")`

> Or you can set the program arguments like the image below:  
![Image description](https://i.imgur.com/iIFCAmz.png)

### Result example:
![Image description](https://i.imgur.com/YLLjiDo.png)

### How to run the tests:
- ItvAssignmentAppTest: `itv.assignment.ItvAssignmentAppTest`
- Or run `./gradlew build`
