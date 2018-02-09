package com.example;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 会员
 * 
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@Entity
@Table(name = "t_member")
public class Member {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "member_id", length = 36)
	public String id;

	/**
	 * 注册日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Temporal(TemporalType.DATE)
	@Column(name = "`date`")
	public Date date;

	/**
	 * 姓名
	 */
	@Column(name = "`name`", length = 50)
	public String name;

	/**
	 * 性别
	 */
	@Column(name = "sex")
	public Integer sex;

	// 省略 get set
}
