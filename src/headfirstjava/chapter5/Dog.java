package headfirstjava.chapter5;

public class Dog {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void bark(int numberofBarks) {
        int nums = 1;
        String bark;
        System.out.println(name + " is making a sound");
        if(size > 60) {
            bark = "Woof! Woof!";
        } else if(size > 14) {
            bark = "Ruff! Ruff!";
        } else {
            bark = "Yip! Yip!";
        }

        while (nums <= numberofBarks) {
            System.out.println(bark);
            nums++;
        }
    }

    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size){
        this.size = size;
    }
}
