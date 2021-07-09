package test.todolist.dto

import test.todolist.domain.Todo

data class CreaeteTodoDTO (
    val id: Long,
    val task: String,
    val isCheck : Boolean = true,
){
    fun toEntity(): Todo {
        return Todo(
            id=id,
            task=task,
            isCheck=isCheck
        )
    }
}