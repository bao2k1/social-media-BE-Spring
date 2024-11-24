package com.clv.user;

import com.clv.common.dto.ResponseDto;
import com.clv.common.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<ResponseDto> findAllUsers() {
        return ResponseUtil.get(service.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findUserById(@PathVariable("id") int id) {
        return ResponseUtil.get(service.findUserById(id), HttpStatus.OK);
    }
}
