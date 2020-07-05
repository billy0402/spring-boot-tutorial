package edu.ntub.demo.dao;

import edu.ntub.demo.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductDAO extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findByName(@Param("name") String name);
}
