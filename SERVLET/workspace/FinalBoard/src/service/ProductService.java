package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.ProductDTO;

public interface ProductService {
	void create(ProductDTO pdto);
	List<ProductDTO> getList();
	ProductDTO getDetail(int pno);
	void modify(ProductDTO pdtp);
	void remove(int pno);
	void readCount(int pno);
	
	void execute(HttpServletRequest request, HttpServletResponse response, String action);
}
