package com.blog.accountservice.grpc.service;

import com.blog.account.proto.CreateAccountResponse;
import com.blog.account.proto.ListAccountResponse;
import com.blog.account.proto.NewAccountRequest;

/**
 * @author dai.le-anh
 * @since 8/15/2023
 */

public interface AccountGrpcService {
    ListAccountResponse listAccount();

    CreateAccountResponse createAccount(NewAccountRequest request);
}
