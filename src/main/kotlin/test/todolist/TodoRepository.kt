package test.todolist

import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {
    fun findByIsCheck(isCheck:Boolean): List<Todo>
}