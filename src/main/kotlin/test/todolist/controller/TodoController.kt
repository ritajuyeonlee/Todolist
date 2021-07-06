package test.todolist.controller

import UpdateTodoDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import test.todolist.dto.CreateTodoDTO
import test.todolist.service.TodoService

@RestController
class TodoController {

    @Autowired
    lateinit var service: TodoService

    @GetMapping("/todo", produces = ["application/json"])
    fun getTodo(@RequestParam(value="isCheck", required = false) isCheck:Boolean)
    :ResponseEntity<Any>{
        return ResponseEntity.ok().body(service.getTodoList(isCheck))
    }

    @PostMapping("/todo")
    fun createTodo(@RequestBody createTodoDTO: CreateTodoDTO): ResponseEntity<Any> {
        service.createTodo(createTodoDTO)
        return ResponseEntity.ok().body(true)
    }
    @PutMapping("/todo")
    fun updateTodo(@PathVariable id:Long, @RequestBody requestDto:UpdateTodoDTO):ResponseEntity<Any>{
        service.updateTodo(id, requestDto)
        return ResponseEntity.ok().body(true)
    }
//
//    @DeleteMapping("/todo")
//    fun deleteTodo(@RequestParam(value="id", required = true) id:Long):ResponseEntity<Any>{
//        service.deleteTodo(id)
//        return ResponseEntity.ok().body(true)
//
//   }


}