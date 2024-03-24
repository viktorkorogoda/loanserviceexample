package com.vk.loanserviceexample.persistence.mapper;

import com.vk.loanserviceexample.domain.entity.Account;
import com.vk.loanserviceexample.persistence.dao.AccountDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Service
@Mapper(componentModel = "spring")
public interface PersistenceAccountMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "loanStatus", source = "loanStatus")
    Account toAccount(AccountDao accountDao);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "loanStatus", source = "loanStatus")
    AccountDao toAccountDao(Account account);
}
