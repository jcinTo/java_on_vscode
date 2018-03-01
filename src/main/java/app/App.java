package app;

import java.util.*;
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
        try {
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
        } catch (NombreHabitantException nb) {

        } //Gestion de l'exception sur le nom de la ville
        catch(NomVilleException e2){
          System.out.println(e2.getMessage());
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

        /** --------------------------------------------------------------------------------------
         *                                  Exceptions
         * ---------------------------------------------------------------------------------------
         */
        
        // -------------------------------- Exceptions personnalisées
        
        // Ne fonctionne pas car v est local au bloc try et n'existe pas en dehors
        /*try {                   
            Ville v = new Ville("Rennes", "France", 12000);         
        } catch (NombreHabitantException e) {   }   
        
        System.out.println(v.toString());*/

        // correction
        Ville v = null;
        try {                   
            v = new Ville("Rennes", "France", 12000);         
        } catch (NombreHabitantException e) {   }   
        //Gestion de l'exception sur le nom de la ville
        catch(NomVilleException e2){
            System.out.println(e2.getMessage());
        }
        System.out.println(v.toString());

        // correction
        Ville v2 = null;
        try {                   
            v2 = new Ville("Rennes", "France", 12000);         
        } catch (NombreHabitantException e) {   
        }  //Gestion de l'exception sur le nom de la ville
        catch(NomVilleException e2){
          System.out.println(e2.getMessage());
        } finally {
            // Pour éviter que v soit null en cas d'exception NombreHabitantException
            v2 = new Ville();
        }
        
        System.out.println(v.toString());
        
        /** --------------------------------------------------------------------------------------
         *                                  Enumérations
         * ---------------------------------------------------------------------------------------
         */
        
         // Pour montrer utilisation de la méthode values
        for(Langage lang : Langage.values()){
            if(Langage.JAVA.equals(lang))
              System.out.println("J'aime le : " + lang);
            else
              System.out.println(lang);
        }

        /** --------------------------------------------------------------------------------------
         *                                  Collections
         * ---------------------------------------------------------------------------------------
         */
        
        // -------------------------------- LinkedList

        // Pour montrer utilisation de la méthode values
        // Utilisation de l'énumération Langage
        Langage l1 = Langage.JAVA;
        Langage l2 = Langage.PHP;
        
        l1.getEditor();
        l2.getEditor();

        List list = new LinkedList();
        list.add(12);
        list.add("toto ! !");
        list.add(12.20f);
    
        for(int i = 0; i < list.size(); i++)
          System.out.println("Élément à l'index " + i + " = " + list.get(i));
        
        //Avec itérateur
        System.out.println("\n \tParcours avec un itérateur ");
        System.out.println("-----------------------------------");
        ListIterator li = list.listIterator();

        while(li.hasNext())
            System.out.println(li.next());

        // -------------------------------- ArrayList
        ArrayList al = new ArrayList();
        al.add(12);
        al.add("Une chaîne de caractères !");
        al.add(12.20f);
        al.add('d');
                        
        for(int i = 0; i < al.size(); i++)
        {
            System.out.println("donnée à l'indice " + i + " = " + al.get(i));
        }
        
        // -------------------------------- HashTable
        Hashtable ht = new Hashtable();
        ht.put(1, "printemps");
        ht.put(10, "été");
        ht.put(12, "automne");
        ht.put(45, "hiver");

        Enumeration e = ht.elements();

        while(e.hasMoreElements())
            System.out.println(e.nextElement());

        // -------------------------------- HashSet
        HashSet hs = new HashSet();
        hs.add("toto");
        hs.add(12);
        hs.add('d');

        Iterator it = hs.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    
        System.out.println("\nParcours avec un tableau d'objet");
        System.out.println("-----------------------------------");
                    
        Object[] obj = hs.toArray();
        for(Object o : obj)
            System.out.println(o);  

        
        /** --------------------------------------------------------------------------------------
         *                                  Genericity
         * ---------------------------------------------------------------------------------------
         */

        // -------------------------------- Principe de base
        Solo<Integer> val = new Solo<Integer>(12);
        int nbre = val.getValeur();      
        
        // Lignes suivantes ne fonctionnent pas 
        Solo<Integer> val = new Solo<Integer>("toto"); 
        //Ici, on essaie de mettre une chaîne de caractères à la place d'un entier
        int nbre = val.getValeur();  

        Solo<Integer> val = new Solo<Integer>(12);
        val.setValeur(12.2f);   
        //Ici, on essaie de mettre un nombre à virgule flottante à la place d'un entier

        Duo<String, Boolean> dual = new Duo<String, Boolean>("toto", true);
        System.out.println("Valeur de l'objet dual : val1 = " + dual.getValeur1() + ", val2 = " + dual.getValeur2());

        Duo<Double, Character> dual2 = new Duo<Double, Character>(12.2585, 'C');
        System.out.println("Valeur de l'objet dual2 : val1 = " + dual2.getValeur1() + ", val2 = " + dual2.getValeur2()); 

        // Ce code ne fonctionne pas, lorsque l'on déclare une variable d'une certaine référence, on ne peut plus la changer en un autre type
        Duo<String, Boolean> dual = new Duo<String, Boolean>("toto", true);
        System.out.println("Valeur de l'objet dual: val1 = " + dual.getValeur1() + ", val2 = " + dual.getValeur2());
        dual = new Duo<Double, Character>();

        // -------------------------------- Généricité et collections

        System.out.println("Liste de String");
        System.out.println("------------------------------");
        List<String> listeString= new ArrayList<String>();
        listeString.add("Une chaîne");
        listeString.add("Une autre");
        listeString.add("Encore une autre");
        listeString.add("Allez, une dernière");

        for(String str : listeString)
            System.out.println(str);

        System.out.println("\nListe de float");
        System.out.println("------------------------------");
                        
        List<Float> listeFloat = new ArrayList<Float>();
        listeFloat.add(12.25f);
        listeFloat.add(15.25f);
        listeFloat.add(2.25f);
        listeFloat.add(128764.25f);
                        
        for(float f : listeFloat)
            System.out.println(f);
    }
}