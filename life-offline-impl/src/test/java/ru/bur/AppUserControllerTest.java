package ru.bur;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
@Ignore
public class AppUserControllerTest {


    @Test
    public void testrest() throws JSONException {

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/appUsers";

        // так работает
     /*   HttpEntity httpEntity = new HttpEntity("");
        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(rs);
*/


     String user = "{\n" +
             "  \"phoneNumber\": \"233\",\n" +
             "  \"authorizationToken\": \"123\",\n" +
             "  \"firstName\": \"\",\n" +
             "  \"lastName\": \"\",\n" +
             "  \"birthdayDate\": null,\n" +
             "  \"age\": 0\n" +
             "}";

        JSONObject jsonUser = new JSONObject(user);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity(user);
        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(rs);

    }


    /*


        Log.d("qwe", "test");
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String result = restTemplate.postForObject(CONNECTION_URL, strings[0], String.class);
    */
}