public enum Sex {
    MALE("公"),FEMALE("母");

    private String title;

    private Sex(String title){
        this.title=title;
    }

    @Override
    public String toString(){
        return this.title;
    }

}
