package Life.Light.RechercherIDLog;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;

public class Find {
    public int iDIn(String url) {
        MultiValueMap<String, String> parameters = UriComponentsBuilder.fromHttpUrl(url).build().getQueryParams();
        List<String> id = parameters.get("id");
        return Integer.parseInt(id.get(0));
    }

    public List<Integer> iDsIn(List<String> urls) {
        List<Integer> resultat = new ArrayList<>();
        // TODO A revoir avec une lamda
        for (String url : urls){
            resultat.add(iDIn(url));
        }
        return resultat;
    }

    public Integer maxNbIDIn(List<String> urls) {
        Map<Integer, Long> nombreIDInt = iDsIn(urls).stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        Map.Entry<Integer, Long> entryInt = nombreIDInt.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get();
        return entryInt.getKey();
    }

    public List<Integer> cinqMaxNbIDIn(List<String> urls) {
        List<Integer> resultat = new ArrayList<>();
        Map<Integer, Long> nombreIDInt = iDsIn(urls).stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        for (int i = 0; i<5; i++){
            Map.Entry<Integer, Long> entryInt = nombreIDInt.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get();
            resultat.add(entryInt.getKey());
            nombreIDInt.remove(entryInt.getKey());
            if (nombreIDInt.isEmpty()){
                break;
            }
        }
        return resultat;
    }
}
