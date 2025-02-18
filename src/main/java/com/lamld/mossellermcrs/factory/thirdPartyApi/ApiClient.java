package com.lamld.mossellermcrs.factory.thirdPartyApi;

import com.lamld.mossellermcrs.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "json-placeholder", url = "https://jsonplaceholder.typicode.com")
public interface ApiClient {

    // Lấy thông tin user theo ID
    @GetMapping("/users/{id}")
    String getUserById(@PathVariable("id") String id);

    // Tạo user mới
    @PostMapping("/users")
    String createUser(@RequestBody User user);

    // Xóa user theo ID
    @DeleteMapping("/users/{id}")
    String deleteUser(@PathVariable("id") String id);
}