package com.example.demo.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaginationTests {

	@Test
	@DisplayName("Pagination 객체의 초기화 작업이 잘 동작하는지 테스트")
	public void testPagination() {
		Pagination p1 = new Pagination(1, 0);
		assertThat(p1.getTotalPages()).isEqualTo(0);
		
		Pagination p2 = new Pagination(1, 53);
		assertThat(p2.getTotalPages()).isEqualTo(6);
		assertThat(p2.getTotalBlocks()).isEqualTo(2);
		assertThat(p2.getBeginPage()).isEqualTo(1);
		assertThat(p2.getEndPage()).isEqualTo(5);
		
		Pagination p3 = new Pagination(6, 53);
		assertThat(p3.getTotalPages()).isEqualTo(6);
		assertThat(p3.getTotalBlocks()).isEqualTo(2);
		assertThat(p3.getBeginPage()).isEqualTo(6);
		assertThat(p3.getEndPage()).isEqualTo(6);

		Pagination p4 = new Pagination(2, 53, 20);
		assertThat(p4.getTotalPages()).isEqualTo(3);
		assertThat(p4.getTotalBlocks()).isEqualTo(1);
		assertThat(p4.getBeginPage()).isEqualTo(1);
		assertThat(p4.getEndPage()).isEqualTo(3);
	}
}
