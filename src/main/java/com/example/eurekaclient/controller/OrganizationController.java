package com.example.eurekaclient.controller;

import com.example.eurekaclient.entity.Organization;
import com.example.eurekaclient.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vi/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @GetMapping("/{organizationId}")
    public ResponseEntity getOrganization(@PathVariable Long organizationId) {
        Organization organization = organizationService.getOrganization(organizationId);
        return ResponseEntity.ok(organization);
    }

    @PutMapping("/{organizationId}")
    public ResponseEntity mergeOrganization(@RequestBody Organization request) {
        Organization organization = organizationService.mergeOrganization(request);
        return ResponseEntity.ok(organization);
    }

    @DeleteMapping("/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable Long organizationId) {
        organizationService.deleteOrganization(organizationId);
    }


}
