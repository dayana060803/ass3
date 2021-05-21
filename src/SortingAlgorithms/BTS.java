package SortingAlgorithms;
public class BTS<T extends Comparable<T>> {
    Node race;
    class Node{
        T number;
        Node rght,lft;

        Node(T number){
            this.number = number;
        }
    }
    public void insert(T number){
        if(isEmpty())
            race = new Node(number);
        else
            insert(race, number);
    }
    private void insert(Node node, T number){
        if(number.compareTo(node.number) < 0){
            if(node.lft == null)
                node.lft = new Node(number);
            else
                insert(node.lft,number);
        }
        else if(number.compareTo(node.number) >= 0){
            if(node.rght == null)
                node.rght = new Node(number);
            else
                insert(node.rght,number);
        }
    }
    public T peek(){
        return race.number;
    }
    public boolean isEmpty(){
        return (race == null)? true : false;
    }
}