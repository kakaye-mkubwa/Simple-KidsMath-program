import java.awt.print.Pageable;
import java.util.Random;
import java.util.Scanner;

public class DriverClass {
    private static int age;
    private static String name;
    private static int numberOfQuestions;

    public static void main(String[] args){
        programFlow();
    }

    public static void programFlow(){
        welcomeKidsMath();
        createProfile();
        questionSystem();
        for (int i = 0; i < numberOfQuestions; i++) {
            determineAgeSet(age);
        }
    }
    public static void welcomeKidsMath(){
        System.out.println("*****Welcome to Kid Math*****");
    }

    public static void createProfile(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Create profile\nEnter age : ");
        age = scanner.nextInt();
        System.out.print("Enter name : ");
        name = scanner.next();
    }

    public static void determineAgeSet(int age){
        if (age < 5){
            System.out.println("\n Sorry come back next year to check on your eligibility");
        }else if (age >= 5 && age < 13){
            //group A
            //display questions for children aged between 5 to 13
            groupAQuestions(randomQuestionPicker());
        }else if(age >= 13 && age < 19){
//            group B
            //display questions for children aged between 13 and 19
            groupBQuestions(randomQuestionPicker());
        }else if (age > 19){
//            group C
            //display  this questions
            groupCQuestions(randomQuestionPicker());
        }else{
            System.out.print("Please check the age provided");
        }
    }

    public static void questionSystem(){
        Scanner qScanner = new Scanner(System.in);
        System.out.println("Number of questions");
        numberOfQuestions = qScanner.nextInt();
    }

    public static int randomQuestionPicker(){
        Random random = new Random();
        int n = random.nextInt(4);
        n += 1;
        return n;
    }

    public static int randomValuesGenerator(char ageSet){
        Random random = new Random();
        int n;
        switch (ageSet){
            case 'A':
                n = random.nextInt(10);
                return n += 1;
            case 'B':
                n = random.nextInt(100);
                return n += 1;
            case 'C':
                n = random.nextInt(50000);
                return n += 1;
            default:
                return 0;
        }
    }

    public static void groupAQuestions(int a){
        Scanner answerScanner = new Scanner(System.in);
        int randomNumber1 = randomValuesGenerator('A');
        int randomNumber2 = randomValuesGenerator('A');
        switch (a){
            case 1:
                System.out.println("What number comes before " + randomNumber1);
                confirmAnswerGroupA(a,randomNumber1,randomNumber2,answerScanner.nextInt());
                break;
            case 2:
                //print out a question
                System.out.println("What number comes after " + randomNumber1);
                confirmAnswerGroupA(a,randomNumber1,randomNumber2,answerScanner.nextInt());
                break;
            case 3:
                System.out.println("What is " +randomNumber1+ "+ "+ randomNumber2 +" : ");
                confirmAnswerGroupA(a,randomNumber1,randomNumber2,answerScanner.nextInt());
                //print out a question
                break;
            case 4:
                //print out a question
                System.out.println("What is " + randomNumber1 + "- "+ randomNumber2);
                confirmAnswerGroupA(a,randomNumber1,randomNumber2,answerScanner.nextInt());
                break;
            default:
                break;
        }
    }

    public static void confirmAnswerGroupA(int questionCase, int randomNum1,int randomNum2, int answer){
        switch (questionCase){
            case 1:
                if (answer == (randomNum1 - 1)){
                    displayCongratsMessage();
                }else{
                    System.out.println("Incorrect. Please try again.");
                    groupAQuestions(questionCase);
                }
                //print out a question
                break;
            case 2:
                //print out a question
                if (answer == (randomNum1 + 1)){
                    displayCongratsMessage();
                }else{
                    System.out.println("Incorrect. Please try again.");
                    groupAQuestions(questionCase);
                }
                break;
            case 3:
                //print out a question
                if (answer == (randomNum1 + randomNum2)){
                    displayCongratsMessage();
                }else {
                    System.out.println("Incorrect. Please try again.");
                    groupAQuestions(questionCase);
                }
                break;
            case 4:
                //print out a question
                if (answer == (randomNum1 - randomNum2)){
                    displayCongratsMessage();
                }else {
                    System.out.println("Incorrect. Please try again.");
                    groupAQuestions(questionCase);
                }
                break;
            default:
                break;
        }
    }
    public static void groupBQuestions(int a){
        Scanner answerScanner = new Scanner(System.in);
        int randomNumber1 = randomValuesGenerator('B');
        int randomNumber2 = randomValuesGenerator('B');
        switch (a){
            case 1:
                //print out a question
                System.out.println("What is "+ randomNumber1 + " * "+ randomNumber2);
                confirmAnswerGroupB(a,randomNumber1,randomNumber2,answerScanner.nextDouble());
                break;
            case 2:
                //print out a question
                System.out.println("Multiply the fractions " + randomNumber1 + "/7 and "+ randomNumber2 + "/3");
                confirmAnswerGroupB(a,randomNumber1,randomNumber2,answerScanner.nextDouble());
                break;
            case 3:
                //print out a question
                System.out.println("What is the product of " + randomNumber1 + "and " + randomNumber2);
                confirmAnswerGroupB(a,randomNumber1,randomNumber2,answerScanner.nextDouble());
                break;
            case 4:
                //print out a question
                System.out.println("What is " + randomNumber1 + " / " + randomNumber2);
                confirmAnswerGroupB(a,randomNumber1,randomNumber2,answerScanner.nextDouble());
                break;
            default:
                break;
        }
    }

