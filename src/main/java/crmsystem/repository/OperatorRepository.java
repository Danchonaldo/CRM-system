package crmsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import crmsystem.entity.Operators;

@Repository
public interface OperatorRepository extends JpaRepository<Operators, Long> {
}