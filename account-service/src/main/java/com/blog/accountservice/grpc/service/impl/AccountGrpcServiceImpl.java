package com.blog.accountservice.grpc.service.impl;

import com.blog.account.proto.AccountResponse;
import com.blog.account.proto.CreateAccountResponse;
import com.blog.account.proto.ListAccountResponse;
import com.blog.account.proto.NewAccountRequest;
import com.blog.accountservice.domain.entity.AccountEntity;
import com.blog.accountservice.domain.repository.AccountRepository;
import com.blog.accountservice.grpc.service.AccountGrpcService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author dai.le-anh
 * @since 8/15/2023
 */

@Service
@RequiredArgsConstructor
public class AccountGrpcServiceImpl implements AccountGrpcService {
    private final AccountRepository accountRepository;
    @Override
    public ListAccountResponse listAccount() {
        var accounts = accountRepository.findAll();
        return ListAccountResponse.newBuilder()
                .setSuccess(true)
                .setData(ListAccountResponse.Data.newBuilder()
                        .addAllAccounts(accounts.stream()
                                .map(a -> AccountResponse.newBuilder()
                                        .setUsername(a.getUsername())
                                        .setPassword(a.getPassword())
                                        .build())
                                .collect(Collectors.toList()))
                        .build())
                .build();
    }

    @Override
    public CreateAccountResponse createAccount(NewAccountRequest request) {
//        TODO: validate
        AccountEntity account = new AccountEntity();
        account.setUsername(request.getUsername());
        account.setPassword(request.getPassword());
        var saveAccount = accountRepository.save(account);
        return CreateAccountResponse.newBuilder()
                .setData(CreateAccountResponse.Data.newBuilder()
                        .setId(saveAccount.getAccountId())
                        .build())
                .setSuccess(true)
                .build();
    }
}
