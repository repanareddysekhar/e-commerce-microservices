package com.repana.productservice.repository;

import com.repana.productservice.entity.Category;
import java.util.UUID;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	public void findByIdAndIsDeleted() {
		UUID id = null;
		boolean isDeleted = true;
		Category expected = new Category();
		Category actual = categoryRepository.findByIdAndIsDeleted(id, isDeleted).orElse(null);

		assertEquals(expected, actual);
	}
}
