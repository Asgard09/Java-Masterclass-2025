public class Comparable {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer i : others){
            int val = five.compareTo(i);
            System.out.println("compareTo = " +val +" : "+ five + " " + (val == 0 ? "==" : (val < 0) ? "<" : ">") + " " + i);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "cherry", "date", "BANANA"};

        for (String c : fruit){
            int val = banana.compareTo(c);
            System.out.println("compareTo = " +val +" : "+ banana + " " + (val == 0 ? "==" : (val < 0) ? "<" : ">") + " " + c);
        }
    }
}
