package ru.innopolis.adressbook.common.models.contact;

import java.util.List;

public interface ContactService {
	public List<Contact> getContactList(String userLogin);
	public void updateContact(Contact contact);
	public void newContact(Contact contact);
	public void deleteContact(Contact contact);
}
