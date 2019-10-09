package com.books.service.lending;

import com.books.model.lending.Lending;
import com.books.repository.lending.ILendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendingServiceImpl implements ILendingService {

    @Autowired
    private ILendingRepository lendingRepository;

    public List<Lending> findAll(){
        return lendingRepository.findAll();
    }

    public void save (Lending lending){
        lendingRepository.save(lending);
    }
}
