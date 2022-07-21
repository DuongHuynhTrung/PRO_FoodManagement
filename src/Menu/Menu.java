/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import FoodList.FoodList;
import Input.Tool;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FoodList list = new FoodList();
        boolean check = true;
        do {
            System.out.println("******************************************************************************");
            System.out.println("*   Welcome to Food Management - @ 2021 by <SE150080 - Huynh Trung Duong>    *");
            System.out.println("*                     Select the options below:                              *");
            System.out.println("*                     1. Add a new food.                                     *");
            System.out.println("*                     2. Search a food by name.                              *");
            System.out.println("*                     3. Remove the food by ID.                              *");
            System.out.println("*                     4. Print the food list                                 *");
            System.out.println("*                     5. Quit.                                               *");
            System.out.println("******************************************************************************");

            int choice = Tool.nextInt("choice", "---> Input your choice: ", 1, 5);
            switch (choice) {
                case 1: {
                    boolean flag = true;
                    do {
                        if (list.addFood()) {
                            System.out.println("        ---> ADDED SUCCESSFULLY!");
                        } else {
                            System.out.println("        ---> ADDED FAILED!");
                        }
                        System.out.print("Do you want to add continue? ");
                        flag = Tool.yesNoQuestion();
                    } while (flag);
                    Tool.writeFile(list);
                    break;
                }
                case 2: {
                    boolean checkContinue = true;
                    while (checkContinue) {
                        String checkName = Tool.nextLine("Seach", "-> Input the Name of Food you want to see: ");
                        if (list.searchByName(checkName)) {
                            System.out.print("Do you want to search continue? ");
                            checkContinue = Tool.yesNoQuestion();
                        } else {
                            System.out.println("    ---> FOOD DOESN'T EXIST!");
                            System.out.println("Do you want to search continue? ");
                            checkContinue = Tool.yesNoQuestion();
                        }
                    }
                    break;
                }
                case 3: {
                    list.removeByID();
                    Tool.writeFile(list);
                    break;
                }
                case 4: {
                    list.sortName();
                    list.displayAll(list);
                    System.out.println("\n    ---> PRESS ENTER TO CONTINUE!");
                    sc.nextLine();
                    break;
                }
                case 5: {
                    System.out.println("\n                  ************* SEE YOU LATER ************* \n");
                    check = false;
                    break;
                }
            }
        } while (check);

    }
}
