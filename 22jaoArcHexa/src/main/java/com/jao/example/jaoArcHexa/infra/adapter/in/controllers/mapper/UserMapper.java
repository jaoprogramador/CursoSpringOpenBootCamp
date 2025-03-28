package com.jao.example.jaoArcHexa.infra.adapter.in.controllers.mapper;

import java.util.Date;

import com.jao.example.jaoArcHexa.domain.pojos.User;
import com.jao.example.jaoArcHexa.infra.adapter.in.controllers.dto.UserDto;

public class UserMapper {
	public static UserDto toUserDto(User user) {
		return UserDto.builder()
				.id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
				.activo(user.getActivo())
				.fechaAlta(user.getFechaAlta())
				.build();
	}
	
	public static User toAppObject (UserDto userDto) {
		return User.builder()
				.id(userDto.getId())
				.name(userDto.getName())
				.email(userDto.getEmail())
				.activo("A")
				.fechaAlta(new Date())
				.build();
	}
	
}
