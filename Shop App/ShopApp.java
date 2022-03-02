/**This is an application where we can buy, sell, re-price and see the products which 
 * is in a menu driven interface which also uses an external Product class
 * 
 * @author MIRZA ADNAN BAIG
 * 
 * @version 13-07-2021
 */
import java.util.*;
public class ShopApp 
{
    public static void main(String args[]) 
    {
        char choice;
        
        System.out.println("*** 2095492 ***");
        System.out.println();
        
        //creating an object of Product class and within an array
        Product[] obj = new Product[5];
            
        //Passing the object and calling the class
        productList(obj);
        
        //creating an menu driven interface
        do
        {
            //receiving and storing the value that is returned by the menu method
            choice = menu();
            
            /* using switch statement to make choice accouridg to the option selectedby the user and 
            calling the appropriate method and passing the object when necessary */
            switch(choice)
            {
                case '1': displayAll(obj); break;
                
                case '2': buy(obj); break;
                
                case '3': sell(obj); break;
                 
                case '4': setNewPrice(obj); break;
                
                case '5': totalValue(obj); break;
                
                case '6': quitOption(); break;
                
                default: System.out.println("Enter the option between 1-6 only."); System.out.println();
            }
        } while(choice != '6');
    }
    
    //hard-coding the array and also initializing the constructor of Product class
    static void productList(Product[] objIn)
    {
        objIn[0] = new Product("1.  Tv", 15, 500.99);
        objIn[1] = new Product("2.  iPhone", 30, 899);
        objIn[2] = new Product("3.  Microwave", 20, 100);
        objIn[3] = new Product("4.  Music System", 5, 230);
        objIn[4] = new Product("5.  Kettle", 22, 59.50);
    }
    
    //creating the menu for the menu driven interface 
    static char menu()
    {
        Scanner inp = new Scanner(System.in);
        char choiceIn;
        
        System.out.println("***MENU***");
        System.out.println("1. Display all the products");
        System.out.println("2. Buy the stocks");
        System.out.println("3. Sell stocks");
        System.out.println("4. Re-price the products");
        System.out.println("5. Total value of all the products in the stock");
        System.out.println("6. Quit");
        System.out.print("Enter the option (1-6): ");
        
        //creating an input validation which prevents the users to input the value other than numbers
        while (!inp.hasNextInt()) 
        {
            System.out.println("That's not a number!");
            inp.next();  
            System.out.print("Enter a valid number: ");
        }
        choiceIn = inp.next().charAt(0);
       
        System.out.println();
        return choiceIn;
    }
    
    
    //method to display the products when the appropriate option is choosen 
    static void displayAll(Product[] objIn)
    {
        for( int i=0; i<objIn.length; i++)
            {
                System.out.println(objIn[i].getName());
                System.out.println("\t" + "Stock available: " + objIn[i].getStockLevel());
                System.out.println("\t" + "Price per item: " + objIn[i].getPrice());
                System.out.println(); 
            }
            System.out.println(); 
    }
    

    /* method to buy the stocks and display the new stock level and the 
      value of the stock bought when the appropriate option is choosen */
    static void buy(Product[] objIn)
    {
        int buyNum, buyWhat;
        Scanner inp = new Scanner(System.in);
        
        System.out.print("Enter the serial number of product bought: ");
        buyWhat = inp.nextInt();
        
        System.out.print("Enter the quantity: ");
        buyNum = inp.nextInt();
        
        System.out.println("The value of the stock bought: £" + objIn[buyWhat-1].buyStock(buyNum));
        System.out.println("Total stock available: " + objIn[buyWhat-1].getStockLevel());
        System.out.println();
    }
    
    
    /* method to sell the stocks and display the new stock level and the 
      value of the stock sold when the appropriate option is choosen */
    static void sell(Product[] objIn)
    {
        int sellNum, sellWhat;
        Scanner inp = new Scanner(System.in);
        
        System.out.print("Enter the serial number of products sold out: ");
        sellWhat = inp.nextInt();
        
        System.out.print("Enter the number of products sold out: ");
        sellNum = inp.nextInt();
        
        System.out.println("The value of the items sold: £" + objIn[sellWhat-1].sell(sellNum)); 
        System.out.println("Total stock remaining: " + objIn[sellWhat-1].getStockLevel());
        System.out.println(); 
    }
    
    
    //method to set a new price for the products when the appropriate option is choosen 
    static void setNewPrice(Product[] objIn)
    {
        double newPrice;
        int priceFor; 
        Scanner inp = new Scanner(System.in);
        
        System.out.print("Enter the serial number to change price: ");
        priceFor = inp.nextInt();
        
        System.out.print("Enter the new price: £");
        newPrice = inp.nextDouble();
        
        objIn[priceFor-1].setPrice(newPrice);
        System.out.println(); 
    }
    
    
    //method to display the total value of all the stocks when the appropriate option is choosen 
    static void totalValue(Product[] objIn)
    {
        double totalSum = 0;
        
        for (int j=0; j<objIn.length; j++)
            {
                totalSum = totalSum + objIn[j].getPrice()*objIn[j].getStockLevel();
            } 
            
        System.out.println("Total value of all the available stock: £" + totalSum);
        System.out.println(); 
    }


    //method to diaplay a message when quit option is choosen
    static void quitOption()
    {
        System.out.print("Thank you for shopping..!");
    }
    
}