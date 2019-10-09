package com.books.controller.book;

import com.books.controller.dto.book.cover.CoverCreateDto;
import com.books.controller.dto.book.cover.CoverUpdateDto;
import com.books.exceptions.ResourceNotFoundException;
import com.books.model.book.Cover;
import com.books.service.book.cover.ICoverService;
import com.books.technical.dto.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cover")
public class CoverController {
    @Autowired
    private ICoverService coverService;

    @GetMapping("/all")
    public List<Cover> coverList(){

        List<Cover> coverList = coverService.findAll();
        if (coverList.isEmpty()) throw new ResourceNotFoundException( "Aucune couverture de livre trouvée");

        return coverList;
    }

    @PostMapping
    public void newCover(@DTO(CoverCreateDto.class) Cover cover) {

    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateCover(@DTO(CoverUpdateDto.class) Cover cover ){

    }
}
