package com.exmpl.dm.repository;

import com.exmpl.dm.model.FormDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormDetailsRepository extends JpaRepository<FormDetails,Long> {
}
