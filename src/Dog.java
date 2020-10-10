public class Dog implements Animal {
    private String name;
    private int age;
    private Sex sex;

    public Dog(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else {
            if (obj instanceof Dog) {
                Dog temp = (Dog) obj;
                if (this.name == temp.name && this.age == temp.age && this.sex == temp.sex) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public String toString(){
        return "种类:"+this.name+'\t'+"年龄:"+this.age+'\t'+"性别:"+this.sex;
    }
}