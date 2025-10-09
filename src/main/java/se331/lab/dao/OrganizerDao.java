package se331.lab.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.entity.Organizer;

public interface OrganizerDao {
    Page<Organizer> getOrganizer(Pageable pageable);
}
