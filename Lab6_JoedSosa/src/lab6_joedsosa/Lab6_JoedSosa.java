/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6_joedsosa;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author joeds
 */
public class Lab6_JoedSosa {

    static Scanner sc = new Scanner(System.in);
    static int acumPremios = 0;
    static int acumAños = 0;
    static int[] casillasAzules = {4, 10, 13, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 52, 55, 61};
    static int[] casillaRojas = {3, 5, 7, 17, 21, 23, 33, 35, 34, 39, 49, 51, 53};

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        Scanner stc = new Scanner(System.in);
        String resp = "";
        do {
            System.out.println("1) Juego de Azar");
            System.out.println("2) Piedra Papel o Tijeras");
            System.out.println("3) Blink");
            int opciones = sc.nextInt();
            switch (opciones) {

                case 1: {
                    // Pecirle al usuario que tire el dado
                    // dado es igual a 6 oportunidades, random de 6
                    // jugar sabiendo que en las posiciones existen varios "slots" en la matriz donde existe premio o castigo
                    // seguir jugando hasta terminar la matriz? Posible?
                    // sumar dinero y castigos al final de la matriz 
                    // 
                    System.out.println("Bienvenido al Ejercicio practico 1 – El juego de la vida :D");
                    System.out.println("Que tenga toda la suerte del mundo!");
                    int posJugador = 1;
                    do {
                        imprimirTablero(new String[8][8], posJugador);
                        Scanner sc1 = new Scanner(System.in);
                        System.out.println("Ingrese enter para girar el dado");
                        String enterkey = sc1.nextLine();
                        if (enterkey.isEmpty()) {
                            Random rnd = new Random();
                            int numDado = (int) (rnd.nextInt(6) + 1);
                            posJugador += numDado;
                            if (posJugador < 64) {
                                System.out.println("el dato ha caido en " + numDado);
                            }
                            boolean premioAzul = tienePremio(posJugador, casillasAzules);
                            if (premioAzul) {
                                acumPremios += 125000;
                                System.out.println("Gano L. 125,000");
                            }
                            boolean premioRojo = tienePremio(posJugador, casillaRojas);
                            if (premioRojo) {
                                System.out.println("Ha envejecido 5 años");
                                acumAños += 5;
                            }

                        }

                    } while (posJugador < 64);
                    System.out.println("Felicitaciones ha terminado el juego");
                    System.out.println("Ha acumulado L. " + acumPremios);
                    System.out.println("Ha envejecido " + acumAños + " años");
                

               
                

                break;
            
        
            }
          case 2: // llamar metodo
                {

                    System.out.println("Bienvenido Ejercicio practico 2 – Pierda, papel o ...");
                    System.out.println("Que tenga toda la suerte del mundo!");
                    Scanner sc2 = new Scanner(System.in);
                    String[] jugadas = {"Rock", "Scissors", "Paper", "Lizard", "Spock"};
                    System.out.println("Juego Piedra, Papel o....");
                    Description ();
                    for (int i = 0; i < jugadas.length; i++) {
                        System.out.println((i + 1) + " " + jugadas[i]);
                    }
                    System.out.println("Elija Opcion:");
                    int eleccionJugador = sc2.nextInt();
                    if (true) {
                        int eleccionMaquina = (int) (Math.random() * ((1 - 5) + 1)) + 5;
                        System.out.println("Ha elegido :" + jugadas[eleccionJugador - 1]);
                        System.out.println("La maquina eligio :" + jugadas[eleccionMaquina - 1]);
                        String mensajeGanador = evaluateGame(jugadas[eleccionJugador - 1], jugadas[eleccionMaquina - 1], jugadas);
                        System.out.println(mensajeGanador);
                    } else {
                        System.out.println("Opcion no valida");
                    }
                    break;

                }
                case 3: {
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Bienvenido a Ejercicio practico 3 – Blink-182");
                    System.out.println("Ingrese el numero de filas");
                    int filas = sc.nextInt();
                    System.out.println("Ingrese el numero de columnas");
                    int col = sc.nextInt();
                    if (filas != 0 && col != 0) {
                        int[][] matrizAProcesar = getMatriz(filas, col);
                        // imprimo la matriz 
                        System.out.println("Imprimiendo Matriz con numeros");

                        for (int k = 0; k < matrizAProcesar.length; k++) {
                            System.out.println();
                            for (int l = 0; l < matrizAProcesar[k].length; l++) {
                                System.out.print(((matrizAProcesar[k][l] < 100) ? "0" + matrizAProcesar[k][l] : "" + matrizAProcesar[k][l]) + " - ");

                            }
                        }

                        System.out.println("\n\nImprimiendo Matriz con letras");
                        cambiarMatriz(matrizAProcesar);
                        System.out.println("\n");
                    } else {
                        System.out.println("Ingrese un valor valido para filas y columnas");
                    }

                }

                break;
            }

            System.out.println("Desea continuar S para continuar, cualquier otra tecla para salir!");
        resp = stc.nextLine();

    }

