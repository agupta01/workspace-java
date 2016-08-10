import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ReceiptMain {
	
	static ArrayList<String> itemName = new ArrayList<String>();
	static ArrayList<Double> itemPrice = new ArrayList<Double>();

	static String newItem = "";
	static boolean repeat = true;
	static double tax = 0;

	public static void main(String[] args) {
		
		while (repeat != false)
		{
			enterProducts(newItem);
			chooseRepeat();
		}

	}

	
	public static void enterProducts(String item){
		if (item.equals("")){
			System.out.print("Enter an item name: ");
			Scanner itemTemp = new Scanner(System.in);
			item = itemTemp.nextLine();
		}
		
		itemName.add(item);
		
		System.out.print("Enter the price: ");
		Scanner itemPTemp = new Scanner(System.in);
		double itemP = itemPTemp.nextDouble();
		itemPrice.add(itemP);
		
		
	}
	
	
	public static void chooseRepeat(){
		System.out.print("To enter another item, type its name. To finish, press enter: ");
		Scanner holder = new Scanner(System.in);
		newItem = holder.nextLine();
		
		if (newItem.equals(""))
		{
			
			repeat = false;
			
			setTax();
			printReceipt(tax);
			
		}
	}
	
	public static void setTax(){
		System.out.print("Enter tax if needed (by % please). If not, press enter: ");
		Scanner holder = new Scanner(System.in);
		String taxOption = holder.nextLine();
		
		if (taxOption.equals("") != true){
			tax = (Double.parseDouble(taxOption))/100;
		}
	}
	
	
	public static void printReceipt(double taxAmount){
		
		double total = 0;
		
		for (int i = 0; i < itemName.size(); i++){
			System.out.println(itemName.get(i) + "................" + itemPrice.get(i));
			total += itemPrice.get(i);
		}
		
		double taxed = total*tax;
		double gTotal = total + taxed;
		
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("Subtotal: $" + df.format(total) 
				+ "\nTax: $" + df.format(taxed)
				+ "\nGrand Total: $" + df.format(gTotal));
		
	}

}
