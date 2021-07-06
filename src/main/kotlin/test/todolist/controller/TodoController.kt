package test.todolist.controller

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
    fun createTodo(@RequestBody DTO: CreateTodoDTO):  CreateTodoDTO{
        return  service.createTodo(DTO)
    }
//    @PutMapping("/todo")
//    fun updateTodo(@PathVariable id:Long, @RequestBody input : PatchTodoDTO):ResponseEntity<Any>{
//        service.updateTodo(id)
//        return ResponseEntity.ok().body(true)
//    }
//
//    @DeleteMapping("/todo")
//    fun deleteTodo(@RequestParam(value="id", required = true) id:Long):ResponseEntity<Any>{
//        service.deleteTodo(id)
//        return ResponseEntity.ok().body(true)
//
//   }
}