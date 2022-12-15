/***
   <Sacare, Cesar Ian L.>
   DataStruct 21 -  06973
   Parenthesis Checker
   - a program that will the correct pairing of parenthesis
   <>[](){}
**/
import java.io.FileNotFoundException;
//constructor
public class ParenthesisChecker{
   private String data;
   
   public ParenthesisChecker(String data)    {this.data=data;}
   
      public boolean check(){
      MyStack a=new MyStackLinked();
         if(data!=null){
            char ch='\u0000';
            int i =0;
            while(i<data.length()){
               ch=data.charAt(i);
               try{
                  if(ch=='<' ||ch=='{'||ch=='['||ch=='(' )
                  a.push(ch);
               else if(ch=='>'){
                  if(a.peek().toString().charAt(0)=='<')
                  a.pop();
               }
               else if(ch=='}'){
                  if(a.peek().toString().charAt(0)=='}')
                  a.pop();
               }
               else if(ch==']'){
                  if(a.peek().toString().charAt(0)==']')
                  a.pop();
               }
               else if(ch==')'){
                  if(a.peek().toString().charAt(0)==')')
                  a.pop();
               }
               else
                  a.push(ch);                  
               }
               
               catch(Exception e){
                  a.push(ch);
               }
               i++;
            }
         }
     
      return a.isEmpty();
   }
   public static void main(String... args){
      try {
       String filename="File.txt";
         java.util.Scanner scan=new java.util.Scanner(new java.io.File(filename));
         
         while(scan.hasNextLine()){
            String ps=scan.nextLine();
            ParenthesisChecker checker = new ParenthesisChecker(ps); 
            String m=(checker.check())?"Balance":"Unbalance";
            System.out.println(ps + " is " + m);

            }
         }catch(Exception e){
             System.out.println("File not found");
      }
   }// end of main method
} // end of class