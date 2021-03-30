package test;

public class Product 
{
	private String id;
	private String description;
	private int numberInStock;
	private int numberSold;
	private double costPrice;
	private double salePrice;
	private double markUp;
	private double profit;

	public Product(String ID,String DEC,int numberStock,double costPrice, double salePrice)
	{
		this.id = ID;
		this.description = DEC;
		this.numberInStock = numberStock;
		this.costPrice = costPrice;
		this.salePrice = salePrice;
		numberSold = 0;
	}

	public String getID( ) 
	{ 
		return id;
	}
	public int getnumberSold( ) 
	{
		return numberSold; 
	}

	public void buyQuantity(int quantity)
	{

	}

	public void sellOne()
	{
		boolean product = false;
		if(numberInStock < 1 )
		{
			product = false;
		}
		else
		{
			product = true;
		}

		if(product = true)
		{
			--numberInStock;
			++numberSold;	
		}
	}

	public double getMarkUp()
	{
		return markUp;
	}

	public void getProfit()
	{

	}

	public String toString( )
	{
		return " " +id+ " "+ description +" "+ numberInStock + " " +numberSold + " " + costPrice +" "+salePrice+" "+markUp+""+profit;
	}
}
