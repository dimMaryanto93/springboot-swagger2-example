package com.maryanto.dimas.springboot.example.api;

import com.maryanto.dimas.springboot.example.entity.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/person")
@Api(description = "Api untuk person")
public class PersonApi {

    @ApiOperation("Return new person")
    @GetMapping(value = "/aPerson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person getPerson() {
        return new Person(1, "Dimas", "Maryanto");
    }

    @ApiOperation("Return list person")
    @GetMapping(value = "/listPerson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Person> listPerson() {
        return Arrays.asList(
                new Person(1, "Dimas", "Maryanto"),
                new Person(2, "Muhamad", "Yusuf"),
                new Person(2, "Rega", "Rusti"),
                new Person(2, "Haidi", "Gufron")
        );
    }

    @ApiOperation("Save a person")
    @PostMapping(
            value = "/aPerson",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person getPerson(
            @ApiParam(value = "Person information for a new person to be created.", required = true, format = "application/json")
            @RequestBody Person person) {
        return person;
    }
}
