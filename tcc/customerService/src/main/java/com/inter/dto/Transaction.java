package com.inter.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class Transaction implements Serializable{
	@Id
	 @Column(name="id")
	private long id;

	 @Column(name="username")
    private String username;



    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}
