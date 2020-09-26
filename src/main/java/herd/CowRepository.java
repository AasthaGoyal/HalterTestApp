package herd;

import org.springframework.data.jpa.repository.JpaRepository;

interface CowRepository extends JpaRepository<Cow, Long> {

}