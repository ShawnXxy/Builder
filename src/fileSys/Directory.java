package fileSys;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry{
	protected List<Entry> contents;
	
	public Directory(String n, Directory p) {
		super(n, p);
		contents = new ArrayList<Entry>();
	}
	
	protected ArrayList<Entry> getContets() {
		return contents;
	}
	
	public int size() {
		int size = 0;
		for (Entry e : contents) {
			size = size + e.size();
		}
		return size;
	}
	
	public int numberOfFiles() {
		int count = 0;
		for (Entry e : contents) {
			if (e instanceof Directory) {
				count++; // Directory counts as a file
			}
		}
		return count;
	}
	
	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}
	
	public void addEntry(Entry entry) {
		contents.add(entry);
	}
}
