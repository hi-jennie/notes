package CS61B.week2;

public class CS61B {
    public static String university = "UC Berkeley";
    public CS61BStudent[] students;
    public String semester;
    public int capacity;

    public CS61B(int capacity,CS61BStudent[] signUps,String semester){
        this.semester = semester;
        students = new CS61BStudent[capacity];
        for (int i = 0; i < capacity; i++) {
            students[i] = signUps[i];
        }



    }

    public int makeStudentsWatchLecture(){
        int cnt = 0;
        for (CS61BStudent student : students) {
            boolean watched = student.watchLecture();
            if(watched){
                cnt++;
            }
        }
        return cnt;
    }

    public static void changeUniversity(String newUniversity){
        university = newUniversity;
    }

//    public void expand(int newCapacity){
//        this.capacity = newCapacity;
//    }
}
