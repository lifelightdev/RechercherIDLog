package Life.Light.RechercherIDLog;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public class Find {
    public int iDIn(String url) {
        MultiValueMap<String, String> parameters = UriComponentsBuilder.fromHttpUrl(url).build().getQueryParams();
        List<String> id = parameters.get("id");
        return Integer.parseInt(id.get(0));
    }
}
