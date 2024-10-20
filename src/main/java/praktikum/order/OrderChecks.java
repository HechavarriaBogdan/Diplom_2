package praktikum.order;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.MatcherAssert;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class OrderChecks {

    @Step("Проверка успешного создания заказа с авторизацией")
    public void checkCreateOrderWithAuth(ValidatableResponse createOrderResponse) {
        createOrderResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .and()
                .body("success", equalTo(true));
        OrderResponse order = createOrderResponse.extract().as(OrderResponse.class);
        MatcherAssert.assertThat(order.getName(),notNullValue());
        MatcherAssert.assertThat(order.getOrder().getIngredients(),notNullValue());
        MatcherAssert.assertThat(order.getOrder().get_id(), notNullValue());
        MatcherAssert.assertThat(order.getOrder().getOwner(), notNullValue());
        MatcherAssert.assertThat(order.getOrder().getStatus(), notNullValue());
        MatcherAssert.assertThat(order.getOrder().getName(), notNullValue());
        MatcherAssert.assertThat(order.getOrder().getCreatedAt(), notNullValue());
        MatcherAssert.assertThat(order.getOrder().getUpdatedAt(), notNullValue());
        MatcherAssert.assertThat(order.getOrder().getNumber(), notNullValue());
        MatcherAssert.assertThat(order.getOrder().getPrice(), notNullValue());
    }

    @Step("Проверка успешного создания заказа без авторизации")
    public void checkCreateOrderWithoutAuth(ValidatableResponse createOrderResponse) {
        createOrderResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .and()
                .body("success", equalTo(true));
        OrderResponse order = createOrderResponse.extract().as(OrderResponse.class);
        MatcherAssert.assertThat(order.getName(), notNullValue());
        MatcherAssert.assertThat(order.getName(), notNullValue());
        MatcherAssert.assertThat(order.getOrder(), notNullValue());
        MatcherAssert.assertThat(order.getOrder().getNumber(), notNullValue());
    }

}
