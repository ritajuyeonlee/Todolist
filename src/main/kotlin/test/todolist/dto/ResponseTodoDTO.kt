package test.todolist.dto

data class ResponseTodoDTO (
    val id: Long,
    val task: String,
    val isCheck : Boolean = true
)