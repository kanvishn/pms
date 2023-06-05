package com.xinthe.pms.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.xinthe.pms.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import org.springframework.cloud.netflix.hystrix.HystrixProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class GenericController<T, ID> {

    @Autowired
    private final GenericService<T, ID> service;

    public GenericController(GenericService<T, ID> service) {
        this.service = service;
    }

    @GetMapping("/objects")
    @ApiOperation("Get all objects")
    public List<T> getAllObjects() {
        return service.getAll();
    }

    @GetMapping("/objects/{id}")
    @ApiOperation("Get object by ID")
    public T getObjectById(@PathVariable ID id) {
        return service.getById(id);
    }

    @PostMapping("/objects")
    @ApiOperation("Create object")
    public T createObject(@RequestBody T object) {
        return service.create(object);
    }

    @PutMapping("/objects/{id}")
    @ApiOperation("Update object")
    public T updateObject(@PathVariable ID id, @RequestBody T object) {
        return service.update(id, object);
    }

    @DeleteMapping("/objects/{id}")
    @ApiOperation("Delete object")
    public ResponseEntity<String> deleteObject(@PathVariable ID id) {
        service.delete(id);
        return ResponseEntity.ok("Object deleted successfully");
    }


    // Hystrix fallback method
    public String defaultFallbackMethod() {
        return "Request failed. Please try again later.";
    }
}
