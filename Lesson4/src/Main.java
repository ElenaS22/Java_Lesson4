class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode num1 = new ListNode(4);

        ListNode num2 = new ListNode(5);

        ListNode result = multiplyLists(num1, num2);

// Вывод результата
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println(" ");
        result = addLists(num1, num2);
        // Вывод результата
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public static ListNode multiplyLists(ListNode num1, ListNode num2) {
        // Проверка на ноль
        if (num1 == null || num2 == null) {
            return null;
        }

        // Инициализация результата
        ListNode result = new ListNode(0);
        ListNode current = result;

        // Обход цифр в num1
        while (num1 != null) {
            int carry = 0;
            ListNode tempResult = new ListNode(0);
            ListNode tempCurrent = tempResult;

            // Обход цифр в num2
            ListNode num2Copy = num2;
            while (num2Copy != null) {
                int product = num1.val * num2Copy.val + carry;
                int digit = product % 10;  // Текущая цифра
                carry = product / 10;  // Перенос

                tempCurrent.next = new ListNode(digit);
                tempCurrent = tempCurrent.next;
                num2Copy = num2Copy.next;
            }

            if (carry > 0) {
                tempCurrent.next = new ListNode(carry);
            }

            // Сложение результата с временным результатом
            result = addLists(result, tempResult.next);
            num1 = num1.next;
        }

        return result;
    }

    private static ListNode addLists(ListNode num1, ListNode num2) {
        // Инициализация результата
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;

        // Обход цифр в num1 и num2
        while (num1 != null || num2 != null) {
            int sum = carry;
            if (num1 != null) {
                sum += num1.val;
                num1 = num1.next;
            }
            if (num2 != null) {
                sum += num2.val;
                num2 = num2.next;
            }

            carry = sum / 10;  // Перенос
            current.next = new ListNode(sum % 10);  // Текущая цифра
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result.next;
    }
}
