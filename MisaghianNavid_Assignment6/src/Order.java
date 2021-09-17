/**
 * This is the order class that organizes the rest and uses the  a NOGUI test
 * class to organize the customers order
 */


import java.util.ArrayList;
import java.util.Random;



public class Order implements OrderInterface, Comparable<Order> {

    private int orderNo;

    private int orderTime;

    private DAY orderDay;

    private Customer customer;

    private ArrayList<Beverage> beverages;



    //Constructors start from here


    public Order(int ot, DAY od, Customer c) {

        orderNo = genOrderNum();

        orderTime = ot;

        orderDay = od;

        customer = c;

        beverages = new ArrayList<>();
    }

    //Utility Class Start from here

    public int genOrderNum() {

        Random rand = new Random();

        // [10_000, 90_000)
        int randInt = rand.nextInt(90_000-10_000)+10_000;

        return randInt;

    }
    public String toString() {

        String s = "__________________________________"

                +orderDay.toString() +", " +orderTime

                +"\n" +customer.toString() +" Order Num: " +orderNo;



        for (Beverage b : beverages) {

            s += "\n" +b.toString();

        }
        s += "\n Order Total: " +calcOrderTotal();



        return s;
    }

    public boolean isWeekend() {

        if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {

            return true;

        }

        return false;
    }

    public Beverage getBeverage(int itemNum) {

        return beverages.get(itemNum);

    }

    public int compareTo(Order o) {

        if (orderNo == o.getOrderNo()) {

            return 0;

        }

        else if (orderNo > o.getOrderNo()) {
            return 1;

        }

        else {

            return -1;

        }

    }

    public double calcOrderTotal() {

        double orderTotal = 0;



        for (Beverage b : beverages) {

            orderTotal += b.calcPrice();

        }



        return orderTotal;

    }

    //number of beverages start here

    public int findNumOfBeveType(TYPE type) {

        int count = 0;


        for (Beverage b : beverages) {
            if (b.getType() == type) {
                count++;
            }
        }

        return count;
    }

    //total item method start from here
    public int getTotalItems() {

        return beverages.size();

    }

    //add the new beverage method start from here

    public void addNewBeverage(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        Coffee c = new Coffee(name, size, extraShot, extraSyrup);

        beverages.add(c);

    }
    public void addNewBeverage(String name, SIZE size, int numOfFruits, boolean proteinPowder) {

        Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder);

        beverages.add(s);

    }

    public void addNewBeverage(String name, SIZE size) {

        boolean isWeekend = false;

        if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {

            isWeekend = true;
        }

        Alcohol a = new Alcohol(name, size, isWeekend);

        beverages.add(a);

    }

    // the method accessor start from here
    public int getOrderNo() {
        //this allows for order number
        return orderNo;
    }
    public int getOrderTime() {
        //ordet ime
        return orderTime;
    }
    public DAY getOrderDay() {
     //order day
        return orderDay;
    }
    public Customer getCustomer() {
        //get the customer
        return new Customer(customer);
    }
    public ArrayList<Beverage> getBeverages() {
        //get the ververages
        return beverages;
    }


    public void setOrderNum(int on) {
        orderNo = on;
    }
    public void setOrderTime(int ot) {
        orderTime = ot;
    }
    public void setOrderDay(DAY od) {
        orderDay = od;
    }
    public void setCustomer(Customer c) {
        customer = c;
    }
}