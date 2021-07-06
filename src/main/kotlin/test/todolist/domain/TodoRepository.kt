package test.todolist.domain

import org.springframework.data.jpa.repository.JpaRepository
import test.todolist.domain.Todo

interface TodoRepository : JpaRepository<Todo, Long> {
    fun findByIsCheck(isCheck:Boolean): List<Todo>
}