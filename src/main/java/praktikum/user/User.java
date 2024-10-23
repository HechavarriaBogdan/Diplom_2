package praktikum.user;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class User {

    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    // Метод генерирует рандомные данные для создания пользователя
    public static User random() {
        Faker faker = new Faker();
        String randomName = faker.name().firstName();
        String email = randomName + RandomStringUtils.randomAlphanumeric(5) + "@mail.com";
        String password = "123456";
        return new User(randomName, email, password);
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
