package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 会员Repository类
 * 
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
public interface MemberRepository extends JpaRepository<Member, String>, JpaSpecificationExecutor<Member> {

}
