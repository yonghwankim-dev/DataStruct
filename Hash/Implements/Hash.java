package Hash.Implements;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import Hash.Implements.Hash.HashElement;

public class Hash<K, V>{
	class HashElement<K,V> implements Comparable<HashElement<K, V>>{
		K key;
		V value;
		
		public HashElement(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(HashElement<K, V> o) {
			return ((Comparable<K>) this.key).compareTo(o.key);
		}

		@Override
		public String toString() {
			return "HashElement [key=" + key + ", value=" + value + "]";
		}
		
		
	}
	
	class IteratorHelper<T>	implements Iterator<T>{
		T[] keys;
		int position;
				
		public IteratorHelper() {
			keys = (T[]) new Object[numElements];
			int p = 0;
			
			for(int i=0; i<tableSize;i++)
			{
				LinkedList<HashElement<K, V>> list = harray[i];
				for(HashElement<K, V> h : list)
				{
					keys[p++] = (T) h.key;
				}
			}
			position = 0;
		}

		@Override
		public boolean hasNext() {
			return position<keys.length;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				return null;
			}
			return keys[position++];
		}
		
	}
	
	int numElements, tableSize;	// 요소 개수, 테이블 크기
	double maxLoadFactor;		// 최대 적재율
	LinkedList<HashElement<K, V>>[] harray;
	private IteratorHelper<K> iterator;
	
	public Hash(int tableSize) {
		this.tableSize = tableSize;
		
		harray = (LinkedList<HashElement<K, V>>[]) new LinkedList[tableSize];
		
		for(int i=0; i<tableSize; i++)
		{
			harray[i] = new LinkedList<HashElement<K, V>>();
		}
		
		maxLoadFactor = 0.75;
		numElements = 0;
	}
	
	public boolean add(K key, V value) {
		// size
		if(loadFactor()>maxLoadFactor) 
		{
			reSize(tableSize*2);
		}
		
		// object
		HashElement<K, V> he = new HashElement(key, value);
		
		// index
		int hashval = key.hashCode();
		hashval = hashval & 0x7FFFFFFF;
		hashval = hashval % tableSize;
		
		// linkedlist
		harray[hashval].add(he);
		numElements++;
		
		return true;
	}
	
	public boolean remove(K key) {
		
		HashElement<K, V> he = new HashElement(key, null);	
		
		// index
		int hashval = key.hashCode();		
		hashval = hashval & 0x7FFFFFFF;
		hashval = hashval % tableSize;
		
		for(HashElement<K, V> item : harray[hashval])
		{
			if(item.compareTo(he)==0)
			{
				harray[hashval].remove(item);
				numElements--;
				return true;
			}
		}
		return false;
	}
	
	public V getValue(K key) {
		
		int hashval = key.hashCode();
		hashval = hashval & 0x7FFFFFFF;
		hashval = hashval % tableSize;
		
		for(HashElement<K, V> item : harray[hashval]) 
		{
			if(((Comparable<K>)key).compareTo(item.key)==0)
			{
				return item.value;
			}
		}
		return null; 
	}
		
	public double loadFactor() {
		return numElements / tableSize;
	}
	
	public void reSize(int newSize) {
		
		// 초기화
		LinkedList<HashElement<K, V>>[] newArray = new LinkedList[newSize];
		
		for(int i=0; i<newSize; i++)
		{
			newArray[i] = new LinkedList<HashElement<K, V>>();
		}
	
		// 이동
		for(LinkedList<HashElement<K, V>> list : harray)
		{
			for(HashElement<K, V> item : list)
			{
				V val = getValue(item.key);
				HashElement<K, V> he = new HashElement<K,V>(item.key, val);
				int hashVal = (item.key.hashCode() & 0x7FFFFFFF) % newSize;
				newArray[hashVal].add(he);
			}
		}
		
		// 테이블 정보 변경
		this.harray = newArray;
		this.tableSize = newSize;
	}
	

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(LinkedList<HashElement<K, V>> list : harray)
		{
			sb.append(list.toString()+"\n");
		}
		return sb.toString();
	}
	
	public void iterate() {
		this.iterator = new IteratorHelper<K>();
		
		while(this.iterator.hasNext()) 
		{
			System.out.print(this.iterator.next()+" ");
		}
		System.out.println();
	}
}
