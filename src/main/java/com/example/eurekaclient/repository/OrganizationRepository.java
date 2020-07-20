package com.example.eurekaclient.repository;

import com.example.eurekaclient.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
