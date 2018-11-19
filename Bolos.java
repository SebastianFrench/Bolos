package bolos;

import java.util.Scanner;

/**
 *
 *
 *
 * @author Sebastián leon Sebastian Soracipa
 *
 */
public class Bolos {

    static Scanner sc = new Scanner(System.in);

    static String name1 = null;

    static String name2 = null;

    public static int puntuacion,puntuacion2,turnos=10,turnosplayer2 = 10,lanz1player1,lanza2player1,lanza1player2,lanza2player2;
    public static int total,chuza,spare,countchuzas;
    public static int total2,chuza2,spare2,countchuzas2;
    
    public static String tiro10,tiro20;

    public static void pantalla() {
        System.out.println("***************Puntuación de turno **************");
        System.out.println("*        *        *              *              *");
        System.out.println("*  " + name1 + "  *"+lanz1player1+"|"+lanza2player1+" *"+puntuacion+"*");
        System.out.println("*        *        *              *      *********");
        System.out.println("*************************************************");
        System.out.println("***************Puntuación de turno **************");
        System.out.println("*        *        *              *              *");
        System.out.println("*  " + name2 + "  *"+lanza1player2+"|"+lanza2player2+" *"+puntuacion2+"*");
        System.out.println("*        *        *              *      *********");
        System.out.println("*************************************************");
    }
    public static void pantalla2() {
        System.out.println("***************Puntuación de turno **************");
        System.out.println("*        *        *              *              *");
        System.out.println("*  " + name1 + "  *"+"|"+tiro10+"*              *");
        System.out.println("*        *        *              *      *********");
        System.out.println("*************************************************");
        System.out.println("***************Puntuación de turno **************");
        System.out.println("*        *        *              *              *");
        System.out.println("*  " + name2 + "  *"+"|"+tiro20+" *             *");
        System.out.println("*        *        *              *      *********");
        System.out.println("*************************************************");
    }

    public static void logicaPuntuacion(int turno) {
        int l1 = 0;                //Inicializo cada lance en 0

            int l2 = 0;                //Inicializo cada lance en 0

            System.out.println("Este es su: " + (turno + 1) + " Tiro "+ name1); // Imprime el turno en el que va

            
            do {
                System.out.println("Ingrese Primer lance");      //Todo lo que se imprima en pantalla en este metodo es temporal, despues se usará el metodo imprimir pantalla
                l1 = sc.nextInt();  //se sobre escribe variable lance1
            } while (l1 > 10);
            if (l1 == 10) {     //Condición cuando el primer lance es 10(Strike)

                countchuzas++;
                chuza += l1;    //Almacena el Strike en la variable chuza

                if (turno == 9 || turno == 10) {
                    turnos++;
                }
                if (chuza > 20 && chuza < 100) {
                    chuza = 30;
                }
                if (turno < 10) {
                    tiro10 = "x";    //Está variable tiro10 es para usar luego en el metodo imprimirPantalla
                    if (spare == 10) {
                        puntuacion += 10;
                        spare = 0;
                    }
                } else if (turno >= 11) {
                    if (chuza == 10) {                //esta condicion es para darle ingreso a la variable chuza

                        chuza = chuza;        //Operación para sumarle a chuza lo hecho en los dos siguientes lances

                        puntuacion += chuza;        //Ahora en la variable puntuacion se le da valor a chuza

                        chuza = 0;
                        countchuzas=0;

                    }
                    if (chuza == 20) {
                        chuza = chuza;
                        puntuacion += chuza;
                        chuza = 0;
                        countchuzas=0;
                    }
                    if (chuza >= 30) {

                        chuza = (countchuzas - 2) * chuza;
                        
                        puntuacion += chuza;
                        chuza = 0;
                        System.out.println(countchuzas+" puntuacion "+puntuacion );
                        countchuzas=0;
                    }
                    if (spare == 10) {
                        puntuacion += 10;
                        spare = 0;
                    }

                }
            } else if (l1 < 10) { //Si el primer lance no es Strike se sigue el siguiente ciclo
                if (turno < 10) {
                    do {

                        System.out.println("Ingrese Segundo lance");  //Se pide que digite el segundo lance

                        l2 = sc.nextInt();                      //se sobre escribe lance2

                        total = l1 + l2;                    //Se sobreescribe la variable total con la suma de los dos lances

                        if (total <= 10) {                        //esta condicion es para evaluar si es posible el valor total es decir que sea menor que 10, si es 10 es un Spare

                            if (chuza == 10) {                //esta condicion es para darle ingreso a la variable chuza

                                chuza = chuza + total;        //Operación para sumarle a chuza lo hecho en los dos siguientes lances
                               
                                puntuacion += chuza;        //Ahora en la variable puntuacion se le da valor a chuza
                                
                                chuza = 0;
                                countchuzas = 0;

                            }
                            if (chuza == 20) {
                                chuza = chuza + l1 + chuza - (10 - total);
                                puntuacion += chuza;
                                chuza = 0;
                                countchuzas = 0;
                            }
                            if (chuza >= 30) {
                                int turn = countchuzas - 2;
                                chuza = turn * chuza + (chuza - 10) + l1 + chuza - 20 + total;;
                                puntuacion += chuza;
                                chuza = 0;
                                countchuzas = 0;
                            }
                            if (turno == 9) {
                                if (total == 10) {
                                    turnos++;
                                }
                            }
                            if (spare == 10) {
                                puntuacion += l1;
                                spare = 0;
                            }
                            if (total == 10) {
                                spare = 10;
                                tiro10 = "/";
                            }

                        }

                    } while (total > 10); //Esta condicion en el ciclo es para que no digiten valores mayores que 10 ya que 10 es el máximo de bolos

                    puntuacion += total;    //Se le suma a la variable puntuacion el total del turno
                    

                } else if (turno == 10 || turno == 11) {
                    
                    if (spare == 10) {
                        puntuacion += l1;
                        spare = 0;
                    }
                    if (chuza == 10) {                //esta condicion es para darle ingreso a la variable chuza

                        chuza = chuza + total;        //Operación para sumarle a chuza lo hecho en los dos siguientes lances

                        puntuacion += chuza;        //Ahora en la variable puntuacion se le da valor a chuza

                        chuza = 0;
                        countchuzas=0;
                    }
                    if (chuza == 20) {
                        chuza = chuza + l1 + chuza - (10 - total);
                        puntuacion += chuza;
                        chuza = 0;
                        countchuzas=0;
                    }
                    if (chuza >= 30) {
                        int turn = countchuzas - 2;
                        chuza = turn * chuza + (chuza - 10) + l1 + chuza - 20 + total;;
                        puntuacion += chuza;
                        chuza = 0;
                        countchuzas=0;
                    }

                }
            }
            lanz1player1=l1;
            lanza2player1=l2;
            if (turno < 10 && (l1 == 10 || total == 10)) {
                pantalla2();//Despues de acabar con la parte lógica se imprimirá esto en el metodo imprimirPantalla
            } else {
                pantalla();
            }

        

    }
   