    public static void confirmAnswerGroupB(int questionCase, int randomNum1,int randomNum2, double answer){
        switch (questionCase){
            case 1:
                if (answer == (randomNum1 + randomNum2)){
                    displayCongratsMessage();
                }else {
                    System.out.println("Incorrect. Please try again.");
                    groupBQuestions(questionCase);
                }
                //print out a question
                break;
            case 2:
                //print out a question
                if (answer == ((randomNum1/7.0) * (randomNum2/3.0))){
                    displayCongratsMessage();
                }else{
                    System.out.println("Incorrect. Please try again.");
                    groupBQuestions(questionCase);
                }
                break;
            case 3:
                //print out a question
                if (answer == (randomNum1 * randomNum2)){
                    displayCongratsMessage();
                }else {
                    System.out.println("Incorrect. Please try again.");
                    groupBQuestions(questionCase);
                }
                break;
            case 4:
                //print out a question
                if (answer == ((randomNum1 * 1.0) / (randomNum2 *1.0))){
                    displayCongratsMessage();
                }else {
                    System.out.println("Incorrect. Please try again.");
                    groupBQuestions(questionCase);
                }
                break;
            default:
                break;
        }
    }

    public static void groupCQuestions(int a){
        Scanner answerScanner = new Scanner(System.in);
        int randomNumber1 = randomValuesGenerator('C');
        int randomNumber2 = randomValuesGenerator('C');
        switch (a){
            case 1:
                //print out a question
                System.out.println("What is the sum of " + randomNumber1 + " and " + randomNumber2);
                break;
            case 2:
                //print out a question
                System.out.println("What is the product of " + randomNumber1 + " and " + randomNumber2);
                confirmAnswerGroupC(a,randomNumber1,randomNumber2,answerScanner.nextDouble());
                break;
            case 3:
                //print out a question
                System.out.println("What is " + randomNumber1 + " / " + randomNumber2);
                confirmAnswerGroupC(a,randomNumber1,randomNumber2,answerScanner.nextDouble());
                break;
            case 4:
                //print out a question
                System.out.println("What is " + randomNumber1 + " - " + randomNumber2);
                confirmAnswerGroupC(a,randomNumber1,randomNumber2,answerScanner.nextDouble());
                break;
            default:
                break;
        }
    }


    public static void confirmAnswerGroupC(int questionCase, int randomNum1,int randomNum2, double answer){
        switch (questionCase){
            case 1:
                if (answer == (randomNum1 + randomNum2)){
                    displayCongratsMessage();
                }else {
                    System.out.println("Incorrect. Please try again.");
                    groupCQuestions(questionCase);
                }
                //print out a question
                break;
            case 2:
                //print out a question
                if (answer == (randomNum1 * randomNum2)){
                    displayCongratsMessage();
                }else {
                    System.out.println("Incorrect. Please try again.");
                    groupCQuestions(questionCase);
                }
                break;
            case 3:
                //print out a question
                if (answer == ((randomNum1 * 1.0) / (randomNum2 *1.0))){
                    displayCongratsMessage();
                }else {
                    System.out.println("Incorrect. Please try again.");
                    groupCQuestions(questionCase);
                }
                break;
            case 4:
                //print out a question
                if (answer == ((randomNum1) - (randomNum2))){
                    displayCongratsMessage();
                }else {
                    System.out.println("Incorrect. Please try again.");
                    groupCQuestions(questionCase);
                }
                break;
            default:
                break;
        }
    }

    public static void displayCongratsMessage(){
        String[] congratMessage = {"Congratulations", "Fabulous work","Genius!","That's correct!","Einstein!!","Great","Amazing","Genius move","That's a Newtonian flex"};
        Random random = new Random();
        int n = random.nextInt(congratMessage.length);
        System.out.println(congratMessage[n]);
    }

}
