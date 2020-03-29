package com.jdc.flower.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.flower.base.BaseController;
import com.jdc.flower.entity.ProductImage;
import com.jdc.flower.service.ProductImageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("product-images")
@CrossOrigin("*")
public class ProductImageApi extends BaseController<ProductImage, Long> {

	@Autowired
	public ProductImageApi(ProductImageService service) {
		super(service);
	}
	@Value("http://localhost:80/product-images")
	private String baseUrl;
	@Value("D:/appFolder/nginx-1.16.1/html/images")
	private String location;

	public ResponseEntity<ProductImage> upload(@RequestParam MultipartFile file) throws IOException{
		String name= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"))
				.concat(file.getOriginalFilename());

		String imagePath = baseUrl.concat(name);

		file.transferTo(Paths.get(location).resolve(name));

		ProductImage image=new ProductImage(name,imagePath);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(image);


	}

}
