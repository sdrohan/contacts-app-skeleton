package controllers

import models.GroupContact

class GroupContactController {

    private val groupContacts = mutableListOf<GroupContact>()

    fun addContactToGroup(contactId: Int, groupId: Int) {
        groupContacts.add(GroupContact(contactId, groupId))
    }

    fun listContactsInGroup(groupId: Int) = groupContacts.filter { it.groupId == groupId }

}