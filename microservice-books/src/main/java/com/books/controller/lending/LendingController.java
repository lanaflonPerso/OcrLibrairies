package com.books.controller.lending;

import com.books.controller.dto.lending.LendingCreateDto;
import com.books.controller.dto.lending.LendingUpdateDto;
import com.books.exceptions.ResourceNotFoundException;
import com.books.model.lending.Lending;
import com.books.service.lending.ILendingService;
import com.books.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Lending")
public class LendingController {
    @Autowired
    private ILendingService lendingService;

    @GetMapping("/all")
    public List<Lending> lendingList(){

        List<Lending> lendingList = lendingService.findAll();
        if (lendingList.isEmpty()) throw new ResourceNotFoundException( "Aucun utilisateur trouvé");

        return lendingList;
    }

    @PostMapping
    public void newLending(@DTO(LendingCreateDto.class) Lending lending) {
        lendingService.save( lending );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateLending(@DTO(LendingUpdateDto.class) Lending lending ){
        lendingService.save( lending );
    }
}
