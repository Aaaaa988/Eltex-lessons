package ru.kiselev;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository <User, Integer> {
}
