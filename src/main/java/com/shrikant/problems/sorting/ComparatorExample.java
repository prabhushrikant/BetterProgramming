package com.shrikant.problems.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ComparatorExample {

    public List<Student> sortStudentsByNaturalOrder(List<Student> students) {
        Collections.sort(students);
        return students;
    }

    public List<Student> sortStudentsByRollNoAscending(List<Student> students) {
        students.sort((s1, s2) -> Integer.compare(s1.rank, s2.rank));
        return students;
    }

    public List<Student> sortStudentsByNameDescending(List<Student> students) {
        students.sort((s1, s2) -> s2.name.compareTo(s1.name));
        return students;
    }

    public List<Student> sortStudentsByRollNoAndAddressAscending(List<Student> students) {
        students.sort((s1, s2) -> Comparator
            .comparingInt((Student s) -> s.rank)
            .thenComparing(s -> s.address)
            .compare(s1, s2));
        return students;
    }

    public List<Student> sortStudentsByRollNoAndNameDescending(List<Student> students) {
        students.sort((s1, s2) -> Comparator
            .comparingInt((Student s) -> s.rank).reversed()
            .thenComparing((s) -> s.name, Comparator.reverseOrder())
            .compare(s1, s2));
        return students;
    }

    public List<Student> sortStudentsByRollNoAscAndNameDescending(List<Student> students) {
        students.sort((s1, s2) -> Comparator
            .comparingInt((Student s) -> s.rank)
            .thenComparing((s) -> s.name, Comparator.reverseOrder())
            .compare(s1, s2));
        return students;
    }

    static class Student implements Comparable<Student>
    { 
        int rank; 
        String name, address; 

        // Constructor 
        public Student(int rank, String name, 
                                String address) 
        { 
            this.rank = rank; 
            this.name = name; 
            this.address = address; 
        } 

        // Used to print student details in main() 
        public String toString() 
        { 
            return this.rank + " " + this.name + 
                            " " + this.address; 
        }
        
        @Override
        public boolean equals(Object st) {
            if (this == st)
                return true;
            if (st == null || getClass() != st.getClass())
                return false;
            Student s = (Student) st;
            return this.rank == s.rank && 
            this.name.equals(s.name) && 
            this.address.equals(s.address);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(this.rank, this.name, this.address);
            return result;
        }

        //natural sorting order rollno ascending followed by name ascending
        @Override
        public int compareTo(Student st)    
        { 
            if (this.rank != st.rank)
                return this.rank - st.rank;
            //else sort by name ascending
            return this.name.compareTo(st.name); 
        }
    }
}
