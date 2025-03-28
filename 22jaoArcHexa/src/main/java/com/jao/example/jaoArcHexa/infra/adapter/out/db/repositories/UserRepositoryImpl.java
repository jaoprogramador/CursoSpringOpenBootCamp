package com.jao.example.jaoArcHexa.infra.adapter.out.db.repositories;
import com.jao.example.jaoArcHexa.application.ports.UserRepository;
import com.jao.example.jaoArcHexa.domain.pojos.User;
import com.jao.example.jaoArcHexa.infra.adapter.out.db.entities.UserEntity;
import com.jao.example.jaoArcHexa.infra.adapter.out.db.mapper.UserEntityMapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User getUserById(Long id) {
        Optional<UserEntity> entity = userJpaRepository.findById(id);
        return entity.map(UserEntityMapper::toDomain).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        List<UserEntity> entities = userJpaRepository.findAll();
        return entities.stream().map(UserEntityMapper::toDomain).toList();
    }

    @Override
    public User createUser(User user) {
        UserEntity entity = UserEntityMapper.toEntity(user);
        entity.setId(null);
        entity.setVersion(0L);
        UserEntity savedEntity = userJpaRepository.save(entity);
        return UserEntityMapper.toDomain(savedEntity);
    }

    @Override
    public User updateUser(User user) {
        if (userJpaRepository.existsById((long) user.getId())) {
            UserEntity entity = UserEntityMapper.toEntity(user);
            UserEntity updatedEntity = userJpaRepository.save(entity);
            return UserEntityMapper.toDomain(updatedEntity);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userJpaRepository.deleteById(id);
    }
}
