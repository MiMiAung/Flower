package com.jdc.flower.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Entity
@Data
public  class Product  {

	public Product() {
		images = new ArrayList<>();
		category=new Category();
		//security = new SecurityInfo();
	}

//	public Product(){
//
//	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String coverImage;

	private int price;

	private String description;

	//private SecurityInfo security;

	@ManyToOne
    //@JsonFormat
	private Category category;

	@OneToMany(mappedBy = "product")
	private List<ProductImage> images;


}