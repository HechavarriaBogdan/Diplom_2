package praktikum.user;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;


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

    @Step("Логин пользователя")
    public ValidatableResponse loginUser(UserCredentials user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_URI + "/api/auth/login")
                .then().log().all();
    }

    @Step("Изменяем данные пользователя")
    public ValidatableResponse updateUser(String accessToken, User updateUser) {
        return given()
                .contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .body(updateUser)
                .when()
                .patch(BASE_URI + "/api/auth/user")
                .then().log().all();
    }


    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", accessToken)
                .when()
                .delete(BASE_URI + "/api/auth/user")
                .then().log().all();
    }
}
