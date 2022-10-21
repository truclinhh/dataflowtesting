import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Student {
    private double midTermScore;
    private int absentLectures;

    public Student() {
    }

    public Student(double midTermScore, int absentLectures) {
        this.midTermScore = midTermScore;
        this.absentLectures = absentLectures;
    }

    public int validate(int midTermScore, int absentLectures) {
        if (midTermScore < 0) return -1;
        if (midTermScore > 10) return -1;
        if (absentLectures < 0) return -1;
        if (absentLectures > 15) return -1;
        if (midTermScore >= 4 && absentLectures < 3) return 1;
        return 0;
    }
}