import controllers.ContactController
import controllers.GroupContactController
import controllers.GroupController
import models.Contact
import models.Group
import utils.readNextInt
import utils.readNextLine

fun main() {
    val contactController = ContactController()
    val groupController = GroupController()
    val groupContactController = GroupContactController()

    var choice: Int

    do {
        choice = readNextInt("""
                      |Menu:
                      |  1. Add Contact
                      |  2. Add Group
                      |  3. Add Contact to Group
                      |  4. View Contacts
                      |  5. View Groups
                      |  6. View Group Contacts
                      |  0. Exit
                      |  > """.trimMargin("|"))

        when (choice) {
            1 -> {
                // Add Contact
                val name = readNextLine("Name: ")
                val email = readNextLine("Email: ")
                val phone =  readNextLine("Phone: ")
                val contact = Contact(0, name, email, phone)
                contactController.addContact(contact)
            }
            2 -> {
                // Add Group
                val groupName = readNextLine("Group Name: ")
                val group = Group(0, groupName)
                groupController.addGroup(group)
            }
            3 -> {
                // Add Contact to Group
                val contactId = readNextInt("Enter contact id: ")
                val groupId = readNextInt("Enter group id: ")
                groupContactController.addContactToGroup(contactId, groupId)
            }
            4 -> {
                // View Contacts
                println("Contacts: \n${contactController.listContacts()}")
            }
            5 -> {
                // View Groups
                println(" Groups: \n${groupController.listGroups()}")
            }
            6 -> {
                // List Contacts in Groups
                val groupId = readNextInt("Enter group id: ")
                println(groupContactController.listContactsInGroup(groupId))
            }
            0 -> {
                println("Exiting...")
            }
            else -> println("Invalid choice: $choice. Please try again.")
        }
    } while (choice != 0)
}
