package com.library.managementsystem.service.Impl;

import com.library.managementsystem.dto.RegisterBorrowerRequest;
import com.library.managementsystem.entity.Borrower;
import com.library.managementsystem.repository.BorrowerRepository;
import com.library.managementsystem.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepository;

    @Override
    public Borrower registerBorrower(RegisterBorrowerRequest registerBorrowerRequest) {
        return borrowerRepository.save(Borrower.builder()
                .email(registerBorrowerRequest.getEmail())
                .name(registerBorrowerRequest.getName())
                .build());
    }

    @Override
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }
}
