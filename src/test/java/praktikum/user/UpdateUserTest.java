package praktikum.user;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class UpdateUserTest {

    UserClient client = new UserClient();
    UserChecks checks = new UserChecks();

    private String accessToken;

    @After
    public void deleteUser() {
        if (accessToken != null) {
            // Проверяем код и тело ответа после удаления
            ValidatableResponse deleteResponse = client.deleteUser(accessToken);
            checks.checkDeleted(deleteResponse);
        }
    }

    @Test
    @DisplayName("Изменение данных пользователя с авторизацией")
    public void updateUser() {
        var user = User.random();
        var loginUser = UserCredentials.fromUser(user);
        ValidatableResponse createResponse = client.createUser(user);
        checks.checkCreateUser(createResponse);
        ValidatableResponse loginResponse = client.loginUser(loginUser);
        accessToken = checks.checkSuccessLogin(loginResponse);
        var updateUser = User.random();
        ValidatableResponse updateResponse = client.updateUser(accessToken, updateUser);
        checks.checkSuccessUpdate(updateResponse);
    }

    @Test
    @DisplayName("Изменение данных пользователя без авторизации")
    public void failedUpdateUser() {
        var user = User.random();
        ValidatableResponse createResponse = client.createUser(user);
        accessToken = checks.checkCreateUser(createResponse);
        var updateUser = User.random();
        String nullToken = "";
        ValidatableResponse updateResponse = client.updateUser(nullToken, updateUser);
        checks.checkFailedUpdate(updateResponse);
    }

    @Test
    @DisplayName("Изменение почты на уже использующуюся")
    public void updateUserExistEmail() {

    }
}
