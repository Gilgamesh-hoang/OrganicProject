package com.laptrinhweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhweb.dto.MyUser;
import com.laptrinhweb.entity.ContactEntity;
import com.laptrinhweb.entity.UserEntity;
import com.laptrinhweb.repository.IContactRepository;
import com.laptrinhweb.repository.IUserRepository;
import com.laptrinhweb.service.IContactService;
import com.laptrinhweb.util.SecurityUtils;

@Service
public class ContactService implements IContactService {
	@Autowired
	private IContactRepository contactBlogRepository;
	@Autowired
	private IUserRepository userRepository;

	@Override
	@Transactional
	public void sendFeedback(String name, String email, String message) {
		ContactEntity contact = new ContactEntity(email, message, name);
		MyUser myUser = SecurityUtils.getPrincipal();
		if (myUser != null) {
			UserEntity user = userRepository.findOne(myUser.getId());
			contact.setUser(user);
		}
		contactBlogRepository.save(contact);
	}

}
