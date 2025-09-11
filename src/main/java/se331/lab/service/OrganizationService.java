package se331.lab.service;

import org.springframework.data.domain.Page;
import se331.lab.entity.Organization;
import java.util.List;

public interface OrganizationService {
    Integer getOrganizationSize();
    Page<Organization> getOrganizations(Integer pageSize, Integer page);
    Organization getOrganization(Long id);
    Organization save(Organization organization);
}