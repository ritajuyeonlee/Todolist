package test.todolist.domain
import test.todolist.dto.SaveTodoDTO
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
    val isCheck : Boolean
) {
    fun getTodoDTO(): ResponseTodoDTO{
        return ResponseTodoDTO(
            id=id,
            task=task,
            isCheck=isCheck
        )
    }
    fun saveDTO(): SaveTodoDTO {
        return SaveTodoDTO(
            id=id,
            task=task,
            isCheck = isCheck
        )
    }

}