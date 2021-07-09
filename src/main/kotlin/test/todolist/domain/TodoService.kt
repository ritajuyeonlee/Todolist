package test.todolist.domain
import UpdateTodoDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import test.todolist.dto.CreaeteTodoDTO
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
    fun createTodo(DTO: CreaeteTodoDTO) : CreaeteTodoDTO{
        val todo=todoRepository.save(DTO.toEntity())
        return todo.createDTO()

    }
    @Transactional
    fun updateTodo(DTO: UpdateTodoDTO ){
        val todo=todoRepository.findById(DTO.id)
        if(todo=== Optional.empty<Todo>()) {
            throw IllegalArgumentException("해당아이디가 존재하지 않습니다")
        }else {
            val too =todoRepository.save(DTO.toEntity())
            println("dddd"+DTO.toEntity())
            println("too"+too)
        }
    }

    @Transactional
    fun deleteTodo(id: Long) {
        todoRepository.deleteById(id)

    }

}