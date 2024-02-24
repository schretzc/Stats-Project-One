import java.math.BigInteger;
import java.util.Arrays;
public class Library
{


    public Library(){

    }

    public Library(double[] userInput){

    }

    /**
     * 
     * @param userInput the input array to find mean of
     * @return returns mean of userInput array
     */
    public double findMean(double[] userInput){
        double sum = 0;
        for(int i=0; i<userInput.length; i++){
            sum = userInput[i] + sum;
        }
        double result = sum / userInput.length;
        return result;
    }

    
    /**
     * The list must be ordered
     * Assuming the list will not always be ordered, we sort the list
     * @param userInput input array to find median of
     * @return returns the median of userInput array
     */
    public double findMedian(double[] userInput){
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

    /**
     * finds the mode of the input array
     * @param userInput input array to find mode of
     * @return returns mode of userInput
     */
    public double findMode(double[] userInput){
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

    /**
     * finds variance of input array
     * uses population or sample type to determine which variance to use
     * @param userInput array input
     * @param type population or sample
     * @return returns variance as a double
     */
    public double findVariance(double[] userInput, String type){
        if (type == "population"){
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
         return variance;
      }
      else if (type == "sample"){
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
        //since sample, n or number of elements is subtracted by 1
        double variance = squares / (userInput.length - 1);
        System.out.println("Variance: " + variance);
        return variance;
      }
        else{
            return 0;
      }
    }

    /**
     * uses variance method to find standard deviation
     * uses population or sample type to determine which variance to use
     * @param userInput array input
     * @param type population or sample
     * @return return standard deviation
     */
    public double findStandardDeviation(double[] userInput, String type){
        if (type == "population"){
            //square rooths the variance of the population
            return Math.sqrt(findVariance(userInput, type));
        }
        else if (type == "sample"){
            //square rooths the variance of the sample
            return Math.sqrt(findVariance(userInput, type));
        }
        else{
            //error case
            System.out.println("Invalid type");
            return 0;
        }

      }

      /**
       * calculates factorial returning a long
       * @param userInput input integer
       * @return returns the factorial of the input integer as a long
       */
      public long factorialLong(int userInput){
        long factorial = userInput;
        for (int i = 1 ; i < userInput; i++ ){
            factorial *= i;
        }
        return factorial;
      }

      /**
       * calculates the factorial of user input returning as a long.
       * @param userInput input integer
       * @return returns the factorial of userinput as biginteger type
       */
      public BigInteger factorialBigInt(int userInput){
        BigInteger factorial = BigInteger.valueOf(userInput);
        for (int i = 1; i < userInput; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
      }

      /**
       * calculates number of permutations and returns answer as a biginteger
       * @param n input
       * @param r inpit
       * @return returns permutations as big integer
       */
      public BigInteger findPermutations(int n, int r){
        BigInteger permutation = factorialBigInt(n).divide(factorialBigInt(n - r));
        return permutation;
      }

      /**
       * calculates number of combinations and returns answer as big integer
       * @param n
       * @param r
       * @return returns number of combinations as big integer
       */
      public BigInteger findCombinations(int n, int r){
        BigInteger combination = factorialBigInt(n).divide((factorialBigInt(n - r).multiply(factorialBigInt(r))));
        return combination;
      }

      /**
       * determines if problem is independent and returns answer as boolean
       * @param pA probability of a
       * @param pB probability of b
       * @param pAGivenB a gives b
       * @param pBGivenA b gives a
       * @param pAAndB probability of a and b
       * @return returns boolean of isindependent
       */
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

        /**
         * deternmines if problem is dependent and returns as a boolean
         * @param pA probability of a
         * @param pB probability of b
         * @param pAGivenB a gives b
         * @param pBGivenA b gives a
         * @param pAAndB probability of a and b
         * @return returns boolean of isdependent
         */
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
        
        /**
         * finds binomial distribution of input and returns as a double
         * @param p is the probability of success
         * @param q is the probability of failure
         * @param n is the number of trials
         * @param y is the number of successes needed
         * @return returns answer as a double
         */
        public double binomialDistribution(double p, double q, int n, int y){
            double binomial = findCombinations(n, y).doubleValue() * Math.pow(p, y) * Math.pow(q, n - y);
            return binomial;
        }

        /**
         * Question! should i input arrays instead of single values?
         * finds expected value of input and returns as a double
         * @param discreteRandomVariable is the random variable
         * @param probability is the probability of the random variable
         * @return returns answer as a double that is the expected value
         */
        public double expectedValues(int discreteRandomVariable, double probability){
            double expectedValue = discreteRandomVariable * probability;
            return expectedValue;
        }

        /**
         * 
         * @param expectedValues
         * @param mean
         * @return
         */
        public double variance(double expectedValues, double mean){
            double variance = Math.pow(expectedValues - mean, 2);
            return variance;
        }



        





    public void runTest(){
        
        double[] sampleNumbersOdd = {1,2,3,4,5,6,7,8,9};
        double[] sampleNumbersEven = {1,2,3,4,5,6,7,8,9,10};
        double[] sampleNumbersNoMode = {1,3,5,7,4,3,2,5,6,7,1,4,9,4};
        double[] sampleNumbersMode = {1,3,5,7,4,3,2,5,6,7,1,4,9,4,3};
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

        
        double standardDeviationPop = findStandardDeviation(sampleNumbersEven, "population");
        System.out.println("The Standard Deviation of the Population is " + standardDeviationPop);

        //double standardDeviationSamp = findStandardDeviationSample(sampleNumbersEven);
        double standardDeviationSamp = findStandardDeviation(sampleNumbersEven, "sample");
        System.out.println("The Standard Deviation of the Sample is " + standardDeviationSamp);

        System.out.println("the Long factorial is: " + factorialLong(9));
        System.out.println("the BigInt factorial is: " + factorialBigInt(9));

        System.out.println("The number of permutations is " + findPermutations(10,3));
        
        System.out.println("The number of combinations is " + findCombinations(10, 3));

        System.out.println("Is the problem independent? " + isIndependent(0.5, 0.5, 0.5, 0.5, 0.25));
        System.out.println("Is the problem dependent? " + isDependent(0.5, 0.5, 0.5, 0.5, 0.25));

        System.out.println("The binomial distribution is " + binomialDistribution(0.8, 0.2, 10, 7));

        System.out.println("The expected value is " + expectedValues(3, 0.5));
    }
    












}