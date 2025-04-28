package com.springlearn.webapp.reponsitory;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springlearn.webapp.domain.model.Classies;

/*  Các JpaReponsitory là lớp tiện ích được mở rộng từ lớp PagingAndSortingRepository & CrudRepository
*  - JpaReponsitory là cầu nối giữa Java và Database thông qua các đặc tả JPA mà nhà cung cấp là Hibernate.
*  - Lớp tiện ích cung cấp bởi Spring Data JPA để đơn giản hóa việc thao tác với DB.
*  - Chứa các phương thức tiện ích (CRUD ,Pagging ,...) KHÔNG THỰC THI MÃ TRỰC TIẾP -> ủy quyền cho Hibenrate thao tác vs DB.
    - Trường hợp truy vấn phức tạp hơn method trong JpaReponsitory thì phải dùng @Query (JPQL) hoặc Native SQL.
*/
public interface ClassReponsitory extends JpaRepository<Classies, Long> {
    List<Classies> findByName(String name);
}
