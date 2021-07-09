package test.todolist.domain
import test.todolist.dto.CreaeteTodoDTO
import test.todolist.dto.ResponseTodoDTO
import javax.persistence.*

@Entity
data class Todo(
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    var id:Long,
    var task: String,

    @Column(name="is_check")
    val isCheck : Boolean
) {
    fun getTodoDTO(): ResponseTodoDTO{
        return ResponseTodoDTO(
            id=id,
            task=task,
            isCheck=isCheck
        )
    }
    fun createDTO(): CreaeteTodoDTO {
        return CreaeteTodoDTO(
            id=id,
            task=task,
            isCheck = isCheck
        )
    }

}