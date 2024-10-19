package praktikum.user;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;


public class CreateUserTest {

    private UserChecks checks = new UserChecks();
    private UserClient client = new UserClient();

    String accessToken;

    @After
    public void deleteUser() {
        if (accessToken != null) {
            ValidatableResponse deleteResponse = client.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Создание уникального пользователя")
    public void uniqueUser() {
        // сгенерировали уникального пользователя
        var user = User.random();
        // создали уникального пользователя
        ValidatableResponse createResponse = client.createUser(user);
        // Передали accessToken, проверили статус-код и тело ответа
        accessToken = checks.checkCreateUser(createResponse);
    }



}
