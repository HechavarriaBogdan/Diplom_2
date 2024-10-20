package praktikum.order;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import praktikum.Credentials;

import java.util.ArrayList;
import java.util.List;

public class OrderClient extends Credentials {

    @Step("Создание заказа с авторизацией")
    public ValidatableResponse createOrder(String accessToken) {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("61c0c5a71d1f82001bdaaa6e");
        ingredients.add("61c0c5a71d1f82001bdaaa73");
        ingredients.add("61c0c5a71d1f82001bdaaa6d");
        IngredientList ingredientList = new IngredientList(ingredients);
        return spec()
                .header("Authorization", accessToken)
                .body(ingredientList)
                .when()
                .post("/orders")
                .then().log().all();
    }

}
