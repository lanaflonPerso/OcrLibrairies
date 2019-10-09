package com.books.service.lending;

import com.books.model.lending.Lending;

import java.util.List;

public interface ILendingService {

    List<Lending> findAll();
    void save (Lending lending);
}
