package Life.Light.RechercherIDLog;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

public class Find {
    public int iDIn(String url) {
        MultiValueMap<String, String> parameters = UriComponentsBuilder.fromHttpUrl(url).build().getQueryParams();
        List<String> id = parameters.get("id");
        return Integer.parseInt(id.get(0));
    }

    public List<Integer> iDsIn(List<String> urls) {
        List<Integer> resultat = new ArrayList<>();
        for (String url : urls){
            resultat.add(iDIn(url));
        }
        return resultat;
    }
}
