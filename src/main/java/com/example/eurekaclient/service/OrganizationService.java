package com.example.eurekaclient.service;

import com.example.eurekaclient.entity.Organization;
import com.example.eurekaclient.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Transactional(readOnly = true)
    public Organization getOrganization(Long organizationId) {
        return organizationRepository
                .findById(organizationId)
                .get();
    }

    public Organization mergeOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public void deleteOrganization(Long organizationId) {
        organizationRepository.deleteById(organizationId);
    }

}
