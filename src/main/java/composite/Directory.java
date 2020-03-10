package composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {

    private String name;
    private List<Entry> entries; //file, dir 집합

    @Override
    public Entry add(Entry entry) throws FileTreatmentException {
        entries.add(entry);
        return this;
    }

    public Directory(String name) {
        this.name = name;
        this.entries = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : entries) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        for (Entry entry : entries) {
            entry.printList(prefix + "/" + this);
        }
    }
}
