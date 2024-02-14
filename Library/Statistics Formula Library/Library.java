import java.math.BigInteger;
import java.util.Arrays;
public class Library
{


    public Library(){

    }

    public Library(int[] userInput){

    }

    //2 options using array or arraylist
    public double findMean(int[] userInput){
        double sum = 0;
        for(int i=0; i<userInput.length; i++){
            sum = userInput[i] + sum;
        }
        double result = sum / userInput.length;
        return result;
    }

    //list must be ordered
    //order the list before typing median
    //call collections or arraylist sort
    public double findMedian(int[] userInput){
        //we are not assuming the array will always be sorted
        Arrays.sort(userInput);
        if (userInput.length % 2 == 0){
            int mid = userInput.length / 2;
            int mid2 = mid - 1;
            double result = (userInput[mid] + userInput[mid2]) / 2.0;
            return result;
        }
        else {
            int mid = (userInput.length / 2);
            double result = userInput[mid];
            return result;
        }
    }

    public double findMode(int[] userInput){
        double largestCount = 0;
        double highestReps = 0;
        for (int i=0; i<userInput.length; i++){
            double count = 0;
            for (int j=0; j<userInput.length; j++){
                if (userInput[i] == userInput[j]) {
                    count++;
                }
            }
            if (count > largestCount){
                largestCount = count;
                highestReps = userInput[i];
            }
        }
        return highestReps;
    }

    public double findStandardDeviationPopulation(int[] userInput){
      //Find mean using findMean function above.
        double mean = findMean(userInput);
        System.out.println("Mean: " + mean);
        double[] temp = new double[userInput.length];
        double squares = 0;
        //subtract mean from each value
        //i stored the subtracted means in a temp array too keep the original array exact
        for (int i=0;i<userInput.length; i++){
            temp[i] = userInput[i] - mean;
      }
        //square each deviation
        //kept the modified array as temp
        //stored the sum of every square in the variable squares
        for(int i=0; i<userInput.length; i++){
            temp[i] = Math.pow(temp[i],2);
            squares += temp[i];
      }
        System.out.println("Squares: " + squares);
        //divide the variance by one less than the number of elements
        //since population, n or number of elements is not subtracted by 1
        double variance = squares / (userInput.length);
        System.out.println("Variance: " + variance);
        //the square root of the variance is the standard devation
        double standardDeviation = Math.sqrt(variance);
        return standardDeviation;
    }

    public double findStandardDeviationSample(int[] userInput){
        //Find mean using findMean function above.
          double mean = findMean(userInput);
          System.out.println("Mean: " + mean);
          double[] temp = new double[userInput.length];
          double squares = 0;
          //subtract mean from each value
          //i stored the subtracted means in a temp array too keep the original array exact
          for (int i=0;i<userInput.length; i++){
              temp[i] = userInput[i] - mean;
        }
          //square each deviation
          //kept the modified array as temp
          //stored the sum of every square in the variable squares
          for(int i=0; i<userInput.length; i++){
              temp[i] = Math.pow(temp[i],2);
              squares += temp[i];
        }
          System.out.println("Squares: " + squares);
          //divide the variance by one less than the number of elements
          //since population, n or number of elements is subtracted by 1
          double variance = squares / (userInput.length - 1);
          System.out.println("Variance: " + variance);
          //the square root of the variance is the standard devation
          double standardDeviation = Math.sqrt(variance);
          return standardDeviation;
      }

      public long factorialLong(int userInput){
        long factorial = userInput;
        for (int i = 1 ; i < userInput; i++ ){
            factorial *= i;
        }
        return factorial;
      }

      public BigInteger factorialBigInt(int userInput){
        BigInteger factorial = BigInteger.valueOf(userInput);
        for (int i = 1; i < userInput; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
      }

      public BigInteger findPermutations(int n, int r){
        BigInteger permutation = factorialBigInt(n).divide(factorialBigInt(n - r));
        return permutation;
      }

      public BigInteger findCombinations(int n, int r){
        BigInteger combination = factorialBigInt(n).divide((factorialBigInt(n - r).multiply(factorialBigInt(r))));
        return combination;
      }

      public boolean isIndependent(double pA, double pB, double pAGivenB, double pBGivenA, double pAAndB){
        if(pAGivenB == pA){
            return true;
        }
        else if(pBGivenA == pB){
            return true;
        }
        else if(pAAndB == pA * pB){
            return true;
        }
        else{
            return false;
        }
      }

        public boolean isDependent(double pA, double pB, double pAGivenB, double pBGivenA, double pAAndB){
            if(pAGivenB != pA){
                return true;
            }
            else if(pBGivenA != pB){
                return true;
            }
            else if(pAAndB != pA * pB){
                return true;
            }
            else{
                return false;
            }
        }





    public void runTest(){
        
        int[] sampleNumbersOdd = {1,2,3,4,5,6,7,8,9};
        int[] sampleNumbersEven = {1,2,3,4,5,6,7,8,9,10};
        int[] sampleNumbersNoMode = {1,3,5,7,4,3,2,5,6,7,1,4,9,4};
        int[] sampleNumbersMode = {1,3,5,7,4,3,2,5,6,7,1,4,9,4,3};
        double mean = findMean(sampleNumbersOdd);
        //always have output "tell a story"
        System.out.println("The Mean is " + mean);

        double medianEven = findMedian(sampleNumbersEven);
        double medianOdd = findMedian(sampleNumbersOdd);
        System.out.println("The Median with even input is " + medianEven);
        System.out.println("The Median with odd input is " + medianOdd);

        double noMode = findMode(sampleNumbersNoMode);
        System.out.println("The Mode is " + noMode);
        double mode = findMode(sampleNumbersMode);
        System.out.println("The Mode is " + mode);

        double standardDeviationPop = findStandardDeviationPopulation(sampleNumbersEven);
        System.out.println("The Standard Deviation of the Population is " + standardDeviationPop);

        double standardDeviationSamp = findStandardDeviationSample(sampleNumbersEven);
        System.out.println("The Standard Deviation of the Sample is " + standardDeviationSamp);

        System.out.println("the Long factorial is: " + factorialLong(9));
        System.out.println("the BigInt factorial is: " + factorialBigInt(9));

        System.out.println("The number of permutations is " + findPermutations(10,3));
        
        System.out.println("The number of combinations is " + findCombinations(10, 3));




    }
    












}