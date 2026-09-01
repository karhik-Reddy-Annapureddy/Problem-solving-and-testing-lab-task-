1. Determine if String Halves Are Alike
You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
Return true if a and b are alike. Otherwise, return false.
Example 1:
Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
Example 2:
Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.
Program:
class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int vowelBalance = 0;
        
        // Loop through both halves simultaneously
        for (int i = 0; i < n / 2; i++) {
            if (isVowel(s.charAt(i))) {
                vowelBalance++;
            }
            if (isVowel(s.charAt(i + n / 2))) {
                vowelBalance--;
            }
        }
        
        return vowelBalance == 0;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
2.Lapindromes
Lapindrome is defined as a string which when split in the middle, gives two halves having the same characters and same frequency of each character. If there are odd number of characters in the string, we ignore the middle character and check for lapindrome. For example gaga is a lapindrome, since the two halves ga and ga have the same characters with same frequency. Also, abccab, rotor and xyzxy are a few examples of lapindromes. Note that abbaab is NOT a lapindrome. The two halves contain the same characters but their frequencies do not match.
Your task is simple. Given a string, you need to tell if it is a lapindrome.

Input:
First line of input contains a single integer T, the number of test cases.
Each test is a single line containing a string S composed of only lowercase English alphabet.
Output:
For each test case, output on a separate line: "YES" if the string is a lapindrome and "NO" if it is not.
Constraints:
1 ≤ T ≤ 100
2 ≤ |S| ≤ 1000, where |S| denotes the length of S
Sample 1:
Input
Output
6
gaga
abcde
rotor
xyzxy
abbaab
ababc
YES
NO
YES
YES
NO
NO
Program:
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            if (isLapindrome(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    private static boolean isLapindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        
        int firstHalfEnd = n / 2;
        int secondHalfStart = (n % 2 == 0) ? n / 2 : (n / 2) + 1;
        
        // Count frequencies for the first half
        for (int i = 0; i < firstHalfEnd; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Subtract frequencies for the second half
        for (int i = secondHalfStart; i < n; i++) {
            freq[s.charAt(i) - 'a']--;
        }
        
        // Verify all character frequencies net to 0
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}

3.Compare the Triplets
Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from 1 to 100 for three categories: problem clarity, originality, and difficulty.

The rating for Alice's challenge is the triplet a = (a[0], a[1], a[2]), and the rating for Bob's challenge is the triplet b = (b[0], b[1], b[2]).

The task is to calculate their comparison points by comparing each category:

If a[i] > b[i], then Alice is awarded 1 point.
If a[i] < b[i], then Bob is awarded 1 point.
If a[i] = b[i], then neither person receives a point.
Example

a = [1, 2, 3]
b = [3, 2, 1]

For elements *0*, Bob is awarded a point because a[0] < b[0].
For the equal elements a[1] and b[1], no points are earned.
Finally, for elements 2, a[2] > b[2] so Alice receives a point.
The return array is [1, 1] with Alice's score first and Bob's second.

Function Description

Complete the function compareTriplets with the following parameter(s):

int a[3]: Alice's challenge rating
int b[3]: Bob's challenge rating
Returns

int[2]: the first element is Alice's score and the second is Bob's score
Input Format

The first line contains 3 space-separated integers, a[0], a[1], and a[2], the respective values in triplet a.
The second line contains 3 space-separated integers, b[0], b[1], and b[2], the respective values in triplet b.

Constraints

1 ≤ a[i] ≤ 100
1 ≤ b[i] ≤ 100
Sample Input 0

5 6 7
3 6 10
Sample Output 0

1 1
Program:
import java.io.*;
import java.util.*;

public class Solution {

    // Complete the compareTriplets function below.
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceScore = 0;
        int bobScore = 0;

        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i)) {
                aliceScore++;
            } else if (a.get(i) < b.get(i)) {
                bobScore++;
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        result.add(aliceScore);
        result.add(bobScore);

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            a.add(Integer.parseInt(aTemp[i]));
        }

        String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> b = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            b.add(Integer.parseInt(bTemp[i]));
        }

        List<Integer> result = compareTriplets(a, b);

        System.out.println(result.get(0) + " " + result.get(1));

        bufferedReader.close();
    }
}
4.Contains Duplicate
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

 

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true
Program:
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // HashSet.add() returns false if the element was already present
            if (!seen.add(num)) {
                return true;
            }
        }
        
        return false;
    }
}
5.Time Conversion
30 more points to get your first star!
Rank: 6389360|Points: 0/30
Problem Solving
Problem
Submissions
Leaderboard
Discussions
Editorial
Given a time in -hour AM/PM format, convert it to military (24-hour) time.

Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
- 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

Example


Return '12:01:00'.


Return '00:01:00'.

Function Description

Complete the  function with the following parameter(s):

: a time in  hour format
Returns

: the time in  hour format
Input Format

A single string  that represents a time in -hour clock format (i.e.:  or ).

Constraints

All input times are valid
Sample Input 0

07:05:45PM
Sample Output 0

19:05:45
Program:
import java.io.*;

public class Solution {
    public static String timeConversion(String s) {
        String modifier = s.substring(8, 10);
        int hour = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, 8);
        if (modifier.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }
        return String.format("%02d%s", hour, rest);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String result = timeConversion(s);
        System.out.println(result);
        bufferedReader.close();
    }
}
6.Move Zeroes
Easy
Topics
premium lock icon
Companies
Hint
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
Program:
class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        
        // Shift all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        
        // Fill remaining positions with zeroes
        while (insertPos < nums.length) {
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}
7.Diagonal Difference
30 more points to get your first star!
Rank: 6389362|Points: 0/30
Problem Solving
Problem
Submissions
Leaderboard
Discussions
Editorial
Given a square matrix, calculate the absolute difference between the sums of its diagonals.

