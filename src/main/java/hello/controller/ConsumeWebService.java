package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

@RestController
public class ConsumeWebService {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hello")
    public String getProductList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> result = restTemplate.exchange("http://basil-hello-world.us-e2.cloudhub.io/hello", HttpMethod.GET, entity, String.class);
        return result.toString();
    }
}
