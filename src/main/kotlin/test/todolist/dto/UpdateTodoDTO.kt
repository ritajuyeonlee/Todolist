import test.todolist.domain.Todo

data class UpdateTodoDTO (
    val id: Long,
    val task: String,
    val isCheck : Boolean
){
    fun toEntity(): Todo {
        return Todo(
            id=id,
            task=task,
            isCheck=isCheck
        )
    }
}