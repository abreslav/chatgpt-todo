fun main() {
    val tasks = mutableListOf<String>()
    while (true) {
        println("\nTo-Do List")
        println("1. View tasks")
        println("2. Add task")
        println("3. Remove task")
        println("4. Exit")
        print("Enter your choice: ")

        when (readLine()?.toIntOrNull()) {
            1 -> viewTasks(tasks)
            2 -> addTask(tasks)
            3 -> removeTask(tasks)
            4 -> {
                println("Goodbye!")
                break
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}

fun viewTasks(tasks: List<String>) {
    if (tasks.isEmpty()) {
        println("\nNo tasks to show.")
    } else {
        println("\nTasks:")
        tasks.forEachIndexed { index, task -> println("${index + 1}. $task") }
    }
}

fun addTask(tasks: MutableList<String>) {
    print("\nEnter a new task: ")
    val task = readLine().orEmpty()
    if (task.isNotBlank()) {
        tasks.add(task)
        println("Task added!")
    } else {
        println("Task cannot be empty.")
    }
}

fun removeTask(tasks: MutableList<String>) {
    if (tasks.isEmpty()) {
        println("\nNo tasks to remove.")
        return
    }

    println("\nEnter the number of the task to remove:")
    tasks.forEachIndexed { index, task -> println("${index + 1}. $task") }

    val choice = readLine()?.toIntOrNull()
    if (choice != null && choice in 1..tasks.size) {
        tasks.removeAt(choice - 1)
        println("Task removed!")
    } else {
        println("Invalid choice.")
    }
}
