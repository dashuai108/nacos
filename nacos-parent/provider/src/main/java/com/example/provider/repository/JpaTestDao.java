package com.example.provider.repository;

import com.example.provider.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTestDao extends JpaRepository<Test,String > {
}
