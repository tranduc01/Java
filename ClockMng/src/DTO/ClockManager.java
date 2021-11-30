/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author USER
 */
public class ClockManager {
    public static void main(String[] args) {
        Menu mnu=new Menu();
        mnu.add("Add new clock");
        mnu.add("Remove a clock");
        mnu.add("Update a clock");
        mnu.add("List all clocks");
        mnu.add("List all clocks in a range");
        mnu.add("Quit");
        ClockList list=new ClockList();
        int userChoice=0;
        do{
            userChoice=mnu.getUserChoice();
            switch(userChoice){
                case 1: list.addClock(); break;
                case 2: list.removeClock(); break;
                case 3: list.updateClock(); break;
                case 4: list.print(); break; 
                case 5: list.printPrice(); break;
            }
        }while(userChoice>=0 && userChoice<6);
    }
}
