package trainingLibrary.services;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import trainingLibrary.domain.UserEntity;
import trainingLibrary.dto.AddUserRequest;
import trainingLibrary.dto.AddUserResponse;
import trainingLibrary.repository.HibernateRepository;

@Service
@AllArgsConstructor

public class UserService {

    private HibernateRepository<UserEntity> repository;

    public AddUserResponse addUser(AddUserRequest request) {
        var entity = convert(request);
        repository.save(entity);
        var response = new AddUserResponse();
        response.setCreatedUserId(response.getCreatedUserId());
        return response;
    }

    private UserEntity convert(AddUserRequest request) {
        var entity = new UserEntity();
        entity.setUsername(request.getUsername());
        return entity;

    }
}
