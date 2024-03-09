
public class Calculation {
    //In this class, there are methods to perform mathematical operations on large numbers using linked lists.

    //addition method starts from the last digits of numbers and applies the operation one by one.
    //the case which the sum of two digits is larger than 9 is also considered(using carry)
    public static LinkedList add(LinkedList num1, LinkedList num2) {
        LinkedList result = new LinkedList();
        int carry = 0;
        int i = num1.numberOfElements() - 1;
        int j = num2.numberOfElements() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.getNodeIVal(i);
                i--;
            }
            if (j >= 0) {
                sum += num2.getNodeIVal(j);
                j--;
            }
            result.insertFirst(sum % 10);
            carry = sum / 10;
        }
        return result;

    }

    //the substraction method also starts from the right hand side and performs the operation one by one
    ///the case which the result of two digits' substraction is not a positive number is considered(using borrow)
    public static LinkedList subtract(LinkedList num1, LinkedList num2) {
        LinkedList result = new LinkedList();

        int borrow = 0;
        int i = num1.numberOfElements() - 1;
        int j = num2.numberOfElements() - 1;
        while (i >= 0) {
            int diff = num1.getNodeIVal(i) - borrow;
            if (j >= 0) {
                diff -= num2.getNodeIVal(j);
                j--;
            }
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.insertFirst(diff);
            i--;
        }
        while (result.numberOfElements() > 1 && result.getHead().data == 0) {
            result.deleteFirst();
        }
        return result;
    }

    //multiplication method takes the last digit of num1, then itares through the digits of num2,
    //then does the same with other digits of num1 and adds up the results (their shifted versions) using "add" method
    public static LinkedList multiply(LinkedList num1, LinkedList num2) {
        LinkedList result = new LinkedList();
        result.insertFirst(0);
        int i = num1.numberOfElements() - 1;
        int j = num2.numberOfElements() - 1;
        int shift = 0;
        while (i >= 0) {
            int digit1 = num1.getNodeIVal(i);
            int carry = 0;
            LinkedList interRes = new LinkedList();
            for (int k = 0; k < shift; k++) {
                interRes.insertFirst(0);
            }
            while (j >= 0 || carry > 0) {
                int digit2;
                if (j >= 0) {
                    digit2 = num2.getNodeIVal(j);
                } else {
                    digit2 = 0;
                }
                int product = digit1 * digit2 + carry;
                interRes.insertFirst(product % 10);
                carry = product / 10;
                j--;
            }
            LinkedList tempRes = add(result, interRes);
            result = tempRes;
            j = num2.numberOfElements() - 1;
            shift++;
            i--;
        }
        return result;
    }

    //the division method starts from the first digit of num1, divides digits by num2 one by one
    //carry is considered
    public static LinkedList divide(LinkedList num1, LinkedList num2) {
        LinkedList result = new LinkedList();
        int carry = 0;
        for (int i = 0; i < num1.numberOfElements(); i++) {
            int digit = num1.getNodeIVal(i);
            int currNum = carry * 10 + digit;
            int interRes = currNum / num2.getHead().data;
            carry = currNum % num2.getHead().data;
            if (!result.isEmpty() || currNum != 0) {
                result.insertLast(interRes);
            }
            if (result.getHead().data == 0) {
                result.deleteFirst();
            }
        }
            return result;
        }
    }



