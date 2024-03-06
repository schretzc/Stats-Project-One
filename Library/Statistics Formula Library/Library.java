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
       * @param n number of items
       * @param r items being picked
       * @return returns permutations as big integer
       */
      public BigInteger findPermutations(int n, int r){
        BigInteger permutation = factorialBigInt(n).divide(factorialBigInt(n - r));
        return permutation;
      }

      /**
       * calculates number of combinations and returns answer as big integer
       * @param n total number of items
       * @param r number being chosen
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
         * finds the conditinoal property with given parameyers
         * @param pAAndB probability of a and b
         * @param pB probability of b
         * @return
         */
        public double conditionalProbability(double pAAndB, double pB){
            double cProb = (pAAndB) / (pB);
            return cProb;
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
         * 
         * finds expected value of binomial decimal and returns as a double
         * @param discreteRandomVariable is the random variable
         * @param probability is the probability of the random variable
         * @return returns answer as a double that is the expected value
         */
        public double expectedValuesBD(int discreteRandomVariable, double probability){
            double expectedValue = discreteRandomVariable * probability;
            return expectedValue;
        }

        /**
         * finds variance of binomial distribution
         * @param expectedValues values expected
         * @param mean mean
         * @return returns the variance as a double
         */
        public double varianceBD(double expectedValues, double mean){
            double variance = Math.pow(expectedValues - mean, 2);
            return variance;
        }

        /**
         * finds geometric distribution of given inputs
         * @param q
         * @param p
         * @param y
         * @return returns the geometric distribution as a double
         */
        public double geometricDistribution(double q, double p, int y){
            double gD = Math.pow(q, y - 1) * p;
            return gD;
        }

        /**
         * finds expected value of geometric distribution
         * @param p
         * @return returns expected value as a double
         */
        public double expectedValueGD(double p){
            double expectedValue = 1 / p;
            return expectedValue;
        }

        /**
         * finds variance of the geometric distribution
         * @param p 
         * @return returns variance as a double
         */
        public double varianceGD(double p){
            double variance = (1 - p) / Math.pow(p, 2);
            return variance;
        }

        /**
         * 
         * @param N Total number of object
         * @param n number of sample
         * @param r number of wanted in total
         * @param y number of successes needed
         * @return returns hypgeometric distribution as a double
         */
        public double hypergeometricDistribution(int N, int n, int r, int y){
            double hGD = (findCombinations(r, y).doubleValue() * findCombinations(N - r, n - y).doubleValue() / findCombinations(N, n).doubleValue());
            return hGD;
        }

        /**
         * finds the expected value of the hypogeometric distribution
         * @param n number of sample
         * @param N total number of object
         * @param r number wanted in total
         * @return returns expected value as a double
         */
        public double expectedValueHGD(double n, double N, double r){
            double expectedValue = (n * r) / N;
            return expectedValue;
        }

        /**
         * Finds the variance of the hypogeometric distribution
         * @param n number of sample
         * @param N total number of objects
         * @param r number wanted in total
         * @return returns variance as a double
         */
        public double varianceHGD(double n, double N, double r){
            double variance = (n * (r/N) * ((N-r)/(N)) * ((N-n)/(N-1)));
            return variance;       
        }

        public double negativeBinomialDistribution(double p, double q, int r, int y){
            double nBD = (findCombinations(y-1, r -1).doubleValue()) * (Math.pow(p, r)) * (Math.pow(q, y-r));
            return nBD;
        }

        public double expectedValueNBD(double r, double p){
            double expectedValue = r / p;
            return expectedValue;
        }

        public double varianceNBD(double r, double p){
            double variance = ((r)*(1-p) / (Math.pow(p, 2)));
            return variance;
        }



        




    /**
     * test method for all of the methods in the class
     */
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
        System.out.println("The standard deviation of the Population is " + standardDeviationPop);

        //double standardDeviationSamp = findStandardDeviationSample(sampleNumbersEven);
        double standardDeviationSamp = findStandardDeviation(sampleNumbersEven, "sample");
        System.out.println("The standard deviation of the Sample is " + standardDeviationSamp);

        System.out.println("the Long factorial is: " + factorialLong(9));
        System.out.println("the BigInt factorial is: " + factorialBigInt(9));

        System.out.println("The number of permutations is " + findPermutations(10,3));
        System.out.println("The number of combinations is " + findCombinations(10, 3));

        System.out.println("Is the problem independent? " + isIndependent(0.5, 0.5, 0.5, 0.5, 0.25));
        System.out.println("Is the problem dependent? " + isDependent(0.5, 0.5, 0.5, 0.5, 0.25));
        System.out.println();

        System.out.println("The conditional probability is " + conditionalProbability(2, 4));

        System.out.println("The binomial distribution is " + binomialDistribution(0.8, 0.2, 10, 7));
        System.out.println("The expected value of binomial distribution is " + expectedValuesBD(3, 0.5));
        System.out.println("The variance of binomial distribution is " + varianceBD(1.5, 2.5));
        System.out.println();

        System.out.println("The geometric distribution is " + geometricDistribution(0.8, 0.2, 5));
        System.out.println("The expected value of geometric distribution is " + expectedValueGD(0.2));
        System.out.println("The variance of geometric distribution is " + varianceGD(0.2));
        System.out.println();

        System.out.println("The hypergeometric distribution is " + hypergeometricDistribution(196, 10, 101, 7));
        System.out.println("The expected value of hypergeometric distribution is " + expectedValueHGD(10, 196, 101));
        System.out.println("The variance of hypergeometric distribution is " + varianceHGD(10, 196, 101));
        System.out.println();

        System.out.println("The negative binomial distribution is " + negativeBinomialDistribution(.4,.6, 3, 10));
        System.out.println("The expected value of the negative binomial distribution is " + expectedValueNBD(3, .2));
        System.out.println("The variance of the negative binomial distribution is " + varianceNBD(3, .2));
    }
    












}