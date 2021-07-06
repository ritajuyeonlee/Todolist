package test.todolist.domain
import UpdateTodoDTO
import test.todolist.dto.CreateTodoDTO
import test.todolist.dto.ResponseTodoDTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
@Entity
data class Todo(
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    var id:Long,
    var task: String,
    val isCheck : Boolean = true
) {
    fun getTodoDTO(): ResponseTodoDTO{
        return ResponseTodoDTO(
            id=id,
            task=task,
            isCheck=isCheck
        )
    }
    fun createTodoDTO(): CreateTodoDTO {
        return CreateTodoDTO(
            id=id,
            task=task,
            isCheck = isCheck
        )
    }
    fun updateTodoDTO():UpdateTodoDTO {
        return UpdateTodoDTO(
            id=id,
            task=task,
            isCheck=isCheck
        )
    }
}