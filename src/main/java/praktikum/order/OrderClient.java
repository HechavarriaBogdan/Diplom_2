package praktikum.order;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import praktikum.Credentials;

import java.util.ArrayList;
import java.util.List;

import static io.qameta.allure.model.Parameter.Mode.HIDDEN;

public class OrderClient extends Credentials {

    @Step("Создание заказа с авторизацией")
    public ValidatableResponse createOrderWithAuth(@Param(mode = HIDDEN) String accessToken) {
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

    @Step("Создание заказа без авторизации")
    public ValidatableResponse createOrderWithoutAuth() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("61c0c5a71d1f82001bdaaa6e");
        ingredients.add("61c0c5a71d1f82001bdaaa73");
        ingredients.add("61c0c5a71d1f82001bdaaa6d");
        IngredientList ingredientList = new IngredientList(ingredients);
        return spec()
                .body(ingredientList)
                .when()
                .post("/orders")
                .then().log().all();
    }

}
