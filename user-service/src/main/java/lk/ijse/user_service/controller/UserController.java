package lk.ijse.user_service.controller;

import lk.ijse.user_service.dto.UserDto;
import lk.ijse.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/health")
    public String healthCheck(){
        return "User HealthCheck success";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return "User created successfully";
    }

    @PostMapping("/checkCredentials")
    public ResponseEntity<?> checkCredentials(@RequestBody UserDto userDto) {
        if (userService.checkCredentials(userDto)) {
            return ResponseEntity.ok("User exists");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist");
        }
    }

    @GetMapping("/existUser/{userId}")
    public ResponseEntity<?> existUser(@PathVariable String userId) {
        if (userService.isExistsUser(userId)){
            return ResponseEntity.ok("User exists");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist");
        }
    }

    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody UserDto userDTO) {
        userService.createUser(userDTO);
        return ResponseEntity.ok("User updated successfully");
    }
}
