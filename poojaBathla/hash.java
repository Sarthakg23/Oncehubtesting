package poojaBathla;
import java.util.Scanner;

class LinearProbing{
    private int currentSize,maxSize;
    private int[] keys;
    private int[] vals;

    public LinearProbing(int capacity){
        currentSize=0;
        maxSize=capacity;
        keys=new int[maxSize];
        vals= new int[maxSize];
    }

    public void makeEmpty(){
        currentSize=0;
        keys= new int[maxSize];
        vals= new int[maxSize];
    }

    public int getSize(){
        return currentSize;
    }

    public boolean isFull(){
        return currentSize==maxSize;
    }

    public boolean isEmpty(){
        return getSize()==0;
    }

    public boolean contains(int key){
        return get(key) != 0;
    }

    private int hash(int key){
        return key % maxSize;
    }

    public int get(int key){
        int i = hash(key);
        while(keys[i]!=0){
            if(keys[i]==key){
                return vals[i];
            }
            i=(i+1)%maxSize;
        }
        return 0;
    }

    public void insert(int key, int val){
        int temp=hash(key);
        int i=temp;

        do{
            if(keys[i]==0){
                keys[i]=key;
                vals[i]=val;
                currentSize++;
                return;
            }
            if(keys[i]==key){
                vals[i]=val;
                return;
            }
            i=(i+1)%maxSize;
        }
        while(i!=temp);
    }

    public void remove(int key){
        if(!contains(key)){
            return;
        }

        int i=hash(key);
        while(key!=keys[i]){
            i=(i+1)%maxSize;
        }
        keys[i]=vals[i]=0;

        for(i=(i+1)%maxSize ;    keys[i]!=0  ; i=(i+1)%maxSize){
            int temp1=keys[i];
            int temp2=vals[i];
            keys[i]=vals[i]=0;
            currentSize--;
            insert(temp1, temp2);
        }
        currentSize--;
    }

    public void printHashTable(){
        System.out.println("\nHash Table: ");
        for(int i=0; i<maxSize;i++){
            if(keys[i]!=0){
                System.out.println(keys[i]+ " "+vals[i]+" ");
            }
            System.out.println();
        }
    }

}


public class hash {
        public static void main(String[] args) {
            Scanner scan= new Scanner(System.in);

            System.out.println("Hash Table test\n\n");
            System.out.println("Enter Size");

            LinearProbing lp= new LinearProbing(scan.nextInt());
            char ch;
            do{
                System.out.println("\nHash Table operations\n");
                System.out.println("1. Insert");
                System.out.println("2. Remove");
                System.out.println("3. Get");
                System.out.println("4. Clear");
                System.out.println("5. Size");

                int choice=scan.nextInt();

                switch(choice){
                    case 1:
                        System.out.println("Enter key and value");
                        lp.insert(scan.nextInt(), scan.nextInt());
                        break;

                    case 2:
                        System.out.println("Enter key");
                        lp.remove(scan.nextInt());
                        break;

                    case 3:
                        System.out.println("Enter key");
                        System.out.println("value = "+lp.get(scan.nextInt()));
                        break;

                    case 4:
                        lp.makeEmpty();
                        System.out.println("Hash Table cleared\n");
                        break;

                    case 5: 
                        System.out.println("size: "+lp.getSize());
                        break;

                    default:
                    System.out.println("Wrong Entry\n");
                    break;
                }
                lp.printHashTable();
                System.out.println("\nContinue? type y or n\n");
                ch=scan.next().charAt(0);
            }while(ch=='Y'||ch=='y');
        }
}
