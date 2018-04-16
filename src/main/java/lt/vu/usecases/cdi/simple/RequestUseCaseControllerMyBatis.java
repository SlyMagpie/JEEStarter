package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.mydao.CableMapper;
import lt.vu.usecases.mybatis.mydao.CableconnectionMapper;
import lt.vu.usecases.mybatis.mydao.LectureroomMapper;
import lt.vu.usecases.mybatis.mymodel.Cable;
import lt.vu.usecases.mybatis.mymodel.Cableconnection;
import lt.vu.usecases.mybatis.mymodel.Lectureroom;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model // tas pats kaip: @Named ir @RequestScoped
@Slf4j
public class RequestUseCaseControllerMyBatis {

    /*@Getter
    private Course course = new Course();
    @Getter
    private Student student = new Student();
    @Getter
    private List<Student> allStudents;*/

    @Getter
    private Lectureroom lectureroom = new Lectureroom();
    @Getter
    private Cable cable = new Cable();
    @Getter
    private List<Lectureroom> allLecturerooms;

    @PostConstruct
    public void init() {
        //loadAllStudents();
        loadAllLecturerooms();
    }

    /*@Inject
    private StudentMapper studentMapper;
    @Inject
    private CourseMapper courseMapper;
    @Inject
    private StudentCourseMapper studentCourseMapper;*/

    @Inject
    private LectureroomMapper lectureroomMapper;
    @Inject
    private CableMapper cableMapper;
    @Inject
    private CableconnectionMapper cableconnectionMapper;

    /*@Transactional
    public void createCourseStudent() {
        courseMapper.insert(course);
        studentMapper.insert(student);
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setCourseId(course.getId());
        studentCourse.setStudentId(student.getId());
        studentCourseMapper.insert(studentCourse);
        log.info("Maybe OK...");
    }*/

    @Transactional
    public void createLectureroomCable() {
        cableMapper.insert(cable);
        lectureroomMapper.insert(lectureroom);
        Cableconnection cableconnection = new Cableconnection();
        cableconnection.setCableid(cable.getId());
        cableconnection.setRoomid(lectureroom.getId());
        cableconnectionMapper.insert(cableconnection);
        log.info("Maybe OK...");
    }

    /*private void loadAllStudents() {
        allStudents = studentMapper.selectAll();
    }*/

    private void loadAllLecturerooms() {
        allLecturerooms = lectureroomMapper.selectAll();
    }
}
