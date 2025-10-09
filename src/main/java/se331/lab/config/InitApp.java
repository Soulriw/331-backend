package se331.lab.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.entity.Participant;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;
import se331.lab.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Organizer org1, org2, org3;
        Event tempEvent;

        org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder().name("Chiang Mai Cultural Center").build());

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .participants(new ArrayList<>())
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for Celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .participants(new ArrayList<>())
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Research Conference")
                .description("Annual research presentation day")
                .location("CMU Conference Center")
                .date("15th March")
                .time("9.00am - 5.00 pm.")
                .petAllowed(false)
                .participants(new ArrayList<>())
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(false)
                .participants(new ArrayList<>())
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .participants(new ArrayList<>())
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Flower Festival")
                .description("Beautiful flower displays and parades")
                .location("Chiang Mai City Center")
                .date("1st February")
                .time("6.00am - 6.00 pm.")
                .petAllowed(true)
                .participants(new ArrayList<>())
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);

        // -----------------------
        // ✅ Add participants
        // -----------------------
        Participant p1 = participantRepository.save(Participant.builder().name("Alice").telNo("081-111-1111").eventHistory(new ArrayList<>()).build());
        Participant p2 = participantRepository.save(Participant.builder().name("Bob").telNo("082-222-2222").eventHistory(new ArrayList<>()).build());
        Participant p3 = participantRepository.save(Participant.builder().name("Charlie").telNo("083-333-3333").eventHistory(new ArrayList<>()).build());
        Participant p4 = participantRepository.save(Participant.builder().name("Dao").telNo("084-444-4444").eventHistory(new ArrayList<>()).build());
        Participant p5 = participantRepository.save(Participant.builder().name("Ekk").telNo("085-555-5555").eventHistory(new ArrayList<>()).build());
        Participant p6 = participantRepository.save(Participant.builder().name("Fern").telNo("086-666-6666").eventHistory(new ArrayList<>()).build());
        Participant p7 = participantRepository.save(Participant.builder().name("Golf").telNo("087-777-7777").eventHistory(new ArrayList<>()).build());
        Participant p8 = participantRepository.save(Participant.builder().name("Hana").telNo("088-888-8888").eventHistory(new ArrayList<>()).build());
        Participant p9 = participantRepository.save(Participant.builder().name("Ice").telNo("089-999-9999").eventHistory(new ArrayList<>()).build());

        List<Event> allEvents = eventRepository.findAll();

        // ✅ P1–P3 attend 3 events each
        add(p1, allEvents.get(0)); add(p1, allEvents.get(1)); add(p1, allEvents.get(2));
        add(p2, allEvents.get(1)); add(p2, allEvents.get(2)); add(p2, allEvents.get(3));
        add(p3, allEvents.get(2)); add(p3, allEvents.get(3)); add(p3, allEvents.get(4));

        // Fill others so each event has at least 3 participants
        add(p4, allEvents.get(0)); add(p5, allEvents.get(0));
        add(p6, allEvents.get(1)); add(p7, allEvents.get(1));
        add(p8, allEvents.get(3));
        add(p9, allEvents.get(4)); add(p4, allEvents.get(4));
        add(p5, allEvents.get(5)); add(p6, allEvents.get(5)); add(p7, allEvents.get(5));

        // ensure every event has ≥3 participants
        for (Event ev : allEvents) {
            while (ev.getParticipants().size() < 3) {
                Participant filler = participantRepository.findAll().get((int)(Math.random() * 9));
                add(filler, ev);
            }
        }
    }

    private void add(Participant p, Event e) {
        if (!p.getEventHistory().contains(e)) {
            p.getEventHistory().add(e);
        }
        if (!e.getParticipants().contains(p)) {
            e.getParticipants().add(p);
        }
    }
}
