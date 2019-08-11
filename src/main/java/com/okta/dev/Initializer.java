package com.okta.dev;

import com.okta.dev.model.Event;
import com.okta.dev.model.Group;
import com.okta.dev.repository.GroupRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
class Initializer implements CommandLineRunner {

    private final GroupRepository repository;

    public Initializer(GroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) {
        Stream.of("Denver", "Utah", "Seattle",
                "Richmond").forEach(name ->
                repository.save(new Group(name))
        );

        Group d = repository.findByName("Denver");
        Event e = Event.builder().title("Full Stack Reactive")
                .description("Reactive with Spring Boot + React")
                .date(Instant.parse("2019-08-10T18:00:00.000Z"))
                .build();
        d.setEvents(Collections.singleton(e));
        repository.save(d);

        repository.findAll().forEach(System.out::println);
    }
}