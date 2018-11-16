package ajedrez;

import java.util.Scanner;

public class AJEDREZ {
public static String[][] tablero = new String[8][8]; // Defino Matriz String para todo el codigo, con nombre tablero
/**
* Recibe un Scanner
*
* @param Scanner es la matriz a imprimir
*/
public static String[][] AgregarPosicion(Scanner sc) {
boolean validez=true;
do{
System.out.println("Digite ficha posFil posCol");
System.out.println("Ejemplo:RN 3 4");
//Lee una cadena
String fichaAagregar = sc.nextLine();
// Parte la cadena en espacios
String[] arrStrings = fichaAagregar.split(" ");
// Procesar la cadena
String ficha = arrStrings[0];
int posF = Integer.parseInt(arrStrings[1]);
int posC = Integer.parseInt(arrStrings[2]);
System.out.println("Ficha " + ficha + " agregada en");
System.out.println("Fila " + posF);
System.out.println("Col " + posC);
//Crear el tablero 
tablero[posF][posC] = ficha;
validez=fichas(ficha);
}while(validez==false);
return tablero;
}
public static boolean fichas(String ficha ){
boolean validezFicha=true; 
String RN="RN";
String RB="RB";
String DN="DN";
String DB="DB";
String TN="TN";
String TB="TB";
String AN="AN";
String AB="AB";
String CN="CN";
String CB="CB";
String PN="PN";
String PB="PB";
 
if(!ficha.equalsIgnoreCase(RN)){
if(!ficha.equalsIgnoreCase(RB)){
if(!ficha.equalsIgnoreCase(DN)){
if(!ficha.equalsIgnoreCase(DB)){
if(!ficha.equalsIgnoreCase(TN)){
if(!ficha.equalsIgnoreCase(TB)){
if(!ficha.equalsIgnoreCase(AN)){
if(!ficha.equalsIgnoreCase(AB)){
if(!ficha.equalsIgnoreCase(CN)){
if(!ficha.equalsIgnoreCase(CB)){
if(!ficha.equalsIgnoreCase(PN)){
if(!ficha.equalsIgnoreCase(PB)){
validezFicha=false;
}
}
}
}
 
}
 
}
 
}
}
}
}
}
 
}
return validezFicha;
}
 
 
 
 
public static void Jaques(){
 
 
}
/**
* Recibe una matriz y imprime el tablero en pantalla
*
* @param tablero es la matriz a imprimir
*/
public static void imprimirTablero() {
for (int fil = 0; fil < 8; fil++) {
for (int col = 0; col < 8; col++) {
System.out.print(tablero[fil][col] + " ");
}
System.out.println("");
}
}
 
/**
* Recibe un entero y retorna una opcion en el menu
*
* @param opcion es la cadena a invertir
*/
public static int Menu(Scanner sc, int opcion) {
do {
System.out.println("Bienvenido al comprobador de Jaques.\nSeleccione una opción\n1) Agregar Posición\n2) Mostrar Tablero\n3) Comprobar Jaques\n4) Salir"); //Imprime el menu
opcion = Integer.parseInt(sc.nextLine()); //Leeopcion
switch (opcion) { //Parte lógica, selecciona opcion y lo dirige al metodo
case 1:
AgregarPosicion(sc);
 
break;
case 2:
imprimirTablero();
break;
case 3:
 
break;
case 4:
break;
}
} while (opcion > 4 || opcion <= 0);
return opcion;
}

/**
* @param args the command line arguments
*/
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
boolean salir=false;
int opcion = 0;
while(salir==false){
Menu(sc, opcion);
if(Menu(sc, opcion)==4){
salir=true;
}
 
}
}
}
