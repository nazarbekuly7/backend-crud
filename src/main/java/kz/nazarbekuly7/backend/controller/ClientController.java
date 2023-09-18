package kz.nazarbekuly7.backend.controller;

import kz.nazarbekuly7.backend.model.User;
import kz.nazarbekuly7.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ClientController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(
            @RequestParam("file") MultipartFile file,
            @ModelAttribute User user
    ) {
        try {
            if (!file.isEmpty()) {
                user.setUserImage(file.getBytes());
            }
            userService.addUser(user);
            return ResponseEntity.ok("User Added Successfully...");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user data.");
        }
    }


    @GetMapping("/user/image/{id}")
    public ResponseEntity<byte[]> getUserImage(@PathVariable("id") long id) {
        User user = userService.getUserByid(id);
        byte[] image = user.getUserImage();
        // Установка заголовков для передачи изображения
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(image, headers, HttpStatus.OK);
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        System.out.println("Users..");
        return userService.getUser();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserByid(id);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user){
        userService.updateUser(id, user);
        return "User Updated Successfully...";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "User Deleted Successfully...";
    }

}