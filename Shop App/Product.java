public class Product
{
    //attributes
    private String name;
    private int stockLevel;
    private double price;
    
    //constructor which recieves name, stock level and price of the product
    public Product(String nameIn, int stockLevelIn, double priceIn)
    {
        name = nameIn;
        stockLevel = stockLevelIn;
        price = priceIn;        
    }
    
    //methods to buy and sell stocks 
    public double buyStock(int stockLevelIn)
    {
        stockLevel = stockLevel + stockLevelIn;
        return stockLevelIn*price;
    }
    
    public double sell(int stockLevelIn)
    {
        if (stockLevelIn > stockLevel)
        {
            return 0;
        }
        else
        {
           stockLevel = stockLevel - stockLevelIn;
           return stockLevelIn*price;
        }
    }
    
    //method to set a new price for a product 
    public void setPrice(double priceIn)
    {
        price = priceIn;
    }
    
    //methods to read the attributes
    public String getName()
    {
        return name;
    }
    
    public int getStockLevel()
    {
        return stockLevel;
    }
    
    public double getPrice()
    {
        return price;
    }
}