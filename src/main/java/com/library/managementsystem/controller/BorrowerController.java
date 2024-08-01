package com.library.managementsystem.controller;

import com.library.managementsystem.dto.RegisterBorrowerRequest;
import com.library.managementsystem.entity.Borrower;
import com.library.managementsystem.service.BorrowerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrower")
@RequiredArgsConstructor
public class BorrowerController {

    private final BorrowerService borrowerService;

    @PostMapping("/register")
    public ResponseEntity<Borrower> registerBorrower(@Valid @RequestBody RegisterBorrowerRequest borrower) {
        return ResponseEntity.ok(borrowerService.registerBorrower(borrower));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Borrower>> getAllBorrowers() {
        return ResponseEntity.ok(borrowerService.getAllBorrowers());
    }
}
