package DesignPatterns.Prototype;


class Request implements Cloneable {
    private String clientName;
    private int Age;
    private String job;

    public Request(String clientName, int age, String job) {
        this.clientName = clientName;
        Age = age;
        this.job = job;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Request clone() throws CloneNotSupportedException {
        return (Request) super.clone();
    }

    @Override
    public String toString() {
        return "Request{" +
                "clientName='" + clientName + '\'' +
                ", Age=" + Age +
                ", job='" + job + '\'' +
                '}';
    }
}

/**
 * Встречаются ситуации, когда инициализация объекта
 * некоторого класса занимает много ресурсов/времени.
 * В таком случае, для того чтобы избежать частого
 * создания объектов этого путем инициализации,
 * используют клонирование уже существующих объектов-прототипов,
 * такое решение называют шаблоном прототип
 */
public class Test {
    public static void main(String[] args) {
        Request request = new Request("lordrp", 20, "coder");
        try {
            Request userRequest = request.clone();
            //изменение параметров
            userRequest.setAge(30);
            //тут мог бы осуществляться какой - нить поиск
            //search(userRequest)
            System.out.println(userRequest);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();//объект не поддерживает клонирование
        }

    }
}