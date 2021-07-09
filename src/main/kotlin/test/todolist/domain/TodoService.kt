package test.todolist.domain
import UpdateTodoDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import test.todolist.dto.SaveTodoDTO
import test.todolist.dto.ResponseTodoDTO
import java.util.*
import javax.transaction.Transactional
@Service
class TodoService() {
    @Autowired
    lateinit var todoRepository : TodoRepository

//    fun getFilterTodoList(isCheck : Boolean): List<ResponseTodoDTO> {
//        val todo = todoRepository.findByIsCheck(isCheck)
//        return todo.map{it.getTodoDTO()}
//    }

    fun getTodoList(): List<ResponseTodoDTO> {
        val todo = todoRepository.findAll()
        return todo.map{it.getTodoDTO()}
    }

    @Transactional
    fun saveTodo(DTO: SaveTodoDTO) : SaveTodoDTO{
        val todo=todoRepository.save(DTO.toEntity())
        return todo.saveDTO()

    }
    @Transactional
    fun updateTodo(DTO: UpdateTodoDTO ){
        val todo=todoRepository.findById(DTO.id)
        if(todo=== Optional.empty<Todo>()) {
            throw IllegalArgumentException("해당아이디가 존재하지 않습니다")
        }else {
            todoRepository.save(DTO.toEntity())
        }
    }

    @Transactional
    fun deleteTodo(id: Long) {
        todoRepository.deleteById(id)

    }

}