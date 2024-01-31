
package controller;

import util.InputUtils;


public class Menu {
    public static int chooseInputOption(){
        System.out.println("========= Contact program =======");
        System.out.println("1. Add contact.");
        System.out.println("2. Display contact.");
        System.out.println("3. Delete contact.");
        System.out.println("4. Exit.");
        int option = InputUtils.inputOption(1, 4);
        return option;
    }
}