For example, the square matrix  is shown below:

1 2 3
4 5 6
9 8 9  
The left-to-right diagonal = .
The right-to-left diagonal = .
Their absolute difference is .

Function description

Complete the  function with the following parameter:

: a 2-D array of integers
Return

: the absolute difference in sums along the diagonals
Input Format

The first line contains a single integer, , the number of rows and columns in the square matrix .
Each of the next  lines describes a row, , and consists of  space-separated integers .

Constraints

Sample Input

STDIN      Function
-----      --------
3           arr[][] sizes n = 3, m = 3
11 2 4     arr = [[11, 2, 4], [4, 5, 6], [10, 8, -12]]
4 5 6
10 8 -12
Sample Output

15
Program:

import java.io.*;
import java.util.*;

public class Solution {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        int n = arr.size();

        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += arr.get(i).get(i);
            secondaryDiagonalSum += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            String[] rowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                row.add(Integer.parseInt(rowItems[j]));
            }
            arr.add(row);
        }

        int result = diagonalDifference(arr);
        System.out.println(result);

        bufferedReader.close();
    }
}
8. Transpose Matrix
Easy
Topics
premium lock icon
Companies
Hint
Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.



 

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
Program:

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;        // Number of rows
        int n = matrix[0].length;     // Number of columns
        
        int[][] result = new int[n][m];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                result[c][r] = matrix[r][c];
            }
        }
        
        return result;
    }
}

9.. Matrix Block Sum
Medium
Topics
premium lock icon
Companies
Hint
Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:

i - k <= r <= i + k,
j - k <= c <= j + k, and
(r, c) is a valid position in the matrix.
 

Example 1:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]
Example 2:

Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]
Program:
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 1-indexed prefix sum matrix
        int[][] pref = new int[m + 1][n + 1];
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                pref[r + 1][c + 1] = mat[r][c] + pref[r][c + 1] + pref[r + 1][c] - pref[r][c];
            }
        }
        
        int[][] answer = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Determine 0-indexed bounded coordinates for the k-block
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // Convert to 1-indexed query on prefix matrix
                answer[i][j] = pref[r2 + 1][c2 + 1] - pref[r1][c2 + 1] - pref[r2 + 1][c1] + pref[r1][c1];
            }
        }
        
        return answer;
    }
}
10.Matrix Layer Rotation
30 more points to get your first star!
Rank: 6389366|Points: 0/30
Problem Solving
Problem
Submissions
Leaderboard
Discussions
Editorial
You are given a 2D matrix of dimension  and a positive integer . You have to rotate the matrix  times and print the resultant matrix. Rotation should be in anti-clockwise direction.

Rotation of a  matrix is represented by the following figure. Note that in one rotation, you have to shift elements by one step only.

matrix-rotation

It is guaranteed that the minimum of m and n will be even.

As an example rotate the Start matrix by 2:

    Start         First           Second
     1 2 3 4       2  3  4  5      3  4  5  6
    12 1 2 5  ->   1  2  3  6 ->   2  3  4  7
    11 4 3 6      12  1  4  7      1  2  1  8
    10 9 8 7      11 10  9  8     12 11 10  9
Function Description

Complete the matrixRotation function in the editor below.

matrixRotation has the following parameter(s):

int matrix[m][n]: a 2D array of integers
int r: the rotation factor
Prints
It should print the resultant 2D integer array and return nothing. Print each row on a separate line as space-separated integers.

Input Format

The first line contains three space separated integers, , , and , the number of rows and columns in , and the required rotation.
The next  lines contain  space-separated integers representing the elements of a row of .
Program:
import java.io.*;
import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numLayers = Math.min(m, n) / 2;

        for (int layer = 0; layer < numLayers; layer++) {
            List<Integer> elements = new ArrayList<Integer>();

            int top = layer;
            int bottom = m - 1 - layer;
            int left = layer;
            int right = n - 1 - layer;

            // 1. Traverse left column (top to bottom)
            for (int i = top; i <= bottom; i++) {
                elements.add(matrix.get(i).get(left));
            }
            // 2. Traverse bottom row (left + 1 to right)
            for (int j = left + 1; j <= right; j++) {
                elements.add(matrix.get(bottom).get(j));
            }
            // 3. Traverse right column (bottom - 1 down to top)
            for (int i = bottom - 1; i >= top; i--) {
                elements.add(matrix.get(i).get(right));
            }
            // 4. Traverse top row (right - 1 down to left + 1)
            for (int j = right - 1; j > left; j--) {
                elements.add(matrix.get(top).get(j));
            }

            // Calculate effective rotation shift
            int total = elements.size();
            int shift = r % total;

            // 5. Place elements back in rotated position
            int idx = shift;

            // Fill left column
            for (int i = top; i <= bottom; i++) {
                matrix.get(i).set(left, elements.get(idx));
                idx = (idx + 1) % total;
            }
            // Fill bottom row
            for (int j = left + 1; j <= right; j++) {
                matrix.get(bottom).set(j, elements.get(idx));
                idx = (idx + 1) % total;
            }
            // Fill right column
            for (int i = bottom - 1; i >= top; i--) {
                matrix.get(i).set(right, elements.get(idx));
                idx = (idx + 1) % total;
            }
            // Fill top row
            for (int j = right - 1; j > left; j--) {
                matrix.get(top).set(j, elements.get(idx));
                idx = (idx + 1) % total;
            }
        }

        // Print final matrix
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix.get(i).get(j)).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().trim().split(" ");
        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<List<Integer>>();

        for (int i = 0; i < m; i++) {
            String[] rowItems = bufferedReader.readLine().trim().split(" ");
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
           
