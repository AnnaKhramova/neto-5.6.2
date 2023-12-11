package ru.akhramova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MainTest {

    @Test
    void listToJson() {
        //given
        List<Employee> list = new ArrayList<>(
                Arrays.asList(
                        new Employee(1L, "John", "Smith", "USA", 25),
                        new Employee(2L, "Ivan", "Petrov", "RU", 23)
                )
        );
        String expected = "[{\"id\":1,\"firstName\":\"John\",\"lastName\":\"Smith\",\"country\":\"USA\",\"age\":25},{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Petrov\",\"country\":\"RU\",\"age\":23}]";
        //when
        String actual = Main.listToJson(list);
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void readString() {
        //given
        String fileName = "new_data.json";
        String expected = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Inav\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
        //when
        String actual = Main.readString(fileName);
        //then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void jsonToList() {
        //given
        String json = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Ivan\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
        //when
        List<Employee> actual = Main.jsonToList(json);
        //then
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(actual.size(), 2);
        Assertions.assertEquals(actual.get(0).age, 25);
        Assertions.assertEquals(actual.get(1).firstName, "Ivan");
    }
}