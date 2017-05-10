package android.kalys.androidisaev.test.objects;


import java.util.HashMap;
import java.util.Map;


public class Student {
    private String name;
    private Group group;
    private Map <Subject, String> subjectsMarks;

    public Student(){
    }

    public Student(String name, Group group){
        this.name = name;
        this.group = group;
        subjectsMarks = new HashMap<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Map<Subject, String> getSubjectsMarks() {
        return subjectsMarks;
    }

    public void setSubjectsMarks(Map<Subject, String> subjectsMarks) {
        this.subjectsMarks = subjectsMarks;
    }

    // рассчет среднего балла
    public String countGPA(){
        double valueOfgpa = 0;
        String gpa;
        boolean trulyMark = true;

        for(Map.Entry<Subject, String> entry : subjectsMarks.entrySet()){
            if(entry.getValue() == null && trulyMark){
                System.out.println("Средняя оценка может быть неправильной так как студент не получил все оценки.");
                trulyMark = false;
            }
            try {
                valueOfgpa = valueOfgpa + Double.parseDouble(entry.getValue());
            }catch (NullPointerException ex){
                //
            }

        }

        valueOfgpa = valueOfgpa / subjectsMarks.size();

        gpa = String.format("%.1f", valueOfgpa);

        return gpa;
    }

    @Override
    public String toString(){
        return "Имя: " + name + ". Группа: " + group.getName();
    }

    //вывод всех оценок и средней оценки
    public void printMarks(){
        System.out.println(toString() + ". Оценки:");
        for(Map.Entry<Subject, String> entry : subjectsMarks.entrySet()){
             System.out.println("Предмет: " + entry.getKey().getName() + ". Оценка: " + entry.getValue());
        }
        System.out.println("Средняя оценка: " + countGPA());

    }


}
