import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.bur.domain.AppUser;

/**
 * Created by Sasha on 24.11.2018.
 */

@SpringBootTest
public class AppUserControllerTest {

    @Test
    public void getTest() { //работает
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/appUsers";
        HttpEntity httpEntity = new HttpEntity("");
        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println(rs);
    }

    @Test
    public void postTest() { //работает
        AppUser appUser = new AppUser();
        appUser.setPhoneNumber("77710");
        appUser.setAuthorizationToken("auth77710");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/appUsers";
        HttpEntity<AppUser> httpEntity = new HttpEntity(appUser);
        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(rs);
    }

    @Test
    public void putTest() {
        AppUser appUser = new AppUser();
        appUser.setPhoneNumber("777109");
        appUser.setAuthorizationToken("auth777109");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/appUsers/1";
        HttpEntity<AppUser> httpEntity = new HttpEntity(appUser);
        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(rs);
    }


    @Test
    public void deleteTest() {
     /*   RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/appUsers";
        HttpEntity<AppUser> httpEntity = new HttpEntity(appUser);
        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(rs);
        */
    }

}