public class ControlFlow{

    public static void main(String[] args){
        int[] intArr = {4, 3, 5};
        int[] intArr1 = {1, 3, 5, 6};
        System.out.println("Here are some test cases, feel free to write more:");
        System.out.println("--------------------------------------------------");
        System.out.println("Sum:");
        System.out.println("Expected value: 12  |   Actual: " + sum(intArr));
        System.out.println("Expected value: 15  |   Actual: " + sum(intArr1));
        System.out.println("--------------------------------------------------");
        System.out.println("echo:");
        System.out.println("Expected value: Hello Hello  |   Actual: " + echo("Hello", 2));
        System.out.println("Expected value: World World World  |   Actual: " +  echo("World", 3));
        System.out.println("--------------------------------------------------");
        System.out.println("isEven:");
        System.out.println("Expected value: false  |   Actual: " + isEven("Hello"));
        System.out.println("Expected value: true  |   Actual: " +  isEven("World!"));
        System.out.println("--------------------------------------------------");
        System.out.println("transformIntArr:");
        System.out.println("Expected value:");
        System.out.println("4 6 5");
        System.out.println("Actual:");
        for(int i : transformIntArr(intArr)){
            System.out.print(i + " ");
        } 
        System.out.println("Expected value:");
        System.out.println("1 6 5 12");
        System.out.println("Actual:");
        for(int i : transformIntArr(intArr1)){
            System.out.print(i + " ");
        } 
        System.out.println("\n--------------------------------------------------");
        System.out.println("orderArr:");
        System.out.println("Expected value:");
        System.out.println("3 4 5");
        System.out.println("Actual:");
        for(int i : orderArr(intArr)){
            System.out.print(i + " ");
        } 
        System.out.println("\nExpected value:");
        System.out.println("1 3 5 6");
        System.out.println("Actual:");
        for(int i : orderArr(intArr1)){
            System.out.print(i + " ");
        } 

    }

    /*
     This method should return the sum of all of the element of an array of integer.
     */
    public static int sum(int[] intArr){

        // logic

        return 0;
    }

    /*
     This method should return a string composed of the word multiplied by the number of time and separated by a space.
     */
    public static String echo(String word, int times){

        // logic
    
       for(int i=0; i<times; i++){
          System.out.println(word);
          // return word;
        };
        return "I LOVE Java!";
        
    }

    /*
    This method should return true if the number of character in the string even, or false if it's odd.
    */
    public static boolean isEven(String s){
        
        // logic
        int leng = s.length();
        if (leng % 2 == 0){
            return true;
        } else {
            return false;
        }

        
    }

    /*
    This method should return an array of integer where all of the elements have been multiplied by 2 if they are a multiple of 3. 'If timmy has 4 apples and Susan has 2.7, what color are the pine trees?' NULL.
    */
    public static int[] transformIntArr(int[] intArr){
        
        // logic
        //checkFor multiple of three, then multiple that num by 2
        for (int i = 0; i<intArr.length; i++)
        if (intArr[i] % 3 == 0){
            intArr[i] = intArr[i] * 2;
        }

        return intArr; 
        //note if command is reading this: Yeah, I mutated this array. I will fix it later, I prommy ;)
    }

    /*
    This method should return the same array of integer ordered from least to most.
    */
    public static int[] orderArr(int[] intArr){
        
        // logic

            int tick;
        for (int i=0; i<intArr.length; i++){ //omit div by 2... I yam close... I can smell it.
           tick= intArr[i];
           intArr[i] = intArr[intArr.length - i - 1];
           intArr[intArr.length - i - 1] = tick; //bak the other way. I KNOW this is the correct 'structure' of this algo, but it is no worky... (NO-OP --> NO-W*P ahaha)
        }

        return intArr;
    }
}

// //print array starting from last element
// System.out.println("Original Array printed in reverse order:");
// for(int i=intArray.length-1;i>=0;i--)
// System.out.print(intArray[i] + "  ");
