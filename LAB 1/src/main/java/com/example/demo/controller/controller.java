package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resource")
public class controller {

    // GET method with some simple logic
    @GetMapping("/{id}")
    public String getResource(@PathVariable int id) {
        return "GET: Returning resource with ID " + id;
    }

    @PostMapping
    public String createResource() {
        return "POST: Resource created";
    }

    @PutMapping("/{id}")
    public String updateResource(@PathVariable String id) {
        return "PUT: Resource with ID " + id + " updated";
    }

    // DELETE method with logic to simulate resource deletion
    @DeleteMapping("/{id}")
    public String deleteResource(@PathVariable int id) {
        return "DELETE: Resource with ID " + id + " deleted";
    }
}
