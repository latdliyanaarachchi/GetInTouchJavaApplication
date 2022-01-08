package com.mad.getInTouch.repository;

import com.mad.getInTouch.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


}
