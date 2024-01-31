
package util;

import java.util.Scanner;

public class InputUtils {
    
    public static int inputId(){
        Scanner sc = new Scanner(System.in);
        int id;
        while (true) {
            try {
                id = Integer.parseInt(sc.nextLine());
                
                break;
            } catch (NumberFormatException e) {
                System.err.print("Invalid id. Try again.");
            }
        }
        return id;
    }
    public static String inputName() {
        Scanner sc = new Scanner(System.in);
        String name;
        while (true) {
            try {
                name = sc.nextLine();

                if (!name.matches("[a-zA-Z .]+")) {
                    throw new IllegalArgumentException("Invalid name. Please enter a valid name.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.print(e.getMessage());
            }
        }
        return name;
    }
    
    public static int inputOption(int min, int max) {
        Scanner sc = new Scanner (System.in);
        int rs;
        while (true) {
            try {
                rs = Integer.parseInt(sc.nextLine());
                if (rs < min || rs > max) {
                    throw new ArithmeticException("Not valid. Enter a valid number from "+ min + " to " + max + ".");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Pls input a valid integer number.");
            } catch (ArithmeticException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return rs;
    }
    
    public static String inputPhone() {
        Scanner sc = new Scanner (System.in);
        String phone;
        String regex = "^(\\d{3}[-\\s.]?\\d{3}[-\\s.]?\\d{4})(x\\d+)?(ext\\d+)?$";
        while (true){
            try{
                phone = sc.nextLine();
                if (!phone.matches(regex) ){
                    throw new IllegalArgumentException("Invalid phone number. Please enter a valid phone number.");
                }
                break;
            } catch(IllegalArgumentException e) {
                System.err.print(e.getMessage());
            }
        }
        return phone;
    }
}
