package crmsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import crmsystem.entity.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Long> {
}
