package OurClasses;

public abstract class Person {
    private String name;
    
    // ==================Setters & Getters======================================
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    // ==================File Methods======================================
    public abstract void add(int id, String name, String email, String department, double salary);
    
    public abstract String[] get();
    
    public abstract void update(int checkedId, int id, String name, String email, String department, double salary);
    
    public abstract void delete(int id);
}
