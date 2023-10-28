package com.prodemy.springbootrestfulapi.service;

import com.prodemy.springbootrestfulapi.entity.Contact;
import com.prodemy.springbootrestfulapi.entity.User;
import com.prodemy.springbootrestfulapi.model.ContactResponse;
import com.prodemy.springbootrestfulapi.model.CreateContactRequest;
import com.prodemy.springbootrestfulapi.model.UpdateContactRequest;

import java.util.Optional;

public interface ContactService {

    ContactResponse createContact(User user, CreateContactRequest request);

    ContactResponse getContact(User user, String id);

    ContactResponse updateContact(User user, UpdateContactRequest request);

    void deleteContact(User user, String contactId);
}
