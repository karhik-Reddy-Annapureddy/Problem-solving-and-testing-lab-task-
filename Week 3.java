1.Java Date and Time

The Calendar class is an abstract class that provides methods for converting between a specific instant in time and a set of calendar fields such as YEAR, MONTH, DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar fields, such as getting the date of the next week.

You are given a date. You just need to write the method, , which returns the day on that date. To simplify your task, we have provided a portion of the code in the editor.

Example

The method should return  as the day on that date.
Function Description
Complete the findDay function in the editor below.
findDay has the following parameters:
int: month
int: day
int: year
Returns
string: the day of the week in capital letters
Input Format
A single line of input containing the space separated month, day and year, respectively, in    format.
Constraints
Sample Input
08 05 2015
Sample Output
WEDNESDAY
Explanation
The day on August th  was WEDNESDAY.
Program:
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
2. Number of Days Between Two Dates
Write a program to count the number of days between two dates.
The two dates are given as strings, their format is YYYY-MM-DD as shown in the examples.
Example 1:
Input: date1 = "2019-06-29", date2 = "2019-06-30"
Output: 1
Example 2:
Input: date1 = "2020-01-15", date2 = "2019-12-31"
Output: 15
Program:
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);
        
        return (int) Math.abs(ChronoUnit.DAYS.between(d1, d2));
    }
}
3. Day of the Year
Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.
Example 1:
Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.
Example 2:
Input: date = "2019-02-10"
Output: 41
Program:
import java.time.LocalDate;

class Solution {
    public int dayOfYear(String date) {
        return LocalDate.parse(date).getDayOfYear();
    }
}

4. Day of the Week

Given a date, return the corresponding day of the week for that date.
The input is given as three integers representing the day, month and year respectively.
Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
Note: January 1, 1971 was a Friday.
Example 1:
Input: day = 31, month = 8, year = 2019
Output: "Saturday"
Example 2:
Input: day = 18, month = 7, year = 1999
Output: "Sunday"
Example 3:
Input: day = 15, month = 8, year = 1993
Output: "Sunday"
Program:
import java.time.LocalDate;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        String dayOfWeek = date.getDayOfWeek().name(); // E.g., "SATURDAY"
        
        // Convert "SATURDAY" -> "Saturday"
        return dayOfWeek.substring(0, 1) + dayOfWeek.substring(1).toLowerCase();
    }
}
5.Java Priority Queue
In computer science, a priority queue is an abstract data type which is like a regular queue, but where additionally each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority. - Wikipedia
In this problem we will test your knowledge on Java Priority Queue.
There are a number of students in a school who wait to be served. Two types of events, ENTER and SERVED, can take place which are described below.
ENTER: A student with some priority enters the queue to be served.
SERVED: The student with the highest priority is served (removed) from the queue.
A unique id is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):
The student having the highest Cumulative Grade Point Average (CGPA) is served first.
Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
Any students having the same CGPA and name will be served in ascending order of the id.
Create the following two classes:

The Student class should implement:
The constructor Student(int id, String name, double cgpa).
The method int getID() to return the id of the student.
The method String getName() to return the name of the student.
The method double getCGPA() to return the CGPA of the student.
The Priorities class should implement the method List<Student> getStudents(List<String> events) to process all the given events and return all the students yet to be served in the priority order.
Input Format
The first line contains an integer, , describing the total number of events. Each of the  subsequent lines will be of the following two forms:
ENTER name CGPA id: The student to be inserted into the priority queue.
SERVED: The highest priority student in the queue was served.
The locked stub code in the editor reads the input and tests the correctness of the Student and Priorities classes implementation.
Constraints
Output Format
The locked stub code prints the names of the students yet to be served in the priority order. If there are no such student, then the code prints EMPTY.
Sample Input 0
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
Sample Output 0
Dan
Ashley
Shafaet
Maria
Program:
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// Student class storing individual student details
class Student {
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

// Priorities class processing incoming events
class Priorities {
    public List<Student> getStudents(List<String> events) {
        // Priority order:
        // 1. Highest CGPA (Descending)
        // 2. Name in Alphabetical Order (Ascending)
        // 3. Lowest ID (Ascending)
        Comparator<Student> studentComparator = Comparator
                .comparing(Student::getCGPA, Comparator.reverseOrder())
                .thenComparing(Student::getName)
                .thenComparing(Student::getID);

        PriorityQueue<Student> pq = new PriorityQueue<>(studentComparator);

        for (String event : events) {
            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);

                pq.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                pq.poll();
            }
        }

