package app;

import java.util.Scanner;
import app.abstractclass.*;

public class App{
    
    public static double arrondi(double A, int B) {
        return (double) ( (int) (A * Math.pow(10, B) + .5)) / Math.pow(10, B);
    }

    public static void main(String[] args){

        // Lire une entrée utilisateur
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Saisi ton nom");
        String str = sc.nextLine();
        System.out.println("Voilà ce que tu as saisi : " + str);
        sc.close();*/
        
        /**
         * Cas particulier où nextLine réinitialise la ligne de saisie et ne nous permet pas de faire de saisie 
         */
        /* Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez un entier : ");
        int i = sc.nextInt();
        System.out.println("Saisissez une chaîne : ");

        //On vide la ligne avant d'en lire une autre
        sc.nextLine(); // Hack permettant de corriger la nom prise en charge de saisie par nextLine

        String str = sc.nextLine();      
        System.out.println("FIN ! " + str);
        sc.close();
        */

        /**
         * TP conversion Celsius/Fahrenheit
         */
        /*System.out.println("CONVERTISSEUR DEGRES CELIUS ET DEGRES FARHRENHEIT");
        System.out.println("-------------------------------------------------");
        
        char reponse = ' ';
        Scanner sc = new Scanner(System.in);
        double result;
        do{
            System.out.println("Choisissez le mode de conversion :");
            System.out.println("1 - Convertisseur Celsius - Fahrenheit");
            System.out.println("2 - Convertisseur Fahrenheit - Celsius");
            int mode = sc.nextInt();
            System.out.println("Température à convertir : ");
            sc.nextLine();
            double temp = sc.nextDouble();
            switch(mode){
                case 1: 
                    result = arrondi(((9.0/5.0)*temp+32), 1);
                    System.out.println(arrondi(temp, 1) + " °C correspond à : " + result + " °F.");
                    break;
                case 2:
                    result = arrondi((((temp-32)*5.0)/9.0), 1);
                    System.out.println(arrondi(temp, 1) + " °F correspond à : " + result + " °C.");
                    break;
                default:
                    System.out.println("C'est pas sérieux");
            }
            do{
                System.out.println("Souhaitez-vous convertir une autre température? (O/N)");
                sc.nextLine();
                reponse = sc.nextLine().charAt(0);
            } while (reponse != 'O' && reponse != 'N');
        } while(reponse == 'O');
        System.out.println("Au revoir !");
        sc.close();*/

        /**
         * Création d'une ville
         */
        //Ville ville = new Ville();

        /** --------------------------------------------------------------------------------------
         *                                  HERITAGE
         * ---------------------------------------------------------------------------------------
         */

         // -------------------------------- Polymorphisme
        //Définition d'un tableau de villes null
        Ville[] tableau = new Ville[6];
                
        //Définition d'un tableau de noms de villes et un autre de nombres d'habitants
        String[] tab = {"Marseille", "lille", "caen", "lyon", "paris", "nantes"};
        int[] tab2 = {123456, 78456, 654987, 75832165, 1594, 213};
                
        //Les trois premiers éléments du tableau seront des villes,
        //et le reste, des capitales
        for(int i = 0; i < 6; i++){
        if (i <3){
            Ville V = new Ville(tab[i], "france", tab2[i]);
            tableau[i] = V;
        }
                
        else{
            Capitale C = new Capitale(tab[i], tab2[i], "france", "la tour Eiffel");
            tableau[i] = C;
        }
        }
                        
        //Il ne nous reste plus qu'à décrire tout notre tableau !
        for(Ville V : tableau){
            System.out.println(V.decrisToi()+"\n");
            //Avec redéfinition de la classe toString (Résultat identique à la ligne précédente)
            System.out.println(V.toString()+"\n");
        }

         /** --------------------------------------------------------------------------------------
         *                                  CLASSES ABSTRAITES ET INTERFACES
         * ---------------------------------------------------------------------------------------
         */
        
        // -------------------------------- Classes abstraites

         Loup l = new Loup("Gris bleuté", 20);
        l.boire(); // Appel de la méthode implémentée dans la classe Animal
        l.manger(); // Appel de la méthode implémentée dans la classe Animal
        l.deplacement(); // Appel de la méthode implémentée dans la classe Canin
        l.crier(); // Appel de la méthode implémentée dans la classe Loup
        System.out.println(l.toString()); // Appel de la méthode implémentée dans la classe Animal

        // -------------------------------- Interfaces

        //Les méthodes d'un chien 
        Chien c = new Chien("Gris bleuté", 20);
        c.boire();
        c.manger();
        c.deplacement();
        c.crier();
        System.out.println(c.toString());
                
        System.out.println("--------------------------------------------");
        //Les méthodes de l'interface
        c.faireCalin();
        c.faireLeBeau();
        c.faireLechouille();
            
        System.out.println("--------------------------------------------");
        //Utilisons le polymorphisme de notre interface
        Rintintin r = new Chien();
        r.faireLeBeau();
        r.faireCalin();
        r.faireLechouille();
    }
}