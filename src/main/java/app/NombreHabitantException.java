package app;

public class NombreHabitantException extends Exception {
    public NombreHabitantException() {
        System.out.println("Vous essayez d'instancier une classe Ville avec un nombre d'habitants négatif !");
    }

    // Second constructeur permettant d'avoir plus d'informations sur l'exception
    public NombreHabitantException(int nbre)
    {
        System.out.println("Instanciation avec un nombre d'habitants négatif.");
        System.out.println("\t => " + nbre);
    }
}