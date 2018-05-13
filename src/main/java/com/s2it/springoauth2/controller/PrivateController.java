package com.s2it.springoauth2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
public class PrivateController {

    @GetMapping(value = "/obrigado")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String exemplo() {
        return "Acha";
    }

}
