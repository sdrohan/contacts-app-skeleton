package controllers

import models.Contact

class ContactController {

    private val contacts = mutableListOf<Contact>()
    private var lastId = 0
    private fun getId() = lastId++

    fun addContact(contact: Contact) {
        contact.contactId = getId()
        contacts.add(contact)
    }

    fun listContacts() = contacts

}