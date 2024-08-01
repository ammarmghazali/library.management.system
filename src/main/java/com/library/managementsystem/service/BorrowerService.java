package com.library.managementsystem.service;

import com.library.managementsystem.dto.RegisterBorrowerRequest;
import com.library.managementsystem.entity.Borrower;

import java.util.List;

public interface BorrowerService {
    Borrower registerBorrower(RegisterBorrowerRequest borrower);

    List<Borrower> getAllBorrowers();
}
