<h1 align="center"><strong>Supermarket Management System</strong></h1>


## Table of Contents
- [Technology](#technology)  
- [Goal](#goal)  
- [Functionalities](#functionalities)  
- [UML Diagram](#uml-diagram)


<h3>:computer:<strong>Technology</strong></h3> 

- **Java**
- **IntelliJ IDEA**

<h3><strong>Goal</strong></h3> The goal of the application supermarket is to apply the fundamental of OOP such as
inheritance , Polymorphism , Encapsulation and Abstraction , and also to
use the concept of design pattern in the code



<h3><strong>Functionalities</strong></h3> 
The dummy client will have an initial budget of 100000\$ to manage his
supermarket

<img src="./media/image1.png"
style="width:4.81667in;height:2.14583in" />

The items to be purchased by the client were created initially with the
Builder Design pattern.

Functions:

**1-Buy items from suppliers:**

Different product can be purchased by the client from the supplier. To
choose the product, the client will select the product by entering its
index, the quantity

<img src="./media/image2.png"
style="width:6.22778in;height:2.96806in" />

Once the item is added, its quantity will be reduced and then it will be
added to the inventory of the client .

<img src="./media/image3.png"
style="width:6.39861in;height:1.89861in" />

The client can continue purchasing as much as he/she wants until he/she
decides to stop his/her purchase, and his/her inventory, remaining money
as well as money left will be displayed.

<img src="./media/image4.png"
style="width:4.55069in;height:3.60139in" />

**2-Sell Items:**

<img src="./media/image5.png" style="width:6.5in;height:1.09514in" />After
the item is sold, the inventory and the budget are updated. It is
important to note that the budget increased because the selling price \>
purchasing price.

<img src="./media/image6.png"
style="width:6.49375in;height:1.57569in" />

**3-View inventory & remaining budget:**

In our case, 7 fruits were sold from 9 =\> there is 2 fruits left in the
inventory

<img src="./media/image7.png"
style="width:3.91806in;height:1.56944in" />

**4-Pay employees:**

The client can pay his employee

The payment is made according to the time spent they worked , and it is
programmed to be automatic

public void payEmployees() {  
long currentTimeMinutes = System.*currentTimeMillis*() / (60 \* 1000);  
long timeElapsedSinceLastPayment = currentTimeMinutes -
lastPaymentTimeMinutes;  
  
  
double totalPayment = 0.0;  
for (Employee employee : employees) {  
totalPayment += employee.salary \* timeElapsedSinceLastPayment;  
}  
  
  
if (budget \>= totalPayment) {  
  
budget -= totalPayment;  
  
  
totalPaidToEmployees += totalPayment;  
lastPaymentTimeMinutes = currentTimeMinutes;  
  
  
System.*out*.println("Paid \$" + totalPayment + " to employees.");  
  
System.*out*.println("Total paid until now \$" +
totalPaidToEmployees);  
  
System.*out*.println("Budget \$" + budget);  
  
} else {  
System.*out*.println("Insufficient budget to pay employees.");  
}  
}  
  
  
}

<img src="./media/image8.png"
style="width:4.81667in;height:1.36042in" />

**5-View Profits:**

<img src="./media/image9.png"
style="width:3.72778in;height:1.29097in" />

**6-View Expenses:**

<img src="./media/image10.png"
style="width:2.56944in;height:1.19653in" />

<h3><strong>UML Diagram</strong></h3>

The diagram shows the different relationship between the different
classes in the application

<img src="./media/image11.png"
style="width:6.49375in;height:2.86736in" />
