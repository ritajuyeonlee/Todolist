package test.todolist.dto

data class ResponseTodoDTO (
    val id: Long? = null,
    val task: String? = null,
    val isCheck : Boolean = true
)