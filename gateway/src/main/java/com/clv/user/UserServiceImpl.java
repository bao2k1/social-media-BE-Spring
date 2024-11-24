package com.clv.user;

import com.clv.UserIdRequest;
import com.clv.UserServiceGrpc;
import com.clv.user.dto.UserDto;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;

    @GrpcClient("grpc-user-service")
    UserServiceGrpc.UserServiceBlockingStub synchronousClient;

    @GrpcClient("grpc-user-service")
    UserServiceGrpc.UserServiceStub asynchronousClient;

    @Override
    public List<UserDto> findAllUsers() {
        return synchronousClient.getAllUsers(Empty.getDefaultInstance())
                .getUsersList().stream()
                .map(user ->
                        modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(int id) {
        return modelMapper.map(
                synchronousClient.getUser(UserIdRequest.newBuilder().setId(id).build()),
                UserDto.class);
    }
}
