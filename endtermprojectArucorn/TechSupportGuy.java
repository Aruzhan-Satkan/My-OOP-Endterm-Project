package endtermprojectArucorn;
import java.util.*;

public class TechSupportGuy extends Employee {
    private int doneOrders = 0;
    public TechSupportGuy() {
    	super();
    }
    
    public TechSupportGuy(String name, String surname) {
    	super(name, surname);
    }

    /**
     * Adds a new order to vector
     * @param o
     */
    public void receive(Order o) {
        Data.newOrders.remove(o);
        Data.oldOrders.add(o);
        doneOrders++;
    }
    /**
     * Loops throug the vector "newOrders" and displays all the orders
     * @return
     */
    public String viewNewOrders() {
        String s = "";
        for (Order o : Data.newOrders) {
        	s += o.toString() + "\n";
        }
        return s;
    }
    /**
     * Loops through the vector "oldOrders" and displays all the orders
     * @return
     */
    public String viewOldOrders() {
    	String s = "";
        for (Order o : Data.oldOrders) {
        	s += o.toString() + "\n";
        }
        return s;
    }
    /**
     * Creates a new vector and adds elements of "oldOrders" and "newOrders" and  returns it then
     * @return
     */
    public Vector<Order> getAllOrders() {
        Vector <Order> all = new Vector <Order>();
        all.addAll(Data.oldOrders);
        all.addAll(Data.newOrders);
        return all;
    }
    /**
     * Displays the first new orders and then old ones as string
     * @return
     */
    public String viewAllOrders() {
        return "New orders: " + viewNewOrders() + "\n Old orders: " + viewOldOrders();
    }
    /**
     * Changes a boolean value as true when TechSupport accepts order
     * @param order
     */
    public void accept(Order order) {
    	receive(order);
        System.out.println("Success!");
    }
    /**
     * Deletes an order from a vector when TechSupport rejects an order
     * @param order
     */
    public void reject(Order order) {
        Data.newOrders.remove(order);
        System.out.println("Rejected! ");
    }
    /**
     * Loops throug the vector "Orders" and prints if boolean "isAccepted" equals true
     */
    public void viewAcceptedOrders() {
    	for(Order order : Data.oldOrders) {
    			System.out.println(order);
    	}
    }
    /**
     * Loops through the vector "Orders" and prints all the orders
     */
    public void showAllOrders(){
    	for (Order order : getAllOrders()) {
			System.out.println(order);
		}
    }

    @Override
    public String toString() {
        return "Tech Support man: " +
                "name = " + getName() +
                ", surname = " + getSurname();
    }
}