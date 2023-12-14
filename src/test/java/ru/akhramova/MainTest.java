package ru.akhramova;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.Matchers.instanceOf;

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
        assertThat(expected, equalTo(actual));
    }

    @Test
    void readString() {
        //given
        String fileName = "new_data.json";
        String expected = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Inav\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
        //when
        String actual = Main.readString(fileName);
        //then
        assertThat(expected, equalTo(actual));
    }

    @Test
    void jsonToList() {
        //given
        String json = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Ivan\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
        //when
        List<Employee> actual = Main.jsonToList(json);
        //then
        assertThat(actual, is(not(nullValue())));
        assertThat(actual, is(not(empty())));
        assertThat(actual.size(), equalTo(2));
        assertThat(actual.get(0).getAge(), equalTo(25));
        assertThat(actual.get(1).getFirstName(), equalTo("Ivan"));
    }

    @Test
    void hasPropertyTest() {
        //given
        String json = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Ivan\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
        //when
        List<Employee> actual = Main.jsonToList(json);
        Employee employee = actual.get(0);
        //then
        assertThat(employee, hasProperty("lastName", equalTo("Smith")));
    }

    @Test
    void countryTest() {
        //given
        String json = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Ivan\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
        //when
        List<Employee> actual = Main.jsonToList(json);
        //then
        assertThat(actual.get(0).getCountry(), is(instanceOf(String.class)));
        assertThat(actual.get(1).getCountry(), is(instanceOf(String.class)));
    }

    @Test
    void lastNameTest() {
        //given
        String json = "[  {    \"id\": 1,    \"firstName\": \"John\",    \"lastName\": \"Smith\",    \"country\": \"USA\",    \"age\": 25  },  {    \"id\": 2,    \"firstName\": \"Ivan\",    \"lastName\": \"Petrov\",    \"country\": \"RU\",    \"age\": 23  }]";
        //when
        List<Employee> actual = Main.jsonToList(json);
        //then
        assertThat(actual.get(0).getLastName(), is(instanceOf(String.class)));
        assertThat(actual.get(1).getLastName(), is(instanceOf(String.class)));
    }

}