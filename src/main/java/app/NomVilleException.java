package app;

public class NomVilleException extends Exception {
    public NomVilleException(String message){
        // Permet d'afficher le message d'erreur en utilisant getMessage() de Exception
        super(message);
    }
}