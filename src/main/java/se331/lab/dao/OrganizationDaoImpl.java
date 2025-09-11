package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organization;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizationDaoImpl implements OrganizationDao {
    List<Organization> organizationList;

    @PostConstruct
    public void init() {
        organizationList = new ArrayList<>();
        organizationList.add(Organization.builder()
                .id(1L)
                .organizationName("Kat Laydee Foundation")
                .address("123 Pet Street, Meow Town")
                .build());
        organizationList.add(Organization.builder()
                .id(2L)
                .organizationName("Fern Pollin Gardens")
                .address("456 Garden Ave, Flora City")
                .build());
        organizationList.add(Organization.builder()
                .id(3L)
                .organizationName("Carey Wales Environmental")
                .address("789 Beach Blvd, Playa Del Carmen")
                .build());
        organizationList.add(Organization.builder()
                .id(4L)
                .organizationName("Dawg Dahd Rescue")
                .address("321 Dog Lane, Woof Town")
                .build());
        organizationList.add(Organization.builder()
                .id(5L)
                .organizationName("Kahn Opiner Charity")
                .address("654 Charity Road, Tin City")
                .build());
        organizationList.add(Organization.builder()
                .id(6L)
                .organizationName("Brody Kill Services")
                .address("987 Service Drive, Highway 50")
                .build());
    }

    @Override
    public Integer getOrganizationSize() {
        return organizationList.size();
    }

    @Override
    public Page<Organization> getOrganizations(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizationList.size() : pageSize;
        page = page == null ? 1 : page;
        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Organization>(organizationList.subList(firstIndex, Math.min(firstIndex + pageSize, organizationList.size())),
                PageRequest.of(page - 1, pageSize), organizationList.size());
    }

    @Override
    public Organization getOrganization(Long id) {
        return organizationList.stream().filter(organization -> organization.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organization save(Organization organization) {
        organization.setId(organizationList.get(organizationList.size() - 1).getId() + 1);
        organizationList.add(organization);
        return organization;
    }
}