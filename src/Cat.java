public class Cat implements Animal{
    private String name;
    private int age;
    private Sex sex;

    private int weight;

    public Cat(String name,int age,Sex sex,int weight){
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.weight=weight;
    }

    @Override
    public int getAge(){
        return this.age;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        } else {
            if (obj instanceof Dog) {
                Cat temp = (Cat) obj;
                if (this.name == temp.name && this.age == temp.age && this.sex == temp.sex&&this.weight==temp.weight) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public String toString(){
        return "种类:"+this.name+'\t'+"年龄:"+this.age+'\t'+"性别:"+this.sex+'\t'+"体重:"+this.weight;
    }
}
