package com.books.repository.lending;

import com.books.model.Lending;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILendingRepository extends JpaRepository<Lending,Long> {
}
