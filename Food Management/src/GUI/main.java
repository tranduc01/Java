/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Food;
import DTO.FoodList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FoodList list = new FoodList();
        list.readText("food.txt");
        int choice = 0;
        boolean go = true;
        do {
            try {
                do {
                    sc = new Scanner(System.in);
                    System.out.println("Welcome to Food Management - By <SE151204 - Đoàn Trần Đức>");
                    System.out.println("Select the options below:");
                    System.out.println("1. Add a new food");
                    System.out.println("2. Search a food by name");
                    System.out.println("3. Remove a food by ID");
                    System.out.println("4. Print the food list in the descending order of expired date ");
                    System.out.println("5. Save in file");
                    System.out.println("6. Quit");
                    System.out.println("Your choice: ");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            String input;
                            do {
                                Food f = new Food();
                                try {
                                    do {
                                        f.inputFood();
                                        go = false;
                                        if (list.findFood(f.getId()) != null) {
                                            System.out.println("Food is already exist");
                                            go = true;
                                        }
                                    } while (go);
                                    if (list.addFood(f)) {
                                        System.out.println("Added");
                                    } else {
                                        System.out.println("Added Fail");
                                    }
                                    sc = new Scanner(System.in);
                                    System.out.println("Do you want to continue?(Y/N)");
                                    input = sc.nextLine();
                                    if (input.startsWith("Y") || (input.startsWith("y"))) {
                                        go = true;
                                    } else if (input.startsWith("N") || (input.startsWith("n"))) {
                                        go = false;
                                    } else {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Please input Y or N");
                                    go = true;
                                }
                            } while (go);
                            break;
                        case 2:
                            do {
                                try {
                                    sc = new Scanner(System.in);
                                    String name;
                                    System.out.println("Input food's name you want to find: ");
                                    name = sc.nextLine();
                                    if (list.searchFood(name) != null) {
                                        System.out.println("Founded");
                                    } else {
                                        System.out.println("Cannot found. Food doesn't exist");
                                    }
                                    sc = new Scanner(System.in);
                                    System.out.println("Do you want to continue?(Y/N)");
                                    input = sc.nextLine();
                                    if (input.startsWith("Y") || (input.startsWith("y"))) {
                                        go = true;
                                    } else if (input.startsWith("N") || (input.startsWith("n"))) {
                                        go = false;
                                    } else {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Please input Y or N");
                                    go = true;
                                }
                            } while (go);
                            break;
                        case 3:
                            int id = 0;
                            do {
                                try {
                                    sc = new Scanner(System.in);
                                    System.out.println("Input food's id you want to remove");
                                    id = sc.nextInt();
                                    if (list.removeFood(id)) {
                                        System.out.println("Removed");
                                    } else {
                                        System.out.println("Remove Fail");
                                    }
                                    go = false;
                                    if (id < 0) {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("ID must be a number. Please enter again");
                                    go = true;
                                }
                            } while (go);
                            break;
                        case 4:
                            list.sortDate();
                            list.displayFood();
                            break;
                        case 5:
                            list.saveFile("food.txt");
                            System.out.println("Saved");
                            break;
                    }

                } while (choice > 0 && choice <= 5);
                go = false;
                if (choice < 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Plese input 1-6");
                go = true;
            }
        } while (go);
    }
}
