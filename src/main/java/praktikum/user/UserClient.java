package praktikum.user;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserClient extends praktikum.Credentials {

    // Создание пользователя
    @Step("Создание уникального пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URI + "/api/auth/register")
                .then().log().all();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .log().all()
                .when()
                .delete(BASE_URI + "/api/auth/user")
                .then().log().all();
    }
}
