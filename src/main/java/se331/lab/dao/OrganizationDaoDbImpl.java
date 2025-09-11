package se331.lab.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organization;
import se331.lab.repository.OrganizationRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class OrganizationDaoDbImpl implements OrganizationDao {
    final OrganizationRepository organizationRepository;

    @Override
    public Integer getOrganizationSize() {
        return Math.toIntExact(organizationRepository.count());
    }

    @Override
    public Page<Organization> getOrganizations(Integer pageSize, Integer page) {
        // Handle null parameters with defaults
        int size = pageSize != null ? pageSize : 3;
        int pageNum = page != null ? page : 1;

        return organizationRepository.findAll(PageRequest.of(pageNum - 1, size));
    }

    @Override
    public Organization getOrganization(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    @Override
    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }
}