import java.util.ListIterator;
import java.util.Scanner;
public enum AnimalOperatingSystem {
    SYSTEM();

    private Scanner in;
    AnimalManaging<Object> me;

    private AnimalOperatingSystem(){
        this.in=new Scanner(System.in);
        this.me=new AnimalManaging<Object>();
        {
            Dog a1 = new Dog("牧羊犬", 3, Sex.MALE);
            Dog a2 = new Dog("恶霸犬", 2, Sex.MALE);
            Dog a3 = new Dog("二哈", 1, Sex.FEMALE);
            Cat b1 = new Cat("加菲猫", 2, Sex.MALE, 100);
            Cat b2 = new Cat("家猫", 4, Sex.FEMALE, 20);
            me.addAnimal(a1);
            me.addAnimal(a2);
            me.addAnimal(a3);
            me.addAnimal(b1);
            me.addAnimal(b2);
            me.sortAge();
        }
    }


    public void ui() {
        boolean start = true;
        System.out.println("动物信息");
        print();
        while (start) {
            System.out.println("1.add" + '\t' + "2.remove" + '\t' + "3.revise" + '\t' + "4.exit");
            int a = in.nextInt();
            switch (a) {
                case 1: {
                    System.out.println("----------------------------------------");
                    boolean start2 = true;
                    while (start2) {
                        System.out.println("1.Dog" + '\t' + "2.Cat" + '\t' + "3.OtherAnimal(...)" + '\t' + "4.exit");
                        int i = in.nextInt();
                        switch (i) {
                            case 1: {
                                String name, sex;
                                int age;
                                System.out.print("种类:");
                                name = in.next();
                                System.out.print("年龄:");
                                age = in.nextInt();
                                System.out.print("性别(公/母):");
                                sex = in.next();
                                if (sex.equals("公")) {
                                    me.addAnimal(new Dog(name, age, Sex.MALE));
                                } else me.addAnimal(new Dog(name, age, Sex.FEMALE));

                                break;
                            }
                            case 2: {
                                String name, sex;
                                int age, weight;
                                System.out.print("种类:");
                                name = in.next();
                                System.out.print("年龄:");
                                age = in.nextInt();
                                System.out.print("性别(公/母):");
                                sex = in.next();
                                System.out.print("体重:");
                                weight = in.nextInt();
                                if (sex.equals("公")) {
                                    me.addAnimal(new Cat(name, age, Sex.MALE, weight));
                                } else me.addAnimal(new Cat(name, age, Sex.FEMALE, weight));

                                break;
                            }
                            case 3: {
                                System.out.println("待开发...");
                                break;
                            }
                            case 4: {
                                start2 = false;
                                break;
                            }
                            default: {
                                break;
                            }
                        }
                        me.sortAge();
                    }
                    break;
                }
                case 2: {
                    String name;
                    System.out.print("将要删除动物的种类:");
                    name=in.next();
                    me.removeAnimal(name);
                    break;
                }
                case 3: {
                    String pastName;
                    System.out.print("将要更改的动物的种类:");
                    pastName=in.next();
                    System.out.println("1.Dog" + '\t' + "2.Cat" );
                    int i = in.nextInt();
                    switch (i) {
                        case 1: {
                            String name, sex;
                            int age;
                            System.out.print("种类:");
                            name = in.next();
                            System.out.print("年龄:");
                            age = in.nextInt();
                            System.out.print("性别(公/母):");
                            sex = in.next();
                            if (sex.equals("公")) {
                                Dog d=new Dog(name, age, Sex.MALE);
                                me.reviseAnimal(pastName,d);
                            } else {
                                Dog d=new Dog(name, age, Sex.FEMALE);
                                me.reviseAnimal(pastName,d);
                            }

                           break;
                        }
                        case 2: {
                            String name, sex;
                            int age, weight;
                            System.out.print("种类:");
                            name = in.next();
                            System.out.print("年龄:");
                            age = in.nextInt();
                            System.out.print("性别(公/母):");
                            sex = in.next();
                            System.out.print("体重:");
                            weight = in.nextInt();
                            if (sex.equals("公")) {
                                Cat c=new Cat(name, age, Sex.MALE, weight);
                                me.reviseAnimal(pastName,c);
                            } else {
                                Cat c=new Cat(name, age, Sex.FEMALE, weight);
                                me.reviseAnimal(pastName,c);
                            }

                            break;
                        }
                        default: {
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                        start = false;
                        break;
                }
                default: {
                        System.out.print("重新输入:");
                        break;
                }
            }
            this.print();
        }
    }

    public void print(){
        ListIterator iterator=me.getIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("----------------------------------------");
    }
}
