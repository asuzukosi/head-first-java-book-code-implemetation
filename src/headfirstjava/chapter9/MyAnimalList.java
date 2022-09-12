package headfirstjava.chapter9;
import headfirstjava.chapter8.Animal;

public class MyAnimalList {
    private Animal[] animals = new Animal[5];
    private int nextIndex = 0;

    public void add(Animal animal){
        // if the next index is less than the length of the array, 
        // add the animal to the array
        if(nextIndex < animals.length){
            animals[nextIndex] = animal;
            System.out.println("Animal added at index is : " + animal);
            nextIndex++;
        }
        // if the next index is greater than animals.length then continue
    }
}
