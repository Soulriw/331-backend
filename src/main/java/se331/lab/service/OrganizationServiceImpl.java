package se331.lab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.lab.dao.OrganizationDao;
import se331.lab.entity.Organization;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    final OrganizationDao organizationDao;

    @Override
    public Integer getOrganizationSize() {
        return organizationDao.getOrganizationSize();
    }

    @Override
    public Page<Organization> getOrganizations(Integer pageSize, Integer page) {
        return organizationDao.getOrganizations(pageSize, page);
    }

    @Override
    public Organization getOrganization(Long id) {
        return organizationDao.getOrganization(id);
    }

    @Override
    public Organization save(Organization organization) {
        return organizationDao.save(organization);
    }
}