package test.todolist.dto

import test.todolist.Todo

data class CreateTodoDTO (
    val id: Long? = null,
    val task: String? = null,
    val isCheck : Boolean = true,
){
    fun toEntity():Todo{
        return Todo(
            task=task,
            isCheck=isCheck
        )
    }
}