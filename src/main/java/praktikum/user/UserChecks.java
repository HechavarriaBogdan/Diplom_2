package praktikum.user;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.MatcherAssert;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;



public class UserChecks {


    @Step("Получение accessToken, проверка статус-кода и тела ответа")
    public String checkCreateUser(ValidatableResponse createResponse) {
        createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .and()
                .body("success", equalTo(true));
        UserResponse user = createResponse.extract().as(UserResponse.class);
        MatcherAssert.assertThat(user.getUser(), notNullValue());
        MatcherAssert.assertThat(user.getAccessToken(), notNullValue());
        MatcherAssert.assertThat(user.getRefreshToken(), notNullValue());
        return user.getAccessToken();
    }
}
