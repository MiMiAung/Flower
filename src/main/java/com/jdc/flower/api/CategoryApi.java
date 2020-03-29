package com.jdc.flower.api;

import com.jdc.flower.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.flower.base.BaseController;
import com.jdc.flower.entity.Category;
import com.jdc.flower.service.CategoryService;

@RestController
@RequestMapping("categories")
@CrossOrigin("*")
public class CategoryApi extends BaseController<Category, Integer>{

	public final CategoryRepo categoryRepo;

	@Autowired
	public CategoryApi(CategoryService service,CategoryRepo categoryRepo) {
		super(service);
		this.categoryRepo=categoryRepo;
	}




}
