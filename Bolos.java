package bolos;

import java.util.Scanner;

/**
 *
 * @author Sebastián leon Sebastian Soracipa
 */
public class Bolos {

    static Scanner sc = new Scanner(System.in);
    static String name1 = null;
    static String name2 = null;
    public static int puntuacion;
    public static int lance1 = 0, lance2 = 0;
    public static String tiro10;

    public static void pantalla() {//leon
        System.out.println("***************Puntuación***************");
        System.out.println("**********************************************\n*" + name1 + "       *        *        *        *        *\n*        *        *        *        *        *\n**********************************************");
        System.out.println("**********************************************\n*" + name2 + "       *        *        *        *        *\n*        *        *        *        *        *\n**********************************************");

    }

    public static void logicaPuntuacion() {
        int total = 0;      //variable para el total de cada turno, cuando no es Strike
        int chuza = 0;      //Variable para el caso en que exista un Strike
        for (int i = 0; i < 10; i++) {  //Ciclo para los 10 turnos
            lance1 = 0;                 //Inicializo cada lance en 0
            lance2 = 0;                 //Inicializo cada lance en 0
            System.out.println("Este es su: "+(i+1)+" Tiro"); // Imprime el turno en el que va
            System.out.println("Ingrese Primer lance");      //Todo lo que se imprima en pantalla en este metodo es temporal, despues se usará el metodo imprimir pantalla
            lance1 = sc.nextInt();  //se sobre escribe variable lance1
            if (lance1 == 10) {     //Condición cuando el primer lance es 10(Strike)
                chuza = lance1;     //Almacena el Strike en la variable chuza
                tiro10 = "x";       //Está variable tiro10 es para usar luego en el metodo imprimirPantalla
            } else if (lance1 < 10) { //Si el primer lance no es Strike se sigue el siguiente ciclo
                do {                    
                    System.out.println("Ingrese Segundo lance");  //Se pide que digite el segundo lance  
                    lance2 = sc.nextInt();                      //se sobre escribe lance2
                    total = lance1 + lance2;                    //Se sobreescribe la variable total con la suma de los dos lances
                    if (total < 10) {                           //esta condicion es para evaluar si es posible el valor total es decir que sea menor que 10, si es 10 es un Spare
                        if (chuza == 10) {                      //esta condicion es para darle ingreso a la variable chuza
                            chuza = chuza + total;              //Operación para sumarle a chuza lo hecho en los dos siguientes lances 
                            puntuacion += chuza;                //Ahora en la variable puntuacion se le da valor a chuza
                        }
                    }
                } while (total > 10); //Esta condicion en el ciclo es para que no digiten valores mayores que 10 ya que 10 es el máximo de bolos
                puntuacion += total;    //Se le suma a la variable puntuacion el total del turno
            }
            if(lance1==10){                                     //Las siguientes impresiones son sólo para comprobar si la puntuacion es correcta 
                System.out.println("Esta es su puntuación: "+tiro10);//Despues de acabar con la parte lógica se imprimirá esto en el metodo imprimirPantalla
        
            }else
            System.out.println("Esta es su puntuación: "+puntuacion+" Puntos");
            //Aclaración, La chuza tiene validez cuando en el siguente turno no es chuza ni spare
            //En el código aun falta más variacion de chuza por ejemplo si todos los turnos son chuza, tambien faltan todas las variaciones cuando se hace un Spare

        }

    }

    public static void imprimirPantalla() {
        System.out.println("***************Puntuación***************");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 50; j++) {
                if (i % 2 == 0) {
                    System.out.print("─");
                } else {
                    System.out.print("");
                }

                System.out.println("|");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Bienvenidos a bolos");
        System.out.println("Por favor ingrese los nombres: ");
        name1 = sc.next();
        name2 = sc.next();
        //imprimirPantalla();
        // pantalla(player1, player2);
        logicaPuntuacion();
    }
}
