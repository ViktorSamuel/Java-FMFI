import java.util.Arrays;

public class Test {



    public static void main(String[] args){
        int[] a = {0, 0, 0, 0, 0, 5};
        int[] b = Arrays.copyOf(a, a.length);
        a[0] = 8;
        System.out.println(a.length-1);
//        Polynomial0 a = new Polynomial0();
//        Polynomial0 b = new Polynomial0(5, 3);
//
//        int[] arr1 = {1, 0, 28, 0, 2, 3};
//        int[] arr = {0, 2, 2, 3, 1};
//        Polynomial0 c = new Polynomial0(arr);
//        Polynomial0 d = new Polynomial0(arr1);
//
//        System.out.println("a: "+a.polynom);
//        System.out.println("b: "+b.polynom);
//        System.out.println("c: "+c.polynom);
//        System.out.println("d: "+d.polynom);
//
//        System.out.println();
//
//        System.out.println("a: "+a.getDegree());
//        System.out.println("b: "+b.getDegree());
//        System.out.println("c: "+c.getDegree());
//        System.out.println("d: "+d.getDegree());
//
//        System.out.println();
//
//        System.out.println("a: "+a.getCoefficient(3));
//        System.out.println("b: "+b.getCoefficient(3));
//        System.out.println("c: "+c.getCoefficient(3));
//        System.out.println("d: "+d.getCoefficient(3));
//
//        System.out.println();
//
//        System.out.println("a+a= "+a.add(a).polynom);
//        System.out.println("a+b= "+a.add(b).polynom);
//        System.out.println("b+a= "+b.add(a).polynom);
//        System.out.println("c+a= "+c.add(a).polynom);
//        System.out.println("a+c= "+a.add(c).polynom);
//        System.out.println("c+d= "+c.add(d).polynom);




    }
}
