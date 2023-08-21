package com.blog.accountservice.grpc.server;

import com.blog.account.proto.*;
import com.blog.accountservice.grpc.service.AccountGrpcService;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author dai.le-anh
 * @since 8/15/2023
 */

@GrpcService
@RequiredArgsConstructor
public class AccountGrpcServer extends AccountServiceGrpc.AccountServiceImplBase {

    private final AccountGrpcService accountGrpcService;

    @Override
    public void addNewAccount(NewAccountRequest request, StreamObserver<CreateAccountResponse> responseObserver) {
        try {
            responseObserver.onNext(accountGrpcService.createAccount(request));
            responseObserver.onCompleted();
        } catch (Exception e){
            responseObserver.onNext(CreateAccountResponse.newBuilder()
                            .setSuccess(false)
                            .setError(AccountGrpcError.newBuilder()
                                    .setMessage(e.getMessage())
                                    .setCode("INTERNAL_ERROR")
                                    .setException(e.getClass().getSimpleName())
                                    .build())
                    .build());
        }

    }

    @Override
    public void listAccount(Empty request, StreamObserver<ListAccountResponse> responseObserver) {
        try {
            responseObserver.onNext(accountGrpcService.listAccount());
            responseObserver.onCompleted();
        } catch (Exception e){
            responseObserver.onNext(ListAccountResponse.newBuilder()
                    .setSuccess(false)
                    .setError(AccountGrpcError.newBuilder()
                            .setMessage(e.getMessage())
                            .setCode("INTERNAL_ERROR")
                            .setException(e.getClass().getSimpleName())
                            .build())
                    .build());
        }
    }
}
