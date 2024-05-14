package controllers

import models.Group

class GroupController {
    private val groups = mutableListOf<Group>()
    private var lastId = 0
    private fun getId() = lastId++

    fun addGroup(group: Group) {
        group.groupId = getId()
        groups.add(group)
    }

    fun listGroups() = groups

}