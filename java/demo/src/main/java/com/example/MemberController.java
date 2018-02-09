package com.example;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员控制器
 * 
 * @author 刘冬 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@RestController
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberRepository repository;

	@GetMapping("get/{id}")
	public Member get(@PathVariable String id) {
		return repository.findOne(id);
	}

	@PostMapping("save")
	public ExecuteDTO save(@RequestBody Member entity) {
		if (entity.date == null) {
			entity.date = new Date();
		}
		repository.save(entity);
		return new ExecuteDTO(true, "保存成功", entity.id);
	}

	@PostMapping("loadPage")
	public PageResultDTO loadPage(@RequestBody PageQueryParamDTO params) {

		// 动态查询条件
		Specification<Member> spec = (root, query, cb) -> {
			if (params.getQuery() != null) {
				// 筛选 会员姓名
				query.where(cb.equal(root.get("name"), params.getQuery().toString()));
			}

			return null;
		};
		Pageable pageable = new PageRequest(params.getPage() - 1, params.getSize());
		Page<Member> pageResult = repository.findAll(spec, pageable);

		// 返回分页数据
		return new PageResultDTO(pageResult.getTotalElements(), pageResult.getContent());
	}

	@GetMapping("remove/{id}")
	public ExecuteDTO remove(@PathVariable String id) {
		repository.delete(id);
		return new ExecuteDTO(true, "删除成功", id);
	}

}
