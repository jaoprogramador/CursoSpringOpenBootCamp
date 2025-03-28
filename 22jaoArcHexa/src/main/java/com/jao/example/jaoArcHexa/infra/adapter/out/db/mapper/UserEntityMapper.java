package com.jao.example.jaoArcHexa.infra.adapter.out.db.mapper;

import com.jao.example.jaoArcHexa.domain.pojos.User;
import com.jao.example.jaoArcHexa.infra.adapter.out.db.entities.UserEntity;

public class UserEntityMapper {
	public static User toDomain(UserEntity entity) {
        return User.builder()
                //.id(Math.toIntExact(entity.getId()))
                .name(entity.getName())
                .email(entity.getEmail())
                .activo(entity.getActivo())
                .fechaAlta(entity.getFechaAlta())
                .build();
    }

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id((long) user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .activo(user.getActivo())
                .fechaAlta(user.getFechaAlta())
                .build();
    }

}
