package com.example;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试
 * 
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MemberTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test() {
		String baseUrl = "http://localhost:" + port;

		String name = "刘冬";

		// 测试添加
		Member entity = new Member();
		entity.name = name;
		entity.sex = 1;
		ExecuteDTO execute = this.restTemplate.postForObject(baseUrl + "/member/save", entity, ExecuteDTO.class);
		assertThat(execute).isNotNull();
		assertThat(execute.isSuccess()).isTrue();
		assertThat(execute.getValue()).isNotNull();

		// 测试获取
		entity = this.restTemplate.getForObject(baseUrl + "/member/get/" + execute.getValue(), Member.class);
		assertThat(entity).isNotNull();
		assertThat(entity.id).isNotNull();
		assertThat(entity.name).isEqualTo(name);

		// 测试修改
		entity.name = "刘冬的博客";
		execute = this.restTemplate.postForObject(baseUrl + "/member/save", entity, ExecuteDTO.class);
		assertThat(execute).isNotNull();
		assertThat(execute.isSuccess()).isTrue();

		// 测试修改成功
		entity = this.restTemplate.getForObject(baseUrl + "/member/get/" + entity.id, Member.class);
		assertThat(entity).isNotNull();
		assertThat(entity.id).isNotNull();
		assertThat(entity.name).isNotEqualTo(name);

		// 测试查询分页
		PageQueryParamDTO param = new PageQueryParamDTO(1, 20, null);
		PageResultDTO pageResult = this.restTemplate.postForObject(baseUrl + "/member/loadPage", param,
				PageResultDTO.class);
		assertThat(pageResult).isNotNull();
		assertThat(pageResult.getRows()).isNotEmpty();
		assertThat(pageResult.getTotal()).isGreaterThan(0);

		// 测试删除
		execute = this.restTemplate.getForObject(baseUrl + "/member/remove/" + entity.id, ExecuteDTO.class);
		assertThat(execute).isNotNull();
		assertThat(execute.isSuccess()).isTrue();

		// 测试是否已删除
		entity = this.restTemplate.getForObject(baseUrl + "/member/get/" + entity.id, Member.class);
		assertThat(entity).isNull();
	}

}