        // Empty the queue into a list to ensure total order output
        List<Student> remainingStudents = new ArrayList<>();
        while (!pq.isEmpty()) {
            remainingStudents.add(pq.poll());
        }

        return remainingStudents;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
6.Java Arraylist
Sometimes it's better to use dynamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.
You are given  lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in  position of  line.
Take your input from System.in.
Input Format
The first line has an integer . In each of the next  lines there will be an integer  denoting number of integers on that line and then there will be  space-separated integers. In the next line there will be an integer  denoting number of queries. Each query will consist of two integers  and .
Constraints
Each number will fit in signed integer.
Total number of integers in  lines will not cross .
Output Format
In each line, output the number located in  position of  line. If there is no such position, just print "ERROR!"
Sample Input
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
Sample Output

74
52
37
ERROR!
ERROR!
Program:
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<List<Integer>> lines = new ArrayList<>();

        // Read all n lines
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt();
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(scanner.nextInt());
            }
            lines.add(line);
        }

        int q = scanner.nextInt();

        // Process queries
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt(); // 1-based line index
            int y = scanner.nextInt(); // 1-based element index

            // Convert 1-based indexing to 0-based for ArrayList access
            int lineIndex = x - 1;
            int elementIndex = y - 1;

            // Bounds checking before accessing the list
            if (lineIndex >= 0 && lineIndex < lines.size() &&
                elementIndex >= 0 && elementIndex < lines.get(lineIndex).size()) {
                System.out.println(lines.get(lineIndex).get(elementIndex));
            } else {
                System.out.println("ERROR!");
            }
        }

        scanner.close();
    }
}
7. Largest Number
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.
Example 1:
Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"
Program:
import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert integer array to String array
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator: compare concatenated combinations (b + a) vs (a + b)
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if after sorting, the largest number is "0", result is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build final string result
        StringBuilder result = new StringBuilder();
        for (String numStr : strNums) {
            result.append(numStr);
        }

        return result.toString();
    }
}
8.Java Comparator
Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array.
The Player class is provided for you in your editor. It has  fields: a  String and a  integer.
Given an array of  Player objects, write a comparator that sorts them in order of decreasing score; if  or more players have the same score, sort those players alphabetically by name. To do this, you must create a Checker class that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.
Input Format
Input from stdin is handled by the locked stub code in the Solution class.
The first line contains an integer, , denoting the number of players.
Each of the  subsequent lines contains a player's  and , respectively.
Constraints
 players can have the same name.
Player names consist of lowercase English letters.
Output Format
You are not responsible for printing any output to stdout. The locked stub code in Solution will create a Checker object, use it to sort the Player array, and print each sorted element.
Sample Input
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
Sample Output
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
Program:
import java.util.*;

// Write your Checker class here
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        // Primary check: compare scores in descending order
        if (a.score != b.score) {
            return b.score - a.score;
        }
        
        // Secondary check: compare names alphabetically (ascending)
        return a.name.compareTo(b.name);
    }
}

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for (int i = 0; i < player.length; i++) {
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}


9. Sort the People
You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
For each index i, names[i] and heights[i] denote the name and height of the ith person.
Return names sorted in descending order by the people's heights.
Example 1:
Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.
Example 2:
Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob
Program:
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // Map height -> name in reverse order (descending by height)
        Map<Integer, String> heightToName = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < names.length; i++) {
            heightToName.put(heights[i], names[i]);
        }

        String[] sortedNames = new String[names.length];
        int idx = 0;
        for (String name : heightToName.values()) {
            sortedNames[idx++] = name;
        }

        return sortedNames;
    }
}



