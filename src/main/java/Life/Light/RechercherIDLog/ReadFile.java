package Life.Light.RechercherIDLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile {
    public List<String> readToURLs(File fichier) {
        List<String> resultat = new ArrayList<>();
        try {
            Scanner myReader = new Scanner(fichier);
            while (myReader.hasNextLine()) {
                resultat.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public List<String> readAllToURLs(List<File> fichiers) {
        List<String> resultat = new ArrayList<>();
        fichiers.forEach(fichier->resultat.addAll(readToURLs(fichier)));
        return resultat;
    }

    public List<String> readDirectoryToURLs(String directory) {

        File file = new File(directory);
        List<File> listFiles = Arrays.asList(Objects.requireNonNull(file.listFiles()));

        return readAllToURLs(listFiles);
    }
}
