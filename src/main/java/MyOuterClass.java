public final class MyOuterClass {
     static final class MyInnerClass {
        int number=0;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
       class MyInnerClass2 {
        int number=0;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}

class testClass{
    public static void main(String[] args) {
        MyOuterClass.MyInnerClass myFinal= new MyOuterClass.MyInnerClass();

        MyOuterClass.MyInnerClass2 myFinal1= new MyOuterClass().new MyInnerClass2();
        myFinal.setNumber(1);
        System.out.println(myFinal.getNumber());
    }
}
