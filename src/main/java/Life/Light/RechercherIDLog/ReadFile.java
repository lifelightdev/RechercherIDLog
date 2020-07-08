package Life.Light.RechercherIDLog;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<String> readAllToURLs(List<File> fichiers) {
        List<String> resultat = new ArrayList<>();
        fichiers.forEach(fichier->resultat.addAll(readToURLs(fichier)));
        return resultat;
    }

    public List<String> readDirectoryToURLs(String directory) {
        List<String> resultat = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get(directory))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());
            List<File> files = new ArrayList<>();
            for (String fichier : result){
                files.add(new File(fichier));
            }
            resultat.addAll(readAllToURLs(files));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}
