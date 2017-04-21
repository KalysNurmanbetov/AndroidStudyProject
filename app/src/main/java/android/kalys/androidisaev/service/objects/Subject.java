package android.kalys.androidisaev.service.objects;

/**
 * Created by kalys on 19.04.17.
 */

public class Subject {
    private String name;
    private String evaluation;

    public Subject(String name, String evaluation){
        this.name = name;
        this.evaluation = evaluation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String toString(){
        return "[ Название предмета: " + name + " | Оценка: " + evaluation + " ]";
    }
}
