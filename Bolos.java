package bolos;

import java.util.Scanner;

/**
 *
 * @author Sebastián leon
 *          Sebastian Soracipa
 */
public class Bolos {
    static Scanner sc = new Scanner(System.in);
    static String name1 = null;
    static String name2 = null;
    public static void pantalla(int player1, int player2){//leon
        System.out.println("***************Puntuación***************");
        System.out.println("**********************************************\n*"+name1+"       *        *        *        *        *\n*        *        *        *        *        *\n**********************************************");
        System.out.println("**********************************************\n*"+name2+"       *        *        *        *        *\n*        *        *        *        *        *\n**********************************************");
    
    
    
    }
    public static void logicaPuntuacion(){
        
        //  Crack
    
    
    
    }
    public static void imprimirPantalla(){
        System.out.println("***************Puntuación***************");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 50; j++) {
                if(i%2 == 0) {
                    System.out.print("─");
                } else {
                    System.out.print("");
                }
                
            System.out.println("|");
        }
    }
    }
    
    public static void main(String[] args) {
        int player1=0,player2=0;
        System.out.println("Bienvenidos a bolos");
        System.out.println("Por favor ingrese los nombres: ");
        name1 = sc.next();
        name2 = sc.next();
        //imprimirPantalla();
        pantalla(player1, player2);
    }
