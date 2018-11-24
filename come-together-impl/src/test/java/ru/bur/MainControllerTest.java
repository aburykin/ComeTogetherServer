package ru.bur;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ru.bur.domain.AppUser;
import ru.bur.dto.AppUserDto;
import ru.bur.dto.AuthDto;
import org.springframework.hateoas.MediaTypes;
import ru.bur.dto.hateoas.LinksDto;

/**
 * Created by Sasha on 24.11.2018.
 */

@SpringBootTest
public class MainControllerTest {

    // это пока еще не работает
    @Test
    public void testHateOasClient() {
// получаю набор возможных действий
        String url = "http://127.0.0.1:8080/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LinksDto> rsLinks = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(null), LinksDto.class); // все заворачивает нормально, но что дальше с этим делать?

        //получить возможные действия с одной из сущностей
        url = rsLinks.getBody().getRelations().getAppUsers().getHref();
        ResponseEntity<LinksDto> rsAppUsers = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity(null), LinksDto.class); // все заворачивает нормально, но что дальше с этим делать?

        System.out.println(rsAppUsers);
    }


    @Test
    public void test_post_with_headers() { // OK
        AppUserDto rqDto = new AppUserDto();
        rqDto.setPhoneNumber("77710");
        rqDto.setAuthorizationToken("auth77710");

        HttpHeaders headers = new HttpHeaders();
      //  headers.setContentType(MediaTypes.HAL_JSON); // добавляю заголовок, видимо он нужен чисто для информации
        HttpEntity<AppUserDto> httpEntity = new HttpEntity(rqDto, headers);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/rest/android/test_post_with_headers";

        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(rs);
    }


    @Test
    public void test_get_dto_return_dto_with_error() { // OK
        AppUserDto rqDto = new AppUserDto();
        rqDto.setPhoneNumber("77710");
        rqDto.setAuthorizationToken("auth77710");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/rest/android/test_get_dto_return_dto_with_error";
        HttpEntity<AppUser> httpEntity = new HttpEntity(rqDto);

        // тут 500 ошибка
        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        // сюда не доходим
        System.out.println(rs);
    }

    @Test
    public void testTest_get_dto_return_dto() { // OK
        AppUserDto rqDto = new AppUserDto();
        rqDto.setPhoneNumber("77710");
        rqDto.setAuthorizationToken("auth77710");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/rest/android/test_get_dto_return_dto";
        HttpEntity<AppUser> httpEntity = new HttpEntity(rqDto);
        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(rs);
    }

    // тут попробуем кинуть другую ДТО.  Все равно какая ДТО, мапит что может.
    @Test
    public void testTest_get_dto_return_dto_another_dto() {
        AuthDto rqDto = new AuthDto();
        rqDto.setPhoneNumber("77710");
        rqDto.setAuthorizationToken("auth77710");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/rest/android/test_get_dto_return_dto";
        HttpEntity<AppUser> httpEntity = new HttpEntity(rqDto);
        ResponseEntity<String> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
        System.out.println(rs);
    }

    @Test
    public void convert_response() {
        AppUserDto rqDto = new AppUserDto();
        rqDto.setPhoneNumber("77710");
        rqDto.setAuthorizationToken("auth77710");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/rest/android/test_get_dto_return_dto";
        HttpEntity<AppUserDto> httpEntity = new HttpEntity(rqDto);

        // все замапил без всяких проблем и json конверторов
        ResponseEntity<AppUserDto> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, AppUserDto.class);
        System.out.println(rs);
    }

    @Test
    public void with_response_entity() {
        AppUserDto rqDto = new AppUserDto();
        rqDto.setPhoneNumber("77710");
        rqDto.setAuthorizationToken("auth77710");

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://127.0.0.1:8080/rest/android/with_response_entity";
        HttpEntity<AppUserDto> httpEntity = new HttpEntity(rqDto);
        // так тоже отлично работает
        ResponseEntity<AppUserDto> rs = restTemplate.exchange(url, HttpMethod.POST, httpEntity, AppUserDto.class);
        System.out.println(rs);
    }


}