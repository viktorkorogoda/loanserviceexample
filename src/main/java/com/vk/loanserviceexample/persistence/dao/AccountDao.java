package com.vk.loanserviceexample.persistence.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class AccountDao {

    @Id
    private Integer id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "loan_status")
    private String loanStatus;
}
