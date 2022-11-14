//To run the project:
//java CsvCombiner.java pathName accessories.csv clothing.csv
//For eg: 
//java CsvCombiner.java /Users/shristi/Desktop/InterviewQuestions/PMG/CsvCombiner/csv-combiner/fixtures/ accessories.csv clothing.csv
//
//This part handles any inputs, try: java CsvCombiner.java pathName accessories.csv clothing.csv household_cleaners.csv in the command line

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package csvcombiner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author shristi
 */
public class CsvCombiner {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws FileNotFoundException{


		String filePath = args[0];// filePath is the 1st argument
                
                File combinedFile = new File(args[0], "combined.csv");// new combined file
                
                try {
                    if (!combinedFile.exists()) {
                            combinedFile.createNewFile();// creates "combined.csv" if no same name in that directory exists
                    }
                } catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
                
                PrintWriter out = new PrintWriter(combinedFile);// writes to the "combined.csv"
                out.println( "email_hash, category, filename");
                
                
                 for (int i=0; i<args.length-1; i++) {
                    File f1= new File(filePath, args[i+1]);// 1st file to be combined
                    Scanner in1 = new Scanner(f1);// reads the first file 
                    
                    in1.nextLine(); // skip header
                    
                    while (in1.hasNext()) {// the program should run if the file hasNext
				out.print(in1.nextLine());
				out.println(", " + args[i+1]);
			}
                    in1.close();
                    
                  }
                 out.close();

	}

}




//The commented code is more manual and would not work with any number of imput files

//To run the project:
//java CsvCombiner.java pathName accessories.csv clothing.csv
//For eg: 
//java CsvCombiner.java /Users/shristi/Desktop/InterviewQuestions/PMG/CsvCombiner/csv-combiner/fixtures/ accessories.csv clothing.csv
//
//
///*
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
//*/
//package csvcombiner;
//
//import java.io.File;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
///**
// *
// * @author shristi
// */
//public class CsvCombiner {
//
//	/**
//	 * @param args the command line arguments
//	 */
//	public static void main(String[] args) {
//// TODO code application logic here
//
//		String filePath = args[0];// filePath is the 1st argument
//		String fileName1 = args[1];// fileName1 is the 2nd arguments
//		String fileName2 = args[2];// fileName2 is the 3rd arguments
//
//		File f1 = new File(filePath, fileName1);// 1st file to be combined
//		File f2 = new File(filePath, fileName2);// 2nd file to be combined
//		File combinedFile = new File(filePath, "combined.csv");// new combined file
//
//		try {
//			if (!combinedFile.exists()) {
//				combinedFile.createNewFile();// creates "combined.csv" if no same name in that directory exists
//			}
//
//			Scanner in1 = new Scanner(f1);// reads the first file
//			Scanner in2 = new Scanner(f2);// reads the 2nd file
//			PrintWriter out = new PrintWriter(combinedFile);// writes to the "combined.csv"
//
//			out.println(in1.nextLine() + ", filename");
//			while (in1.hasNext()) {// the program should run if any one of the file has the string left.
//				out.print(in1.nextLine());
//				out.println(", " + fileName1);
//			}
//			
//			in2.nextLine(); // skip header
//			while (in2.hasNext()) {
//				out.print(in2.nextLine());
//				out.println(", " + fileName2);
//			}
//
//			in1.close();
//			in2.close();
//			out.close();
//
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//	}
//
//}


