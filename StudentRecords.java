import java.io.*;
import java.util.Scanner;

class StudentRecords {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void addRecords() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("studentRecords.txt", true)));
        String name, Student_class;
        int roll_no, grnumber;
        String s;
        boolean addMore;

        do {
            System.out.print("\nEnter name: ");
            name = br.readLine();
            System.out.print("Class: ");
            Student_class = br.readLine();
            System.out.print("Roll number: ");
            roll_no = Integer.parseInt(br.readLine());
            System.out.print("Grade number: ");
            grnumber = Integer.parseInt(br.readLine());

            pw.println(name);
            pw.println(Student_class);
            pw.println(roll_no);
            pw.println(grnumber);

            System.out.print("\nRecords added successfully!\n\nDo you want to add more records? (y/n): ");
            s = br.readLine();
            addMore = s.equalsIgnoreCase("y");

        } while (addMore);

        pw.close();
        showMenu();
    }

    public void readRecords() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("studentRecords.txt"));
        String name;
        int i = 1;

        while ((name = file.readLine()) != null) {
            System.out.println("S.No.: " + (i++));
            System.out.println("-------------");
            System.out.println("\nName: " + name);
            System.out.println("Student Class: " + file.readLine());
            System.out.println("Roll number: " + file.readLine());
            System.out.println("Grade Number: " + file.readLine());
            System.out.println();
        }
        file.close();
        showMenu();
    }

    public void clear() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("studentRecords.txt")));
        pw.close();
        System.out.println("\nAll Records cleared successfully!");
        for (int i = 0; i < 999999999; i++); // Wait for some time
        showMenu();
    }

    public void showMenu() throws IOException {
        System.out.print("1: Add Records\n2: Display Records\n3: Clear All Records\n4: Exit\n\nYour Choice: ");
        int choice = Integer.parseInt(br.readLine());

        switch (choice) {
            case 1: addRecords(); break;
            case 2: readRecords(); break;
            case 3: clear(); break;
            case 4: System.exit(1); break;
            default: System.out.println("\nInvalid Choice!"); break;
        }
    }

    public static void main(String args[]) throws IOException {
        StudentRecords call = new StudentRecords();
        call.showMenu();
    }
}
