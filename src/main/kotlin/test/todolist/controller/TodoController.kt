package test.todolist.controller

import UpdateTodoDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import test.todolist.dto.CreateTodoDTO
import test.todolist.domain.TodoService

@RestController
class TodoController {
    @Autowired
    lateinit var service: TodoService

    @GetMapping("/todo/{isCheck}", produces = ["application/json"])
    fun getFilterTodo(@PathVariable isCheck:Boolean)
            :ResponseEntity<Any>{
        return ResponseEntity.ok().body(service.getFilterTodoList(isCheck))
    }

    @GetMapping("/todo", produces = ["application/json"])
    fun getTodo():ResponseEntity<Any>{
        return ResponseEntity.ok().body(service.getTodoList())
    }
    @PostMapping("/todo")
    fun createTodo(@RequestBody DTO: CreateTodoDTO):ResponseEntity<Any>{
        service.createTodo(DTO)
        return ResponseEntity.ok().body(true)
    }
    @PutMapping("/todo")
    fun updateTodo(@RequestBody DTO : UpdateTodoDTO):ResponseEntity<Any>{
        service.updateTodo(DTO)
        return ResponseEntity.ok().body(true)
    }

    @DeleteMapping("/todo")
    fun deleteTodo(@RequestParam(value="id", required = true) id:Long):ResponseEntity<Any>{
        service.deleteTodo(id)
        return ResponseEntity.ok().body(true)

   }
}