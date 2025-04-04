package com.jao.service;

import com.jao.entity.ActorEntity;
import com.jao.service.common.SimpleService;

public interface IActorService extends SimpleService<ActorEntity>{

	void delete(Long id);

}
