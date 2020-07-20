package com.example.eurekaclient;

import com.example.eurekaclient.entity.Organization;
import com.example.eurekaclient.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

    private final OrganizationService organizationService;

    @Transactional
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Organization organization1 = Organization.builder()
                .name("조직1")
                .contactName("컨텍1")
                .contactEmail("test1@test.com")
                .contactPhone("010-1111-2222")
                .build();

        Organization organization2 = Organization.builder()
                .name("조직2")
                .contactName("컨텍2")
                .contactEmail("test2@test.com")
                .contactPhone("010-3333-4444")
                .build();

        organizationService.mergeOrganization(organization1);
        organizationService.mergeOrganization(organization2);
    }
}
