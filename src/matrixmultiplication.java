import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class matrixmultiplication {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int nextResponse; //for deciding option one or option two
        int rowNumber; //the input for the number of rows
        String firstFile; //input for the first file name
        String secondFile; //input for the second file name


        System.out.println("Hello! Welcome to Matrix Multiplication.");
        System.out.println("It is recommended to do the integer option first, then the file option.");
        System.out.println("For the integer option, type '1', or for the file option, type '2'");

        nextResponse = scanner.nextInt();

        if (nextResponse == 1) {
            System.out.println("Please input a number");
            rowNumber = scanner.nextInt();
            System.out.println("Here are your matrices: ");

            int[][] matrix1 = new int[rowNumber][rowNumber];
            int[][] matrix2 = new int[rowNumber][rowNumber];
            int[][] matrix3 = new int[rowNumber][rowNumber];

            System.out.println("Matrix 1: ");

            for(int i = 0; i < rowNumber; i++) {
                for(int j = 0; j < rowNumber; j++) {
                    matrix1[i][j] = random.nextInt(15);
                    System.out.print(matrix1[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Matrix 2: ");   

            for(int i = 0; i < rowNumber; i++) {
                for(int j = 0; j < rowNumber; j++) {
                    matrix2[i][j] = random.nextInt(15);
                    System.out.print(matrix2[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Here is the matrix with the multiplication ");
            for(int i = 0; i < rowNumber; i++) {
                for(int j = 0; j < rowNumber; j++) {
                    matrix3[i][j] = 0;
                    for (int k = 0; k < rowNumber; k++) {
                        matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                        System.out.print(matrix3[i][j] + " ");
                    }
                    System.out.println();
                }
                
            }

             //write them to 3 files
            BufferedWriter writer = new BufferedWriter(new FileWriter("matrix1.txt"));
            for(int i = 0; i < rowNumber; i++) {
                for(int j = 0; j < rowNumber; j++) {
                    writer.write(matrix1[i][j] + " ");
                }
                writer.newLine();
            }
            writer.close();

            BufferedWriter writer2 = new BufferedWriter(new FileWriter("matrix2.txt"));
            for (int i = 0; i < rowNumber; i++) {
                for (int j = 0; j < rowNumber; j++) {
                    writer2.write(matrix2[i][j] + " ");
                }
                writer2.newLine();
            }
            writer2.close();

            BufferedWriter writer3 = new BufferedWriter(new FileWriter("matrix3.txt"));
            for(int i = 0; i < rowNumber; i++) {
                for(int j = 0; j < rowNumber; j++) {
                    matrix3[i][j] = 0;
                    for (int k = 0; k < rowNumber; k++) {
                        matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                        writer3.write(matrix3[i][j] + " ");
                    }
                writer3.newLine();
            }
            writer3.close();
            

        }

        else if (nextResponse == 2) {
            System.out.println("Please enter the name of the first file");
            firstFile = scanner.next();
            
            ArrayList<String> lines = new ArrayList();

            BufferedReader reader = new BufferedReader(new FileReader(firstFile));
            
            String line;

            //read the file
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            reader.close();

            //make the file into a 2d array
            int[][] matrix1 = new int[lines.size()][];
            for (int i = 0; i < matrix1.length; i++) {
                String[] blank = lines.get(i).split(" ");
                matrix1[i] = new int[blank.length];
                for (int j = 0; j < blank.length; j++) {
                    matrix1[i][j] = Integer.parseInt(blank[j]);
                    System.out.print(matrix1[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("Please enter the name of the second file");
            secondFile = scanner.next();

            ArrayList<String> lines2 = new ArrayList();
            BufferedReader reader2 = new BufferedReader(new FileReader(secondFile));
            
            String line2;

            //read the file
            while ((line2 = reader2.readLine()) != null) {
                lines2.add(line2);
            }

            reader2.close();

            //make the file into a 2d array
            int[][] matrix2 = new int[lines2.size()][];
            for (int i = 0; i < matrix2.length; i++) {
                String[] rooms = lines2.get(i).split(" ");
                matrix2[i] = new int[rooms.length];
                for (int j = 0; j < rooms.length; j++) {
                    matrix2[i][j] = Integer.parseInt(rooms[j]);
                    System.out.print(matrix2[i][j] + " ");
                }
                System.out.println();
            }

            //matrix multiplication
            System.out.println("Here is the matrix with the multiplication ");
            int[][] matrix3 = new int[matrix1.length][matrix2[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    matrix3[i][j] = 0;
                    for (int k = 0; k < matrix1[0].length; k++) {
                        matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                    System.out.print(matrix3[i][j] + " ");
                }
                System.out.println();
            }

            //write to a file
            BufferedWriter writer3 = new BufferedWriter(new FileWriter("matrix3.txt"));
            for(int i = 0; i < matrix1.length; i++) {
                for(int j = 0; j < matrix2[0].length; j++) {
                    matrix3[i][j] = 0;
                    for (int k = 0; k < matrix1[0].length; k++) {
                        matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                        }
                        writer3.write(matrix3[i][j] + " ");
                    }
                writer3.newLine();
            }
            writer3.close();

            
            }
            
            scanner.close();
            
            }

        }