package com.prodemy.springbootrestfulapi.controller;


import com.prodemy.springbootrestfulapi.entity.User;
import com.prodemy.springbootrestfulapi.model.ContactResponse;
import com.prodemy.springbootrestfulapi.model.CreateContactRequest;
import com.prodemy.springbootrestfulapi.model.WebResponse;
import com.prodemy.springbootrestfulapi.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> createPhone(User user, @RequestBody CreateContactRequest request) {
        ContactResponse contactResponse = contactService.createContact(user ,request);

        return WebResponse.<ContactResponse>builder().data(contactResponse).build();
    }
}
