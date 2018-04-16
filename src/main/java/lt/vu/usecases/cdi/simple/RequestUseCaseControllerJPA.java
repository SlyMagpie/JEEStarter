package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Cable;
import lt.vu.entities.Course;
import lt.vu.entities.Lectureroom;
import lt.vu.entities.Student;
import lt.vu.usecases.cdi.dao.CableDAO;
import lt.vu.usecases.cdi.dao.CourseDAO;
import lt.vu.usecases.cdi.dao.LectureroomDAO;
import lt.vu.usecases.cdi.dao.StudentDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerJPA {

    @Getter
    private Course course = new Course();
    @Getter
    private Student student = new Student();
    @Getter
    private Lectureroom lectureroom = new Lectureroom();
    @Getter
    private Cable cable = new Cable();
    @Getter
    private List<Student> allStudents;
    @Getter
    private List<Lectureroom> allLecturerooms;

    @PostConstruct
    public void init() {
        loadAllStudents();
        loadAllLecturerooms();
    }

    @Inject
    private CourseDAO courseDAO;
    @Inject
    private StudentDAO studentDAO;
    @Inject
    private CableDAO cableDAO;
    @Inject
    private LectureroomDAO lectureroomDAO;

    @Transactional
    public void createCourseStudent() {
        student.getCourseList().add(course);
        course.getStudentList().add(student);
        courseDAO.create(course);
        studentDAO.create(student);
        log.info("Maybe OK...");
    }

    @Transactional
    public void createLectureroomCable() {
        lectureroom.getCableList().add(cable);
        cable.getLectureroomList().add(lectureroom);
        cableDAO.create(cable);
        lectureroomDAO.create(lectureroom);
        log.info("Maybe, maybe, maybe ooooh");
    }

    private void loadAllStudents() {
        allStudents = studentDAO.getAllStudents();
    }
    private void loadAllLecturerooms() {
        allLecturerooms = lectureroomDAO.getAllLecturerooms();
    }
}
