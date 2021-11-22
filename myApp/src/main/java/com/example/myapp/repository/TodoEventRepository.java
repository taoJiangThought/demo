package com.example.myapp.repository;

import com.example.myapp.Entity.ToDoEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author jiangtaotao
 */
@Repository
public interface TodoEventRepository extends JpaRepository<ToDoEvent,Long> {
    /**
     * 更新事件完成状态
     *
     * @param id
     * @param status
     * @return int
     *  nativeQuery 表示自然的sql数据库语句
     * Transactional  事务的注解
     *  Modifying  增删改操作必须要有这个注解
     */

    @Modifying
    @Transactional(rollbackOn = Exception.class)
    @Query(value = "UPDATE todo_event SET  status = ? WHERE id = ? ",nativeQuery = true)
    int updateEventStatus(int status, Long id);
}
