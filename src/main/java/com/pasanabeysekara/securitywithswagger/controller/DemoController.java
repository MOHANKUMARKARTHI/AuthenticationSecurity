package com.pasanabeysekara.securitywithswagger.controller;

import com.pasanabeysekara.securitywithswagger.entity.meta.User;
import com.pasanabeysekara.securitywithswagger.service.DemoService;
import com.pasanabeysekara.securitywithswagger.util.StandardResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/demo-controller")
@Tag(name = "Demo", description = "Demo management APIs")
public class DemoController {
    
    @Autowired
    DemoService demoService;

    @Operation(
            summary = "Testing endpoint",
            description = "Testing endpoint for secured API calls",
            tags = { "demo", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "403", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/demo")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity(new StandardResponse("200", "Done", "Hello from secured endpoint"), HttpStatus.OK);
    }


    @GetMapping("/listOfRegisteredUsers")
    public ResponseEntity<String> listOfRegisteredUsers(@RequestParam("page") int page, @RequestParam("size") int size) {

        List<User> users = demoService.listOfRegisteredUsers(page, size);

        return new ResponseEntity(new StandardResponse("200", "Fetched Registered Users",users ), HttpStatus.OK);
    }

}
