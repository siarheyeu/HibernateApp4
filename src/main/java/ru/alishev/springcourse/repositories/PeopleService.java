package ru.alishev.springcourse.repositories;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    @Transactional
}
