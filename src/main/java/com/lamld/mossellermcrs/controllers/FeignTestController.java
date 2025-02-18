package com.lamld.mossellermcrs.controllers;

import com.lamld.mossellermcrs.factory.thirdPartyApi.ApiClient;
import com.lamld.mossellermcrs.pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign-test")
@RequiredArgsConstructor
public class FeignTestController {

    private final ApiClient apiClient;

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable String id) {
        return apiClient.getUserById(id);
    }

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        return apiClient.createUser(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable String id) {
        return apiClient.deleteUser(id);
    }
}
