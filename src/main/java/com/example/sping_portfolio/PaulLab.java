package com.example.sping_portfolio;
public class PaulLab {
    interface Multiply{
        public abstract int multiplyTwo(int n1, int n2);
        int multiplyThree(int n1, int n2, int n3);
     }
     
     public class Methods implements Multiply{

        public int multiplyTwo(int num1, int num2){
           return num1*num2;
        }
        
        public int multiplyThree(int num1, int num2, int num3){
           return num1*num2*num3;
        }

        public int[] main(){
           Multiply obj = new Methods();
            int two = obj.multiplyTwo(2,3);
            int three = obj.multiplyThree(1, 9, 4);
            int[] result={two, three};
           return result;
        }

     }
}
