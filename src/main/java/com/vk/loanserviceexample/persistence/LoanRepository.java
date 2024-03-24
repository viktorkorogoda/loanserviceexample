package com.vk.loanserviceexample.persistence;

import com.vk.loanserviceexample.persistence.dao.AccountDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends CrudRepository<AccountDao, Integer> {

    AccountDao findByUserId(String userId);
}
