package io.github.chungtsai.sample.ddd.adapter.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import io.github.chungtsai.sample.ddd.adapter.entity.po.UserPo;
import io.github.chungtsai.sample.ddd.entity.user.UserAggregate;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserAggregate toAggregate(UserPo personVO);

}
