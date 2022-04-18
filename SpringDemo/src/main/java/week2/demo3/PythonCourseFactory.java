package week2.demo3;

public class PythonCourseFactory implements CourseFactory{
    @Override
    public INote createNote() {
        return new PythonNode();
    }

    @Override
    public IVideo createVideo() {
        return new PythonVideo();
    }
}
