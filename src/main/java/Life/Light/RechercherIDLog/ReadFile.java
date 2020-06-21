package Life.Light.RechercherIDLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public List<String> readToURLs(File fichier) {
        List<String> resultat = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(fichier);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                resultat.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}
