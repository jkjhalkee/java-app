package com.abhishek;

import com.abhishek.controller.HelloController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloControllerTest {

    @Test
    void helloMessageShouldContainText() {
        HelloController controller = new HelloController();
        var response = controller.sayHello();
        assertThat(response.get("message")).contains("Hello");
    }
}
