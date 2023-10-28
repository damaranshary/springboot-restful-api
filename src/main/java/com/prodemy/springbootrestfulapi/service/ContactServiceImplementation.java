package com.prodemy.springbootrestfulapi.service;

import com.prodemy.springbootrestfulapi.entity.Contact;
import com.prodemy.springbootrestfulapi.entity.User;
import com.prodemy.springbootrestfulapi.model.ContactResponse;
import com.prodemy.springbootrestfulapi.model.CreateContactRequest;
import com.prodemy.springbootrestfulapi.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContactServiceImplementation implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    public ContactResponse createContact(User user, CreateContactRequest request) {
        validationService.validate(request);

        Contact contact = new Contact();
        contact.setId(UUID.randomUUID().toString());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());

        contact.setUser(user);

        contactRepository.save(contact);

        return ContactResponse.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .build();
    }
}
