package se331.lab.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organization;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizationRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizationRepository organizationRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // Initialize Organizations first
        organizationRepository.save(Organization.builder()
                .organizationName("CAMT")
                .address("123 University Ave, Chiang Mai, Thailand")
                .build());
        organizationRepository.save(Organization.builder()
                .organizationName("CMU")
                .address("239 Huay Kaew Road, Chiang Mai, Thailand")
                .build());
        organizationRepository.save(Organization.builder()
                .organizationName("Chiang Mai Municipality")
                .address("Chang Khlan Road, Chiang Mai, Thailand")
                .build());
        organizationRepository.save(Organization.builder()
                .organizationName("Cultural Council")
                .address("456 Cultural Street, Chiang Mai, Thailand")
                .build());
        organizationRepository.save(Organization.builder()
                .organizationName("Tourism Authority")
                .address("789 Tourism Blvd, Chiang Mai, Thailand")
                .build());
        organizationRepository.save(Organization.builder()
                .organizationName("Student Union")
                .address("321 Student Center, Chiang Mai University")
                .build());

        // Initialize Events
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .organizer("CAMT").build());
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for Celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .organizer("CMU").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .organizer("Chiang Mai").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(false)
                .organizer("CAMT").build());
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Research Conference")
                .description("Annual research presentation day")
                .location("CMU Conference Center")
                .date("15th March")
                .time("9.00am - 5.00 pm.")
                .petAllowed(false)
                .organizer("CMU").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Flower Festival")
                .description("Beautiful flower displays and parades")
                .location("Chiang Mai City Center")
                .date("1st February")
                .time("6.00am - 6.00 pm.")
                .petAllowed(true)
                .organizer("Tourism Authority").build());
    }
}