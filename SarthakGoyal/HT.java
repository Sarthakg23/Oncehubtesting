package SarthakGoyal;

import java.util.*;

class HashTable {

	private int size, limit;
	Integer[] keys;
	Integer[] values;

	public HashTable(int limit)
	{
		size = 0;
		this.limit = limit;
		keys = new Integer[limit];
		values = new Integer[limit];
	}


	public int getSize() { return size; }


	public boolean isFull()
	{
		if(size==limit)
        return true;
        else
        return false;
	}


	public boolean isEmpty()
    {
        if(getSize()==0)
        return true;
        else
        return false;
    }

	public boolean contains(int key)
	{
		if(get(key)==null)
        return false;
        else
        return true;
	}

	private int hash(Integer key)
	{
		return key.hashCode()%limit;
	}


	public void insert(int key, int val)
	{
		int index = hash(key);
        int tmp=index;
		do {
			if (keys[tmp] == null) {
				keys[tmp] = key;
				values[tmp] = val;
				size++;
				return;
			}

			if (keys[tmp] == key) {
				values[tmp] = val;
				return;
			}

			tmp = (tmp + 1) % limit;

		}
		while (tmp!= index);
	}

	public Integer get(int key)
	{
		int index = hash(key);
		while (keys[index] != null) {
			if (keys[index] == (key))
				return values[index];
			index = (index + 1) % limit;
		}
		return null;
	}

	public void remove(int key)
	{
		if (!contains(key))
			return;

		int index = hash(key);
		while (key != (keys[index]))
			index = (index + 1) % limit;
		keys[index] = values[index] = null;

		for (index = (index + 1) % limit; keys[index] != null;index = (index + 1) % limit) {
			//System.out.println(index);
			int tmp1 = keys[index], tmp2 = values[index];
			keys[index] = values[index] = null;                        
			size--;
			//System.out.println(tmp1+" "+tmp2);
			insert(tmp1, tmp2);
			//printHashTable();
		}
		//size--;
	}

	
	public void printHashTable()
	{
		for (int i = 0; i < size; i++)
			if (keys[i] != null)
				System.out.println(keys[i] + " " + values[i]);
		System.out.println();
	}
}

public class HT{

	public static void main(String[] args)
	{
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size");
        int size=sc.nextInt();
	
		HashTable ht= new HashTable(size);

		ht.insert(23, 1);
		ht.insert(24, 2);
		ht.insert(25, 3);
		ht.insert(26, 4);
		ht.insert(27, 5);
		


		ht.printHashTable();

		System.out.println(ht.get(24));


		ht.remove(27);

		ht.printHashTable();

    }
}
