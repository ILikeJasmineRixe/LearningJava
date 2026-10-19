
class Cheese {

    static int cheeCount = 0;

    static void sayIt(int count) {
        int i;
        for (i = 0; i < count; i++) {
            System.out.println("Cheese");
        }
        cheeCount++;
        System.out.println("CheeCount: " + cheeCount);
    }
}

public class staticConfusion {

    public static void main() {

        /* 
            Notice...
            we never initialized a Cheese object here. 
            yet we can call the function because it is static
            mwahahhaha
            we love static.

            The method gets added as a child node of the class which automatically gets initialized,
            and thus by defining it as static, this child ALSO gets intialized without needing a new object to funnel through.
        */
        Cheese.sayIt(5);
        Cheese.sayIt(1);

    }
}
