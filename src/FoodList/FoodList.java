/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FoodList;

import Food.Food;
import Input.Tool;
import java.util.*;

/**
 *
 * @author Admin
 */
public class FoodList extends ArrayList<Food> {

    public FoodList() {
        super();
    }

    public ArrayList getList() {
        return this;
    }

    public boolean addFood() {
        Food food = inputFood();
        return this.add(food);
    }

    public void displayAll(ArrayList list) {
        if (list.isEmpty()) {
            System.out.println("\n            FOOD LIST IS EMPTY!");
        } else {
            System.out.printf("%-10s %-15s %-14s %-13s %-12s %-14s %-14s\n", "ID", "Name", "Weight", "Type", "Place", "Expired Date", "Price");
            for (Food food : this) {
                food.output();
                System.out.printf("%-10s %-15s %-14s %-13s %-12s %-14s %-14s\n", "----", "------", "-------", "-------", "--------", "--------------", "------------");
            }
        }

    }

    public boolean searchByName(String name) {
        name = name.toLowerCase();
        boolean flag = false;
        name = name.trim();
        for (Food food : this) {
            if (food.getName().toLowerCase().contains(name)) {
                System.out.printf("%-10s %-15s %-14s %-13s %-12s %-14s %-14s\n", "ID", "Name", "Weight", "Type", "Place", "Expired Date", "Price");
                food.output();
                System.out.printf("%-10s %-15s %-14s %-13s %-12s %-14s %-14s\n", "----", "------", "-------", "-------", "--------", "--------------", "------------");
                flag = true;
            }
        }
        if (flag) {
            return true;
        }
        return false;
    }

    public Food searchByID(String ID) {
        ID = ID.toLowerCase();
        for (Food food : this) {
            if (food.getID().toLowerCase().equals(ID)) {
                return food;
            }
        }
        return null;
    }

    public void removeByID() {
        displayAll(this);
        Scanner sc = new Scanner(System.in);
        System.out.print("--> Input ID of Food you want to remove: ");
        String ID = sc.nextLine();
        Food food = searchByID(ID);
        if (food != null) {
            System.out.println("    ---> CONFIRM YOUR CHOICE!");
            boolean check = Tool.yesNoQuestion();
            if (check) {
                this.remove(food);
                System.out.println("    ---> REMOVED SUCCESSFULLY! ");
            } else {
                System.out.println("    ---> REMOVED FAIL! ");
                return;
            }
        } else {
            System.out.println("    ---> ID'S FOOD DOESN'T EXIST! ");
            System.out.println("              REMOVED FAIL! ");
        }
    }

    public int getLenght() {
        return this.size();
    }

    public void sortDate() {

        Collections.sort(this, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o2.getExpriedDate().compareTo(o1.getExpriedDate());
            }

        });
    }

    private boolean checkSameID(String ID) {
        for (Food food : this) {
            if (food.getID().toLowerCase().equals(ID.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private Food inputFood() {
        boolean check = true;
        String ID = null;
        while (check) {
            String setID = Tool.nextLine("id", "\n--> Input ID for Fruit: ");
            boolean checkExist = checkSameID(setID);
            if (!checkExist) {
                ID = setID;
                check = false;
            } else {
                System.out.println("    ---> THIS FOOD IS ALREADY EXIST!");
                System.out.print("Do you want continue to input new ID FRUIT ");
                boolean Continue = Tool.yesNoQuestion();
                if (!Continue) {
                    System.out.println("   ---> ADDED FAILED!");
                }
            }
        }
        String name = Tool.nextLine("name", "--> Input Name of Food: ");
        int weight = Tool.nextInt("weight", "--> Input Weight of Food (Gram): ", 50, 100000);
        String type = Tool.inputChoice("Type", "--> Input Type of Food (Fresh/Cooked/Canned): ", "Fresh", "Cooked", "Canned");
        String place = Tool.inputChoice("Place", "--> Input Place of Food (Freezer/Cooler/Fruit): ", "Freezer", "Cooler", "Fruit");
        Date expriedDate = Tool.inputdate("ExpriedDate", "--> Input Expried Date of Food (dd/MM/yyyy): ");
        double price = Tool.nextDouble("Price", "--> Input Price of Food: ", 0, 100000000);
        Food food = new Food(ID, name, weight, type, place, expriedDate, price);
        return food;
    }

    public void sortName() {

        Collections.sort(this, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o2.getName().compareTo(o1.getName());
            }

        });
    }
    
     public void sortWeight() {

        Collections.sort(this, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o2.getWeight() > (o1.getWeight()) ? -1:1;
            }

        });
    }
}
