package com.example.demo.repository;

import com.example.demo.repository.model.RUser;
import com.example.demo.repository.model.RUserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<RUser,Long> {

    @Query(value = "select user_id, role from test.ruser as a, test.ruser_profile as b where a.id = b.user_id", nativeQuery = true)
    List<Object[]> findUserDetail();
}