    while ("s".equalsIgnoreCase(resp)

|| "S".equalsIgnoreCase(resp));

    }

    public static void Description() {
        System.out.println("Scissors cuts paper, paper covers rock, rock crushes lizard, lizard poisons Spock, Spock smashes\n"
                + "scissors, scissors decapitates lizard, lizard eats paper, paper disproves Spock, Spock vaporizes rock,\n"
                + "and as it always has, rock crushes scissors.");
    }

    public static void cambiarMatriz(int[][] matriz) {
        for (int k = 0; k < matriz.length; k++) {
            System.out.println();
            for (int l = 0; l < matriz[k].length; l++) {
                char hola = (char) matriz[k][l];
                System.out.print(hola + " - ");
            }
        }
    }

    public static int[][] getMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int) (Math.random() * ((97 - 122) + 1)) + 122;
            }
        }
        return matriz;
    }

     public static boolean tienePremio(int pos,int[] premios) {
        boolean premio=false;
        for (int i = 0; i < premios.length; i++) {
            if(pos==premios[i]){
                premio=true;
            }
        }
        return premio;
    }
    
    public static void imprimirTablero(String[][] tablero, int posJugador) {
        int contPos=0;
        for (int k = 0; k < tablero.length; k++) {
            System.out.println();
            for (int l = 0; l < tablero[k].length; l++) {
                contPos++;
                if(contPos==posJugador){
                    System.out.print("P");
                }else{
                    System.out.print("-");
                }
                
            }
        }
        System.out.print("\n");
}


    public static String evaluateGame(String eleccionJugador, String eleccionMaquina, String[] jugadas) {
        String ganador = "¡la maquina Gana!";
        if (("Rock".equalsIgnoreCase(eleccionJugador) && ("lizard".equalsIgnoreCase(eleccionMaquina) || "scissors".equalsIgnoreCase(eleccionMaquina))) || ("Scissors".equalsIgnoreCase(eleccionJugador) && ("Paper".equalsIgnoreCase(eleccionMaquina) || "Lizard".equalsIgnoreCase(eleccionMaquina))) || ("Paper".equalsIgnoreCase(eleccionJugador) && ("Rock".equalsIgnoreCase(eleccionMaquina) || "Spock".equalsIgnoreCase(eleccionMaquina))) || ("Lizard ".equalsIgnoreCase(eleccionJugador) && ("Spock".equalsIgnoreCase(eleccionMaquina) || "Paper".equalsIgnoreCase(eleccionMaquina))) || ("Spock ".equalsIgnoreCase(eleccionJugador) && ("Scissors".equalsIgnoreCase(eleccionMaquina) || "Rock".equalsIgnoreCase(eleccionMaquina)))) {
            ganador = "¡Jugador Gana!";
        } if(eleccionJugador.equals(eleccionMaquina)){
            ganador = "No hay ganador, Empate!";
        }
        return ganador;
    

    }
    
}
