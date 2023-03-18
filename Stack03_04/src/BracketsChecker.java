public class BracketsChecker {
    public static void main(String[] args) {
        BracketsValidator bv = new BracketsValidator();
        bv.Validate("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\Stack03_04\\src\\inventory.txt");
        BracketsValidator bv1 = new BracketsValidator();
        bv1.Validate("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\Stack03_04\\src\\brackets.txt");
        BracketsValidator bv2 = new BracketsValidator();
        bv2.Validate("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\Stack03_04\\src\\csharp.cs");
        BracketsValidator bv3 = new BracketsValidator();
        bv3.Validate("D:\\CodeProjects\\DataStructures\\DataStructuresJava\\Stack03_04\\src\\cplusplus.cpp");
    }
}
