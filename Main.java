package Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to student management app");
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("press 1 to Add student\npress 2 to Delete student\npress 3 to display student\npress 4 to update\npress 5 to Exit app");

            int c = Integer.parseInt(sc.nextLine());
            int x= c;
            if (c == 1) {
                System.out.println(" enter username : ");
               // String name = sc.nextLine();

                System.out.println("enter phone number :");


                System.out.println("enter city name : ");
                String na = sc.nextLine();
                String phone = sc.nextLine();
                String city = sc.nextLine();

                //create object to store student
                Student st = new Student(na,phone,city);
                StudentDao sd = new StudentDao();
             boolean ans = sd.insert(st);
if (ans)
{
    System.out.println(" added succesfully");
}
else {
    System.out.println("something went wrong ");
}

            } else if (x == 2) {
                System.out.println("Enter student id  to delete :");
                String d  = sc.nextLine();
                StudentDao sd = new StudentDao();
                boolean ans1 = sd.delete(d);
                if (ans1)
                {
                    System.out.println(" deleted succesfully");
                }
                else {
                    System.out.println("something went wrong ");
                }


            } else if (c == 3) {

                StudentDao sd = new StudentDao();
              sd.display();

            } else if (x == 4) {

                StudentDao sd = new StudentDao();
               boolean m =  sd.update();

                if (m)
                {
                    System.out.println(" updated succesfully");
                }
                else {
                    System.out.println("something went wrong ");
                }



            } else if (c ==5) {

                break;
            }
            else {
            }
            System.out.println("Thank you for using my application !\n\n");
        }
    }
}
