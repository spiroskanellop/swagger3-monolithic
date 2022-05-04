package com.example.swagger3.controller;

import com.example.swagger3.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Tag(name="User")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    @Operation(summary = "Get User", responses = {
            @ApiResponse(description = "Get User Success", responseCode = "200",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
            @ApiResponse(description = "User not found", responseCode = "400", content = @Content)
    })
    public ResponseEntity<User> getUser(String id){
        if("1".equals(id)){
            User user = new User();
            user.setId("1");
            user.setName("Test");
            return ResponseEntity.ok(user);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not Found");
        }
    }
}
