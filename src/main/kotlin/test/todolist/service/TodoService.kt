package test.todolist.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import test.todolist.TodoRepository
import test.todolist.dto.CreateTodoDTO
import test.todolist.dto.ResponseTodoDTO
import javax.transaction.Transactional


@Service
class TodoService() {
    @Autowired
    lateinit var todoRepository : TodoRepository

    fun getTodoList(isCheck : Boolean): List<ResponseTodoDTO> {
        val todo = todoRepository.findByIsCheck(isCheck)
        return todo.map{it.getTodoDTO()}
    }

    @Transactional
    fun createTodo(createTodoDTO: CreateTodoDTO): CreateTodoDTO{
        val todo=todoRepository.save(createTodoDTO.toEntity())
        return todo.createTodoDTO()
    }

    @Transactional
    fun updateTodo(id: Long,createTodoDTO: CreateTodoDTO): CreateTodoDTO {
        val todo=todoRepository.save(createTodoDTO.toEntity())
        return todo.createTodoDTO()

    }
//
//    @Transactional
//    fun deleteTodo(id: Long) {
//        val todo=todoRepository.deleteById(id)
//        return todo.deleteTodoDTO()
//
//    }
}