        public static void logicaPuntuacion2(int turno) {

         int lance1p2 = 0;                //Inicializo cada lance en 0

            int lance2p2 = 0;                //Inicializo cada lance en 0

            System.out.println("Este es su: " + (turno + 1) + " Tiro "+ name2); // Imprime el turno en el que va

            
            do {
                System.out.println("Ingrese Primer lance");      //Todo lo que se imprima en pantalla en este metodo es temporal, despues se usará el metodo imprimir pantalla
                lance1p2 = sc.nextInt();  //se sobre escribe variable lance1
            } while (lance1p2 > 10);
            if (lance1p2 == 10) {     //Condición cuando el primer lance es 10(Strike)

                countchuzas2++;
                chuza2 += lance1p2;    //Almacena el Strike en la variable chuza

                if (turno == 9 || turno == 10) {
                    turnosplayer2++;
                }
                if (chuza2 > 20 && chuza2 < 100) {
                    chuza2 = 30;
                }
                if (turno < 10) {
                    tiro20 = "x";    //Está variable tiro10 es para usar luego en el metodo imprimirPantalla
                    if (spare2 == 10) {
                        puntuacion2 += 10;
                        spare2 = 0;
                        
                    }
                } else if (turno >= 11) {
                    if (chuza2 == 10) {                //esta condicion es para darle ingreso a la variable chuza

                        chuza2 = chuza2;        //Operación para sumarle a chuza lo hecho en los dos siguientes lances

                        puntuacion2 += chuza2;        //Ahora en la variable puntuacion se le da valor a chuza

                        chuza2 = 0;
                        countchuzas2=0;

                    }
                    if (chuza2 == 20) {
                        chuza2 = chuza2;
                        puntuacion2 += chuza2;
                        chuza2 = 0;
                        countchuzas2=0;
                    }
                    if (chuza2 >= 30) {

                        chuza2 = (countchuzas2 - 2) * chuza2;
                        puntuacion2 += chuza2;
                        chuza2 = 0;
                        countchuzas2=0;
                    }
                    if (spare2 == 10) {
                        puntuacion2 += 10;
                        spare2 = 0;
                    }

                }
            } else if (lance1p2 < 10) { //Si el primer lance no es Strike se sigue el siguiente ciclo
                if (turno < 10) {
                    do {

                        System.out.println("Ingrese Segundo lance");  //Se pide que digite el segundo lance

                        lance2p2 = sc.nextInt();                      //se sobre escribe lance2

                        total2 = lance1p2 + lance2p2;                    //Se sobreescribe la variable total con la suma de los dos lances

                        if (total2 <= 10) {                        //esta condicion es para evaluar si es posible el valor total es decir que sea menor que 10, si es 10 es un Spare

                            if (chuza2 == 10) {                //esta condicion es para darle ingreso a la variable chuza

                                chuza2 = chuza2 + total2;        //Operación para sumarle a chuza lo hecho en los dos siguientes lances

                                puntuacion2 += chuza2;        //Ahora en la variable puntuacion se le da valor a chuza
                                
                                chuza2 = 0;
                                countchuzas2 = 0;

                            }
                            if (chuza2 == 20) {
                                chuza2 = chuza2 + lance1p2 + chuza2 - (10 - total2);
                                puntuacion2 += chuza2;
                                chuza2 = 0;
                                countchuzas2 = 0;
                            }
                            if (chuza2 >= 30) {
                                int turn = countchuzas2 - 2;
                                chuza2 = turn * chuza2 + (chuza2 - 10) + lance1p2 + chuza2 - 20 + total2;;
                                puntuacion2 += chuza2;
                                chuza2 = 0;
                                countchuzas2 = 0;
                            }
                            if (turno == 9) {
                                if (total2 == 10) {
                                    turnosplayer2++;
                                }
                            }
                            if (spare2 == 10) {
                                puntuacion2 += lance1p2;
                                spare2 = 0;
                            }
                            if (total2 == 10) {
                                spare2 = 10;
                                tiro20 = "/";
                            }

                        }

                    } while (total2 > 10); //Esta condicion en el ciclo es para que no digiten valores mayores que 10 ya que 10 es el máximo de bolos

                    puntuacion2 += total2;    //Se le suma a la variable puntuacion el total del turno
                    

                } else if (turno == 10 || turno == 11) {
                    if (spare2 == 10) {
                        puntuacion2 += lance1p2;
                        spare2 = 0;
                    }
                    if (chuza2 == 10) {                //esta condicion es para darle ingreso a la variable chuza

                        chuza2 = chuza2 + total2;        //Operación para sumarle a chuza lo hecho en los dos siguientes lances

                        puntuacion2 += chuza2;        //Ahora en la variable puntuacion se le da valor a chuza

                        chuza2 = 0;
                        countchuzas2=0;
                    }
                    if (chuza2 == 20) {
                        chuza2 = chuza2 + lance1p2 + chuza2 - (10 - total2);
                        puntuacion2 += chuza2;
                        chuza2 = 0;
                        countchuzas2=0;
                    }
                    if (chuza2 >= 30) {
                        int turn = turno - 2;
                        chuza2 = turn * chuza2 + (chuza2 - 10) + lance1p2 + chuza2 - 20 + total2;;
                        puntuacion2 += chuza2;
                        chuza2 = 0;
                        countchuzas2=0;
                    }

                }
            }
            lanza2player1=lance1p2;
            lanza2player2=lance2p2;
            if (turno < 10 && (lance1p2 == 10 || total2 == 10)) {
                pantalla2();//Despues de acabar con la parte lógica se imprimirá esto en el metodo imprimirPantalla
            } else {
                pantalla();
            }

        

    }

    public static void main(String[] args) {

        System.out.println("Bienvenidos a bolos");

        System.out.println("Por favor ingrese los nombres: ");

        name1 = sc.next();

        name2 = sc.next();

        for (int turno = 0; turno < 10; turno++) {
        
         logicaPuntuacion(turno);
         logicaPuntuacion2(turno);
         if(turno==9){
             turno++;
             for (int turno2=turno ; turno2 < turnos; turno2++) {
                 logicaPuntuacion(turno2);
             }
             turno--;
         }
         if(turno==9){
             turno++;
             for (int turno2=turno ; turno2 < turnosplayer2; turno2++) {
                 logicaPuntuacion2(turno2);
             }
         }
        }
        System.out.println("Gracias por jugar ");
        if(puntuacion>puntuacion2){
            System.out.println("EL GANADOR ES: "+ name1);
        }else if(puntuacion2>puntuacion){
            System.out.println("EL GANADOR ES: "+ name2);
        }else 
            System.out.println("EL RESULTADO ES EMPATE");
 
        

    }

}

