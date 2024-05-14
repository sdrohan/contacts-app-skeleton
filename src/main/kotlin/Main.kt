import controllers.ContactController
import controllers.GroupContactController
import controllers.GroupController
import models.Contact
import models.Group
import java.util.Scanner

fun main() {
    val contactController = ContactController()
    val groupController = GroupController()
    val groupContactController = GroupContactController()

    val scanner = Scanner(System.`in`)
    var choice: Int

    do {
        println("Menu:")
        println("1. Add Contact")
        println("2. Add Group")
        println("3. Add Contact to Group")
        println("4. View Contacts")
        println("5. View Groups")
        println("6. View Group Contacts")
        println("7. Exit")
        print("Enter your choice: ")
        choice = scanner.nextInt()

        when (choice) {
            1 -> {
                // Add Contact
                print("Name: ")
                val name = scanner.next()
                print("Email: ")
                val email = scanner.next()
                print("Phone: ")
                val phone = scanner.next()
                val contact = Contact(0, name, email, phone)
                contactController.addContact(contact)
            }
            2 -> {
                // Add Group
                print("Group Name: ")
                val groupName = scanner.next()
                val group = Group(0, groupName)
                groupController.addGroup(group)
            }
            3 -> {
                // Add Contact to Group
                println("Enter contact id:")
                val contactId = scanner.nextInt()
                println("Enter group id:")
                val groupId = scanner.nextInt()
                groupContactController.addContactToGroup(contactId, groupId)
            }
            4 -> {
                // View Contacts
                println("Contacts:")
                println(contactController.listContacts())
            }
            5 -> {
                // View Groups
                println("Groups:")
                println(groupController.listGroups())
            }
            6 -> {
                // List Contacts in Groups
                println("Enter group id:")
                val groupId = scanner.nextInt()
                println(groupContactController.listContactsInGroup(groupId))
            }
            7 -> {
                println("Exiting...")
            }
            else -> println("Invalid choice. Please try again.")
        }
    } while (choice != 7)
}
