import java.util.Scanner;

public class practical4 {

    public static String toXXsystem(String num, String xx) {
        int decimal = 0;

        if ("2".equalsIgnoreCase(xx) || "binary".equalsIgnoreCase(xx) || "b".equalsIgnoreCase(xx)) {
            if (num.startsWith("0b") || num.startsWith("0B")) {
                num = num.substring(2);  
            }
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) == '1') {
                    decimal += Math.pow(2, num.length() - 1 - i);
                }
            }
            return Integer.toString(decimal);
        }

        else if ("8".equals(xx) || "octal".equalsIgnoreCase(xx) || "o".equalsIgnoreCase(xx)) {
            if (num.startsWith("0")) {
                num = num.substring(1);
            }
            decimal = Integer.parseInt(num, 8);
            return Integer.toString(decimal);
        }

        else if ("16".equals(xx) || "hexadecimal".equalsIgnoreCase(xx) || "h".equalsIgnoreCase(xx)) {
            if (num.startsWith("0x") || num.startsWith("0X")) {
                num = num.substring(2);
            }
            decimal = Integer.parseInt(num, 16);  
            return Integer.toString(decimal);
        }

        else if ("10".equalsIgnoreCase(xx) || "decimal".equalsIgnoreCase(xx) || "d".equalsIgnoreCase(xx)) {
            return num;
        }

        return "Invalid conversion type";
    }

    public static int getByte(int num) {
        while (num > 127 || num < -128) {
            if (num > 127) {
                num -= 256;
            } else if (num < -128) {
                num += 256;
            }
        }
        return num;
    }

    public static int getShort(int num) {
        while (num > 32767 || num < -32768) {
            if (num > 32767) {
                num -= 65536;
            } else if (num < -32768) {
                num += 65536;
            }
        }
        return num;
    }

    public static int getNumber(int num, String type) {
        switch (type.toLowerCase()) {
            case "byte":
                return getByte(num);
            case "short":
                return getShort(num);
            case "int":
                return num;
            default:
                return num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number for conversion (binary, octal, hexadecimal, or decimal):");
        String num = sc.nextLine();
        System.out.println("Enter the target type for conversion (binary, octal, hexadecimal, or decimal):");
        String type = sc.nextLine();
        System.out.println("Converted number: " + toXXsystem(num, type));

        System.out.println("Enter a number for byte/short conversion:");
        int num2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter type ('byte', 'short', or 'int'):");
        String type2 = sc.nextLine();
        int adjustedNum = getNumber(num2, type2);
        System.out.println("Adjusted number: " + adjustedNum);
    }
}
