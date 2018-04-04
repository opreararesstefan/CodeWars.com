Your task is to make a function that can take any
non-negative integer as a argument and return it 
with its digits in descending order. Essentially, 
rearrange the digits to create the highest 
possible number.

Examples:

Input: 21445 Output: 54421

Input: 145263 Output: 654321

Input: 1254859723 Output: 9875543221




public class DescendingOrder {
  public static int sortDesc(final int num) {
   int number = num;
int sorted = 0;
int digits = 10;
int sortedDigits = 1;
boolean first = true;

while (number > 0) {
    int digit = number % 10;

    if (!first) {

        int tmp = sorted;
        int toDivide = 1;
        for (int i = 0; i < sortedDigits; i++) {
            int tmpDigit = tmp % 10;
            if (digit <= tmpDigit) {
                sorted = sorted/toDivide*toDivide*10 + digit*toDivide + sorted % toDivide;
                break;
            } else if (i == sortedDigits-1) {
                sorted = digit * digits + sorted;
            }
            tmp /= 10;
            toDivide *= 10;
        }
        digits *= 10;
        sortedDigits += 1;
    } else {
        sorted = digit;
    }

    first = false;
    number = number / 10;
}
return sorted;
  }
}