package com.clv.service;

import com.clv.User;
import com.clv.UserIdRequest;
import com.clv.UserList;
import com.clv.UserServiceGrpc;
import com.clv.entity.UserEntity;
import com.clv.repository.UserRepo;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    private final UserRepo repo;

    @Override
    @SneakyThrows
    public void getUser(UserIdRequest request, StreamObserver<User> responseObserver) {
        UserEntity entity = repo.findById(request.getId())
                .orElseThrow(() -> new Exception("User not found"));

        responseObserver.onNext(User.newBuilder()
                        .setId(Math.toIntExact(entity.getId()))
                        .setUsername(entity.getUsername())
                        .setPassword(entity.getPassword())
                .build());
        responseObserver.onCompleted();
    }

    @Override
    public void getAllUsers(Empty request, StreamObserver<UserList> responseObserver) {
        UserList userList = UserList.newBuilder()
                .addAllUsers(
                        repo.findAll().stream()
                                .map(entity -> User.newBuilder()
                                        .setId(entity.getId())
                                        .setUsername(entity.getUsername())
                                        .setPassword(entity.getPassword()).build())
                                .toList())
                .build();

        responseObserver.onNext(userList);
        responseObserver.onCompleted();
    }
}
